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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Config {

	private DesiredCapabilities cap;
	private AppiumDriverLocalService service;

	//protected WebDriver driver;
	//protected AndroidDriver<AndroidElement> aDriver;
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
	protected String locator_iOS = "";

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
		// suite.addListener("frameworkLibrary.reporting.RetryListener");

		for (int Trow = 1; Trow <= TestSuiteExcelRowCount; Trow++) {

			if (this.getCellValueFromTestSuite(Trow, 0, excelPath, sheetName).equals("Run")) {

				XmlTest test = new XmlTest(suite);

				test.addParameter("Trow", String.valueOf(Trow));
				int merchantColumnNumber = 1;
				test.setName(this.pvts("OS" + Trow) + "_" + this.pvts("DeviceName" + Trow) + "_" + ION_App_Version + "_"
						+ Trow);
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

	public String pvl(String propertyFileKey) {

		String propertyFilePath = Dir + "/src/" + this.pvts("AppType" + Trow) + "/" + this.pvts("AppType" + Trow)
				+ "Locators.properties";
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

		String propertyFilePath = Dir + "/src/webSites/webSitesData.properties";
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
	public String getOS(AppiumDriver<?> driver) {
		String s = driver.getPlatformName().toString();
		return s;
	}
	// Get OS Version name by passing row value in TestSuite excel value
		public String getVersion(AppiumDriver<?> driver) {
			String s = this.pvts("DeviceName"+Trow);			
			return s;
		}

	public String locatorByOS(AppiumDriver<?> driver, String locator_Android, String locator_iOS) {
		String locator = null;
		if (this.getOS(driver).equals("Android")) {
			locator = locator_Android;
		} else if (this.getOS(driver).equals("iOS")) {
			locator = locator_iOS;
		}
		return locator;
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

	public String removeSpaceInStr(String value) {

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
		System.out.println("Currnt month and days" + dtf.format(now) + ":" + daysInMonth);
		return daysInMonth;
	}

	public boolean stringCompare_contains(String actualText, String expectedText) {
		boolean f = false;
		if (expectedText.contains(actualText)) {
			f = true;
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

	// ============= Web Driver ========================//

	public WebDriver launchBrowser(WebDriver driver,String browserType) throws Exception {
		if (browserType.equals("Windows_Firefox")) {
			System.setProperty("webdriver.gecko.driver", Dir + "/lib/windows/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else if (browserType.equals("Windows_Chrome")) {
			System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			throw new Exception("Browser is not correct");
		}
		
		return driver;
	}

	public WebDriver launchChromeBrowser(WebDriver driver) throws Exception {
		
			System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver launchBrowser(WebDriver driver) {
		try {
			driver=this.launchBrowser(driver, this.pvts("DeviceName"+Trow));
		} catch (Exception e) {System.out.println("Launch Browser Exception: "+ e);}
		return driver;
	}
	
	public WebElement element(WebDriver driver, String locator, int waitTime) {
		WebElement Element = null;
		// System.out.println("locator_key is :" + locator);
		String locatorType = locator.split(locatorSeparator)[0];
		// System.out.println("locatorType : " + locatorType);
		String locatorValue = locator.split(locatorSeparator)[1];
		// System.out.println("locatorValue : " + locatorValue);
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		switch (locatorType) {
		case "id":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}

			Element = driver.findElement(By.id(locatorValue));

			break;
		case "xpath":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.xpath(locatorValue));

			break;
		case "name":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.name(locatorValue));

			break;
		case "css":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.cssSelector(locatorValue));

			break;
		case "cls":
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			} catch (Exception e) {
				System.out.println("locator not found and locator is : " + locatorValue);
			}
			Element = driver.findElement(By.className(locatorValue));

			break;
		}
		return Element;
	}

	
	private void waitForElementVisibility(WebDriver driver, String locator, int waitTime) {
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

	private void waitForElementClickable(WebDriver driver, String locator, int waitTime) {
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

	private void waitForElementPresence(WebDriver driver, String locator, int waitTime) {
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

	private void waitForElementInVisibility(WebDriver driver, String locator, int waitTime) {
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
	
	public void waitForElement_Visibility(WebDriver driver,String locator, int waitTime) {
		try {
			waitForElementVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_InVisibility(WebDriver driver,String locator, int waitTime) {
		try {
			waitForElementInVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Clickable(WebDriver driver,String locator, int waitTime) {
		try {
			waitForElementClickable(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Presence(WebDriver driver,String locator, int waitTime) {
		try {
			waitForElementPresence(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}


	public void sleep(int sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void waitForLoad(WebDriver driver, int waitTime) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(pageLoadCondition);
	}

	public boolean waitForJStoLoad(WebDriver driver, int waitTime) {

		WebDriverWait wait = new WebDriverWait(driver, waitTime);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
	}

	public void testResult(WebDriver driver, ITestResult testResult) throws IOException {
		System.out.println(
				"testResult Method : Trow result is : " + Trow + "Device Name is : " + this.pvts("DeviceName" + Trow));
		File scrFile = null;
		new File(screenshotsPath).mkdirs();
		Reporter.setCurrentTestResult(testResult);

		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println(testResult.getStatus());
			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String folder_name_fail = this.pvts("AppType" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
					+ this.pvts("DeviceName" + Trow) + "_fail_" + dateWithTime + "/";

			String failureImageFileName = testResult.getName() + "-" + dateFormat.format(new Date()) + ".jpg";
			try {
				FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_fail + failureImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log("<a  href=Screenshots_Output/" + folder_name_fail + failureImageFileName + ">"
					+ "<p style=\"background-color:Tomato;\">Failed Screenshot :: " + folder_name_fail
					+ failureImageFileName + "</p>" + "</a>");
			Reporter.log("<html><body><img src=file://" + Dir + "/test-output/html/Screenshots_Output/"
					+ folder_name_fail + failureImageFileName + " alt=" + "Filed Screenshot"
					+ " width=\"500\" height=\"300\"></body></html>");
			Reporter.setCurrentTestResult(null);
		} else if (this.pvd("requireSuccessScreenshot").equals("yes")) {

			scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String folder_name_pass = this.pvts("AppType" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
					+ this.pvts("DeviceName" + Trow) + "_pass_" + dateWithTime + "/";

			String successImageFileName = testResult.getName() + "-" + Arrays.toString(testResult.getParameters()) + "-"
					+ dateFormat.format(new Date()) + ".jpg";
			try {
				FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_pass + successImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			if (this.pvd("requireSuccessScreenshotInLogs").equals("yes")) {
				Reporter.log("<a  href=Screenshots_Output/" + folder_name_pass + successImageFileName + ">"
						+ "<p style=\"background-color:green;\">Failed Screenshot :: " + folder_name_pass
						+ successImageFileName + "</p>" + "</a>");
				Reporter.log("<html><body><img src=file://" + Dir + "/test-output/html/Screenshots_Output/"
						+ folder_name_pass + successImageFileName + " alt=" + "Filed Screenshot"
						+ " width=\"500\" height=\"300\"></body></html>");
				Reporter.setCurrentTestResult(null);
			}
		}

	}

	public void screenshotPass(WebDriver driver, String testName, String fileName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folder_name_pass = this.pvts("AppType" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
				+ this.pvts("DeviceName" + Trow) + "_Pass_" + dateWithTime + "/" + testName + "/";

		String ImageFileName = fileName + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_pass + ImageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void assertEquals_Text(WebDriver driver, String testName, String fileName, String actualText,
			String expectedText) throws IOException {
		Assert.assertEquals(actualText, expectedText);
		this.screenshotPass(driver, testName, fileName);

	}

	public void assertContains_Text(WebDriver driver, String testName, String fileName, String actualText,
			String expectedText) throws IOException {
		this.assertEquals_True(driver, testName, fileName, stringCompare_contains(actualText, expectedText));
		this.screenshotPass(driver, testName, fileName);

	}

	public void assertEquals_True(WebDriver driver, String testName, String fileName,
			boolean actualValue_WhichReturnsTrue) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsTrue, true);
		this.screenshotPass(driver, testName, fileName);

	}

	public void assertEquals_False(WebDriver driver, String testName, String fileName,
			boolean actualValue_WhichReturnsFalse) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsFalse, false);
		this.screenshotPass(driver, testName, fileName);

	}


	public void scrollDown_Web(WebDriver driver,int scrollCount, int scrollSize) {
		String scrollTo = "window.scrollBy(0," + scrollSize + ")";
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(scrollTo);
		}
		this.sleep(2000);
	}

	public void scrollUp_Web(WebDriver driver,int scrollCount) {
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		}
	}
	public void kepad_Enter_Web(WebDriver driver,String locator, int waitTime) {
		element(driver,locator, waitTime).sendKeys(Keys.RETURN);
	}
	
	
	public void getPage(WebDriver driver,String pageURL) {
		driver.get(pvd(pageURL));
	}

	public void getPage_Direct(WebDriver driver,String pageURL) {
		driver.get(pageURL);
	}

	public void naavigateToUrl(WebDriver driver,String navigationUrl) {
		driver.navigate().to( pvd(navigationUrl + pvd("runIn")));
		sleep(3000);
	}

	public String getCurrentPageTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentPageUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	//=============== ION Web Driver Reusable Methods ============//
	
	public int listCount(WebDriver driver,String listsXpath) {
		List<WebElement> ls = driver.findElements(By.xpath(listsXpath));
		int count = ls.size();
		System.out.println("List count of given xpath is :" + count);
		return count;
	}



	public int getDropDownListCount(WebDriver driver,String locator) {
		int i = 0;
		Select dropDown = new Select(element(driver,locator, waitTime));
		List<WebElement> elementCount = dropDown.getOptions();
		System.out.println("List Count is " + elementCount.size());
		i = elementCount.size();
		return i;
	}	
	
	public void scrollDownFullPage_Web(WebDriver driver,int scrollCount) {
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		this.sleep(3000);

	}

	public void clickAndHold_Actions(WebDriver driver,String locator, int waitTime) {
		// Use action class to mouse hover on Text box field
		Actions action = new Actions(driver);
		action.clickAndHold(element(driver,locator, waitTime)).perform();
		action.release(element(driver,locator, waitTime));
	}
	
	// =================== Mobile Driver =========================//
	// Android App Installation with appium server and delete
	public void androidAppInstallAndDelete(AppiumDriver<?> driver, String DeviceName, String PlatformVersion,
			String Udid) {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodeExecutablePath)).withAppiumJS(new File(appiumJS_Path))
				.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());

		File apk = new File(appDir, "ION.apk");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, "Android");
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", Udid);
		cap.setCapability("appPackage", "com.medico.ionAndroid");
		cap.setCapability("appActivity", "com.medico.ionAndroid.Splash.SplashActivity");
		// cap.setCapability("clearSystemFiles", true);("systemPort",XXXX)
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability("PlatformVersion", PlatformVersion);
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		service.stop();
	}

	// Android App Installation with appium server -- Overriding the existing app
	public AndroidDriver<AndroidElement> androidAppInstall_Override(AndroidDriver<AndroidElement> driver,
			String DeviceName, String PlatformVersion, String Udid) {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);

		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodeExecutablePath)).withAppiumJS(new File(appiumJS_Path))
				.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
		File apk = new File(appDir, "ION.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, "Android");
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", Udid);
		cap.setCapability("appPackage", "com.medico.ionAndroid");
		cap.setCapability("appActivity", "com.medico.ionAndroid.Splash.SplashActivity");
		// cap.setCapability("clearSystemFiles", true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("PlatformVersion", PlatformVersion);
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		return driver;
	}

	// Complete unInstall and install the app
	public AndroidDriver<AndroidElement> installAndroidApp(AndroidDriver<AndroidElement> driver) {
		this.androidAppInstallAndDelete(driver, this.pvts("DeviceName" + Trow), this.pvts("PlatformVersion" + Trow),
				this.pvts("Udid" + Trow));
		return this.androidAppInstall_Override(driver, this.pvts("DeviceName" + Trow),
				this.pvts("PlatformVersion" + Trow), this.pvts("Udid" + Trow));
	}

	// Complete unInstall and install the app
	public AndroidDriver<AndroidElement> installAndroidApp(AndroidDriver<AndroidElement> driver, String DeviceName,
			String PlatformVersion, String Udid) {

		this.androidAppInstallAndDelete(driver, DeviceName, PlatformVersion, Udid);
		return this.androidAppInstall_Override(driver, DeviceName, PlatformVersion, Udid);
	}

	/*
	 * // iOS App Installation with appium server public AppiumDriver<?>
	 * iOSAppiumSetup() { service = AppiumDriverLocalService .buildService(new
	 * AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
	 * .withAppiumJS(new
	 * File(appiumJS_Path)).withIPAddress("127.0.0.1").usingAnyFreePort());
	 * 
	 * File ipa = new File(appDir, this.pvts("Merchant" + Trow) + ".ipa");
	 * System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".ipa");
	 * DesiredCapabilities cap = new DesiredCapabilities();
	 * cap.setCapability("platformName", this.pvts("OS" + Trow)); //
	 * cap.setCapability(CapabilityType.PLATFORM, "Mac");
	 * cap.setCapability("automationName", "XCUITest");
	 * cap.setCapability("xcodeOrgId", super.pvData("xcodeOrgId"));
	 * cap.setCapability("xcodeSigningId", super.pvData("xcodeSigningId"));
	 * cap.setCapability("deviceName", this.pvts("DeviceName" + Trow));
	 * cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
	 * cap.setCapability("useNewWDA", true); String wdaLocalPort =
	 * randomNumString(3); String wdaLocalPort1 = Trow + wdaLocalPort;
	 * cap.setCapability("wdaLocalPort", wdaLocalPort1);
	 * cap.setCapability(MobileCapabilityType.NO_RESET, true);
	 * cap.setCapability("udid", this.pvts("Udid" + Trow));
	 * cap.setCapability("bundleId", super.pvData("bundleId"));
	 * cap.setCapability("app", ipa.getAbsolutePath());
	 * 
	 * driver = new IOSDriver<IOSElement>(service, cap); return driver; }
	 */

	// Resetting the app before executing the testcase
	public void resetApp(AppiumDriver<?> driver) throws IOException, InterruptedException {
		// String ipa = Dir + "/Apps/" + this.pvts("Merchant" + Trow) + ".ipa";
		System.out.println("OS Name is :");
		if (this.getOS(driver).equals("Android")) {
			driver.resetApp();
		} /*
			 * else if (super.getOS(driver).equals("iOS")) { Thread.sleep(2000);
			 * driver.removeApp(super.pvData("bundleId")); driver.installApp(ipa);
			 * Thread.sleep(3000); driver.launchApp(); }
			 */

	}

	public void keypadClose(AppiumDriver<?> driver) throws IOException {
		if (getOS(driver).equals("Android")) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		} else if (getOS(driver).equals("iOS")) {
			driver.findElementById(pvd("keypadDone")).click();
		}
	}

	public void deviceBackBtn_Android(AppiumDriver<?> driver) {

		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void scrollDown_Mobile(AppiumDriver<?> driver, int ScrollCount) throws IOException {

		for (int i = 1; i <= ScrollCount; i++) {
			if (getOS(driver).equals("Android")) {
				Dimension dimensions = driver.manage().window().getSize();
				Double screenHeightStart = dimensions.getHeight() * 0.4;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = screenHeightEnd.intValue();

				TouchAction action = new TouchAction(driver);
				action.press(0, scrollStart);
				action.waitAction();
				action.moveTo(0, scrollEnd);
				action.release();
				action.perform();
			} else if (getOS(driver).equals("iOS")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "down");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}

	public void scrollUp_Mobile(AppiumDriver<?> driver, int ScrollCount) throws IOException {
		for (int i = 1; i <= ScrollCount; i++) {
			if (getOS(driver).equals("Android")) {
				Dimension dimensions = driver.manage().window().getSize();
				Double screenHeightStart = dimensions.getHeight() * 0.4;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = screenHeightEnd.intValue();

				TouchAction action = new TouchAction(driver);
				action.press(0, scrollEnd);
				action.waitAction();
				action.moveTo(0, scrollStart);
				action.release();
				action.perform();
			} else if (getOS(driver).equals("iOS")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("direction", "up");
				js.executeScript("mobile: scroll", scrollObject);
			}
		}
	}

	public void keypadNext(AppiumDriver<?> driver) throws IOException {
		if (getOS(driver).equals("Android")) {
			((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.ENTER);
		} else if (getOS(driver).equals("iOS")) {
			driver.findElementById(pvd("keypadNext")).click();
		}
	}

}
