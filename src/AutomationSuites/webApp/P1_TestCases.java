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
		// super.openSiteUrl();
		System.out.println("Current Executing Method : " + testName);
		// super.login("ramesh", "ramesh");
		// super.click_NoTahnks_Notification();
	}

	@Test
	public void testt() throws IOException {
<<<<<<< HEAD
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openSiteUrl();
		super.login("ramesh", "ramesh");
		super.click_NoTahnks_Notification();
=======
		/*String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		// super.login("ramesh", "ramesh");
		// super.click_NoTahnks_Notification();
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(testName, 1, subject_AskQuestion_WebPage_QueriesPage,
				message_AskQuestion_WebPage_QueriesPage, name_AskQuestion_WebPage_QueriesPage,
				email_AskQuestion_WebPage_QueriesPage, age_AskQuestion_WebPage_QueriesPage,
				mobileNumber_AskQuestion_WebPage_QueriesPage, 2);
		System.out.println(subject_AskQuestion_WebPage_QueriesPage+" :: "+
				message_AskQuestion_WebPage_QueriesPage+" :: "+ name_AskQuestion_WebPage_QueriesPage+" :: "+
				email_AskQuestion_WebPage_QueriesPage+" :: "+ age_AskQuestion_WebPage_QueriesPage+" :: "+
				mobileNumber_AskQuestion_WebPage_QueriesPage);
>>>>>>> 005c2d48269242f3cb1a194ae5b79aceff13b00e
		super.sleep(5000);
		super.openWebAppUrl();
		super.login("Ramesh", "ramesh");
		super.click_NoTahnks_Notification();
		super.click_SideMenuTabs_HomePage(4);
		super.sleep(5000);
		super.verifyData_QueriesPage(testName, 1, subject_AskQuestion_WebPage_QueriesPage,
				message_AskQuestion_WebPage_QueriesPage, name_AskQuestion_WebPage_QueriesPage, age_AskQuestion_WebPage_QueriesPage, "F",
				mobileNumber_AskQuestion_WebPage_QueriesPage, email_AskQuestion_WebPage_QueriesPage);
		
		super.sleep(5000);*/
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
