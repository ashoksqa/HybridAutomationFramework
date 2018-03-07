/*package frameworkLibrary;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class testing extends Config {
	protected DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	protected String dateWithTime = dateFormat.format(new Date());
	//WebDriver driver;
	//WebDriver driver1;

	private AppiumDriverLocalService service;
	AppiumDriver<?> driver;
	private DesiredCapabilities cap;	
	
	// Android App Installation with appium server
		public AppiumDriver<?> androidAppLaunch() {
			int Trow=1;
			cap = new DesiredCapabilities();
			cap.setCapability("clearSystemFiles", true);

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(nodeExecutablePath)).withAppiumJS(new File(appiumJS_Path))
					.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
			File apk = new File(appDir, "ION.apk");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
			cap.setCapability(AndroidMobileCapabilityType.PLATFORM, "ANDROID");
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
			driver = new AndroidDriver<AndroidElement>(service, cap);
			return driver;
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

	@Test
	public void sitesUpdate() throws Exception {
		 androidAppLaunch();
		 System.out.println(driver.getCapabilities().getCapability("platformName"));
		 String a=driver.getCapabilities().getVersion();
		 System.out.println(driver.getCapabilities().getVersion());

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
	
	//@Test
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
*/