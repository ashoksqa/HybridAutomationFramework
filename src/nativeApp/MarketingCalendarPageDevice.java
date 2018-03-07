package nativeApp;

import java.io.IOException;
import java.util.Date;

public class MarketingCalendarPageDevice extends SearchPage { // End

	private String addNewTopicBtn_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[1]/button";
	private String firstTopicRadioBtn_PlanYourCalendar_MarketingCalenderPage_loc = id + "help-topic";
	private String firstTopicText_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/ul/li/div[1]/span";
	private String firstTopicDateField_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/ul/li/div[2]/owl-date-time/div/div[1]/input";
	private String firstTopicDateStartXpath_PlanYourCalendar_MarketingCalenderPage_loc = "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/ul/li/div[2]/owl-date-time/div/div[3]/div/div[2]/table/tbody/tr[";
	private String addNewTopicBtn_PlanYourCalendar_MarketingCalenderPage_loc = cls + "txt-center";
	private String writeTopicTxt_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/form/div[1]/input";
	private String specialityDropDown_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/form/div[2]";
	private String addBtn_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/form/button";
	private String addToCalendarBtn_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[3]/button[2]";
	private String cancel_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[3]/button[1]";

	private String clickNextMonth_PlanYourCalendar_MarketingCalenderPage_loc = xpath
			+ "/html/body/app-root/app-publish/div/div[2]/div[2]/div[1]/div[1]/ul/li[4]/img";

	//================ Calendar page Locators =============================================================
	
	private String dateStartXpath_loc = xpath
			+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/ng-fullcalendar/div[2]/div/table/tbody/tr/td/div/div/div[";
	private String plusMoreStartXpath_loc = "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/ng-fullcalendar/div[2]/div/div/div[2]/div/a";
	private String plusMorePopuCloseIcon_loc=xpath+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/ng-fullcalendar/div[2]/div/div/div[1]/span[1]";
	
	public void createTopic_MarketingCalenderPage(String testName, String topicName, int topicDropDownValue)
			throws IOException {
		super.click_CalendarIcon_HomePage();
		super.sleep(5000);
		super.click(addNewTopicBtn_MarketingCalenderPage_loc, waitTime);
		super.sleep(3000);
		String topic = super.getTextOptional(firstTopicText_PlanYourCalendar_MarketingCalenderPage_loc, 3);
		if (topic.isEmpty()) {
			super.click(addNewTopicBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
			super.setText(writeTopicTxt_PlanYourCalendar_MarketingCalenderPage_loc, topicName, waitTime);
			super.selectDropDownValue(specialityDropDown_PlanYourCalendar_MarketingCalenderPage_loc,
					topicDropDownValue);
			super.click(addBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
			topic = super.getTextOptional(firstTopicText_PlanYourCalendar_MarketingCalenderPage_loc, 10);
			super.assertEquals_Text(testName, "createtedNewTopicVerification", topic, topicName);
		}

	}

	public void addTopicToCalendar_MarketingCalenderPage(String testName, String topicName, int topicDropDownValue,
			String dateValue) throws IOException {
		this.createTopic_MarketingCalenderPage(testName, topicName, topicDropDownValue);
		super.click(firstTopicRadioBtn_PlanYourCalendar_MarketingCalenderPage_loc, 3);
		super.selectDateFromCalender(firstTopicDateField_PlanYourCalendar_MarketingCalenderPage_loc,
				firstTopicDateStartXpath_PlanYourCalendar_MarketingCalenderPage_loc, dateValue, "owl-calendar-invalid");
		super.click(addToCalendarBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
		super.sleep(7000);
	}

	public void verifyToolTipData_MarketingCalendarPage(String testName, String expectedBlogTitle_Topic,
			String expectedBlogStatus, String doctorFirstName, String blogType) throws IOException {
		super.assertEquals_Text(testName, "titleInTooltip_MarketingCalender",
				super.getText(
						xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[1]",
						waitTime),
				expectedBlogTitle_Topic);
		super.assertEquals_Text(testName, "",
				super.getText(xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[1]/a",
						waitTime),
				expectedBlogStatus);
		super.assertEquals_Text(testName, "",
				super.getText(
						xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[2]",
						waitTime),
				"By " + doctorFirstName + " | " + blogType);
		super.assertEquals_Text(testName, "ADD INPUTS Button",
				super.getText(xpath
						+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[1]",
						waitTime),
				"ADD INPUTS");
		super.assertEquals_Text(testName, "IONIZE Button",
				super.getText(xpath
						+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[2]",
						waitTime),
				"IONIZE");

	}

	public void verifyData_MarketingCalendarPage(String testName, String dateValue, String blotTitle_Topic,
			String blogStatus, String blogType, String doctorFirstName) throws IOException {
		super.click_CalendarIcon_HomePage();
		super.scrollDown(1, 150);
		outerloop: for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				String dateV = dateStartXpath_loc + i + "]/div[2]/table/thead/tr/td[" + j + "]";
				String currentDate = super.getAttributeValue_String(dateV, "innerText", waitTime);
				String currentDate_cls = super.getAttributeValue_String(dateV, "className", waitTime);
				System.out.println("date and cls name are : " + currentDate + "/" + currentDate_cls);
				if (currentDate.equals(dateValue) && currentDate_cls.contains("fc-past")) {
					System.out.println(dateValue + " is past date");
				} else if (currentDate.equals(dateValue)) {
					String firstRowText = super.getTextOptional(
							dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[1]/td[" + j + "]/a/div/span[2]", waitTime);
					System.out.println("firstRowText : " + firstRowText);
					if (firstRowText.equals(blotTitle_Topic)) {
						super.clickAndHold_Actions(
								dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[1]/td[" + j + "]/a/div/span[2]",
								waitTime);
						this.verifyToolTipData_MarketingCalendarPage(testName, blotTitle_Topic, blogStatus,
								doctorFirstName, blogType);
						break outerloop;
					} else {
						for (int m = 1; m < 14; m++) {
							String secondRowText = super.getTextOptional(
									dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + m + "]/a/div/span[2]", 1);
							System.out.println(
									"secondRowText : " + secondRowText + " date is : " + dateFormat.format(new Date()));

							if (secondRowText.equals(blotTitle_Topic)) {
								super.clickAndHold_Actions(
										dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + m + "]/a/div/span[2]",
										waitTime);
								this.verifyToolTipData_MarketingCalendarPage(testName, blotTitle_Topic, blogStatus,
										doctorFirstName, blogType);
								break outerloop;
							}

						}
					}

					for (int k = 1; k <= 15; k++) {
						System.out.println("K loop is : " + k);
						String more_loc = super.getTextOptional(
								dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + k + "]/div/a", 0);
						System.out.println("More info text is : " + more_loc);
						if (more_loc.isEmpty()) {
							System.out.println("Not Found +More link");
						} else {
							String f = more_loc.substring(0, 1);
							if (f.equals("+")) {
								super.click(dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + k + "]/div/a",
										waitTime);
								super.sleep(1000);
								int listCount_More = super.listCount(plusMoreStartXpath_loc);
								for (int l = 1; l <= listCount_More; l++) {
									String title = super.getText(xpath+plusMoreStartXpath_loc+ "["+ l + "]/div/span[2]", waitTime);
									if (title.equals(blotTitle_Topic)) {
										super.clickAndHold_Actions(xpath+plusMoreStartXpath_loc+ "["+ l + "]/div/span[2]", waitTime);

										this.verifyToolTipData_MarketingCalendarPage(testName, blotTitle_Topic,
												blogStatus, doctorFirstName, blogType);
										super.assertContains_Text(testName, "date verification", dateValue,
												super.getText(xpath
														+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/ng-fullcalendar/div[2]/div/div/div[1]/span[2]",
														waitTime));
										break outerloop;
									}

									if (l == listCount_More) {
										super.click(plusMorePopuCloseIcon_loc,waitTime);
									}
								}
							}

						}
					}
				}

			}

		}
	}
}