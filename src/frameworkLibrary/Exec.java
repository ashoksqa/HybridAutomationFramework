package frameworkLibrary;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkLibrary.reporting.MailReporting;


public class Exec  {
Config cg = new Config(); 
	MailReporting mail = new MailReporting();

	@BeforeTest
	public void executeBefore() throws IOException {

		System.out.println("Executing");
		cg.updateTestSuiteProperties();
	}

	@Test
	public void execute() throws IOException {

		cg.suitesExecution();

	}

	@AfterTest
	public void sendMail() throws Exception {
		//mail.htmlMail();
	}
}