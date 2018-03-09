package AutomationSuites.webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import nativeApp.EndPage;

public class P0_TestCases extends EndPage {
WebDriver driver;
AndroidDriver<AndroidElement> adriver;
//AppiumDriver<?> driver;
	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		driver=super.launchBrowser(driver);
		super.openWebAppUrl(driver);
		super.login(driver,"uid", "pwd");
		super.click_NoTahnks_Notification(driver);
		adriver=super.installAndroidApp(adriver, "Android_6.0", " ", "emulator-5556");
	}

	 @Test(priority = 0)
	public void addLeadFromHomePage() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"uid", "pwd");
		super.clickOptions_QuickStartPopup_HomePage(driver,3);
		super.addLead_HomePage(driver,testName,firstName_addLead_HomePage, lastName_addLead_HomePage, emailId_addLead_HomePage,
				phoneNumber_addLead_HomePage, city_addLead_HomePage, area_addLead_HomePage, remarks_addLead_HomePage,
				tagName_addLead_HomePage);
		super.click_SideMenuTabs_HomePage(driver,5);
		super.verifyData_LeadsPage(driver,testName, firstName_addLead_HomePage, "Male", "0",
				phoneNumber_addLead_HomePage, emailId_addLead_HomePage, "Lead", tagName_addLead_HomePage);
		// Verifying the Leads data in Android mobile
		super.resetApp(adriver);
		super.loginAfterResetApp(adriver,"uid", "pwd");
		super.click_Menu(adriver);
		super.click_LeadsTab_MenuPage(adriver);
		super.verifyData_LeadsPage(adriver,testName, firstName_addLead_HomePage, lastName_addLead_HomePage, "Male", dateWithYear,
				phoneNumber_addLead_HomePage, emailId_addLead_HomePage, city_addLead_HomePage, area_addLead_HomePage,
				"Lead", tagName_addLead_HomePage+", ", remarks_addLead_HomePage);

	}

	// @Test(priority = 1)
	public void addLeadFromLeadsPage() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");

		super.click_SideMenuTabs_HomePage(driver,5);
		super.click_AddLead_LeadsPage(driver);
		super.addLead_LeadsPage(driver,firstName_addLead_LeadsPage, lastName_addLead_LeadsPage, emailId_addLead_LeadsPage,
				phoneNumber_addLead_LeadsPage, city_addLead_LeadsPage, area_addLead_LeadsPage,
				remarks_addLead_LeadsPage, tagName_addLead_LeadsPage);
		super.assertEquals_Text(driver,"addLeadFromLeadsPage", "SuccessMsg_Popup", super.getSuccessMsg_Popup_LeadsPage(driver),
				"Lead added successfully.");
		super.okBtn_Popup_LeadsPage(driver);
		super.verifyData_LeadsPage(driver,testName, firstName_addLead_LeadsPage, "Male", "0", phoneNumber_addLead_LeadsPage,
				emailId_addLead_LeadsPage, "Lead", tagName_addLead_LeadsPage);
	}

	// @Test(priority = 2)
	public void addVisitFromHomePage_Ramesh_New() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.clickOptions_QuickStartPopup_HomePage(driver,1);
		String visit_Month_Date_Time = super.addVisit_VisitsPage(driver,2, 2, 2, amount_addVisit_HomePage,
				firstName_addVisit_HomePage, lastName_addVisit_HomePage, emailId_addVisit_HomePage,
				phoneNumber_addVisit_HomePage, remarks_addVisit_HomePage, tagName_addVisit_HomePage);

		super.verifyData_BySelectingDateInCalender_VisitsPage(driver,testName, visit_Month_Date_Time,
				firstName_addVisit_HomePage + " " + lastName_addVisit_HomePage, phoneNumber_addVisit_HomePage,
				"Dr Ramesh", "New", amount_addVisit_HomePage);
		super.naavigateToUrl(driver,"leadsUrl");
		super.verifyData_LeadsPage(driver,"addVisitFromHomePage_Ramesh_New", firstName_addVisit_HomePage, "Male", "0",
				phoneNumber_addVisit_HomePage, emailId_addVisit_HomePage, "Visit", tagName_addVisit_HomePage);
	}

	// @Test(priority = 3)
	public void addVisitFromVisitsPage_Manoj_Accepted() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");

		super.click_SideMenuTabs_HomePage(driver,3);
		super.click_AddVisit_VisitsPage(driver);

		String visit_Month_Date_Time = super.addVisit_VisitsPage(driver,2, 3, 3, amount_addVisit_VisitsPage,
				firstName_addVisit_VisitsPage, lastName_addVisit_VisitsPage, emailId_addVisit_VisitsPage,
				phoneNumber_addVisit_VisitsPage, remarks_addVisit_VisitsPage, tagName_addVisit_VisitsPage);
		super.assertEquals_Text(driver,testName, "SuccessMsg_Popup", super.getSuccessMsg_Popup_VisitsPage(driver),
				"Visit added successfully.");
		super.okBtn_Popup_VisitsPage(driver);
		super.verifyData_BySelectingDateInCalender_VisitsPage(driver,testName, visit_Month_Date_Time,
				firstName_addVisit_VisitsPage + " " + lastName_addVisit_VisitsPage, phoneNumber_addVisit_VisitsPage,
				"Dr Manoj", "Accepted", amount_addVisit_VisitsPage);
		super.naavigateToUrl(driver,"leadsUrl");
		super.verifyData_LeadsPage(driver,"addVisitFromVisitsPage_Manoj_Accepted", firstName_addVisit_VisitsPage, "Male", "0",
				phoneNumber_addVisit_VisitsPage, emailId_addVisit_VisitsPage, "Visit", tagName_addVisit_VisitsPage);
	}

	// @Test(priority = 4)
	public void newTopicAdd_MarketingCalendarPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addTopicToCalendar_MarketingCalenderPage(driver,testName, newTopic_MarketingCalendarPage, 2,
				super.getTodayDate());
		super.verifyData_MarketingCalendarPage(driver,testName, super.getTodayDate(), newTopic_MarketingCalendarPage, "Draft",
				"Disha Clinic", "Ramesh");
	}

	// @Test(priority = 5)
	public void newBlog_SelectTopic_Draft_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 1, 1, 1, 2);
		super.verifyData_PublishPage(driver,testName, 1, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 6)
	public void newBlog_SelectTopic_Ionize_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 1, 1, 2, 3);
		super.verifyData_PublishPage(driver,testName, 2, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 7)
	public void newBlog_SelectTopic_PublishNow_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 1, 1, 3, 1);
		super.verifyData_PublishPage(driver,testName, 3, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 8)
	public void newBlog_SelectTopic_Schedule_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 1, 1, 4, 2);
		super.verifyData_PublishPage(driver,testName, 4, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 9)
	public void newBlog_NewTopic_Draft_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		System.out.println("testName is :" + testName);
		super.addNewBlog_PublishPage(driver,testName, 2, 2, 1, 1);
		super.verifyData_PublishPage(driver,testName, 1, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 10)
	public void newBlog_NewTopic_Ionize_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 2, 2, 2, 2);
		super.verifyData_PublishPage(driver,testName, 2, 2, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 11)
	public void newBlog_NewTopic_PublishNow_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 2, 2, 3, 3);
		super.verifyData_PublishPage(driver,testName, 3, 3, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 12)
	public void newBlog_NewTopic_Schedule_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.addNewBlog_PublishPage(driver,testName, 2, 2, 4, 1);
		super.verifyData_PublishPage(driver,testName, 4, 1, super.blogTitle_AddNewBlog, super.description_AddNewBlog, "Ramesh",
				"11", "12");
	}

	// @Test(priority = 13)
	public void AskQuestionGC_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver,testName, 2, subject_AskQuestionGC_WebPage_QueriesPage,
				message_AskQuestionGC_WebPage_QueriesPage, name_AskQuestionGC_WebPage_QueriesPage,
				email_AskQuestionGC_WebPage_QueriesPage, age_AskQuestionGC_WebPage_QueriesPage,
				mobileNumber_AskQuestionGC_WebPage_QueriesPage, 2);

		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(driver,4);
		super.verifyData_QueriesPage(driver,testName, 2, subject_AskQuestionGC_WebPage_QueriesPage,
				message_AskQuestionGC_WebPage_QueriesPage, name_AskQuestionGC_WebPage_QueriesPage,
				age_AskQuestionGC_WebPage_QueriesPage, "F", mobileNumber_AskQuestionGC_WebPage_QueriesPage,
				email_AskQuestionGC_WebPage_QueriesPage);

	}

	// @Test(priority = 14)
	public void AskQuery_WebSite_QueriesPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.askQuery_Website_QueriesPage(driver,testName, name_AskQuery_WebPage_QueriesPage,
				email_AskQuery_WebPage_QueriesPage, mobileNumber_AskQuery_WebPage_QueriesPage,
				queryText_AskQuery_WebPage_QueriesPage);
		super.openWebAppUrl(driver);
		super.login(driver,"ramesh", "ramesh");
		super.click_SideMenuTabs_HomePage(driver,4);
		super.verifyData_QueriesPage(driver,testName, 1, queryText_AskQuery_WebPage_QueriesPage+"...",
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
