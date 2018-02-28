package AutomationSuites.webApp;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webApp.MarketingCalenderPage;

public class P2_TestCases extends MarketingCalenderPage {
	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		super.launchBrowser();
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Current Executing Method : " + testName);
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.click_NoTahnks_Notification();
	}

	// =========Select Topic From Home Page=====================================
	// // @Test(priority = 400)
	public void newBlog_SelectTopic_Draft_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 1, 1);
		super.verifyData_PublishPage(testName, 1, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// // @Test(priority = 401)
	public void newBlog_SelectTopic_Draft_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 1, 2);
		super.verifyData_PublishPage(testName, 1, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// // @Test(priority = 402)
	public void newBlog_SelectTopic_Draft_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 1, 3);
		super.verifyData_PublishPage(testName, 1, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 403)
	public void newBlog_SelectTopic_Ionize_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 2, 1);
		super.verifyData_PublishPage(testName, 2, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 404)
	public void newBlog_SelectTopic_Ionize_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 2, 2);
		super.verifyData_PublishPage(testName, 2, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 405)
	public void newBlog_SelectTopic_Ionize_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 2, 3);
		super.verifyData_PublishPage(testName, 2, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 406)
	public void newBlog_SelectTopic_PublishNow_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 3, 1);
		super.verifyData_PublishPage(testName, 3, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 407)
	public void newBlog_NewTopic_SelectNow_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 3, 2);
		super.verifyData_PublishPage(testName, 3, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 408)
	public void newBlog_SelectTopic_PublishNow_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 3, 3);
		super.verifyData_PublishPage(testName, 3, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 409)
	public void newBlog_SelectTopic_Schedule_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 4, 1);
		super.verifyData_PublishPage(testName, 4, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 410)
	public void newBlog_SelectTopic_Schedule_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 4, 2);
		super.verifyData_PublishPage(testName, 4, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 411)
	public void newBlog_SelectTopic_Schedule_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 1, 4, 3);
		super.verifyData_PublishPage(testName, 4, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// =========New Topic From Publish Page=====================================

	// @Test(priority = 451)
	public void newBlog_NewTopic_Draft_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 1, 2);
		super.verifyData_PublishPage(testName, 1, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 452)
	public void newBlog_NewTopic_Draft_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 1, 3);
		super.verifyData_PublishPage(testName, 1, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 453)
	public void newBlog_NewTopic_Ionize_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 2, 1);
		super.verifyData_PublishPage(testName, 2, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 455)
	public void newBlog_NewTopic_Ionize_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 2, 3);
		super.verifyData_PublishPage(testName, 2, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 456)
	public void newBlog_NewTopic_PublishNow_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 3, 1);
		super.verifyData_PublishPage(testName, 3, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 457)
	public void newBlog_NewTopic_PublishNow_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 3, 2);
		super.verifyData_PublishPage(testName, 3, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 460)
	public void newBlog_NewTopic_Schedule_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 4, 2);
		super.verifyData_PublishPage(testName, 4, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 461)
	public void newBlog_NewTopic_Schedule_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 4, 3);
		super.verifyData_PublishPage(testName, 4, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// =========Select Topic From Publish Page=====================================

	// @Test(priority = 500)
	public void newBlog_SelectTopic_Draft_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 1, 1);
		super.verifyData_PublishPage(testName, 1, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 501)
	public void newBlog_SelectTopic_Draft_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 1, 3);
		super.verifyData_PublishPage(testName, 1, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 502)
	public void newBlog_SelectTopic_Ionize_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 2, 1);
		super.verifyData_PublishPage(testName, 2, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 503)
	public void newBlog_SelectTopic_Ionize_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 2, 2);
		super.verifyData_PublishPage(testName, 2, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 504)
	public void newBlog_NewTopic_SelectNow_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 3, 2);
		super.verifyData_PublishPage(testName, 3, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 505)
	public void newBlog_SelectTopic_PublishNow_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 3, 3);
		super.verifyData_PublishPage(testName, 3, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 506)
	public void newBlog_SelectTopic_Schedule_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 4, 1);
		super.verifyData_PublishPage(testName, 4, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 507)
	public void newBlog_SelectTopic_Schedule_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 4, 3);
		super.verifyData_PublishPage(testName, 4, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// =========New Topic From Home Page=====================================

	// @Test(priority = 550)
	public void newBlog_NewTopic_Draft_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 1, 1);
		super.verifyData_PublishPage(testName, 1, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 551)
	public void newBlog_NewTopic_Draft_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 1, 2);
		super.verifyData_PublishPage(testName, 1, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 552)
	public void newBlog_NewTopic_Draft_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 1, 3);
		super.verifyData_PublishPage(testName, 1, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 553)
	public void newBlog_NewTopic_Ionize_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 2, 1);
		super.verifyData_PublishPage(testName, 2, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 554)
	public void newBlog_NewTopic_Ionize_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 2, 2);
		super.verifyData_PublishPage(testName, 2, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 555)
	public void newBlog_NewTopic_Ionize_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 2, 3);
		super.verifyData_PublishPage(testName, 2, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 556)
	public void newBlog_NewTopic_PublishNow_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 3, 1);
		super.verifyData_PublishPage(testName, 3, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 557)
	public void newBlog_NewTopic_PublishNow_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 3, 2);
		super.verifyData_PublishPage(testName, 3, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 558)
	public void newBlog_NewTopic_PublishNow_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 3, 3);
		super.verifyData_PublishPage(testName, 3, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 559)
	public void newBlog_NewTopic_Schedule_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 4, 1);
		super.verifyData_PublishPage(testName, 4, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 560)
	public void newBlog_NewTopic_Schedule_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 4, 2);
		super.verifyData_PublishPage(testName, 4, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 561)
	public void newBlog_NewTopic_Schedule_Event_HomePage() throws IOException {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		super.openWebAppUrl();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 2, 4, 3);
		super.verifyData_PublishPage(testName, 4, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// ========= Queries Page=====================================

 // @Test(priority = 600)
	public void askQuestionS1_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(testName, 2, subject_AskQuestionS1_WebPage_QueriesPage,
				message_AskQuestionS1_WebPage_QueriesPage, name_AskQuestionS1_WebPage_QueriesPage,
				email_AskQuestionS1_WebPage_QueriesPage, age_AskQuestionS1_WebPage_QueriesPage,
				mobileNumber_AskQuestionS1_WebPage_QueriesPage, 2);

		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(4);
		super.verifyData_QueriesPage(testName, 2, subject_AskQuestionS1_WebPage_QueriesPage,
				message_AskQuestionS1_WebPage_QueriesPage, name_AskQuestionS1_WebPage_QueriesPage,
				age_AskQuestionS1_WebPage_QueriesPage, "F", mobileNumber_AskQuestionS1_WebPage_QueriesPage,
				email_AskQuestionS1_WebPage_QueriesPage);

	}

 // @Test(priority = 601)
	public void askQuestionS2_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(testName, 3, subject_AskQuestionS2_WebPage_QueriesPage,
				message_AskQuestionS2_WebPage_QueriesPage, name_AskQuestionS2_WebPage_QueriesPage,
				email_AskQuestionS2_WebPage_QueriesPage, age_AskQuestionS2_WebPage_QueriesPage,
				mobileNumber_AskQuestionS2_WebPage_QueriesPage, 1);

		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(4);
		super.verifyData_QueriesPage(testName, 3, subject_AskQuestionS2_WebPage_QueriesPage,
				message_AskQuestionS2_WebPage_QueriesPage, name_AskQuestionS2_WebPage_QueriesPage,
				age_AskQuestionS2_WebPage_QueriesPage, "M", mobileNumber_AskQuestionS2_WebPage_QueriesPage,
				email_AskQuestionS2_WebPage_QueriesPage);

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
