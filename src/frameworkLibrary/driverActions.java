package frameworkLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverActions extends Config {
	
	public WebElement element(WebDriver driver,String locator, int waitTime) {
		this.waitForJStoLoad(driver, waitTime);
		WebElement Element = null;
		Element = super.element(driver,locator, waitTime);
		try {
			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", Element);
			}
		} catch (Exception e) {
			System.out.println("Hiligghting the elemnt not possible now : " + Element);
		}
		return Element;
	}

	public void click(WebDriver driver,String locator, int waitTime) {
		element(driver,locator, waitTime).click();
	}

	public void click(WebDriver driver,String locator1, String locator2) {
		element(driver,locator1, waitTime).click();
		element(driver,locator2, waitTime).click();
	}

	public void click(WebDriver driver,String locator1, String locator2, String locator3) {
		element(driver,locator1, waitTime).click();
		element(driver,locator2, waitTime).click();
		element(driver,locator3, waitTime).click();

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
	
	// ---------------------ION Reusable Methods------------------------//
	

	public void selectDropDownValue(WebDriver driver,String locator, int dropDownValueNumber) {
		this.click(driver,locator, waitTime);
		this.sleep(1000);
		this.click(driver,locator + "/select/option[" + dropDownValueNumber + "]", waitTime);
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


	
	//================================= Mobile Actions ==================================================//
	
	public WebElement elementMobile(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		WebElement Element = null;
		String locator = this.locatorByOS(driver,locator_Android, locator_iOS);
		Element = super.element(driver, locator, waitTime);
		return Element;
	}

	public void click(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		elementMobile(driver,locator_Android, locator_iOS, waitTime).click();
	}

	public void setText(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {
		try {
			elementMobile(driver,locator_Android, locator_iOS, waitTime).click();
			elementMobile(driver,locator_Android, locator_iOS, waitTime).clear();
		} catch (Exception e) {
			System.out.println(e);
		}
		elementMobile(driver,locator_Android, locator_iOS, waitTime).sendKeys(value);
	}
	
	public void setValue(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {
		
		((MobileElement) elementMobile(driver,locator_Android, locator_iOS, waitTime)).setValue(value);
	}

	public void setText_ByActions(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {

		Actions actions = new Actions(driver);
		actions.moveToElement(elementMobile(driver,locator_Android, locator_iOS, waitTime));
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
	}

	public String getText(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		String s = elementMobile(driver,locator_Android, locator_iOS, waitTime).getText();
		return s;
	}

	public String getTextOptional(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		String s = "";
		try {
			s = elementMobile(driver,locator_Android, locator_iOS, waitTime).getText();
		} catch (Exception e) {
			System.out.println("Element  Not found. Locator is :" + super.locatorByOS(driver,locator_Android, locator_iOS)
					+ " and exception is : " + e);
		}
		return s;
	}

	public String getAttributeValue_String(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String attributeName,
			int waitTime) {
		String s = elementMobile(driver,locator_Android, locator_iOS, waitTime).getAttribute(attributeName);
		return s;
	}

	public boolean getAttributeValue_Boolean(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String attributeName,
			int waitTime) {
		boolean f = false;
		f = elementMobile(driver,locator_Android, locator_iOS, waitTime).getAttribute(attributeName) != null;
		return f;
	}
	

}
