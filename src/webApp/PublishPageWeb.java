package webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class PublishPageWeb extends HomePageWeb { // Next Extends : VisitsPageWeb

	// -------------locators---------------------------------------------

	private String firstTopicRadioBtn_TrendingTopics_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/ul/li/label";
	private String firstTopicTxt_TrendingTopics_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/ul/li";

	private String selectAndStartBtn_TrendingTopics_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div/div[2]/div/div[2]/div/button[2]";

	// ----------Editor-------------------------------------------------

	private String blogTitle_Editor_loc = xpath + "/html/body/app-root/app-publish/div/div[2]/div[2]/div[2]/input";
	private String description_EditorBeforePublish_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[2]/div[2]/div[3]";
	private String description_EditorAfterPublish_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[2]/div/p/p";
	private String windowTitle_Editor_loc = xpath + "/html/body/app-root/app-publish/div/div[2]/div[1]/span";

	private String blogStatusStartXpath_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[1]/button[";
	private String blogTypeStartXpath_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/a[";
	private String tagName_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[2]/div/tag-input/div/div/tag-input-form/form/input";
	private String calenderloc_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/owl-date-time[1]/div/div[1]/div/i";
	private String timeloc_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/owl-date-time[2]/div/div[1]/div/i";

	private String dateFieldXpathStartValue_loc = "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/owl-date-time[1]/div/div[2]/div[2]/div[2]/table/tbody/tr[";
	private String hourTxt_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/owl-date-time[2]/div/div[2]/div[2]/div[1]/div[2]/input";
	private String minitueTxt_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/owl-date-time[2]/div/div[2]/div[2]/div[2]/div[3]/input";
	private String enteredTimeTxt_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[2]/ul/li[3]/div/div[2]/span";
	private String draft_Ionize_Schedule_Btn_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[3]/button";
	private String publishNowBtn_Editor_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[2]/div[3]/button[3]";

	// --------- Success Pop-Up --------------------------------------------

	private String successMsg_SuccessPopup_loc = xpath + "/html/body/app-root/app-publish/div/div[2]/div/h3";
	private String publishDate_SuccessPopup_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div/div[3]/div[1]/ul/li[1]/b";
	private String publishTime_SuccessPopup_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div/div[3]/div[2]/ul/li/b";
	private String blogTitle_SuccessPopup_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div/div[3]/div[1]/ul/li[2]/p/b";
	private String byUser_SuccessPopup_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div/div[3]/div[1]/ul/li[3]/p/b";

	private String creditsUsed_SuccessPopup_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div/div[3]/div[1]/ul/li[4]/p/b";
	private String daysLeft_SuccessPopup_loc = xpath + "/html/body/app-root/app-publish/div/div[2]/div/div[3]/button";

	private String closeIcon_SuccessPopup_loc = xpath + "/html/body/app-root/app-publish/div/div[2]/a";

	// ------------Publish Page -------------------------
	private String CreatePostBtn_loc = xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div[1]/div[2]/a[2]";
	private String select_Add_BlogBtnStartXpath_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div/div[2]/div/button[";

	protected String subTabsStartXpath_loc = xpath
			+ "/html/body/app-root/app-publish/div/div/app-dashboard/div/div[3]/ul/li[";

	protected String blogStartXpath_ListPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div/div/div/div/div[2]/div/div/div[";

	public void click_SubTabs_PublishPage(WebDriver driver,int SubTabsOpt_PublishPage) {
		if (SubTabsOpt_PublishPage == 4) {
			SubTabsOpt_PublishPage = 3;
		}
		super.click(driver,subTabsStartXpath_loc + SubTabsOpt_PublishPage + "]", waitTime);
		super.sleep(7000);
	}

	public void verifyData_PublishPage(WebDriver driver,String testName, int draft_ionize_publishNow_Schedule_OptNumber,
			int news_blog_event_OptNumber, String blogTitle, String description, String DoctorFirtName, String date,
			String time) throws IOException {
		String blogType = super.pvWebApp("blogType" + news_blog_event_OptNumber);

		this.click_SubTabs_PublishPage(driver,draft_ionize_publishNow_Schedule_OptNumber);
		if (draft_ionize_publishNow_Schedule_OptNumber > 1) {
			super.scrollDownFullPage_Web(driver,10);
			super.scrollUp_Web(driver,2);
		}
		for (int i = 1; i <= 200; i++) {
			String actualTitle = super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[2]", waitTime);
			System.out.println(actualTitle + " : " + blogTitle);
			if (i % 4 == 0) {
				super.scrollDown_Web(driver,1, 300);
			}

			if (actualTitle.equals(blogTitle)) {

				super.assertEquals_Text(driver,testName, "BlogStatus",
						super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[1]/a", waitTime),
						super.pvWebApp("BlogStatus_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
				super.assertEquals_Text(driver,testName, "BlogActionBtn_Lists_PublishPage",
						super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[6]/button[1]", waitTime),
						super.pvWebApp("BlogActionBtn_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));

				if (draft_ionize_publishNow_Schedule_OptNumber == 1) {

					super.assertEquals_Text(driver,testName, "BlogNextStatus",
							super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[6]/button[2]", waitTime), "IONIZE");

				}
				super.assertEquals_Text(driver,testName, "BlogTitle",
						super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[2]", waitTime), blogTitle);

				super.assertEquals_Text(driver,testName, "BlogTypeAndDoctor",
						super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[3]", waitTime),
						"By " + DoctorFirtName + "|" + blogType);

				super.assertEquals_Text(driver,testName, "DaysLeft_CenterText",
						super.removeSpaceInStr(
								super.getText(driver,blogStartXpath_ListPage_loc + i + "]/div[4]/div/div/div/span", waitTime)),
						super.removeSpaceInStr(super.pvWebApp(
								"centerText_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber)));

				super.click(driver,blogStartXpath_ListPage_loc + i + "]/div[6]/button[1]", waitTime);

				if (draft_ionize_publishNow_Schedule_OptNumber == 1) {
					super.assertEquals_Text(driver,testName, "Description",
							super.getText(driver,description_EditorBeforePublish_loc, waitTime), description);
				} else /* if (draft_ionize_publishOptNumber == 2) */ {
					super.assertEquals_Text(driver,testName, "Description",
							super.getText(driver,description_EditorAfterPublish_loc, waitTime), description);
				}
				String expectedWindowTitle = "Topic : " + blogTitle
						+ super.pvWebApp("windowTitleEnd_Editor_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber);
				super.assertEquals_Text(driver,testName, "WindowTitle",
						super.getText(driver,windowTitle_Editor_loc, waitTime).replaceAll("\\s+", ""),
						expectedWindowTitle.replaceAll("\\s+", ""));
				break;
			}

			else {
				if (i == 18 || i == 38 || i == 58 || i == 78 || i == 98 || i == 118 || i == 138 || i == 158
						|| i == 178) {
					super.scrollDown_Web(driver,2, 300);
				}
			}

		}
	}

	public void addNewBlog_PublishPage(WebDriver driver,String testName, int Home_PublishPage_1_2_OptNumber,
			int select_NewTopic_1_2_OptNumber, int draft_ionize_publishNow_Schedule_OptNumber,
			int news_blog_event_OptNumber) throws IOException {
		if (Home_PublishPage_1_2_OptNumber == 1) {
			super.click_QuickStartPopup_StartBlogOptions_HomePage(driver,select_NewTopic_1_2_OptNumber);
		} else if (Home_PublishPage_1_2_OptNumber == 2) {
			super.click_SideMenuTabs_HomePage(driver,2);
			super.click(driver,this.CreatePostBtn_loc, waitTime);
			super.click(driver,select_Add_BlogBtnStartXpath_loc + select_NewTopic_1_2_OptNumber + "]",
					news_blog_event_OptNumber);
		}

		String opt = super.convertIntToStr(Home_PublishPage_1_2_OptNumber)
				+ super.convertIntToStr(select_NewTopic_1_2_OptNumber)
				+ super.convertIntToStr(draft_ionize_publishNow_Schedule_OptNumber)
				+ super.convertIntToStr(news_blog_event_OptNumber);

		blogTitle_AddNewBlog = super.blogTitle_Editor_AddNewBlog_PublishPage + super.pvWebApp(opt + "_Publish");
		tagName_AddNewBlog = super.tagName_Editor_AddNewBlog_PublishPage + super.pvWebApp(opt + "_Publish");
		description_AddNewBlog = super.description_Editor_AddNewBlog_PublishPage + super.pvWebApp(opt + "_Publish");

		int today = super.convertStrToInt(super.getTodayDate());
		int nday = today + 7;

		if (nday > super.currentMonthDays()) {
			nday = nday - super.currentMonthDays();
		}

		if (select_NewTopic_1_2_OptNumber == 1) {
			String topic = super.getText(driver,firstTopicTxt_TrendingTopics_loc, waitTime).replaceAll("\\s+", "");
			super.click(driver,firstTopicRadioBtn_TrendingTopics_loc, waitTime);
			super.click(driver,selectAndStartBtn_TrendingTopics_loc, waitTime);
			String actualTopic = super.getAttributeValue_String(driver,blogTitle_Editor_loc, "value", waitTime)
					.replaceAll("\\s+", "");
			System.out.println("Topic is : " + topic);
			System.out.println("Actual Topic is : " + actualTopic);
			super.assertEquals_Text(driver,testName, "SelectedTopic", actualTopic, topic);
		}
		super.setText(driver,blogTitle_Editor_loc, blogTitle_AddNewBlog, waitTime);
		super.setText_ByActions(driver,description_EditorBeforePublish_loc, description_AddNewBlog, waitTime);
		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 2) {
			super.click(driver,blogStatusStartXpath_Editor_loc + draft_ionize_publishNow_Schedule_OptNumber + "]", waitTime);
		} else {
			super.click(driver,blogStatusStartXpath_Editor_loc + 3 + "]", waitTime);
		}
		super.click(driver,blogTypeStartXpath_Editor_loc + news_blog_event_OptNumber + "]", waitTime);
		super.setText_ByActions(driver,tagName_Editor_loc, tagName_AddNewBlog, waitTime);
		super.kepad_Enter_Web(driver,tagName_Editor_loc, waitTime);
		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 3) {
			super.selectDateFromCalender(driver,calenderloc_Editor_loc, dateFieldXpathStartValue_loc, super.getTodayDate(),
					"owl-calendar-invalid");
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 2 || draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.selectDateFromCalender(driver,calenderloc_Editor_loc, dateFieldXpathStartValue_loc,
					super.convertIntToStr(nday), "owl-calendar-invalid");
		}

		super.click(driver,timeloc_Editor_loc, hourTxt_Editor_loc);

		// String publishTime=super.getText(driver,enteredTimeTxt_Editor_PublishPage);

		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 2
				|| draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.click(driver,draft_Ionize_Schedule_Btn_Editor_loc, waitTime);
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 3) {
			super.click(driver,publishNowBtn_Editor_loc, waitTime);
		}
		// Assert time not added.Add it later
		super.scrollDown_Web(driver,1, 500);
		super.assertEquals_Text(driver,testName, "SuccessMsg",
				super.removeSpaceInStr(
						super.getAttributeValue_String(driver,successMsg_SuccessPopup_loc, "innerText", waitTime)),
				super.removeSpaceInStr(
						super.pvWebApp("successMsg_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber)));

		if (draft_ionize_publishNow_Schedule_OptNumber == 1) {

			super.assertContains_Text(driver,testName, "SuccessDate", super.getTodayDate(),
					super.getText(driver,publishDate_SuccessPopup_loc, waitTime));

		} else if (draft_ionize_publishNow_Schedule_OptNumber == 2 || draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.assertContains_Text(driver,testName, "SuccessDate", super.convertIntToStr(nday),
					super.getText(driver,publishDate_SuccessPopup_loc, waitTime));
			super.assertEquals_Text(driver,testName, "CreditsUsed", super.getText(driver,creditsUsed_SuccessPopup_loc, waitTime),
					super.pvWebApp("creditsUsed_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
			super.assertEquals_Text(driver,testName, "DaysLeft", super.getText(driver,daysLeft_SuccessPopup_loc, waitTime),
					super.pvWebApp("daysLeft_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 3) {

			super.assertContains_Text(driver,testName, "SuccessDate", "Today",
					super.getText(driver,publishDate_SuccessPopup_loc, waitTime));
			super.assertEquals_Text(driver,testName, "CreditsUsed", super.getText(driver,creditsUsed_SuccessPopup_loc, waitTime),
					"0");

		}

		super.assertEquals_Text(driver,testName, "BlogTitle", super.getText(driver,blogTitle_SuccessPopup_loc, waitTime),
				blogTitle_AddNewBlog);
		super.assertEquals_Text(driver,testName, "ByUser", super.getText(driver,byUser_SuccessPopup_loc, waitTime),
				super.doctorFullName);

		super.click(driver,this.closeIcon_SuccessPopup_loc, waitTime);
		super.sleep(3000);
	}

}
