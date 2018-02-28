package frameworkLibrary;

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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class testing extends Config {
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	protected String dateWithTime = dateFormat.format(new Date());
	WebDriver driver;
	WebDriver driver1;


	public void getBrowser() throws Exception {
		System.setProperty("webdriver.gecko.driver", Dir + "/lib/windows/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://in.godaddy.com/dpp/find?checkAvail=1&tmskey=&domainToCheck=Archives.gov");
	}

	// https://moz.com/top500
	/// html/body/div[1]/div/div[1]/section/table/tbody/tr[1]/td[2]/a
	// innerText
	public void updateTestSuiteProperties(String i,String value) throws IOException {

		try {
			Properties props = new Properties();

			File f = new File(Dir + "/src/frameworkLibrary/sitesOutput2.properties");
			InputStream input = new FileInputStream(f);

			if (input != null) {
				System.out.println("Copying row number in Test Suite excel is :" + i);

				props.load(input);
				props.setProperty(i,value);
				OutputStream out = new FileOutputStream(f);
				props.store(out, "save");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void sitesUpdate() throws Exception {

		this.getBrowser();
		Thread.sleep(5000);
		for (int i = 1; i <= 500; i++) {
			//this.updateTestSuiteProperties(i);
		}

	}
	
	public void getBrowser1() throws Exception {
		System.setProperty("webdriver.chrome.driver", Dir + "/lib/windows/drivers/chromedriver.exe");
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver1.get("https://in.godaddy.com/dpp/find?checkAvail=1&tmskey=&domainToCheck=Archives.gov");
	}

	public String pvs(String propertyFileKey) {

		String propertyFileValue = "Please check property file key";
		InputStream is = null;
		Properties prop = null;
		try {
			prop = new Properties();
			is = new FileInputStream(new File(Dir + "/src/frameworkLibrary/sites.properties"));
			prop.load(is);
			propertyFileValue = prop.getProperty(propertyFileKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyFileValue;
	}
	
	//@Test
	public void sitesVerify() throws Exception {
		String[] S = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		this.getBrowser();
		Thread.sleep(5000);
		for(int i=1;i<=25;i++) {
			for(int j=0;j<=25;j++) {

		driver.findElement(By.id("t")).click();
		driver.findElement(By.id("t")).clear();
		
		driver.findElement(By.id("t")).sendKeys(S[i]+S[i]+S[j]);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div/button/span")).click();
		Thread.sleep(3000);
		try {
			String a =driver.findElement(
					By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div/div/p/span")).getAttribute("innerText");
			if(a.contains("Your domain is available")) {
				System.out.println("Domain FOund : "+ a);
				break;
			}
		}catch(Exception e) {System.out.println(e);}
		
		try {
		String s =driver.findElement(
				By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div/div/p/span")).getAttribute("innerText");
		this.updateTestSuiteProperties(S[i]+S[i]+S[j], s);
		System.out.println(s);
		Thread.sleep(1000);
		}catch(Exception e) {System.out.println(e);}
	}
		}
	
	}
	
	//@Test
	public void sitesVerify1() throws Exception {
		String[] S = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		this.getBrowser1();
		Thread.sleep(5000);
		for(int i=1;i<=25;i++) {
			for(int j=0;j<=25;j++) {

		driver1.findElement(By.id("t")).click();
		driver1.findElement(By.id("t")).clear();
		
		driver1.findElement(By.id("t")).sendKeys(S[i]+S[j]);
		driver1.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div/button/span")).click();
		Thread.sleep(3000);
		try {
			String a =driver1.findElement(
					By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div/div/p/span")).getAttribute("innerText");
			if(a.contains("Your domain is available")) {
				System.out.println("Domain FOund : "+ a);
				break;
			}
		}catch(Exception e) {System.out.println(e);}
		
		try {
		String s =driver1.findElement(
				By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div/div/div/p/span")).getAttribute("innerText");
		this.updateTestSuiteProperties(S[i]+S[j], s);
		System.out.println(s);
		Thread.sleep(1000);
		}catch(Exception e) {System.out.println(e);}
	}
	
		}
	}
	
	@Test
	public void tt() {
		String a="9:30AM - 10:30PM";
        String b="9:30AM-10:30PM";
        if(a.replaceAll("\\s+","").equalsIgnoreCase(b.replaceAll("\\s+",""))){
            System.out.println(a.replaceAll("\\s+","")+ "\n"+b.replaceAll("\\s+",""));
        }else{
            System.out.println("no");
        }
		
		
	}

}
