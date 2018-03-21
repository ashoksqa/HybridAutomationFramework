package AutomationSuites.webApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.Config;
import nativeApp.EndPage;

public class Sanity_TestCases extends EndPage{
	protected DateFormat dateFormat2 = new SimpleDateFormat("dd MMM,yyyy");
	protected String dateWithTime = dateFormat.format(new Date());
WebDriver driver;
	
	@Test
	public void tt() {
		
		super.naavigateToUrl(driver, "jdbskh");
		id,xpath,css loca
super.setText(driver, xpath+"identifierId", "skhfvgks", super.waitTime);
		super.setText(driver, xpath+"", "shgkd", waitTime);
		super.click(driver, locator, waitTime);
		super.click(driver, id+"mn vm", waitTime);
		
	}
	
}
