package webSites;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import frameworkLibrary.webDriverConfig;

public class Sanity extends webDriverConfig {
	WebDriver driver;
	
	public void launch() {
		System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               //System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
           else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
           else {
               System.out.println("Missed URL lists : "+linkUrl);
           }
        } catch (Exception e) {
           
        }
    } 
	
	public void scrollDown(int scrollCount) {
		for(int i=0;i<=scrollCount;i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,500)");
	        super.sleep(5000);
		}
		super.sleep(3000);
	}
	
	//@Test
	public void errors_404() {
		int urlNumber=2;
		launch();
		driver.get(super.pvWeb("url"+urlNumber));
		super.sleep(5000);
		List<WebElement> links=driver.findElements(By.xpath("//*[@href or @src]")); 
		int linksCount = links.size();
		System.out.println("Total Links : "+linksCount);
		for(int i=0;i<linksCount;i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			verifyLinkActive(url);
			
		}
		
	}
	
	public void scrollUp(int scrollCount) {
		for(int i=1;i<=scrollCount;i++) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	}

	@Test
	public void testing() {
		launch();
		driver.get(super.pvWeb("url"+1));
		super.sleep(5000);
		//this.scrollDown(5);
		super.sleep(5000);
		this.scrollUp(1);

		
	}}
