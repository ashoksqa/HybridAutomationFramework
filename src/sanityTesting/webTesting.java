package sanityTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.Config;
import frameworkLibrary.webDriverConfig;

public class webTesting extends Config {
	WebDriver driver;

	public void launchBrowser() throws Exception {
		System.out.println("Executing");
		// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver",
				"../HybridAutomationFramework/lib/windows/drivers/chromedriver.exe");
		// create chrome instance
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}
	
	public void selectDropDownValue(String locator, int dropDownNumber) {
		super.element(driver, locator).click();
		int i = dropDownNumber + 1;
		try {
			super.waitForElementVisibility(driver, locator, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + locator);
		}
		super.element(driver, locator + "/select/option[" + i + "]").click();
	}
	public void selectDateFromCalender(String dateFieldXpathStartValue, String dateToBeSeected) {
		String outputDateValue = null;
		String clsName = null;
		outerloop:
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				String loc = dateFieldXpathStartValue + i + "]/td[" + j + "]";
				try {
					outputDateValue = super.element(driver, loc).getAttribute("innerText").split("\n")[0];
					System.out.println("outputDateValue is :"+ outputDateValue);
					clsName = super.element(driver, loc).getAttribute("className");
					System.out.println("Classname is : "+ clsName);
				} catch (Exception e) {
					System.out.println(e);
				}
				if (clsName.contains("ui-datepicker-unselectable")) {
					System.out.println("Unselectable Date");
				} else if (outputDateValue.equals(dateToBeSeected)) {
					super.element(driver, loc).click();
					System.out.println("Braking the for loop");
					break outerloop;
				}
			}
		}

	}
	
	public int getListCount_DropDown(String locator) {
		int i = 0;
		Select dropDown = new Select(super.element(driver, locator));
		List<WebElement> elementCount = dropDown.getOptions();
		System.out.println("List Count is " + elementCount.size());
		i = elementCount.size();
		return i;

	}
	
	public void bookAppointment(String name,String email) throws InterruptedException {
		String contactUs = xpath + "/html/body/div[2]/header/div/div[3]/div/nav[1]/ul/li[7]/a";
String bookAppointment=xpath+"/html/body/div[2]/header/div/div[3]/div/nav[1]/ul/li[7]/ul/li[2]/a";
String maleRadioBtn=xpath+"//*[@id=\"user_field0_value\"]";
driver.get(super.pvd("siteUrl"));
try {
	super.waitForElementVisibility(driver, contactUs, waitTime);
} catch (Exception e) {
	System.out.println("Elemnt Not found : " + contactUs);
}
		super.element(driver, contactUs).click();
		Thread.sleep(1000);
		super.element(driver, bookAppointment).click();
		super.element(driver, id+"name").sendKeys(name);
		super.element(driver, id+"phone").sendKeys("2345676543");
		super.element(driver, id+"email").sendKeys(email);
		super.element(driver, maleRadioBtn).click();
		super.element(driver, id+"user_field2_value").sendKeys(name);
		this.selectDropDownValue(xpath+"/html/body/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/form/div[6]", 1);
		this.selectDropDownValue(xpath+"/html/body/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/form/div[7]", 1);
		System.out.println("todaye is :"+super.getTodayDate());
		this.selectDateFromCalender(xpath+"/html/body/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/form/div[8]/div/table/tbody/tr[", super.getTodayDate());
		super.element(driver, id+"time").click();
		super.element(driver, xpath+"/html/body/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/form/div[9]/select/option[2]").click();
		super.element(driver, id+"submit").click();
		
	}

}
