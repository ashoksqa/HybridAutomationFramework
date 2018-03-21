package AutomationSuites.webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nativeApp.EndPage;

public class P1_TestCases extends EndPage {
	WebDriver driver;

	// AppiumDriver<?> driver;
	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		driver = super.launchBrowser(driver);
		//super.openWebAppUrl(driver);
		//super.loginWebApp(driver);
		//super.click_NoTahnks_NotificationWeb(driver);
		// adriver=super.installAndroidApp(adriver, "Android
		// Device",super.pvWebApp("PlatformVersion"), super.pvWebApp("udid"));
	}

	@Test
	public void flipkartTest() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();

		super.getPage(driver, "https://www.flipkart.com/");
		String uid_loc = xpath + "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input";
		super.setText(driver, uid_loc, "12345678990", waitTime);

		super.assertEquals_Text(driver, testName, "uid test", super.getAttributeValue_String(driver, uid_loc, "value",waitTime), "12345678990");
super.loginWebApp(driver, "ramesh", "ramesh");
	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {
		super.testResult(driver, testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver(driver);
		System.out.println("Stopped");
	}

}
