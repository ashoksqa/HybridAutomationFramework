package frameworkLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;

public class AllDrivers {
	WebDriver wdriver;
	AppiumDriver<AndroidElement> adriver;
	AppiumDriver<IOSElement> idriver;
	private String Dir = System.getProperty("user.dir");

	public void launchChrome(String ch_mz) throws Exception {

		System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
		wdriver = new ChromeDriver();
		wdriver.manage().window().maximize();

	}
}
