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

public class P2_TestCases extends EndPage {
	WebDriver driver;
	AndroidDriver<AndroidElement> adriver;

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

	// =========Select Topic From Home Page=====================================
	@Test(priority = 400)
	public void newBlog_SelectTopic_Draft_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 1, 1);
		super.verifyData_PublishPageWeb(driver, testName, 1, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 401)
	public void newBlog_SelectTopic_Draft_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 1, 2);
		super.verifyData_PublishPageWeb(driver, testName, 1, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 402)
	public void newBlog_SelectTopic_Draft_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 1, 3);
		super.verifyData_PublishPageWeb(driver, testName, 1, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 403)
	public void newBlog_SelectTopic_Ionize_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 2, 1);
		super.verifyData_PublishPageWeb(driver, testName, 2, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 404)
	public void newBlog_SelectTopic_Ionize_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 2, 2);
		super.verifyData_PublishPageWeb(driver, testName, 2, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 405)
	public void newBlog_SelectTopic_Ionize_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 2, 3);
		super.verifyData_PublishPageWeb(driver, testName, 2, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 406)
	public void newBlog_SelectTopic_PublishNow_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 3, 1);
		super.verifyData_PublishPageWeb(driver, testName, 3, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 407)
	public void newBlog_SelectTopic_PublishNow_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 3, 2);
		super.verifyData_PublishPageWeb(driver, testName, 3, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 408)
	public void newBlog_SelectTopic_PublishNow_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 3, 3);
		super.verifyData_PublishPageWeb(driver, testName, 3, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 409)
	public void newBlog_SelectTopic_Schedule_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 4, 1);
		super.verifyData_PublishPageWeb(driver, testName, 4, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 410)
	public void newBlog_SelectTopic_Schedule_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 4, 2);
		super.verifyData_PublishPageWeb(driver, testName, 4, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 411)
	public void newBlog_SelectTopic_Schedule_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 1, 4, 3);
		super.verifyData_PublishPageWeb(driver, testName, 4, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// =========New Topic From Publish Page=====================================

	@Test(priority = 451)
	public void newBlog_NewTopic_Draft_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 1, 2);
		super.verifyData_PublishPageWeb(driver, testName, 1, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 452)
	public void newBlog_NewTopic_Draft_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 1, 3);
		super.verifyData_PublishPageWeb(driver, testName, 1, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 453)
	public void newBlog_NewTopic_Ionize_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 2, 1);
		super.verifyData_PublishPageWeb(driver, testName, 2, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 455)
	public void newBlog_NewTopic_Ionize_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 2, 3);
		super.verifyData_PublishPageWeb(driver, testName, 2, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 456)
	public void newBlog_NewTopic_PublishNow_News_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 3, 1);
		super.verifyData_PublishPageWeb(driver, testName, 3, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 457)
	public void newBlog_NewTopic_PublishNow_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 3, 2);
		super.verifyData_PublishPageWeb(driver, testName, 3, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 460)
	public void newBlog_NewTopic_Schedule_Blog_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 4, 2);
		super.verifyData_PublishPageWeb(driver, testName, 4, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 461)
	public void newBlog_NewTopic_Schedule_Event_PublishPage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 2, 2, 4, 3);
		super.verifyData_PublishPageWeb(driver, testName, 4, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// =========Select Topic From Publish Page=====================================

	@Test(priority = 500)
	public void newBlog_SelectTopic_Draft_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 1, 1);
		super.verifyData_PublishPageWeb(driver, testName, 1, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 501)
	public void newBlog_SelectTopic_Draft_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 1, 3);
		super.verifyData_PublishPageWeb(driver, testName, 1, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 502)
	public void newBlog_SelectTopic_Ionize_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 2, 1);
		super.verifyData_PublishPageWeb(driver, testName, 2, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 503)
	public void newBlog_SelectTopic_Ionize_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 2, 2);
		super.verifyData_PublishPageWeb(driver, testName, 2, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 504)
	public void newBlog_SelectTopic_PublishNow_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 3, 2);
		super.verifyData_PublishPageWeb(driver, testName, 3, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 505)
	public void newBlog_SelectTopic_PublishNow_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 3, 3);
		super.verifyData_PublishPageWeb(driver, testName, 3, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 506)
	public void newBlog_SelectTopic_Schedule_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 4, 1);
		super.verifyData_PublishPageWeb(driver, testName, 4, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 507)
	public void newBlog_SelectTopic_Schedule_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 1, 4, 3);
		super.verifyData_PublishPageWeb(driver, testName, 4, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// =========New Topic From Home Page=====================================

	@Test(priority = 550)
	public void newBlog_NewTopic_Draft_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 1, 1);
		super.verifyData_PublishPageWeb(driver, testName, 1, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 551)
	public void newBlog_NewTopic_Draft_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 1, 2);
		super.verifyData_PublishPageWeb(driver, testName, 1, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 552)
	public void newBlog_NewTopic_Draft_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 1, 3);
		super.verifyData_PublishPageWeb(driver, testName, 1, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 553)
	public void newBlog_NewTopic_Ionize_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 2, 1);
		super.verifyData_PublishPageWeb(driver, testName, 2, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 554)
	public void newBlog_NewTopic_Ionize_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 2, 2);
		super.verifyData_PublishPageWeb(driver, testName, 2, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 555)
	public void newBlog_NewTopic_Ionize_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 2, 3);
		super.verifyData_PublishPageWeb(driver, testName, 2, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 556)
	public void newBlog_NewTopic_PublishNow_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 3, 1);
		super.verifyData_PublishPageWeb(driver, testName, 3, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 557)
	public void newBlog_NewTopic_PublishNow_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 3, 2);
		super.verifyData_PublishPageWeb(driver, testName, 3, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 558)
	public void newBlog_NewTopic_PublishNow_Event_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 3, 3);
		super.verifyData_PublishPageWeb(driver, testName, 3, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 559)
	public void newBlog_NewTopic_Schedule_News_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 4, 1);
		super.verifyData_PublishPageWeb(driver, testName, 4, 1, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 560)
	public void newBlog_NewTopic_Schedule_Blog_HomePage() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 4, 2);
		super.verifyData_PublishPageWeb(driver, testName, 4, 2, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	@Test(priority = 561)
	public void newBlog_NewTopic_Schedule_Event_HomePage() throws IOException {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		super.openWebAppUrl(driver);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.addNewBlog_PublishPageWeb(driver, testName, 1, 2, 4, 3);
		super.verifyData_PublishPageWeb(driver, testName, 4, 3, super.blogTitle_AddNewBlog,
				super.description_AddNewBlog, super.doctorFullName, "11", "12");
	}

	// ========= Queries Page=====================================

	@Test(priority = 600)
	public void askQuestion_Opt2_WebSite_QueriesPage() throws IOException {
		String subject = "SubjectAskQuestionOpt2 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt2 M" + super.randomString(5);
		String name = "AskQuestionNameOpt2 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt2_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(driver, testName, 3, subject, message, name, email, age, mobileNumber, 2);

		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(testName, 2, subject, message, name, age, "F", mobileNumber, email);

	}

	@Test(priority = 601)
	public void askQuestion_Opt3_WebSite_QueriesPage() throws IOException {
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage();
		super.askQuestion_Website_QueriesPage(testName, 4, subject, message, name, email, age, mobileNumber, 1);

		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(testName, 3, subject, message, name, age, "M", mobileNumber, email);

	}

	// ========= Users Page =========================

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessAllQueries_WebSiteAskQuestion_Opt1_UsersPageWeb() throws IOException {
		String firstName = "AfnADUW_" + super.randomString(3);
		String lastName = "SrDoctor";
		String emailId = "SrDoctor_AllAccess@" + super.randomString(3) + "." + super.randomString(3);
		String userName = "SrDoctor" + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		// Testcase :
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 1, 1);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 1, emailId);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName, password, firstName, lastName, emailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 2, subject, message, name, email, age, mobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 1, subject, message, name, age, "F", mobileNumber, email);
	}

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessAllQueries_WebSiteAskQuestion_Opt2_UsersPageWeb() throws IOException {
		String firstName = "AfnADUW_" + super.randomString(3);
		String lastName = "SrDoctor";
		String emailId = "SrDoctor_AllAccess@" + super.randomString(3) + "." + super.randomString(3);
		String userName = "SrDoctor" + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		// Testcase :
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 1, 1);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 1, emailId);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName, password, firstName, lastName, emailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 3, subject, message, name, email, age, mobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 2, subject, message, name, age, "F", mobileNumber, email);
	}

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessOpt1_WebSiteAskQuestion_Opt1_UsersPageWeb() throws IOException {
		String firstName = "AfnADUW_" + super.randomString(3);
		String lastName = "SrDoctor";
		String emailId = "SrDoctor_AllAccess@" + super.randomString(3) + "." + super.randomString(3);
		String userName = "SrDoctor" + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		// Testcase :
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 1, 4);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 1, emailId);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName, password, firstName, lastName, emailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 2, subject, message, name, email, age, mobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 1, subject, message, name, age, "F", mobileNumber, email);
	}

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessOpt2_WebSiteAskQuestion_Opt2_UsersPageWeb() throws IOException {
		String firstName = "AfnADUW_" + super.randomString(3);
		String lastName = "SrDoctor";
		String emailId = "SrDoctor_AllAccess@" + super.randomString(3) + "." + super.randomString(3);
		String userName = "SrDoctor" + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		// Testcase :
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 1, 2);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 1, emailId);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName, password, firstName, lastName, emailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 3, subject, message, name, email, age, mobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 2, subject, message, name, age, "F", mobileNumber, email);
	}

	// @Test(priority = 15)
	public void addUser_SrDoctor_AccessOpt3_WebSiteAskQuestion_Opt3_UsersPageWeb() throws IOException {
		String firstName = "AfnADUW_" + super.randomString(3);
		String lastName = "SrDoctor";
		String emailId = "SrDoctor_AllAccess@" + super.randomString(3) + "." + super.randomString(3);
		String userName = "SrDoctor" + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String subject = "SubjectAskQuestionOpt3 S" + super.randomString(5);
		String message = "MessageAskQuestionOpt3 M" + super.randomString(5);
		String name = "AskQuestionNameOpt3 A" + super.randomString(5);
		String email = "AskQuestionEmailOpt3_" + super.randomString(3) + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String age = super.randomNumString(2);
		String mobileNumber = "5" + super.randomNumString(9);

		// Testcase :
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 1, 3);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 1, emailId);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName, password, firstName, lastName, emailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		super.askQuestion_Website_QueriesPage(driver, testName, 4, subject, message, name, email, age, mobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 3, subject, message, name, age, "F", mobileNumber, email);
	}

	// @Test(priority = 17)
		public void addUser_JuniorDoctor_AccessOpt3_WebSiteAskQuestion_Opt3_UsersPageWeb() throws IOException {
			String firstName = "AfnADUW_" + super.randomString(3);
			String lastName = "JrDoctor";
			String emailId = "JrDoctor_Opt2@" + super.randomString(3) + "." + super.randomString(3);
			String userName = "JrDoctor" + super.randomString(3);
			String password = super.randomString(6);
			// Ask Question Website Data
			String subject = "SubjectAskQuestionOpt2 S" + super.randomString(5);
			String message = "MessageAskQuestionOpt2 M" + super.randomString(5);
			String name = "AskQuestionNameOpt2 A" + super.randomString(5);
			String email = "AskQuestionEmailOpt2_" + super.randomString(3) + "@" + super.randomString(3) + "."
					+ super.randomString(3);
			String age = super.randomNumString(2);
			String mobileNumber = "5" + super.randomNumString(9);

			// Testcase :
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.openWebAppUrl(driver);
			super.loginWebApp(driver);
			super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 3, 3);
			super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 3, emailId);
			super.verifyUserProfile_UsersPageWeb(driver,6, testName, userName, password, firstName, lastName, emailId);
			super.openWebsiteUrl(driver);
			super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
			super.askQuestion_Website_QueriesPage(driver, testName, 4, subject, message, name, email, age, mobileNumber, 3);
			super.openWebAppUrl(driver);
			super.loginWebApp(driver, userName, password);
			super.click_SideMenuTabs_HomePageWeb(driver, 4);
			super.verifyData_QueriesPage(driver, testName, 3, subject, message, name, age, "F", mobileNumber, email);
		}
		// @Test(priority = 17)
		public void addUser_JuniorDoctor_AccessAllQueries_WebSiteAskQuestion_Opt2_UsersPageWeb() throws IOException {
			String firstName = "AfnADUW_" + super.randomString(3);
			String lastName = "JrDoctor";
			String emailId = "JrDoctor_Opt2@" + super.randomString(3) + "." + super.randomString(3);
			String userName = "JrDoctor" + super.randomString(3);
			String password = super.randomString(6);
			// Ask Question Website Data
			String subject = "SubjectAskQuestionOpt2 S" + super.randomString(5);
			String message = "MessageAskQuestionOpt2 M" + super.randomString(5);
			String name = "AskQuestionNameOpt2 A" + super.randomString(5);
			String email = "AskQuestionEmailOpt2_" + super.randomString(3) + "@" + super.randomString(3) + "."
					+ super.randomString(3);
			String age = super.randomNumString(2);
			String mobileNumber = "5" + super.randomNumString(9);

			// Testcase :
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.openWebAppUrl(driver);
			super.loginWebApp(driver);
			super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 3, 1);
			super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 3, emailId);
			super.verifyUserProfile_UsersPageWeb(driver,6, testName, userName, password, firstName, lastName, emailId);
			super.openWebsiteUrl(driver);
			super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
			super.askQuestion_Website_QueriesPage(driver, testName, 3, subject, message, name, email, age, mobileNumber, 3);
			super.openWebAppUrl(driver);
			super.loginWebApp(driver, userName, password);
			super.click_SideMenuTabs_HomePageWeb(driver, 4);
			super.verifyData_QueriesPage(driver, testName, 2, subject, message, name, age, "F", mobileNumber, email);
		}

		// @Test(priority = 17)
		public void addUser_JuniorDoctor_AccessAllQueries_WebSiteAskQuestion_Opt3_UsersPageWeb() throws IOException {
			String firstName = "AfnADUW_" + super.randomString(3);
			String lastName = "JrDoctor";
			String emailId = "JrDoctor_Opt2@" + super.randomString(3) + "." + super.randomString(3);
			String userName = "JrDoctor" + super.randomString(3);
			String password = super.randomString(6);
			// Ask Question Website Data
			String subject = "SubjectAskQuestionOpt2 S" + super.randomString(5);
			String message = "MessageAskQuestionOpt2 M" + super.randomString(5);
			String name = "AskQuestionNameOpt2 A" + super.randomString(5);
			String email = "AskQuestionEmailOpt2_" + super.randomString(3) + "@" + super.randomString(3) + "."
					+ super.randomString(3);
			String age = super.randomNumString(2);
			String mobileNumber = "5" + super.randomNumString(9);

			// Testcase :
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.openWebAppUrl(driver);
			super.loginWebApp(driver);
			super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 3, 1);
			super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 3, emailId);
			super.verifyUserProfile_UsersPageWeb(driver,6, testName, userName, password, firstName, lastName, emailId);
			super.openWebsiteUrl(driver);
			super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
			super.askQuestion_Website_QueriesPage(driver, testName, 4, subject, message, name, email, age, mobileNumber, 3);
			super.openWebAppUrl(driver);
			super.loginWebApp(driver, userName, password);
			super.click_SideMenuTabs_HomePageWeb(driver, 4);
			super.verifyData_QueriesPage(driver, testName, 3, subject, message, name, age, "F", mobileNumber, email);
		}
		
		// @Test(priority = 17)
		public void addUser_JuniorDoctor_AccessAllQueries_WebSiteAskQuestion_Opt1_UsersPageWeb() throws IOException {
			String firstName = "AfnADUW_" + super.randomString(3);
			String lastName = "JrDoctor";
			String emailId = "JrDoctor_Opt2@" + super.randomString(3) + "." + super.randomString(3);
			String userName = "JrDoctor" + super.randomString(3);
			String password = super.randomString(6);
			// Ask Question Website Data
			String subject = "SubjectAskQuestionOpt2 S" + super.randomString(5);
			String message = "MessageAskQuestionOpt2 M" + super.randomString(5);
			String name = "AskQuestionNameOpt2 A" + super.randomString(5);
			String email = "AskQuestionEmailOpt2_" + super.randomString(3) + "@" + super.randomString(3) + "."
					+ super.randomString(3);
			String age = super.randomNumString(2);
			String mobileNumber = "5" + super.randomNumString(9);

			// Testcase :
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.openWebAppUrl(driver);
			super.loginWebApp(driver);
			super.adduser_UsersPageWeb(driver, testName, firstName, lastName, userName, emailId, password, password, 3, 1);
			super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName, 3, emailId);
			super.verifyUserProfile_UsersPageWeb(driver,6, testName, userName, password, firstName, lastName, emailId);
			super.openWebsiteUrl(driver);
			super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
			super.askQuestion_Website_QueriesPage(driver, testName, 2, subject, message, name, email, age, mobileNumber, 3);
			super.openWebAppUrl(driver);
			super.loginWebApp(driver, userName, password);
			super.click_SideMenuTabs_HomePageWeb(driver, 4);
			super.verifyData_QueriesPage(driver, testName, 1, subject, message, name, age, "F", mobileNumber, email);
		}
	
	
	@Test(priority = 602)
	public void addUser_Doctor_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName_Doctor_AUW, lastName_AUW, userName_Doctor_AUW,
				emailId_Doctor_AUW, password_AUW, password_AUW, 1, 1);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName_Doctor_AUW, 1, emailId_Doctor_AUW);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName_Doctor_AUW, password_AUW,
				firstName_Doctor_AUW, lastName_AUW, emailId_Doctor_AUW);

	}

	@Test(priority = 603)
	public void addUser_FrontDesk_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName_FrontDesk_AUW, lastName_AUW, userName_FrontDesk_AUW,
				emailId_FrontDesk_AUW, password_AUW, password_AUW, 2, 1);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName_FrontDesk_AUW, 2, emailId_FrontDesk_AUW);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName_FrontDesk_AUW, password_AUW,
				firstName_FrontDesk_AUW, lastName_AUW, emailId_FrontDesk_AUW);

	}

	@Test(priority = 604)
	public void addUser_JuniorDoctor_UsersPageWeb() throws IOException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		super.adduser_UsersPageWeb(driver, testName, firstName_JuniorDoctor_AUW, lastName_AUW,
				userName_JuniorDoctor_AUW, emailId_JuniorDoctor_AUW, password_AUW, password_AUW, 3, 1);
		super.verifyUserInUsersList_UsersPageWeb(driver, testName, firstName_JuniorDoctor_AUW, 3,
				emailId_JuniorDoctor_AUW);
		super.verifyUserProfile_UsersPageWeb(driver, 6, testName, userName_JuniorDoctor_AUW, password_AUW,
				firstName_JuniorDoctor_AUW, lastName_AUW, emailId_JuniorDoctor_AUW);
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
