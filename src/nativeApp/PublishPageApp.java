package nativeApp;

import java.io.IOException;

public class PublishPageApp extends HomePageApp { // Next Extends : VisitsPageApp

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

	public void click_SubTabs_PublishPage(int SubTabsOpt_PublishPage) {
		if (SubTabsOpt_PublishPage == 4) {
			SubTabsOpt_PublishPage = 3;
		}
		super.click(subTabsStartXpath_loc + SubTabsOpt_PublishPage + "]", waitTime);
		super.sleep(7000);
	}

	public void verifyData_PublishPage(String testName, int draft_ionize_publishNow_Schedule_OptNumber,
			int news_blog_event_OptNumber, String blogTitle, String description, String DoctorFirtName, String date,
			String time) throws IOException {
		String blogType = super.pvd("blogType" + news_blog_event_OptNumber);

		this.click_SubTabs_PublishPage(draft_ionize_publishNow_Schedule_OptNumber);
		if (draft_ionize_publishNow_Schedule_OptNumber > 1) {
			super.scrollDownFullPage(10);
			super.scrollUp(2);
		}
		for (int i = 1; i <= 200; i++) {
			String actualTitle = super.getText(blogStartXpath_ListPage_loc + i + "]/div[2]", waitTime);
			System.out.println(actualTitle + " : " + blogTitle);
			if (i % 4 == 0) {
				super.scrollDown(1, 300);
			}

			if (actualTitle.equals(blogTitle)) {

				super.assertEquals_Text(testName, "BlogStatus",
						super.getText(blogStartXpath_ListPage_loc + i + "]/div[1]/a", waitTime),
						super.pvd("BlogStatus_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
				super.assertEquals_Text(testName, "BlogActionBtn_Lists_PublishPage",
						super.getText(blogStartXpath_ListPage_loc + i + "]/div[6]/button[1]", waitTime),
						super.pvd("BlogActionBtn_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));

				if (draft_ionize_publishNow_Schedule_OptNumber == 1) {

					super.assertEquals_Text(testName, "BlogNextStatus",
							super.getText(blogStartXpath_ListPage_loc + i + "]/div[6]/button[2]", waitTime), "IONIZE");

				}
				super.assertEquals_Text(testName, "BlogTitle",
						super.getText(blogStartXpath_ListPage_loc + i + "]/div[2]", waitTime), blogTitle);

				super.assertEquals_Text(testName, "BlogTypeAndDoctor",
						super.getText(blogStartXpath_ListPage_loc + i + "]/div[3]", waitTime),
						"By " + DoctorFirtName + "|" + blogType);

				super.assertEquals_Text(testName, "DaysLeft_CenterText",
						super.removeSpaceInStr(
								super.getText(blogStartXpath_ListPage_loc + i + "]/div[4]/div/div/div/span", waitTime)),
						super.removeSpaceInStr(super.pvd(
								"centerText_Lists_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber)));

				super.click(blogStartXpath_ListPage_loc + i + "]/div[6]/button[1]", waitTime);

				if (draft_ionize_publishNow_Schedule_OptNumber == 1) {
					super.assertEquals_Text(testName, "Description",
							super.getText(description_EditorBeforePublish_loc, waitTime), description);
				} else /* if (draft_ionize_publishOptNumber == 2) */ {
					super.assertEquals_Text(testName, "Description",
							super.getText(description_EditorAfterPublish_loc, waitTime), description);
				}
				String expectedWindowTitle = "Topic : " + blogTitle
						+ super.pvd("windowTitleEnd_Editor_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber);
				super.assertEquals_Text(testName, "WindowTitle",
						super.getText(windowTitle_Editor_loc, waitTime).replaceAll("\\s+", ""),
						expectedWindowTitle.replaceAll("\\s+", ""));
				break;
			}

			else {
				if (i == 18 || i == 38 || i == 58 || i == 78 || i == 98 || i == 118 || i == 138 || i == 158
						|| i == 178) {
					super.scrollDown(2, 300);
				}
			}

		}
	}

	public void addNewBlog_PublishPage(String testName, int Home_PublishPage_1_2_OptNumber,
			int select_NewTopic_1_2_OptNumber, int draft_ionize_publishNow_Schedule_OptNumber,
			int news_blog_event_OptNumber) throws IOException {
		if (Home_PublishPage_1_2_OptNumber == 1) {
			super.click_QuickStartPopup_StartBlogOptions_HomePage(select_NewTopic_1_2_OptNumber);
		} else if (Home_PublishPage_1_2_OptNumber == 2) {
			super.click_SideMenuTabs_HomePage(2);
			super.click(this.CreatePostBtn_loc, waitTime);
			super.click(select_Add_BlogBtnStartXpath_loc + select_NewTopic_1_2_OptNumber + "]",
					news_blog_event_OptNumber);
		}

		String opt = super.convertIntToStr(Home_PublishPage_1_2_OptNumber)
				+ super.convertIntToStr(select_NewTopic_1_2_OptNumber)
				+ super.convertIntToStr(draft_ionize_publishNow_Schedule_OptNumber)
				+ super.convertIntToStr(news_blog_event_OptNumber);

		blogTitle_AddNewBlog = super.blogTitle_Editor_AddNewBlog_PublishPage + super.pvd(opt + "_Publish");
		tagName_AddNewBlog = super.tagName_Editor_AddNewBlog_PublishPage + super.pvd(opt + "_Publish");
		description_AddNewBlog = super.description_Editor_AddNewBlog_PublishPage + super.pvd(opt + "_Publish");

		int today = super.convertStrToInt(super.getTodayDate());
		int nday = today + 7;

		if (nday > super.currentMonthDays()) {
			nday = nday - super.currentMonthDays();
		}

		if (select_NewTopic_1_2_OptNumber == 1) {
			String topic = super.getText(firstTopicTxt_TrendingTopics_loc, waitTime).replaceAll("\\s+", "");
			super.click(firstTopicRadioBtn_TrendingTopics_loc, waitTime);
			super.click(selectAndStartBtn_TrendingTopics_loc, waitTime);
			String actualTopic = super.getAttributeValue_String(blogTitle_Editor_loc, "value", waitTime)
					.replaceAll("\\s+", "");
			System.out.println("Topic is : " + topic);
			System.out.println("Actual Topic is : " + actualTopic);
			super.assertEquals_Text(testName, "SelectedTopic", actualTopic, topic);
		}
		super.setText(blogTitle_Editor_loc, blogTitle_AddNewBlog, waitTime);
		super.setText_ByActions(description_EditorBeforePublish_loc, description_AddNewBlog, waitTime);
		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 2) {
			super.click(blogStatusStartXpath_Editor_loc + draft_ionize_publishNow_Schedule_OptNumber + "]", waitTime);
		} else {
			super.click(blogStatusStartXpath_Editor_loc + 3 + "]", waitTime);
		}
		super.click(blogTypeStartXpath_Editor_loc + news_blog_event_OptNumber + "]", waitTime);
		super.setText_ByActions(tagName_Editor_loc, tagName_AddNewBlog, waitTime);
		super.kepad_Enter(tagName_Editor_loc, waitTime);
		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 3) {
			super.selectDateFromCalender(calenderloc_Editor_loc, dateFieldXpathStartValue_loc, super.getTodayDate(),
					"owl-calendar-invalid");
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 2 || draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.selectDateFromCalender(calenderloc_Editor_loc, dateFieldXpathStartValue_loc,
					super.convertIntToStr(nday), "owl-calendar-invalid");
		}

		super.click(timeloc_Editor_loc, hourTxt_Editor_loc);

		// String publishTime=super.getText(enteredTimeTxt_Editor_PublishPage);

		if (draft_ionize_publishNow_Schedule_OptNumber == 1 || draft_ionize_publishNow_Schedule_OptNumber == 2
				|| draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.click(draft_Ionize_Schedule_Btn_Editor_loc, waitTime);
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 3) {
			super.click(publishNowBtn_Editor_loc, waitTime);
		}
		// Assert time not added.Add it later
		super.scrollDown(1, 500);
		super.assertEquals_Text(testName, "SuccessMsg",
				super.removeSpaceInStr(
						super.getAttributeValue_String(successMsg_SuccessPopup_loc, "innerText", waitTime)),
				super.removeSpaceInStr(
						super.pvd("successMsg_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber)));

		if (draft_ionize_publishNow_Schedule_OptNumber == 1) {

			super.assertContains_Text(testName, "SuccessDate", super.getTodayDate(),
					super.getText(publishDate_SuccessPopup_loc, waitTime));

		} else if (draft_ionize_publishNow_Schedule_OptNumber == 2 || draft_ionize_publishNow_Schedule_OptNumber == 4) {
			super.assertContains_Text(testName, "SuccessDate", super.convertIntToStr(nday),
					super.getText(publishDate_SuccessPopup_loc, waitTime));
			super.assertEquals_Text(testName, "CreditsUsed", super.getText(creditsUsed_SuccessPopup_loc, waitTime),
					super.pvd("creditsUsed_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
			super.assertEquals_Text(testName, "DaysLeft", super.getText(daysLeft_SuccessPopup_loc, waitTime),
					super.pvd("daysLeft_Popup_PublishPage" + draft_ionize_publishNow_Schedule_OptNumber));
		} else if (draft_ionize_publishNow_Schedule_OptNumber == 3) {

			super.assertContains_Text(testName, "SuccessDate", "Today",
					super.getText(publishDate_SuccessPopup_loc, waitTime));
			super.assertEquals_Text(testName, "CreditsUsed", super.getText(creditsUsed_SuccessPopup_loc, waitTime),
					"0");

		}

		super.assertEquals_Text(testName, "BlogTitle", super.getText(blogTitle_SuccessPopup_loc, waitTime),
				blogTitle_AddNewBlog);
		super.assertEquals_Text(testName, "ByUser", super.getText(byUser_SuccessPopup_loc, waitTime),
				super.doctorFullName);

		super.click(this.closeIcon_SuccessPopup_loc, waitTime);
		super.sleep(3000);
	}

}
