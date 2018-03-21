package AutomationSuites.webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import nativeApp.EndPage;

public class P0_TestCases extends EndPage {
	WebDriver driver;
	AndroidDriver<AndroidElement> adriver;

	// AppiumDriver<?> driver;
	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		super.updateTrow(Trow);
		driver = super.launchBrowser(driver);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_NoTahnks_NotificationWeb(driver);
		// adriver=super.installAndroidApp(adriver, "Android
		// Device",super.pvWebApp("PlatformVersion"), super.pvWebApp("udid"));
	}

	// @Test(priority = 0)
	public void addLeadFromHomePageWeb() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.clickOptions_QuickStartPopup_HomePageWeb(driver, 3);
		super.addLead_HomePageWeb(driver, testName, firstName_ALHW, lastName_ALHW, emailId_ALHW, phoneNumber_ALHW,
				city_ALHW, area_ALHW, remarks_ALHW, tagName_ALHW);
		super.click_SideMenuTabs_HomePageWeb(driver, 5);
		super.verifyData_LeadsPageWeb(driver, testName, firstName_ALHW, "Male", "0", phoneNumber_ALHW, emailId_ALHW,
				"Lead", tagName_ALHW);
		// Verifying the Leads data in Android mobile
		if (crossPlatofrmVerification.equals("yes")) {
			super.resetApp(adriver);
			super.loginAfterResetApp(adriver);
			super.click_MenuApp(adriver);
			super.click_LeadsTab_MenuPageApp(adriver);
			super.verifyData_LeadsPageApp(adriver, testName, firstName_ALHW, lastName_ALHW, "Male",
					super.date_02SpaceFebComma2018, phoneNumber_ALHW, emailId_ALHW, city_ALHW, area_ALHW, "Lead",
					tagName_ALHW + ", ", remarks_ALHW);
		}

	}

	// @Test(priority = 1)
	public void addLeadFromLeadsPage() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_SideMenuTabs_HomePageWeb(driver, 5);
		super.click_AddLead_LeadsPage(driver);
		super.addLead_LeadsPageWeb(driver, firstName_ALLW, lastName_ALLW, emailId_ALLW, phoneNumber_ALLW, city_ALLW,
				area_ALLW, remarks_ALLW, tagName_ALLW);
		super.verifyData_LeadsPageWeb(driver, testName, firstName_ALLW, "Male", "0", phoneNumber_ALLW, emailId_ALLW,
				"Lead", tagName_ALLW);
	}

	// @Test(priority = 2)
	public void addVisitFromHomePage_Ramesh_New() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.clickOptions_QuickStartPopup_HomePageWeb(driver, 1);
		String visit_Month_Date_Time = super.addVisit_VisitsPage(driver, 2, 2, 2, amount_AVHW, firstName_AVHW,
				lastName_AVHW, emailId_AVHW, phoneNumber_AVHW, remarks_AVHW, tagName_AVHW);

		super.verifyData_BySelectingDateInCalender_VisitsPage(driver, testName, visit_Month_Date_Time,
				firstName_AVHW + " " + lastName_AVHW, phoneNumber_AVHW, "Dr Ramesh", "New", amount_AVHW);
		super.naavigateToUrl(driver, "leadsUrl");
		super.verifyData_LeadsPageWeb(driver, "addVisitFromHomePage_Ramesh_New", firstName_AVHW, "Male", "0",
				phoneNumber_AVHW, emailId_AVHW, "Visit", tagName_AVHW);
	}

	// @Test(priority = 3)
	public void addVisitFromVisitsPage_Manoj_Accepted() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);

		super.click_SideMenuTabs_HomePageWeb(driver, 3);
		super.click_AddVisit_VisitsPage(driver);

		String visit_Month_Date_Time = super.addVisit_VisitsPage(driver, 2, 4, 3, amount_AVVW, firstName_AVVW,
				lastName_AVVW, emailId_AVVW, phoneNumber_AVVW, remarks_AVVW, tagName_AVVW);
		super.assertEquals_Text(driver, testName, "SuccessMsg_Popup", super.getSuccessMsg_Popup_VisitsPage(driver),
				"Visit added successfully.");
		super.okBtn_Popup_VisitsPage(driver);
		super.verifyData_BySelectingDateInCalender_VisitsPage(driver, testName, visit_Month_Date_Time,
				firstName_AVVW + " " + lastName_AVVW, phoneNumber_AVVW, "Dr Manoj", "Accepted", amount_AVVW);
		super.naavigateToUrl(driver, "leadsUrl");
		super.verifyData_LeadsPageWeb(driver, testName, firstName_AVVW, "Male", "0", phoneNumber_AVVW, emailId_AVVW,
				"Visit", tagName_AVVW);
	}

	// @Test(priority = 4)
	public void newTopicAdd_MarketingCalendarPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		String topic = super.addTopicToCalendar_MarketingCalenderPage(driver, testName, newTopic_MarketingCalendarPage,
				2, super.getTodayDate());
		super.verifyData_MarketingCalendarPage(driver, testName, super.getTodayDate(), topic, "Draft", "Disha Clinic",
				super.doctorFullName.split(" ")[0]);
	}

	// @Test(priority = 5)
	public void newBlog_SelectTopic_Draft_Blog_HomePageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 1, 2);
		super.verifyData_PublishPageWeb(driver, testName, 1, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 6)
	public void newBlog_SelectTopic_Ionize_Event_HomePageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 2, 3);
		super.verifyData_PublishPageWeb(driver, testName, 2, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 7)
	public void newBlog_SelectTopic_PublishNow_News_HomePageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 3, 1);
		super.verifyData_PublishPageWeb(driver, testName, 3, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 8)
	public void newBlog_SelectTopic_Schedule_Blog_HomePageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 4, 2);
		super.verifyData_PublishPageWeb(driver, testName, 4, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 9)
	public void newBlog_NewTopic_Draft_News_PublishPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		System.out.println("testName is :" + testName);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 1, 1);
		super.verifyData_PublishPageWeb(driver, testName, 1, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 10)
	public void newBlog_NewTopic_Ionize_Blog_PublishPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 2, 2);
		super.verifyData_PublishPageWeb(driver, testName, 2, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 11)
	public void newBlog_NewTopic_PublishNow_Event_PublishPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 3, 3);
		super.verifyData_PublishPageWeb(driver, testName, 3, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 12)
	public void newBlog_NewTopic_Schedule_News_PublishPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 4, 1);
		super.verifyData_PublishPageWeb(driver, testName, 4, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// @Test(priority = 13)
	public void AskQuestion_Opt1_WebSite_QueriesPageWeb() throws IOException {
		String subject = "SubjectAskQuestionOpt1 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt1 M" + super.randomString(5);
		String name = "AskQuestionNameOpt1 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt1_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 2, subject, message, name, email, age, mobileNumber, 3);

		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 1, subject, message, name, age, "F", mobileNumber, email);

	}

	// @Test(priority = 14)
	public void AskQuery_WebSite_QueriesPageWeb() throws IOException {
		String name = "AskQueryName A" + super.randomString(5);
		String email = "AskQueryEmail_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String mobileNumber = "5" + super.randomNumString(9);

		String queryText = "AskQueryText A" + super.randomString(9);

		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.askQuery_Website_QueriesPage(driver, testName, name, email, mobileNumber, queryText);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 1, queryText + "...", queryText, name, "", "", mobileNumber,
				email);

	}

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessAllQueries_WebSiteAskQuestion_Opt3_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.addUser_AccessQueries_Website_askQuestion_UsersPageWeb(driver, testName, 1, 4, 6, 3);

	}

	@Test(priority = 16)
	public void addUser_FrontDesk_AccessOpt1_WebSiteAskQuery_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();

		super.addUser_AccessQueries_Website_askQuery_UsersPageWeb(driver, testName, 2, 1, 6);
	}

	@Test(priority = 17)
	public void addUser_JrDoctor_AccessOpt3_WebSiteAskQuestion_Opt3_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.addUser_AccessQueries_Website_askQuestion_UsersPageWeb(driver, testName, 3, 3, 6, 3);
	}

	@Test(priority = 18)
	public void addUser_JrDoctor_AccessOpt1_WebSiteAskQuestion_Opt1_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.addUser_AccessQueries_Website_askQuestion_UsersPageWeb(driver, testName, 3, 1, 6, 1);
	}

	@Test(priority = 19)
	public void addUser_BusinessHead_AccessSelectAllQueries_WebSiteAskQuestion_Opt2_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.addUser_AccessQueries_Website_askQuestion_UsersPageWeb(driver, testName, 4, 4, 8, 2);
	}

	@AfterMethod
	public void results(ITestResult testResult) throws IOException {
		super.testResult(driver, testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver(driver);
		System.out.println("Stopped");
	}

}
