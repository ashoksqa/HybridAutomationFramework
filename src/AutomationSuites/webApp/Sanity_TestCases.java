package AutomationSuites.webApp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.annotations.Test;

public class Sanity_TestCases {
	protected DateFormat dateFormat2 = new SimpleDateFormat("dd MMM,yyyy");
	protected String dateWithTime = dateFormat.format(new Date());

	
	@Test
	public void tt() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dateFormat.format(new Date()));
		
	}
	
}
