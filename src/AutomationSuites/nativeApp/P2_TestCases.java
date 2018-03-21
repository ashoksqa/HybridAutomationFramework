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
import nativeApp.EndPage;

public class P2_TestCases extends EndPage {
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
		  super.login(wdriver, "uid", "pwd");
		  super.click_NoTahnks_Notification(wdriver);
		 

	}

	// =========Select Topic From Home Page=====================================
	@Test(priority = 400)
	public void addBlog_SelectTopic_Draft_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 1, 2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 2, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 2, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	
	@Test(priority = 401)
	public void addBlog_SelectTopic_Draft_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 1, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	@Test(priority = 402)
	public void addBlog_SelectTopic_Ionize_News_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 2, 1);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	@Test(priority = 403)
	public void addBlog_SelectTopic_Ionize_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 2, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	 @Test(priority = 404)
	public void addBlog_SelectTopic_PublishNow_News_PublishPageApp() throws IOException, InterruptedException {
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.resetApp(driver);
			super.loginAfterResetApp(driver, "uid", "pwd");
			String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 3,1);
			System.out.println("Blog date is :" + date);
			super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, date, " ");
			super.naavigateToUrl(wdriver, "homeUrl");
			super.click_SideMenuTabs_HomePage(wdriver, 2);
			super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

		}
	 
	 @Test(priority = 405)
		public void addBlog_SelectTopic_PublishNow_Blog_PublishPageApp() throws IOException, InterruptedException {
				String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
				super.resetApp(driver);
				super.loginAfterResetApp(driver, "uid", "pwd");
				String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 3,2);
				System.out.println("Blog date is :" + date);
				super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
						super.description_AddNewBlogApp, date, " ");
				super.naavigateToUrl(wdriver, "homeUrl");
				super.click_SideMenuTabs_HomePage(wdriver, 2);
				super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
						super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

			}

	@Test(priority = 406)
	public void addBlog_SelectTopic_Schedule_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 4, 2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}	
	@Test(priority = 407)
	public void addBlog_SelectTopic_Schedule_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 1, 4, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	
	
	// =========New Topic From Publish Page=====================================

	@Test(priority = 450)
	public void addBlog_NewTopic_Draft_News_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 1, 1);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	
	@Test(priority = 451)
	public void addBlog_NewTopic_Draft_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 1, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	@Test(priority = 452)
	public void addBlog_NewTopic_Ionize_News_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 2, 1);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}
	
	@Test(priority = 453)
	public void addBlog_NewTopic_Ionize_Blog_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 2,2);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	 @Test(priority = 454)
	public void addBlog_NewTopic_PublishNow_Blog_PublishPageApp() throws IOException, InterruptedException {
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.resetApp(driver);
			super.loginAfterResetApp(driver, "uid", "pwd");
			String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 3, 2);
			System.out.println("Blog date is :" + date);
			super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, date, " ");
			super.naavigateToUrl(wdriver, "homeUrl");
			super.click_SideMenuTabs_HomePage(wdriver, 2);
			super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

		}
	 
	 @Test(priority = 455)
		public void addBlog_NewTopic_PublishNow_Event_PublishPageApp() throws IOException, InterruptedException {
				String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
				super.resetApp(driver);
				super.loginAfterResetApp(driver, "uid", "pwd");
				String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 3, 3);
				System.out.println("Blog date is :" + date);
				super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
						super.description_AddNewBlogApp, date, " ");
				super.naavigateToUrl(wdriver, "homeUrl");
				super.click_SideMenuTabs_HomePage(wdriver, 2);
				super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
						super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

			}
	 @Test(priority = 456)
		public void addBlog_NewTopic_Schedule_News_PublishPageApp() throws IOException, InterruptedException {
			String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
			super.resetApp(driver);
			super.loginAfterResetApp(driver, "uid", "pwd");
			String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 4, 1);
			System.out.println("Blog date is :" + date);
			super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, date, " ");
			super.naavigateToUrl(wdriver, "homeUrl");
			super.click_SideMenuTabs_HomePage(wdriver, 2);
			super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
					super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

		}
	@Test(priority = 457)
	public void addBlog_NewTopic_Schedule_Event_PublishPageApp() throws IOException, InterruptedException {
		String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
		super.resetApp(driver);
		super.loginAfterResetApp(driver, "uid", "pwd");
		String date = super.addNewBlog_PublishPageApp(driver, testName, 2, 4, 3);
		System.out.println("Blog date is :" + date);
		super.verifyData_PublishPageApp(driver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, date, " ");
		super.naavigateToUrl(wdriver, "homeUrl");
		super.click_SideMenuTabs_HomePage(wdriver, 2);
		super.verifyData_PublishPageWeb(wdriver, testName, 1, 1, super.blogTitle_AddNewBlogApp,
				super.description_AddNewBlogApp, super.doctorFullName, " ", " ");

	}

	// ========= Queries Page=====================================

@Test(priority = 600)
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

@Test(priority = 601)
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
		super.testResult(driver, testResult);
		// super.closeDriver();
	}

	@AfterTest
	public void Quit() throws InterruptedException, IOException {
		super.quitDriver(driver);
		System.out.println("Stopped");
	}
}
