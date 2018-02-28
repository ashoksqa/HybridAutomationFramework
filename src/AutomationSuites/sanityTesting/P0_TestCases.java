package AutomationSuites.sanityTesting;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import sanityTesting.iosTesting;

public class P0_TestCases extends iosTesting {

	@Parameters({ "Trow" })
	@BeforeTest
	public void setupBefore(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		super.launchBrowser();

	}

	@Test(description = "test1 description", priority = 1)
	public void test11() throws IOException, InterruptedException {

		super.bookAppointment("AutomationTest", "test@medicodemo.com");
		System.out.println("A is :" + super.pvd("A"));
	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {

		// super.testResult(testResult);
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		// super.quitDriver();
		System.out.println("Stopped");
	}

}
