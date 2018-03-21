package nativeApp;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class MarketingCalendarPageApp extends SearchPageApp { // New extends : EndPage

	public void createTopic_MarketingCalenderPageApp(AppiumDriver<?> driver, String testName, String topicName)
			throws IOException {

		super.click_CalendarIcon_HomePageApp(driver);
		super.sleep(3000);
		super.click(driver, id + "add_topic_button_mk", locator_iOS, waitTime);
		String t = super.getTextOptional(driver, id + "no_topics_lbl", locator_iOS, 3);
		if (t.equals("No Topics...")) {
			super.click(driver, id + "add_new_topic", locator_iOS, waitTime);
			super.setText(driver, id + "new_topic", locator_iOS, topicName, waitTime);
			super.click(driver, id + "button_txt", locator_iOS, waitTime);
			super.click(driver, id + "lblListHeader", locator_iOS, waitTime);
			String tp = super.getText(driver, id + "radio", locator_iOS, waitTime);
			super.assertEquals_Text(driver, testName, "createtedNewTopicVerification", tp, topicName);
		}

	}

	public String addTopicToCalendar_MarketingCalenderPageApp(AppiumDriver<?> driver, String testName, String topicName)
			throws IOException {
		this.createTopic_MarketingCalenderPageApp(driver, testName, topicName);
		String Android_firstTopicCat_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.TextView";
		String Android_firstTopic_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.CheckBox";
		String Android_firstTopicCalendar_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView";

		super.click(driver, Android_firstTopicCat_loc, locator_iOS, waitTime);
		super.sleep(1000);
		String topic = super.getText(driver, Android_firstTopic_loc, locator_iOS, waitTime);
		super.click(driver, Android_firstTopic_loc, locator_iOS, waitTime);
		super.click(driver, Android_firstTopicCalendar_loc, locator_iOS, waitTime);
		super.click(driver, id + "mdtp_ok", locator_iOS, waitTime);
		super.click(driver, id + "addToCalender", locator_iOS, waitTime);
		super.sleep(7000);
		return topic;
	}

	/*
	 * public void verifyToolTipData_MarketingCalendarPage(String testName, String
	 * expectedBlogTitle_Topic, String expectedBlogStatus, String doctorFirstName,
	 * String blogType) throws IOException { super.assertEquals_Text(testName,
	 * "titleInTooltip_MarketingCalender", super.getText( xpath +
	 * "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[1]",
	 * waitTime), expectedBlogTitle_Topic); super.assertEquals_Text(testName, "",
	 * super.getText(xpath +
	 * "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[1]/a",
	 * waitTime), expectedBlogStatus); super.assertEquals_Text(testName, "",
	 * super.getText( xpath +
	 * "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[2]",
	 * waitTime), "By " + doctorFirstName + " | " + blogType);
	 * super.assertEquals_Text(testName, "ADD INPUTS Button", super.getText(xpath +
	 * "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[1]",
	 * waitTime), "ADD INPUTS"); super.assertEquals_Text(testName, "IONIZE Button",
	 * super.getText(xpath +
	 * "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[2]",
	 * waitTime), "IONIZE");
	 * 
	 * }
	 */

	public void verifyData_MarketingCalendarPageApp(AppiumDriver<?> driver, String testName, String blogTitle_Topic,
			String blogStatus, String blogType, String doctorName) throws IOException {
		String AndroidStartXpathTopic_CalendarApp_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[";
		String AndroidEndXpathTopic_CalendarApp_loc = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView";
		String AndroidEndXpathBlogStatus_CalendarApp_loc = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView[1]";
		String AndroidEndXpathDoctorName_CalendarApp_loc = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[1]";
		String AndroidEndXpathBlogType_CalendarApp_loc = "]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]";
		String AndroidEditorText_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View";

		for (int i = 1; i < 6; i++) {

			String actualTopic = super.getTextOptional(driver,
					AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathTopic_CalendarApp_loc, locator_iOS,
					waitTime);
			if (actualTopic.equals(blogTitle_Topic)) {
				super.assertEquals_Text(driver, testName, "blogTitle",
						super.getTextOptional(driver,
								AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathTopic_CalendarApp_loc,
								locator_iOS, waitTime),
						blogTitle_Topic);
				super.assertEquals_Text(driver, testName, "blogStatus",
						super.getTextOptional(driver,
								AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathBlogStatus_CalendarApp_loc,
								locator_iOS, waitTime),
						blogStatus);
				super.assertEquals_Text(driver, testName, "DoctorName",
						super.getTextOptional(driver,
								AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathDoctorName_CalendarApp_loc,
								locator_iOS, waitTime),
						"By " + doctorName);
				super.assertEquals_Text(driver, testName, "blogType",
						super.getTextOptional(driver,
								AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathBlogType_CalendarApp_loc,
								locator_iOS, waitTime),
						blogType);
				super.click(driver, AndroidStartXpathTopic_CalendarApp_loc + i + AndroidEndXpathTopic_CalendarApp_loc,
						locator_iOS, waitTime);
				super.assertEquals_Text(driver, testName, "blogTitleInView",
						super.getTextOptional(driver, id + "blog_title", locator_iOS, waitTime), blogTitle_Topic);
				super.assertEquals_Text(driver, testName, "blogDescription",
						super.getTextOptional(driver, id + "blog_desc", locator_iOS, waitTime), blogTitle_Topic);
				super.assertEquals_Text(driver, testName, "blogDescription",
						super.getTextOptional(driver, id + "ionize_button", locator_iOS, waitTime), "Ionize");
				break;
			} else if (i % 4 == 0) {
				i = 1;
				super.scrollDown_Mobile(driver, 3);
			}
		}

	}
}