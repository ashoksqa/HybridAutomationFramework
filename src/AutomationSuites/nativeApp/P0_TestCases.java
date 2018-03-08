package AutomationSuites.nativeApp;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import webApp.MarketingCalendarPageWeb;
import nativeApp.MarketingCalendarPageDevice;

public class P0_TestCases extends MarketingCalendarPageDevice {
	AndroidDriver<AndroidElement> adriver;
	AppiumDriver<?> driver;
	MarketingCalendarPageWeb mc = new MarketingCalendarPageWeb();
	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		if (super.pvts("OS"+Trow).equals("Android")) {
			driver=super.installAndroidApp(adriver);
			} /*
			 * else if (super.getOS().equals("iOS")) { driver = super.iOSAppiumSetup(); }
			 */
	}

	 @Test(priority = 0)
	public void addLead() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver,"uid", "pwd");
		String dob = super.addLead_HomePage(driver,firstName_addLead, lastName_addLead,
				emailId_addLead, phoneNumber_addLead, city_addLead, area_addLead,
				remarks_addLead, tagName_addLead, "F");
		super.click_Menu(driver);

		super.click_LeadsTab_MenuPage(driver);
		super.verifyData_LeadsPage(driver,testName, firstName_addLead, lastName_addLead, "F", dob,
				phoneNumber_addLead, emailId_addLead, city_addLead, area_addLead,
				"Lead", tagName_addLead+", ", remarks_addLead);
		mc.verifyData_LeadsPage(driver,methodName, firstName, gender_Male_Female, age, phoneNumber, emailId, source, tagName)
	}

	// @Test(priority = 1)
	public void addVisitFromHomePage_Ramesh_New() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.clickOptions_QuickStartPopup_HomePage(1);
		String visit_Month_Date_Time = super.addVisit_VisitsPage(1, 1, 1, amount_addVisit_HomePage,
				firstName_addVisit_HomePage, lastName_addVisit_HomePage, emailId_addVisit_HomePage,
				phoneNumber_addVisit_HomePage, remarks_addVisit_HomePage, tagName_addVisit_HomePage);

		super.verifyData_BySelectingDateInCalender_VisitsPage(testName, visit_Month_Date_Time,
				firstName_addVisit_HomePage + " " + lastName_addVisit_HomePage, phoneNumber_addVisit_HomePage,
				"Dr Ramesh", "New", amount_addVisit_HomePage);
		super.naavigateToUrl("leadsUrl");
		super.verifyData_LeadsPage("addVisitFromHomePage_Ramesh_New", firstName_addVisit_HomePage, "Male", "0",
				phoneNumber_addVisit_HomePage, emailId_addVisit_HomePage, "Visit", tagName_addVisit_HomePage);
	}

	// @Test(priority = 2)
	public void addVisitFromVisitsPage_Manoj_Accepted() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");

		super.click_SideMenuTabs_HomePage(3);
		super.click_AddVisit_VisitsPage();

		String visit_Month_Date_Time = super.addVisit_VisitsPage(1, 3, 2, amount_addVisit_VisitsPage,
				firstName_addVisit_VisitsPage, lastName_addVisit_VisitsPage, emailId_addVisit_VisitsPage,
				phoneNumber_addVisit_VisitsPage, remarks_addVisit_VisitsPage, tagName_addVisit_VisitsPage);
		super.assertEquals_Text(testName, "SuccessMsg_Popup", super.getSuccessMsg_Popup_VisitsPage(),
				"Visit added successfully.");
		super.okBtn_Popup_VisitsPage();
		super.verifyData_BySelectingDateInCalender_VisitsPage(testName, visit_Month_Date_Time,
				firstName_addVisit_VisitsPage + " " + lastName_addVisit_VisitsPage, phoneNumber_addVisit_VisitsPage,
				"Dr Manoj", "Accepted", amount_addVisit_VisitsPage);
		super.naavigateToUrl("leadsUrl");
		super.verifyData_LeadsPage("addVisitFromVisitsPage_Manoj_Accepted", firstName_addVisit_VisitsPage, "Male", "0",
				phoneNumber_addVisit_VisitsPage, emailId_addVisit_VisitsPage, "Visit", tagName_addVisit_VisitsPage);
	}

	// @Test(priority = 4)
	public void newTopicAdd_MarketingCalendarPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addTopicToCalendar_MarketingCalenderPage(testName, newTopic_MarketingCalendarPage, 2,
				super.getTodayDate());
		super.verifyData_MarketingCalendarPage(testName, super.getTodayDate(), newTopic_MarketingCalendarPage, "Draft",
				"Disha Clinic", "Ramesh");
	}

	// @Test(priority = 5)
	public void newBlog_SelectTopic_Draft_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 1, 2);
		super.verifyData_PublishPage(testName, 1, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 6)
	public void newBlog_SelectTopic_Ionize_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 2, 3);
		super.verifyData_PublishPage(testName, 2, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 7)
	public void newBlog_SelectTopic_PublishNow_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 3, 1);
		super.verifyData_PublishPage(testName, 3, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 8)
	public void newBlog_SelectTopic_Schedule_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 1, 1, 4, 2);
		super.verifyData_PublishPage(testName, 4, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 9)
	public void newBlog_NewTopic_Draft_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		System.out.println("testName is :" + testName);
		super.addNewBlog_PublishPage(testName, 2, 2, 1, 1);
		super.verifyData_PublishPage(testName, 1, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 10)
	public void newBlog_NewTopic_Ionize_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 2, 2);
		super.verifyData_PublishPage(testName, 2, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 11)
	public void newBlog_NewTopic_PublishNow_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 3, 3);
		super.verifyData_PublishPage(testName, 3, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 12)
	public void newBlog_NewTopic_Schedule_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.addNewBlog_PublishPage(testName, 2, 2, 4, 1);
		super.verifyData_PublishPage(testName, 4, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 13)
	public void AskQuestionGC_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(testName, 1, subject_AskQuestionGC_WebPage_QueriesPage,
				message_AskQuestionGC_WebPage_QueriesPage, name_AskQuestionGC_WebPage_QueriesPage,
				email_AskQuestionGC_WebPage_QueriesPage, age_AskQuestionGC_WebPage_QueriesPage,
				mobileNumber_AskQuestionGC_WebPage_QueriesPage, 2);

		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(4);
		super.verifyData_QueriesPage(testName, 1, subject_AskQuestionGC_WebPage_QueriesPage,
				message_AskQuestionGC_WebPage_QueriesPage, name_AskQuestionGC_WebPage_QueriesPage,
				age_AskQuestionGC_WebPage_QueriesPage, "F", mobileNumber_AskQuestionGC_WebPage_QueriesPage,
				email_AskQuestionGC_WebPage_QueriesPage);

	}

	// @Test(priority = 14)
	public void AskQuery_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl();
		super.askQuery_Website_QueriesPage(testName, name_AskQuery_WebPage_QueriesPage,
				email_AskQuery_WebPage_QueriesPage, mobileNumber_AskQuery_WebPage_QueriesPage,
				queryText_AskQuery_WebPage_QueriesPage);
		super.openWebAppUrl();
		super.login("ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(4);
		super.verifyData_QueriesPage(testName, 1, queryText_AskQuery_WebPage_QueriesPage + "...",
				queryText_AskQuery_WebPage_QueriesPage, name_AskQuery_WebPage_QueriesPage, "", "",
				mobileNumber_AskQuery_WebPage_QueriesPage, email_AskQuery_WebPage_QueriesPage);

	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {
		super.testResult(driver,testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver(driver);
		System.out.println("Stopped");
	}

}
