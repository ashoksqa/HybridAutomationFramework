package AutomationSuites.webApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.annotations.Test;

import frameworkLibrary.Config;

public class Sanity_TestCases extends Config{
	protected DateFormat dateFormat2 = new SimpleDateFormat("dd MMM,yyyy");
	protected String dateWithTime = dateFormat.format(new Date());

	
	@Test
	public void tt() {
		
		System.out.println(super.date_02SpaceFebraurySpace2018);
		//System.out.println(super.date_02SpaceFebSpace2018);

	}
	
}
