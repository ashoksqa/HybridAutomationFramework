package frameworkLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileActions extends WebActions {

	public WebElement element(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		WebElement Element = null;
		String locator = this.locatorByOS(driver,locator_Android, locator_iOS);
		Element = super.element(driver, locator, waitTime);
		return Element;
	}

	public void click(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		element(driver,locator_Android, locator_iOS, waitTime).click();
	}

	public void setText(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {
		try {
			element(driver,locator_Android, locator_iOS, waitTime).click();
			element(driver,locator_Android, locator_iOS, waitTime).clear();
		} catch (Exception e) {
			System.out.println(e);
		}
		element(driver,locator_Android, locator_iOS, waitTime).sendKeys(value);
	}
	
	public void setValue(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {
		
		((MobileElement) element(driver,locator_Android, locator_iOS, waitTime)).setValue(value);
	}

	public void setText_ByActions(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String value, int waitTime) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element(driver,locator_Android, locator_iOS, waitTime));
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
	}

	public String getText(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		String s = element(driver,locator_Android, locator_iOS, waitTime).getText();
		return s;
	}

	public String getTextOptional(AppiumDriver<?> driver,String locator_Android, String locator_iOS, int waitTime) {
		String s = "";
		try {
			s = element(driver,locator_Android, locator_iOS, waitTime).getText();
		} catch (Exception e) {
			System.out.println("Element  Not found. Locator is :" + super.locatorByOS(driver,locator_Android, locator_iOS)
					+ " and exception is : " + e);
		}
		return s;
	}

	public String getAttributeValue_String(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String attributeName,
			int waitTime) {
		String s = element(driver,locator_Android, locator_iOS, waitTime).getAttribute(attributeName);
		return s;
	}

	public boolean getAttributeValue_Boolean(AppiumDriver<?> driver,String locator_Android, String locator_iOS, String attributeName,
			int waitTime) {
		boolean f = false;
		f = element(driver,locator_Android, locator_iOS, waitTime).getAttribute(attributeName) != null;
		return f;
	}

}
