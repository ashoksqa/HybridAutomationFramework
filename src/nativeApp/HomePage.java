package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class HomePage extends LoginPage { // Next Extends : PublishPage

	// --- Add Lead Data
	protected String firstName_addLead = "AndFn_" + super.randomString(5);
	protected String lastName_addLead = "AndLn" + super.randomString(3);
	protected String emailId_addLead = "AndEmail_" + super.randomString(4) + "@" + super.randomString(3)
			+ ".ION";
	protected String phoneNumber_addLead = "55" + super.randomNumString(8);
	protected String city_addLead = "AndCity_" + super.randomString(5);
	protected String area_addLead = "AndArea_" + super.randomString(5);
	protected String remarks_addLead = "AndRemarks_" + super.randomString(5);
	protected String tagName_addLead = "AndTag_" + super.randomString(5);

	// --- Add Visit Data
	protected String firstName_addVisit = "AutoHomeVisits_" + super.randomString(3);
	protected String lastName_addVisit = "AutoHomeVisits_" + super.randomString(3);
	protected String emailId_addVisit = "AutoHomeVisits_" + super.randomString(3) + "@" + super.randomString(3)
			+ ".ION";
	protected String amount_addVisit = super.randomNumString(3);
	protected String phoneNumber_addVisit = "44" + super.randomNumString(8);
	protected String city_addVisit = "AutoHomeVisits_" + super.randomString(6);
	protected String area_addVisit = "AutoHomeVisits_" + super.randomString(6);
	protected String remarks_addVisit = "AutoHomeVisits_" + super.randomString(4);
	protected String tagName_addVisit = "AutoHomeVisits_" + super.randomString(4);

	public void click_CalendarIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "marketing_calender", locator_iOS, waitTime);
		super.sleep(5000);
	}

	public void click_FooterPlusIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_blank", locator_iOS, waitTime);
	}

	public void click_HomeIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_home", locator_iOS, waitTime);
	}

	public void click_PublishIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_publish", locator_iOS, waitTime);
	}

	public void click_VisitsIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_visit", locator_iOS, waitTime);
	}

	public void click_QueriesIcon_HomePage(AppiumDriver<?> driver) {
		super.click(driver, id + "navigation_query", locator_iOS, waitTime);
	}

	public void click_AddVisitFromFooter_HomePage(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePage(driver);
		super.click(driver, id + "add_visit_view", locator_iOS, waitTime);
	}

	public void click_AddPromotionsFromFooter_HomePage(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePage(driver);
		super.click(driver, id + "add_promotions_view", locator_iOS, waitTime);
	}

	public void click_AddLeadFromFooter_HomePage(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePage(driver);
		super.click(driver, id + "add_lead_view", locator_iOS, waitTime);
	}

	public void click_AddBlogFromFooter_HomePage(AppiumDriver<?> driver) {
		click_FooterPlusIcon_HomePage(driver);
		super.click(driver, id + "add_new_blog", locator_iOS, waitTime);
	}

	public void click_Menu(AppiumDriver<?> driver) {
		super.click(driver, id + "side_menu_bar", locator_iOS, waitTime);
	}

	public void click_PromotionsTab_MenuPage(AppiumDriver<?> driver) {
		String locator_Android = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]";
		super.click(driver, locator_Android, locator_iOS, waitTime);
	}

	public void click_LeadsTab_MenuPage(AppiumDriver<?> driver) {
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
		click_Menu(driver);
		super.click(driver, id + "side_bar_logout", locator_iOS, waitTime);
	}

	public String addLead_HomePage(AppiumDriver<?> driver, String firstName_addLead,
			String lastName_addLead, String emailId_addLead, String phoneNumber_addLead,
			String city_addLead, String area_addLead, String remarks_addLead,
			String tagName_addLead, String gender_M_F) throws IOException {

		this.click_AddLeadFromFooter_HomePage(driver);

		super.setText(driver, id + "lead_firstname", locator_iOS, firstName_addLead, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_lastname", locator_iOS, lastName_addLead, waitTime);
		super.keypadClose(driver);

		if (gender_M_F.equals("M") || gender_M_F.equals("m")) {
			super.click(driver, id + "leadMale", locator_iOS, waitTime);
		} else if (gender_M_F.equals("F") || gender_M_F.equals("f")) {
			super.click(driver, id + "leadFemale", locator_iOS, waitTime);
		}
		super.click(driver, id + "input_layout_dob", locator_iOS, waitTime);
		super.click(driver, id + "android:id/button1", locator_iOS, waitTime);
		super.setText(driver, id + "lead_phone", locator_iOS, phoneNumber_addLead, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_email", locator_iOS, emailId_addLead, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_city", locator_iOS, city_addLead, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_area", locator_iOS, area_addLead, waitTime);
		super.keypadNext(driver);
		super.setValue(driver, id + "searchView", locator_iOS, tagName_addLead, waitTime);
		super.click(driver, id + "input_layout_group", locator_iOS, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_add_remarks", locator_iOS, remarks_addLead, waitTime);
		super.keypadClose(driver);

		String dob_addLead = super.getText(driver, id + "lead_dob", locator_iOS, waitTime);
		super.scrollDown_Mobile(driver, 3);
		super.click(driver, id + "add_lead", locator_iOS, waitTime);

		return dob_addLead;
	}

}
