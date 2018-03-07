/*package frameworkLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class driverActions extends Config{
	private AppiumDriverLocalService service;
	
	private DesiredCapabilities cap;
	
	public WebDriver launchBrowser() throws Exception {
		if (super.pvts("DeviceName" + Trow).equals("Windows_Firefox")) {
			System.setProperty("webdriver.gecko.driver", Dir + "/lib/windows/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else if (super.pvts("DeviceName" + Trow).equals("Windows_Chrome")) {
			System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			throw new Exception("Browser is not correct");
		}
	return driver;	
	}

	// Android App Installation with appium server
		public void androidAppInstall() {
			cap = new DesiredCapabilities();
			cap.setCapability("clearSystemFiles", true);
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(nodeExecutablePath)).withAppiumJS(new File(appiumJS_Path))
					.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());

			File apk = new File(appDir, "ION.apk");

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
			cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
			cap.setCapability("automationName", "uiautomator2");
			cap.setCapability("udid", this.pvts("Udid" + Trow));
			cap.setCapability("appPackage", "com.medico.ionAndroid");
			cap.setCapability("appActivity", "com.medico.ionAndroid.Splash.SplashActivity");
			// cap.setCapability("clearSystemFiles", true);("systemPort",XXXX)
			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
			String systemPort = randomNumString(3);
			String systemPort1 = Trow + systemPort;
			cap.setCapability("systemPort", systemPort1);
			cap.setCapability("app", apk.getAbsolutePath());
			aDriver = new AndroidDriver<AndroidElement>(service, cap);
			service.stop();
		}

		// Android App Installation with appium server
		public AndroidDriver<AndroidElement> androidAppLaunch() {
			cap = new DesiredCapabilities();
			cap.setCapability("clearSystemFiles", true);

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(nodeExecutablePath)).withAppiumJS(new File(appiumJS_Path))
					.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
			File apk = new File(appDir, "ION.apk");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
			cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
			cap.setCapability("automationName", "uiautomator2");
			cap.setCapability("udid", this.pvts("Udid" + Trow));
			cap.setCapability("appPackage", "com.medico.ionAndroid");
			cap.setCapability("appActivity", "com.medico.ionAndroid.Splash.SplashActivity");
			// cap.setCapability("clearSystemFiles", true);
			cap.setCapability(MobileCapabilityType.FULL_RESET, false);
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
			String systemPort = randomNumString(3);
			String systemPort1 = Trow + systemPort;
			cap.setCapability("systemPort", systemPort1);
			// cap.setCapability("app", apk.getAbsolutePath());
			aDriver = new AndroidDriver<AndroidElement>(service, cap);
			return aDriver;
		}
	
	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
	}

	public void testResult(WebDriver driver,ITestResult testResult) throws IOException {
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
		} else if (super.pvd("requireSuccessScreenshot").equals("yes")) {

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
			if (super.pvd("requireSuccessScreenshotInLogs").equals("yes")) {
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

	public void screenshotPass(WebDriver driver,String testName, String fileName) {

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

	public WebElement element(WebDriver driver,String locator, int waitTime) {
		if(super.getOS().equals("Web")) {
		this.waitForJStoLoad(driver, waitTime);
		}
		WebElement Element = null;
		Element = super.element(driver,locator, waitTime);
		if(super.getOS().equals("Web")) {
		try {
			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			}
		} catch (Exception e) {
			System.out.println("Hiligghting the elemnt not possible now : " + Element);
		}
		}
		return Element;
	}

	public void waitForElement_Visibility(WebDriver driver,String locator, int waitTime) {
		try {
			super.waitForElementVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_InVisibility(WebDriver driver,String locator, int waitTime) {
		try {
			super.waitForElementInVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Clickable(WebDriver driver,String locator, int waitTime) {
		try {
			super.waitForElementClickable(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Presence(WebDriver driver,String locator, int waitTime) {
		try {
			super.waitForElementPresence(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void click(WebDriver driver,String locator, int waitTime) {
		element(driver,locator, waitTime).click();
	}


	public void setText(WebDriver driver,String locator, String value, int waitTime) {
		try {
			element(driver,locator, waitTime).click();
			element(driver,locator, waitTime).clear();
		} catch (Exception e) {
			System.out.println(e);
		}
		element(driver,locator, waitTime).sendKeys(value);
	}

	public void setText_ByActions(WebDriver driver,String locator, String value, int waitTime) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element(driver,locator, waitTime));
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
	}

	public String getText(WebDriver driver,String locator, int waitTime) {
		String s = element(driver,locator, waitTime).getText();
		return s;
	}

	public String getTextOptional(WebDriver driver,String locator, int waitTime) {
		String s = "";
		try {
			s = element(driver,locator, waitTime).getText();
		} catch (Exception e) {
			System.out.println("Element  Not found. Locator is :" + locator + " and exception is : " + e);
		}
		return s;
	}

	public String getAttributeValue_String(WebDriver driver,String locator, String attributeName, int waitTime) {
		String s = element(driver,locator, waitTime).getAttribute(attributeName);
		return s;
	}

	public boolean getAttributeValue_Boolean(WebDriver driver,String locator, String attributeName, int waitTime) {
		boolean f = false;
		f = element(driver,locator, waitTime).getAttribute(attributeName) != null;
		return f;
	}

	public void kepad_Enter(WebDriver driver,String locator, int waitTime) {
		element(driver,locator, waitTime).sendKeys(Keys.RETURN);
	}

	public void assertEquals_Text(WebDriver driver,String testName, String fileName, String actualText, String expectedText)
			throws IOException {
		Assert.assertEquals(actualText, expectedText);
		this.screenshotPass(driver,testName, fileName);

	}

	public void assertContains_Text(WebDriver driver,String testName, String fileName, String actualText, String expectedText)
			throws IOException {
		this.assertEquals_True(driver,testName, fileName, super.stringCompare_contains(actualText, expectedText));
		this.screenshotPass(driver,testName, fileName);

	}

	public void assertEquals_True(WebDriver driver,String testName, String fileName, boolean actualValue_WhichReturnsTrue)
			throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsTrue, true);
		this.screenshotPass(driver,testName, fileName);

	}

	public void assertEquals_False(WebDriver driver,String testName, String fileName, boolean actualValue_WhichReturnsFalse)
			throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsFalse, false);
		this.screenshotPass(driver,testName, fileName);

	}
	// -------------- WebDriver Actions-------------------------------------------------------------------------------//

	public void getPage(WebDriver driver,String pageURL) {
		driver.get(super.pvd(pageURL));
	}

	public void getPage_Direct(WebDriver driver,String pageURL) {
		driver.get(pageURL);
	}

	public void naavigateToUrl(WebDriver driver,String navigationUrl) {
		driver.navigate().to(super.pvd(navigationUrl + super.pvd("runIn")));
		super.sleep(3000);
	}

	public String getCurrentPageTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentPageUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}

	public int getDropDownListCount(WebDriver driver,String locator) {
		int i = 0;
		Select dropDown = new Select(element(driver,locator, waitTime));
		List<WebElement> elementCount = dropDown.getOptions();
		System.out.println("List Count is " + elementCount.size());
		i = elementCount.size();
		return i;
	}

	public void selectDropDownValue(WebDriver driver,String locator, int dropDownValueNumber) {
		this.click(driver,locator, waitTime);
		int i = dropDownValueNumber + 1;
		this.sleep(1000);
		this.click(driver,locator + "/select/option[" + i + "]", waitTime);
		this.sleep(2000);
	}

	public void selectDateFromCalender(WebDriver driver,String dateLocator, String dateFieldXpathStartValue, String dateToBeSelected,
			String invalidDate_ClassNameContains) {
		String outputDateValue = null;
		String clsName = null;
		this.click(driver,dateLocator, waitTime);
		outerloop: for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				String loc = xpath + dateFieldXpathStartValue + i + "]/td[" + j + "]";
				try {
					outputDateValue = this.getAttributeValue_String(driver,loc, "innerText", waitTime).split("\n")[0];
					clsName = this.getAttributeValue_String(driver,loc, "className", waitTime);
				} catch (Exception e) {
					System.out.println(e);
				}
				if (clsName.contains(invalidDate_ClassNameContains)) {
					System.out.println("Invalid Date");
				} else if (outputDateValue.equals(dateToBeSelected)) {
					this.click(driver,loc, waitTime);
					break outerloop;
				}
			}
		}
		super.sleep(2000);

	}

	public int listCount(WebDriver driver,String listsXpath) {
		List<WebElement> ls = driver.findElements(By.xpath(listsXpath));
		int count = ls.size();
		System.out.println("List count of given xpath is :" + count);
		return count;
	}

	public void scrollDownFullPage(WebDriver driver,int scrollCount) {
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		super.sleep(3000);

	}

	public void scrollDown_Web(WebDriver driver,int scrollCount, int scrollSize) {
		String scrollTo = "window.scrollBy(0," + scrollSize + ")";
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(scrollTo);
		}
		super.sleep(2000);
	}

	public void scrollUp_Web(WebDriver driver,int scrollCount) {
		for (int i = 1; i <= scrollCount; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		}
	}

	public void clickAndHold_Actions_Web(WebDriver driver,String locator, int waitTime) {
		// Use action class to mouse hover on Text box field
		Actions action = new Actions(driver);
		action.clickAndHold(element(driver,locator, waitTime)).perform();
		action.release(element(driver,locator, waitTime));
	}

}
*/