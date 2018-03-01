package frameworkLibrary;

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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class mobDriverConfig extends Config{
	private AppiumDriverLocalService service;
	AppiumDriver<?> driver;
	private DesiredCapabilities cap;

	// Android App Installation with appium server
		public void androidAppInstall() {
			cap = new DesiredCapabilities();
			cap.setCapability("clearSystemFiles", true);
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
							.withAppiumJS(new File(appiumJS_Path))
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
			driver = new AndroidDriver<AndroidElement>(service, cap);
			service.stop();
		}

		// Android App Installation with appium server
		public AppiumDriver<?> androidAppLaunch() {
			cap = new DesiredCapabilities();
			cap.setCapability("clearSystemFiles", true);

			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
							.withAppiumJS(new File(appiumJS_Path))
							.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
			File apk = new File(appDir, this.pvts("Merchant" + Trow) + ".apk");
			System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".apk");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
			cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
			cap.setCapability("automationName", "uiautomator2");
			cap.setCapability("udid", this.pvts("Udid" + Trow));
			cap.setCapability("appPackage", super.pvData("appPackage"));
			cap.setCapability("appActivity", super.pvData("appActivity"));
			// cap.setCapability("clearSystemFiles", true);
			cap.setCapability(MobileCapabilityType.FULL_RESET, false);
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
			String systemPort = randomNumString(3);
			String systemPort1 = Trow + systemPort;
			cap.setCapability("systemPort", systemPort1);
			cap.setCapability("app", apk.getAbsolutePath());
			driver = new AndroidDriver<AndroidElement>(service, cap);
			return driver;
		}

		// iOS App Installation with appium server
		public AppiumDriver<?> iOSAppiumSetup() {
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
							.withAppiumJS(new File(appiumJS_Path))
							.withIPAddress("127.0.0.1").usingAnyFreePort());

			File ipa = new File(appDir, this.pvts("Merchant" + Trow) + ".ipa");
			System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".ipa");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", this.pvts("OS" + Trow));
			// cap.setCapability(CapabilityType.PLATFORM, "Mac");
			cap.setCapability("automationName", "XCUITest");
			cap.setCapability("xcodeOrgId", super.pvData("xcodeOrgId"));
			cap.setCapability("xcodeSigningId", super.pvData("xcodeSigningId"));
			cap.setCapability("deviceName", this.pvts("DeviceName" + Trow));
			cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
			cap.setCapability("useNewWDA", true);
			String wdaLocalPort = randomNumString(3);
			String wdaLocalPort1 = Trow + wdaLocalPort;
			cap.setCapability("wdaLocalPort", wdaLocalPort1);
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability("udid", this.pvts("Udid" + Trow));
			cap.setCapability("bundleId", super.pvData("bundleId"));
			cap.setCapability("app", ipa.getAbsolutePath());

			driver = new IOSDriver<IOSElement>(service, cap);
			return driver;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void quitDriver() {
		driver.quit();
	}

	public void closeDriver() {
		driver.close();
	}

	public void testResult(ITestResult testResult) throws IOException {
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

	public void screenshotPass(String testName,String fileName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folder_name_pass = this.pvts("AppType" + Trow) + "_" + this.pvts("OS" + Trow) + "_"
				+ this.pvts("DeviceName" + Trow) + "_Pass_" + dateWithTime + "/"+testName+"/";

		String ImageFileName = fileName + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(screenshotsPath + "/" + folder_name_pass + ImageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitForElement_Visibility(String locator, int waitTime) {
		try {
			super.waitForElementVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_InVisibility(String locator, int waitTime) {
		try {
			super.waitForElementInVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Clickable(String locator, int waitTime) {
		try {
			super.waitForElementClickable(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}

	public void waitForElement_Presence(String locator, int waitTime) {
		try {
			super.waitForElementPresence(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}

	}
	
	

	public void click(String locator,int waitTime) {
		super.element(driver, locator, waitTime).click();
	}
	public void click(String locator1,String locator2) {
		super.element(driver, locator1, waitTime).click();
		super.element(driver, locator2, waitTime).click();
}
	public void click(String locator1,String locator2,String locator3) {
		super.element(driver, locator1, waitTime).click();
		super.element(driver, locator2, waitTime).click();
		super.element(driver, locator3, waitTime).click();

	}

	public void setText(String locator, String value,int waitTime) {
		try {
		super.element(driver, locator, waitTime).click();
		super.element(driver, locator, waitTime).clear();
		}catch(Exception e){System.out.println(e);}
		super.element(driver, locator, waitTime).sendKeys(value);
	}

	public void setText_ByActions(String locator, String value,int waitTime) {

		Actions actions = new Actions(driver);
		actions.moveToElement(super.element(driver, locator, waitTime));
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
	}

	public String getText(String locator,int waitTime) {
		String s = super.element(driver, locator, waitTime).getText();
		return s;
	}

	public String getTextOptional(String locator,int waitTime) {
		String s = "";
		try {
			s = super.element(driver, locator, waitTime).getText();
		} catch (Exception e) {
			System.out.println("Element  Not found. Locator is :" + locator + " and exception is : " + e);
		}
		return s;
	}

	public String getAttributeValue_String(String locator, String attributeName,int waitTime) {
		String s = super.element(driver, locator, waitTime).getAttribute(attributeName);
		return s;
	}

	public boolean getAttributeValue_Boolean(String locator, String attributeName,int waitTime) {
		boolean f = false;
		f = super.element(driver, locator, waitTime).getAttribute(attributeName) != null;
		return f;
	}

	public void kepad_Enter(String locator,int waitTime) {
		super.element(driver, locator, waitTime).sendKeys(Keys.RETURN);
	}

	public void assertEquals_Text(String testName,String fileName, String actualText, String expectedText) throws IOException {
		Assert.assertEquals(actualText, expectedText);
		this.screenshotPass(testName,fileName);

	}

	public void assertContains_Text(String testName,String fileName, String actualText, String expectedText) throws IOException {
		this.assertEquals_True(testName,fileName, super.stringCompare_contains(actualText, expectedText));
		this.screenshotPass(testName,fileName);

	}
	
	public void assertEquals_True(String testName,String fileName, boolean actualValue_WhichReturnsTrue) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsTrue, true);
		this.screenshotPass(testName,fileName);

	}

	public void assertEquals_False(String testName,String fileName, boolean actualValue_WhichReturnsFalse) throws IOException {
		Assert.assertEquals(actualValue_WhichReturnsFalse, false);
		this.screenshotPass(testName,fileName);

	}
	// ---------------------------------------------------------------------------------------------------------------//

	public void getPage(String pageURL) {
		driver.get(super.pvd(pageURL));
	}
	public void getPage_Direct(String pageURL) {
		driver.get(pageURL);
	}
	public void naavigateToUrl(String navigationUrl) {
		driver.navigate().to(super.pvd(navigationUrl+super.pvd("runIn")));
		super.sleep(3000);
	}

	public String getCurrentPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getCurrentPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public int getDropDownListCount(String locator) {
		int i = 0;
		Select dropDown = new Select(super.element(driver, locator, waitTime));
		List<WebElement> elementCount = dropDown.getOptions();
		System.out.println("List Count is " + elementCount.size());
		i = elementCount.size();
		return i;
	}

	public void selectDropDownValue(String locator, int dropDownValueNumber) {
		this.click(locator,waitTime);
		int i = dropDownValueNumber + 1;
		this.sleep(1000);
		this.click(locator + "/select/option[" + i + "]",waitTime);
		this.sleep(2000);
	}

	public void selectDateFromCalender(String dateLocator, String dateFieldXpathStartValue, String dateToBeSelected,
			String invalidDate_ClassNameContains) {
		String outputDateValue = null;
		String clsName = null;
		this.click(dateLocator,waitTime);
		outerloop: for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				String loc = xpath + dateFieldXpathStartValue + i + "]/td[" + j + "]";
				try {
					outputDateValue = this.getAttributeValue_String(loc, "innerText",waitTime).split("\n")[0];
					clsName = this.getAttributeValue_String(loc, "className",waitTime);
				} catch (Exception e) {
					System.out.println(e);
				}
				if (clsName.contains(invalidDate_ClassNameContains)) {
					System.out.println("Invalid Date");
				} else if (outputDateValue.equals(dateToBeSelected)) {
					this.click(loc,waitTime);
					break outerloop;
				}
			}
		}
super.sleep(2000);

	}

	

	public int listCount(String listsXpath) {
		List<WebElement> ls = driver.findElements(By.xpath(listsXpath));
		int count = ls.size();
		System.out.println("List count of given xpath is :" + count);
		return count;
	}
	
	public void scrollDownFullPage(int scrollCount) {
		for(int i=1;i<=scrollCount;i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
		super.sleep(3000);

	}
	
	public void scrollDown(int scrollCount,int scrollSize ) {
		String scrollTo ="window.scrollBy(0,"+scrollSize+")";
		for(int i=1;i<=scrollCount;i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(scrollTo);
		}
		super.sleep(2000);
	}
	public void scrollUp(int scrollCount) {
		for(int i=1;i<=scrollCount;i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		}
	}
	
	public void clickAndHold_Actions(String locator,int waitTime) {
		// Use action class to mouse hover on Text box field
				Actions action = new Actions(driver);
				action.clickAndHold(super.element(driver, locator, waitTime)).perform();
				action.release(super.element(driver, locator, waitTime));
}
	
}
