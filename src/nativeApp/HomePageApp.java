package nativeApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class HomePageApp extends LoginPageApp { // Next Extends : PublishPageApp
	

	

	public void click_CalendarIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "marketing_calender", locator_iOS, waitTime);
		super.sleep(3000);
	}

	public void click_FooterPlusIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_blank", locator_iOS, waitTime);
	}

	public void click_HomeIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_home", locator_iOS, waitTime);
	}

	public void click_PublishIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_publish", locator_iOS, waitTime);
	}

	public void click_VisitsIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_visit", locator_iOS, waitTime);
	}

	public void click_QueriesIcon_HomePageApp(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_query", locator_iOS, waitTime);
	}

	public void click_AddVisitFromFooter_HomePageApp(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePageApp(driver);
		super.click(driver, id + "add_visit_view", locator_iOS, waitTime);
	}

	public void click_AddPromotionsFromFooter_HomePageApp(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePageApp(driver);
		super.click(driver, id + "add_promotions_view", locator_iOS, waitTime);
	}

	public void click_AddLeadFromFooter_HomePageApp(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePageApp(driver);
		super.click(driver, id + "add_lead_view", locator_iOS, waitTime);
	}

	public void click_AddBlogFromFooter_HomePageApp(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePageApp(driver);
		super.click(driver, id + "add_new_blog", locator_iOS, waitTime);
	}

	public void click_MenuApp(AppiumDriver<?> driver) {
		super.click(driver, id + "side_menu_bar", locator_iOS, waitTime);
	}

	public void click_PromotionsTab_MenuPageApp(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void click_LeadsTab_MenuPageApp(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void click_UsersTab_MenuPage(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void click_AnalyticsTab_MenuPage(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void click_SubscriptionTab_MenuPage(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void logout(AppiumDriver<?> driver) {
		click_MenuApp(driver);
		super.click(driver, id + "side_bar_logout", locator_iOS, waitTime);
	}

	



}
