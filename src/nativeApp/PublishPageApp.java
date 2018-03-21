package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class PublishPageApp extends HomePageApp { // Next Extends : VisitsPageApp

	// -------------locators---------------------------------------------

	

	// ----------Editor-------------------------------------------------

	

	// --------- Success Pop-Up --------------------------------------------

	
	public void verifyData_PublishPageApp(AppiumDriver<?> driver, String testName,
			int draft_ionize_publishNow_Schedule_OptNumber, int news_blog_event_OptNumber, String blogTitle,
			String description,String date, String time) throws IOException {
		String blogType = super.pvNativeApp("blogType" + news_blog_event_OptNumber);
		String daysLeft = super.pvNativeApp("daysLeft_Lists_PublishPage" + news_blog_event_OptNumber);
		String blogActionButtons = super.pvNativeApp("BlogActionBtn_Lists_PublishPage" + news_blog_event_OptNumber);
		
		String Android_AddInputs_loc=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.Button";
		String Android_Ionize_loc=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.Button";
		String Android_view_loc=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button";

		// this.click_SubTabs_PublishPage(draft_ionize_publishNow_Schedule_OptNumber);
		super.sleep(3000);
		String Android_Title_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]";
		
		boolean a = super.scrollDownUntilTextEquals(driver, Android_Title_loc, locator_iOS, blogTitle, 1);
		if (a) {

			String Android_Status_loc = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]";
			String Android_DoctorName_loc = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]";
			String Android_BlogType_loc = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]";
			String Android_DaysLeft_loc = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[3]";
			String Android_Date_loc = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView[1]";

			super.assertEquals_Text(driver, testName, "blogStatus",
					super.getTextOptional(driver, Android_Status_loc, locator_iOS, waitTime), super.pvNativeApp("BlogStatus_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
			super.assertEquals_Text(driver, testName, "blogTitle",
					super.getTextOptional(driver, Android_Title_loc, locator_iOS, waitTime), blogTitle);
			super.assertEquals_Text(driver, testName, "doctorFullName",
					super.getTextOptional(driver, Android_DoctorName_loc, locator_iOS, waitTime), super.doctorFullName);
			super.assertEquals_Text(driver, testName, "blogType",
					super.getTextOptional(driver, Android_BlogType_loc, locator_iOS, waitTime), blogType);
			
			super.assertContains_Text(driver, testName, "date",date,
					super.getTextOptional(driver, Android_Date_loc, locator_iOS, waitTime));
			
			if(draft_ionize_publishNow_Schedule_OptNumber==1) {
				
				
				super.assertEquals_Text(driver, testName, "IONIZE",
						super.getTextOptional(driver, Android_Ionize_loc, locator_iOS, waitTime), "IONIZE");
			}
			if(draft_ionize_publishNow_Schedule_OptNumber==1 || draft_ionize_publishNow_Schedule_OptNumber==2) {

			super.assertEquals_Text(driver, testName, "blogActionButtons",
					super.getTextOptional(driver, Android_AddInputs_loc, locator_iOS, waitTime), blogActionButtons);
			super.assertEquals_Text(driver, testName, "daysLeft",
					super.getTextOptional(driver, Android_DaysLeft_loc, locator_iOS, waitTime), daysLeft);
			}
			else if(draft_ionize_publishNow_Schedule_OptNumber==3 || draft_ionize_publishNow_Schedule_OptNumber==4){
				super.assertEquals_Text(driver, testName, "blogActionButtons",
						super.getTextOptional(driver, Android_view_loc, locator_iOS, waitTime), "VIEW");
				
			}


		super.click(driver, Android_Title_loc, locator_iOS, waitTime);
		super.sleep(2000);
		super.assertEquals_Text(driver, testName, "blogTitle In Editor",
				super.getTextOptional(driver, id+"blogtitle", locator_iOS, waitTime), blogTitle);
		String Android_des_loc=xpath+"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View";
		super.assertEquals_Text(driver, testName, "description",
				super.getTextOptional(driver,Android_des_loc, locator_iOS, waitTime), description);
		}

	}

	public String addNewBlog_PublishPageApp(AppiumDriver<?> driver, String testName, int select_NewTopic_1_2_OptNumber,
			int draft_ionize_publishNow_Schedule_OptNumber, int news_blog_event_OptNumber) throws IOException {
		String Android_blogTitle_Editor_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.webkit.WebView/android.webkit.WebView/android.view.View[1]";

		String Android_BlogType_loc = xpath
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RadioGroup/android.widget.RadioButton["
				+ news_blog_event_OptNumber + "]";

		super.click_AddBlogFromFooter_HomePageApp(driver);

		if (select_NewTopic_1_2_OptNumber == 1) {
			super.click(driver, id + "select_the_topic", locator_iOS, waitTime);
			String AndroidFirstTopicCategory = xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.TextView";
			String AndroidFirstTopic_loc= xpath
					+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.CheckBox";
			super.click(driver, AndroidFirstTopicCategory, locator_iOS, waitTime);
			super.click(driver, AndroidFirstTopic_loc, locator_iOS, waitTime);
			String topic = super.getTextOptional(driver, AndroidFirstTopic_loc, locator_iOS, waitTime);
			
			super.click(driver, id + "topicandstart", locator_iOS, waitTime);
			String actualTopic = super.getTextOptional(driver, Android_blogTitle_Editor_loc, locator_iOS, waitTime);
			super.assertEquals_Text(driver, testName, "SelectedTopic", actualTopic, topic);
		} else if (select_NewTopic_1_2_OptNumber == 2) {
			super.click(driver, id + "no_i_want_new_topic", locator_iOS, waitTime);
		}

		String opt = super.convertIntToStr(select_NewTopic_1_2_OptNumber)
				+ super.convertIntToStr(draft_ionize_publishNow_Schedule_OptNumber)
				+ super.convertIntToStr(news_blog_event_OptNumber);

		blogTitle_AddNewBlog = super.getOS(driver) + " " + super.blogTitle_Editor_AddNewBlog_PublishPage
				+ super.pvNativeApp(opt + "_Publish");
		tagName_AddNewBlog = super.tagName_Editor_AddNewBlog_PublishPage + super.pvNativeApp(opt + "_Publish");
		description_AddNewBlog = super.getOS(driver) + " " + super.description_Editor_AddNewBlog_PublishPage
				+ super.pvNativeApp(opt + "_Publish");
String BlogDate="empty";
		int today = super.convertStrToInt(super.getTodayDate());
		int nday = today + 7;
		super.sleep(5000);
		super.switchToWebViewContext(driver);
		super.setText(driver, id + "zss_field_title", locator_iOS, blogTitle_AddNewBlog, waitTime);
		super.setText(driver, id + "zss_field_content", locator_iOS, description_AddNewBlog, waitTime);
		super.switchToNativeAppContext(driver);
		if (draft_ionize_publishNow_Schedule_OptNumber == 1) {
			super.click(driver, id + "draft_btn", locator_iOS, waitTime);
			super.sleep(4000);
			super.click(driver, Android_BlogType_loc, locator_iOS, waitTime);
			super.setText(driver, id + "blogTags", locator_iOS, tagName_AddNewBlog, waitTime);
			super.keypadClose(driver);
			super.keypadClose(driver);
			super.click(driver, id + "btnSave", locator_iOS, waitTime);
			super.assertEquals_Text(driver, testName, "SuccessDate",
					super.getText(driver, id + "publishDate", locator_iOS, waitTime),
					super.date_02SpaceFebrauryComma2018);
			BlogDate=super.getTodayDate();
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 2) {
			super.click(driver, id + "ionize_btn_main", locator_iOS, waitTime);
			super.sleep(2000);
			super.click(driver, Android_BlogType_loc, locator_iOS, waitTime);
			super.setText(driver, id + "blogTags", locator_iOS, tagName_AddNewBlog, waitTime);
			super.keypadClose(driver);
			super.keypadClose(driver);
			super.click(driver, id + "btnIonize", locator_iOS, waitTime);
			super.assertEquals_Text(driver, testName, "CreditsUsed",
					super.getText(driver, id + "publishcredits", locator_iOS, waitTime), "8");

			String sDate = super.getText(driver, id + "publishDate", locator_iOS, waitTime);
			super.assertContains_Text(driver, testName, "SuccessDate", super.convertIntToStr(nday), sDate);
			super.assertEquals_Text(driver, testName, "Days Left",
					super.getText(driver, id + "numberOfDays", locator_iOS, waitTime), "6 days to go");
			BlogDate=super.convertIntToStr(nday);
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 3) {
			super.click(driver, id + "publish_btn", locator_iOS, waitTime);
			super.sleep(2000);
			super.click(driver, Android_BlogType_loc, locator_iOS, waitTime);
			super.setText(driver, id + "blogTags", locator_iOS, tagName_AddNewBlog, waitTime);
			super.keypadClose(driver);
			super.keypadClose(driver);
			super.click(driver, id + "btnPublish", locator_iOS, waitTime);
			super.assertEquals_Text(driver, testName, "CreditsUsed",
					super.getText(driver, id + "publishcredits", locator_iOS, waitTime), "0");
			super.assertEquals_Text(driver, testName, "SuccessDate",
					super.getText(driver, id + "publishDate", locator_iOS, waitTime),
					super.date_02SpaceFebrauryComma2018);
			super.assertEquals_Text(driver, testName, "Days Left",
					super.getText(driver, id + "numberOfDays", locator_iOS, waitTime), "It will be live now");
			BlogDate=super.getTodayDate();
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.click(driver, id + "publish_btn", locator_iOS, waitTime);
			super.sleep(2000);
			super.click(driver, Android_BlogType_loc, locator_iOS, waitTime);
			super.setText(driver, id + "blogTags", locator_iOS, tagName_AddNewBlog, waitTime);
			super.keypadClose(driver);
			super.keypadClose(driver);
			if (nday > super.currentMonthDays()) {
				nday = nday - super.currentMonthDays();
				super.selectDateFromCalendarApp(driver, id + "date_data", Android_BlogType_loc, "N", nday);
			} else {
				super.selectDateFromCalendarApp(driver, id + "date_data", Android_BlogType_loc, " ", nday);
			}
			super.click(driver, id + "btnSchedule", locator_iOS, waitTime);
			String sDate = super.getText(driver, id + "publishDate", locator_iOS, waitTime);
			super.assertContains_Text(driver, testName, "SuccessDate", super.convertIntToStr(nday), sDate);
			super.assertEquals_Text(driver, testName, "CreditsUsed",
					super.getText(driver, id + "publishcredits", locator_iOS, waitTime), "0");
			super.assertEquals_Text(driver, testName, "Days Left",
					super.getText(driver, id + "numberOfDays", locator_iOS, waitTime), "6 days to go");
			BlogDate=super.convertIntToStr(nday);
		}

		String successMsg = super.getText(driver, id + "add_promo_success_message", locator_iOS, waitTime);
		super.assertEquals_Text(driver, testName, "SuccessMsg", super.removeSpaceInStr(successMsg),
				super.removeSpaceInStr(super.pvNativeApp(
						"successMsg_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber)));
		super.assertEquals_Text(driver, testName, "BlogTitle",
				super.getTextOptional(driver, id + "publishtitle", locator_iOS, waitTime), blogTitle_AddNewBlog);
		super.assertEquals_Text(driver, testName, "ByUser",
				super.getTextOptional(driver, id + "publishby", locator_iOS, waitTime), super.doctorFullName);

		super.click(driver, id + "close_layout", locator_iOS, waitTime);
		super.sleep(3000);
		return BlogDate;
	}
}
