package AutomationSuites.webApp;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webApp.MarketingCalenderPage;

public class P1_TestCases extends MarketingCalenderPage {

	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.updateTrow(Trow);
		super.launchBrowser();
		//super.openSiteUrl();
		System.out.println("Current Executing Method : " + testName);
		//super.login("ramesh", "ramesh");
		//super.click_NoTahnks_Notification();
	}
	
	@Test
	public void testt() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		//super.login("ramesh", "ramesh");
		//super.click_NoTahnks_Notification();
		super.askQuestion_Website_QueriesPage(1, testName, testName, testName, testName, testName, testName, 1);
		super.sleep(5000);
		super.click_SideMenuTabs_HomePage(5);
		int i=super.listCount("/html/body/app-root/app-leads/div/div/div/div/div/div[2]/table");
		int j=super.listCount("/html/body/app-root/app-leads/div/div/div/div/div/div[2]");

		System.out.println("count is : "+i);
		System.out.println("count is : "+j);

		//super.addTopicToCalendar_MarketingCalenderPage(testName, super.newTopic_MarketingCalendarPage, 2, "27");
super.verifyData_MarketingCalendarPage(testName, "7", "test blog", "Ionized", "News", "Ramesh");	
super.sleep(5000);
	}


	@AfterMethod
	public void results(ITestResult testResult) throws IOException {
		super.testResult(testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver();
		System.out.println("Stopped");
	}

}
