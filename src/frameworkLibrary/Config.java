package frameworkLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Config {

	protected int Trow;
	protected String Dir = System.getProperty("user.dir");
	protected String prop_TestSuite = Dir + "/src/frameworkLibrary/TestSuite.properties";
	String excelPath = Dir + "/TestSuite.xlsx";
	String sheetName = "MainSheet";
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	protected String ION_App_Version = "1.2";
	protected String gmailUserId = "ionqa1@gmail.com";
	protected String gmailPassword = "ion12345";
	protected String gmailUsersInCC = "ashok.g@medicodesk.com";
	protected String dateWithTime = dateFormat.format(new Date());
	protected String customReportFilename = Dir + "/test-output/custom-report.html";
	protected int waitTime = 60;
	protected int waitTimeMin = 10;
	protected String locatorSeparator = "<LocatorValueIs>";
	protected String xpath = "xpath" + locatorSeparator;
	protected String id = "id" + locatorSeparator;
	protected String name = "name" + locatorSeparator;
	protected String css = "css" + locatorSeparator;
	protected String cls = "cls" + locatorSeparator;
	protected String AppsPath = Dir + "/lib/apps/";
	protected File appDir = new File(AppsPath);
	protected String nodeExecutablePath = "C:\\Program Files\\nodejs\\node.exe";
	protected String appiumJS_Path = "C:\\Users\\Ashok\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	protected String screenshotsPath = Dir + "/test-output/html/Screenshots_Output/";

	public void updateTrow(int Trow1) throws IOException {
		Trow = Trow1;
	}

	// --------------Excel Library-----------------//

	// Get the sheet by passing sheet name and excel path.
	public Sheet getSheet(String excelPath, String sheetName) throws IOException {
		File get_file = new File(excelPath);
		FileInputStream fis = new FileInputStream(get_file);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sh = workbook.getSheet(sheetName);
		workbook.close();
		return sh;
	}

	// Get the row count by passing sheet name and excel path.
	public int getSheetRowCount(String excelPath, String sheetName) throws IOException {
		int rowCount = 0;
		rowCount = getSheet(excelPath, sheetName).getLastRowNum();
		return rowCount;
	}

	// Get column count by passing sheet name and excel path.
	public int getSheetColumnCount(String excelPath, String sheetName) throws IOException {
		int columnCount = 0;

		Iterator<Row> iterator = getSheet(excelPath, sheetName).iterator();
		Row nextRow = iterator.next();
		columnCount = nextRow.getLastCellNum();
		return columnCount;
	}

	// Get Formula cell value by passing cell values from TestSuite excel value
	public String getCellValueFromTestSuite(int x, int y, String excelPath, String sheetName) {
		String val = "";
		File get_file = new File(excelPath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(get_file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

		int rowLength = 0;
		try {
			rowLength = getSheetRowCount(excelPath, sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int colLength = 0;
		try {
			colLength = getSheetColumnCount(excelPath, sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[][] data = new String[rowLength + 1][colLength];
		int i, j;
		for (i = 0; i <= rowLength; i++) { // row
			for (j = 0; j < colLength; j++) // column
			{
				val = evaluator.evaluate(sheet.getRow(i).getCell(j)).formatAsString();
				int len = val.length();

				if (val.contains("\"")) {
					data[i][j] = val.substring(1, len - 1);
				} else {
					data[i][j] = val;
				}
			}
		}
		String CellValue = data[x][y];
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return CellValue;
	}

	// -------------frameWork configurtion-----------------//

	public void updateTestSuiteProperties() throws IOException {

		int Trow = getSheetRowCount(excelPath, sheetName);
		for (int i = 1; i <= Trow; i++) {

			try {
				Properties props = new Properties();

				File f = new File(prop_TestSuite);
				InputStream input = new FileInputStream(f);

				if (input != null) {
					System.out.println("Copying row number in Test Suite excel is :" + i);

					props.load(input);
					props.setProperty("ExecutionStatus" + i,
							this.getCellValueFromTestSuite(i, 0, excelPath, sheetName));
					props.setProperty("AppType" + i, this.getCellValueFromTestSuite(i, 1, excelPath, sheetName));
					props.setProperty("OS" + i, this.getCellValueFromTestSuite(i, 2, excelPath, sheetName));
					props.setProperty("DeviceName" + i, this.getCellValueFromTestSuite(i, 3, excelPath, sheetName));
					props.setProperty("Udid" + i, this.getCellValueFromTestSuite(i, 4, excelPath, sheetName));
					props.setProperty("P0" + i, this.getCellValueFromTestSuite(i, 5, excelPath, sheetName));
					props.setProperty("P1" + i, this.getCellValueFromTestSuite(i, 6, excelPath, sheetName));
					props.setProperty("P2" + i, this.getCellValueFromTestSuite(i, 7, excelPath, sheetName));
					props.setProperty("Sanity" + i, this.getCellValueFromTestSuite(i, 8, excelPath, sheetName));

					OutputStream out = new FileOutputStream(f);
					props.store(out, "save");
					System.out.println("Rows done in Test Suite excel :" + i);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void suitesExecution() throws IOException {

		int TestSuiteExcelRowCount = this.getSheetRowCount(excelPath, sheetName);
		System.out.println("TestSuiteExcelRowCount" + TestSuiteExcelRowCount);
		TestNG tng = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("Automation_Suite" + dateFormat.format(new Date()));
		System.out.println("suite name is : " + "Automation_Suite_" + dateFormat.format(new Date()));
		suite.setParallel(XmlSuite.ParallelMode.TESTS);
		// suite.setThreadCount(10);
		suite.addListener("org.uncommons.reportng.HTMLReporter");
		suite.addListener("org.uncommons.reportng.JUnitXMLReporter");
		suite.addListener("frameworkLibrary.reporting.TestNGCustomReportListener");
		//suite.addListener("frameworkLibrary.reporting.RetryListener");

		for (int Trow = 1; Trow <= TestSuiteExcelRowCount; Trow++) {

			if (this.getCellValueFromTestSuite(Trow, 0, excelPath, sheetName).equals("Run")) {

				XmlTest test = new XmlTest(suite);

				test.addParameter("Trow", String.valueOf(Trow));
				int merchantColumnNumber = 1;
				test.setName(this.pvts("OS" + Trow) + "_" + this.pvts("DeviceName" + Trow) + "_" + ION_App_Version+"_"+Trow);
				test.setPreserveOrder(true);

				List<XmlClass> list = new ArrayList<XmlClass>();

				if (this.pvts("P0" + Trow).equals("Yes")) {
					list.add(new XmlClass("AutomationSuites."
							+ this.getCellValueFromTestSuite(Trow, merchantColumnNumber, excelPath, sheetName) + "."
							+ "P0_TestCases"));
					System.out.println("AutomationSuites."
							+ this.getCellValueFromTestSuite(Trow, merchantColumnNumber, excelPath, sheetName) + "."
							+ "P0_TestCases");
				}

				if (this.pvts("P1" + Trow).equals("Yes")) {
					list.add(new XmlClass("AutomationSuites."
							+ this.getCellValueFromTestSuite(Trow, merchantColumnNumber, excelPath, sheetName) + "."
							+ "P1_TestCases"));

				}

				if (this.pvts("P2" + Trow).equals("Yes")) {
					list.add(new XmlClass("AutomationSuites."
							+ this.getCellValueFromTestSuite(Trow, merchantColumnNumber, excelPath, sheetName) + "."
							+ "P2_TestCases"));

				}
				if (this.pvts("Sanity" + Trow).equals("Yes")) {
					list.add(new XmlClass("AutomationSuites."
							+ this.getCellValueFromTestSuite(Trow, merchantColumnNumber, excelPath, sheetName) + "."
							+ "Sanity_TestCases"));

				}

				test.setXmlClasses(list);

			}

		}

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run();
	}

	public String pvts(String propertyFileKey) {
		String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(prop_TestSuite));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyFileValue;
	}

	public String pvd(String propertyFileKey) {

		String propertyFilePath = Dir + "/src/" + this.pvts("AppType" + Trow) + "/" + this.pvts("AppType" + Trow)
				+ "Data.properties";
		String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(propertyFilePath));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyFileValue;
	}
	
	public String pvWeb(String propertyFileKey) {

		String propertyFilePath = Dir+ "/src/webSites/webSitesData.properties";
		String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(propertyFilePath));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyFileValue;
	}

	// Get OS name by passing row value in TestSuite excel value
	public String getOS() {
		String s = pvts("OS" + Trow);
		return s;
	}

	public int getRunCount() throws IOException { // For Mail reporting
		int i, j = 0;
		int Trow = getSheetRowCount(excelPath, sheetName);
		for (i = 0; i <= Trow; i++) {
			String s = this.getCellValueFromTestSuite(i, 0, excelPath, sheetName);
			// System.out.println("s is :"+s);
			if (s.equals("Run")) {
				j = j + 1;
			}
		}

		return j;
	}

	public String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public String randomNumString(int len) {
		String AB = "123456789987654321";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public int randomNumInteger(int len) {

		String number = this.randomNumString(len);
		int result = Integer.parseInt(number);
		return result;
	}

	public String removeSpaceInStr(String value){
		
		return value.replaceAll("\\s+", "");
		
	}
	
	public String getTodayDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public int currentMonthDays() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
		LocalDateTime now = LocalDateTime.now();
		 System.out.println(dtf.format(now));
		YearMonth yearMonthObject = YearMonth.of(2018, this.convertStrToInt(dtf.format(now)));
		int daysInMonth = yearMonthObject.lengthOfMonth(); 
		System.out.println("Currnt month and days"+dtf.format(now) +":"+daysInMonth);
	return	daysInMonth;
	}
	public boolean stringCompare_contains(String actualText,String expectedText) {
		boolean f=false;
		if(expectedText.contains(actualText)) {
			f=true;
		}
		return f;	
	}
	
	
	public int convertStrToInt(String stringValue) {
		int result = Integer.parseInt(stringValue);
		return result;
	}

	public String convertIntToStr(int intValue) {
		String s = String.valueOf(intValue);
		return s;
	}

	public WebElement element(WebDriver driver, String locator, int waitTime) {
		this.waitForJStoLoad(driver, waitTime);
		WebElement Element = null;
		//System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		//System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		//System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			
			Element = driver.findElement(By.id(locatorValue));
			try {
			 if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			    }
		} catch (Exception e) {
			System.out.println("Hiligghting the elemnt not possible now : " + Element);
		}
			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.xpath(locatorValue));
			try {
			if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			    }
		} catch (Exception e) {
			System.out.println("Hiligghting the elemnt not possible now : " + Element);
		}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.name(locatorValue));
			try {
			if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			    }
			} catch (Exception e) {
				System.out.println("Hiligghting the elemnt not possible now : " + Element);
			}
			break;
		case "css":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.cssSelector(locatorValue));
			try { 
			if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			    }
			} catch (Exception e) {
				System.out.println("Hiligghting the elemnt not possible now : " + Element);
			}
			break;
		case "cls":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.className(locatorValue));
			try { 
			if (driver instanceof JavascriptExecutor) {
			        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			    }
			} catch (Exception e) {
				System.out.println("Hiligghting the elemnt not possible now : " + Element);
			}
			break;
		}
		return Element;
	}

	public void waitForElementVisibility(WebDriver driver, String locator, int waitTime) {
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		}
	}

	public void waitForElementClickable(WebDriver driver, String locator, int waitTime) {
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator, int waitTime) {
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		}
	}
	public void waitForElementInVisibility(WebDriver driver, String locator, int waitTime) {
		System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "name":
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "css":
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		case "cls":
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			break;
		
		}
		
		
	}
	public void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void waitForLoad(WebDriver driver,int waitTime) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(pageLoadCondition);
    }
	
	public boolean waitForJStoLoad(WebDriver driver,int waitTime) {

	    WebDriverWait wait = new WebDriverWait(driver, waitTime);

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        try {
	          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
	        }
	        catch (Exception e) {
	          return true;
	        }
	      }
	    };

	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
              return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");

	      }
	    };

	  return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
}
