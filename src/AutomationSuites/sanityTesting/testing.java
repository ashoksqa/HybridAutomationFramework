package AutomationSuites.sanityTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import frameworkLibrary.Config;
import nativeApp.EndPage;

public class testing extends EndPage {
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	protected String dateWithTime = dateFormat.format(new Date());
	WebDriver driver;

	public void getBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://webapp.getion.in");
	}

	
	 @Test
	public void sitesVerify() throws Exception {
		this.getBrowser();
super.loginWebApp(driver);
Thread.sleep(5000);
String notification_NothanksBtn = xpath + "//*[@id=\"onesignal-popover-cancel-button\"]";
super.element(driver, notification_NothanksBtn, waitTime).click();
super.click_SettingsAndTabs(driver, 4);
super.sleep(2000);
super.click(driver, xpath+"/html/body/app-root/app-settings/div/div/div/div/div/div/div/div/h2", waitTime);
super.click(driver, xpath+"/html/body/app-root/app-settings/div[2]/div/div[2]/div[1]/span[3]/*[@id='rdblGender_0']", 5);
super.sleep(9000);

	}
	
	
	public void tttttt() throws Exception {
		String s ="adfqfaf";
		System.out.println(s.substring(0,1));
	}
}