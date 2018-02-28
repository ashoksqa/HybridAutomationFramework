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

public class testing extends Config {
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	protected String dateWithTime = dateFormat.format(new Date());
	WebDriver driver;
	WebDriver driver1;

	public void getBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://webapp.getion.in");
	}

	public void login() {
		String uid = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[1]/div[2]/input";
		String pwd = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[2]/div[2]/input";
		String submitBtn = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[3]/button";

		super.element(driver, uid, waitTime).sendKeys("ramesh");
		super.element(driver, pwd, waitTime).sendKeys("ramesh");
		super.element(driver, submitBtn, waitTime).click();
	}
	// Thread m = Thread.currentThread();;

	// @Test
	public void sitesVerify() throws Exception {
		this.getBrowser();
		this.login();
		Thread.sleep(7000);
		String notification_NothanksBtn = xpath + "//*[@id=\"onesignal-popover-cancel-button\"]";
		super.element(driver, notification_NothanksBtn, waitTime).click();
		Thread.sleep(8000);
		String calendarIcon = cls + "cal-date";
		super.element(driver, calendarIcon, waitTime).click();
		super.sleep(5000);
		String addNewTopic = xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[1]/button";
		super.element(driver, addNewTopic, 10).click();
		super.element(driver, xpath+"/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[1]/ul/li[4]/img", 10).click();
		super.sleep(2000);
		super.element(driver, xpath+"/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[1]/ul/li[4]/img", 10).click();
		String b = "";
		String txt = null;
		try {
			
			txt=xpath+"/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/ul/li/div[1]/span";
			b=super.element(driver, txt, 10).getText();

		}catch(Exception e) {System.out.println(e);}
		if(b.isEmpty()) {
			System.out.println("Success");
		System.out.println("1 Passed :"+b);

		}	
		super.sleep(5000);

		String c=null;
		String txt1 = null;
		try {
			
			txt1=xpath+"/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/ul/li/div[1]/span";
			c=super.element(driver, txt1, 10).getText();

		}catch(Exception e) {System.out.println(e);}
		if(c.isEmpty()) {
			System.out.println("Success");
		System.out.println("1 Passed :"+c);

		}	
		
		super.sleep(5000);
	}
	@Test
	public void tttttt() throws Exception {
		String s ="adfqfaf";
		System.out.println(s.substring(0,1));
	}
}