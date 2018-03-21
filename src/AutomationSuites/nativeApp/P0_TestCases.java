package AutomationSuites.nativeApp;

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
import webApp.MarketingCalendarPageWeb;
import nativeApp.EndPage;
import nativeApp.MarketingCalendarPageApp;

public class P0_TestCases extends EndPage {
	AndroidDriver<AndroidElement> adriver;
	AppiumDriver<?> driver;
	WebDriver wdriver;

	@Parameters({ "Trow" })
	@BeforeTest
	public void beforeTest(int Trow) throws Exception {
		System.out.println("BeforeTest Executing");
		Trow = super.updateTrow(Trow);
		if (super.pvts("OS" + Trow).equals("Android")) {
			driver=super.installAndroidApp(adriver);
			//driver = super.launchIonApp(adriver);

		} /*
			 * else if (super.getOS().equals("iOS")) { driver = super.iOSAppiumSetup(); }
			 */
		
		  wdriver = super.launchChromeBrowser(wdriver); super.openWebAppUrl(wdriver);
		  super.loginWebApp(wdriver);
		  super.click_NoTahnks_NotificationWeb(wdriver);
		 

	}

	 @Test(priority = 0)
	public void addLeadApp() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		super.addLead_LeadsPageApp(driver, firstName_addLead, lastName_addLead, emailId_addLead, phoneNumber_addLead,
				city_addLead, area_addLead, remarks_addLead, tagName_addLead, "Female");
		super.click_MenuApp(driver);
		super.click_LeadsTab_MenuPageApp(driver);
		super.verifyData_LeadsPageApp(driver, testName, firstName_addLead, lastName_addLead, "Female",
				super.date_02SpaceFebComma2018, phoneNumber_addLead, emailId_addLead, city_addLead, area_addLead,
				"Lead", tagName_addLead + ", ", remarks_addLead);
		// Verifying the Leads data in WebApp

		super.openWebAppUrl(driver);
		super.login(wdriver, "uid", "pwd");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_LeadsPage(wdriver, testName, firstName_addLead, "Female", "0", phoneNumber_addLead,
				emailId_addLead, "Lead", tagName_addLead);
		super.quitDriver(wdriver);
	}

	 @Test(priority = 1)
	public void addVisitFromHomePage_Ramesh_NewApp() throws Exception {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver,"uid", "pwd");
		String visitDate = super.addVisit_LeadsPageApp(driver, testName, 1, 1, 1, amount_addVisit, firstName_addVisit,
				lastName_addVisit, "Female", phoneNumber_addVisit, emailId_addVisit, remarks_addVisit);
		super.click_MenuApp(driver);
		super.click_LeadsTab_MenuPageApp(driver);
		super.verifyData_LeadsPageApp(driver, testName, firstName_addVisit, lastName_addVisit, "Female",
				super.date_02SpaceFebComma2018, phoneNumber_addVisit, emailId_addVisit, "", "", "Visit", "",
				remarks_addVisit);
		// WebApp : Verifying the data in Leads And Visits Data

		super.openWebAppUrl(wdriver);
		super.login(wdriver, "uid", "pwd");
		super.click_SideMenuTabs_HomePage(wdriver, 3);
		System.out.println("Visit date Is : " + visitDate);
		super.verifyData_BySelectingDateInCalender_VisitsPage(wdriver, testName, visitDate,
				firstName_addVisit + " " + lastName_addVisit, phoneNumber_addVisit, "Dr Ramesh", "New",
				amount_addVisit);

		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_LeadsPage(wdriver, testName, firstName_addVisit, "Female", "0", phoneNumber_addVisit,
				emailId_addVisit, "Visit", "");
		super.quitDriver(wdriver);
	}

	@Test(priority = 2)
	public void newTopicAdd_MarketingCalendarPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		String doctorName = super.loginAfterResetApp(driver);

		String topic = super.addTopicToCalendar_MarketingCalenderPageApp(driver, testName,
				newTopic_MarketingCalendarPageApp);
		super.verifyData_MarketingCalendarPageApp(driver, testName, topic, "Draft", "Disha Clinic", doctorName);

	}
	
	@Test(priority = 3)
	public void addBlog_SelectTopic_Draft_News_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 1, 1);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	@Test(priority = 4)
	public void addBlog_SelectTopic_Ionize_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 2, 2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	 @Test(priority = 5)
	public void addBlog_SelectTopic_PublishNow_Event_PublishPageApp() throws IOException, InterruptedException {
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.resetApp(driver);
			super.loginAfterResetApp(driver);
			String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 3, 3);
			System.out.println("Blog date is :" + date);
			super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, date, " ");
			super.naavigateToUrl(wdriver, "homeUrl");
			super.click_SideMenuTabs_HomePage(wdriver,2);
			super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

		}

	@Test(priority = 6)
	public void addBlog_SelectTopic_Schedule_News_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 4, 1);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	
	

	@Test(priority = 9)
	public void addBlog_NewTopic_Draft_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 1, 2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	@Test(priority = 10)
	public void addBlog_NewTopic_Ionize_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 2, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	 @Test(priority = 11)
	public void addBlog_NewTopic_PublishNow_News_PublishPageApp() throws IOException, InterruptedException {
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.resetApp(driver);
			super.loginAfterResetApp(driver);
			String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 3, 1);
			System.out.println("Blog date is :" + date);
			super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, date, " ");
			super.naavigateToUrl(wdriver, "homeUrl");
			super.click_SideMenuTabs_HomePage(wdriver,2);
			super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

		}

	@Test(priority = 12)
	public void addBlog_NewTopic_Schedule_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver);
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 4, 2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver,2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

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
		super.testResult(driver, testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver(driver);
		System.out.println("Stopped");
	}

}
