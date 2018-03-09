package webApp;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class MarketingCalendarPageWeb extends SearchPageWeb { // End

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
	
	public void createTopic_MarketingCalenderPage(WebDriver driver,String testName, String topicName, int topicDropDownValue)
			throws IOException {
		super.click_CalendarIcon_HomePage(driver);
		super.sleep(5000);
		super.click(driver,addNewTopicBtn_MarketingCalenderPage_loc, waitTime);
		super.sleep(3000);
		String topic = super.getTextOptional(driver,firstTopicText_PlanYourCalendar_MarketingCalenderPage_loc, 3);
		if (topic.isEmpty()) {
			super.click(driver,addNewTopicBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
			super.setText(driver,writeTopicTxt_PlanYourCalendar_MarketingCalenderPage_loc, topicName, waitTime);
			super.selectDropDownValue(driver,specialityDropDown_PlanYourCalendar_MarketingCalenderPage_loc,
					topicDropDownValue);
			super.click(driver,addBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
			topic = super.getTextOptional(driver,firstTopicText_PlanYourCalendar_MarketingCalenderPage_loc, 10);
			super.assertEquals_Text(driver,testName, "createtedNewTopicVerification", topic, topicName);
		}

	}

	public void addTopicToCalendar_MarketingCalenderPage(WebDriver driver,String testName, String topicName, int topicDropDownValue,
			String dateValue) throws IOException {
		this.createTopic_MarketingCalenderPage(driver,testName, topicName, topicDropDownValue);
		super.click(driver,firstTopicRadioBtn_PlanYourCalendar_MarketingCalenderPage_loc, 3);
		super.selectDateFromCalender(driver,firstTopicDateField_PlanYourCalendar_MarketingCalenderPage_loc,
				firstTopicDateStartXpath_PlanYourCalendar_MarketingCalenderPage_loc, dateValue, "owl-calendar-invalid");
		super.click(driver,addToCalendarBtn_PlanYourCalendar_MarketingCalenderPage_loc, waitTime);
		super.sleep(7000);
	}

	public void verifyToolTipData_MarketingCalendarPage(WebDriver driver,String testName, String expectedBlogTitle_Topic,
			String expectedBlogStatus, String doctorFirstName, String blogType) throws IOException {
		super.assertEquals_Text(driver,testName, "titleInTooltip_MarketingCalender",
				super.getText(driver,
						xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[1]",
						waitTime),
				expectedBlogTitle_Topic);
		super.assertEquals_Text(driver,testName, "",
				super.getText(driver,xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[1]/a",
						waitTime),
				expectedBlogStatus);
		super.assertEquals_Text(driver,testName, "",
				super.getText(driver,
						xpath + "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[2]/p[2]",
						waitTime),
				"By " + doctorFirstName + " | " + blogType);
		super.assertEquals_Text(driver,testName, "ADD INPUTS Button",
				super.getText(driver,xpath
						+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[1]",
						waitTime),
				"ADD INPUTS");
		super.assertEquals_Text(driver,testName, "IONIZE Button",
				super.getText(driver,xpath
						+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/div/div[3]/div/button[2]",
						waitTime),
				"IONIZE");

	}

	public void verifyData_MarketingCalendarPage(WebDriver driver,String testName, String dateValue, String blotTitle_Topic,
			String blogStatus, String blogType, String doctorFirstName) throws IOException {
		super.click_CalendarIcon_HomePage(driver);
		super.scrollDown_Web(driver,1, 150);
		outerloop: for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				String dateV = dateStartXpath_loc + i + "]/div[2]/table/thead/tr/td[" + j + "]";
				String currentDate = super.getAttributeValue_String(driver,dateV, "innerText", waitTime);
				String currentDate_cls = super.getAttributeValue_String(driver,dateV, "className", waitTime);
				System.out.println("date and cls name are : " + currentDate + "/" + currentDate_cls);
				if (currentDate.equals(dateValue) && currentDate_cls.contains("fc-past")) {
					System.out.println(dateValue + " is past date");
				} else if (currentDate.equals(dateValue)) {
					String firstRowText = super.getTextOptional(driver,
							dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[1]/td[" + j + "]/a/div/span[2]", waitTime);
					System.out.println("firstRowText : " + firstRowText);
					if (firstRowText.equals(blotTitle_Topic)) {
						super.clickAndHold_Actions(driver,
								dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[1]/td[" + j + "]/a/div/span[2]",
								waitTime);
						this.verifyToolTipData_MarketingCalendarPage(driver,testName, blotTitle_Topic, blogStatus,
								doctorFirstName, blogType);
						break outerloop;
					} else {
						for (int m = 1; m < 14; m++) {
							String secondRowText = super.getTextOptional(driver,
									dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + m + "]/a/div/span[2]", 1);
							System.out.println(
									"secondRowText : " + secondRowText + " date is : " + dateFormat.format(new Date()));

							if (secondRowText.equals(blotTitle_Topic)) {
								super.clickAndHold_Actions(driver,
										dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + m + "]/a/div/span[2]",
										waitTime);
								this.verifyToolTipData_MarketingCalendarPage(driver,testName, blotTitle_Topic, blogStatus,
										doctorFirstName, blogType);
								break outerloop;
							}

						}
					}

					for (int k = 1; k <= 15; k++) {
						System.out.println("K loop is : " + k);
						String more_loc = super.getTextOptional(driver,
								dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + k + "]/div/a", 0);
						System.out.println("More info text is : " + more_loc);
						if (more_loc.isEmpty()) {
							System.out.println("Not Found +More link");
						} else {
							String f = more_loc.substring(0, 1);
							if (f.equals("+")) {
								super.click(driver,dateStartXpath_loc + i + "]/div[2]/table/tbody/tr[2]/td[" + k + "]/div/a",
										waitTime);
								super.sleep(1000);
								int listCount_More = super.listCount(driver,plusMoreStartXpath_loc);
								for (int l = 1; l <= listCount_More; l++) {
									String title = super.getText(driver,xpath+plusMoreStartXpath_loc+ "["+ l + "]/div/span[2]", waitTime);
									if (title.equals(blotTitle_Topic)) {
										super.clickAndHold_Actions(driver,xpath+plusMoreStartXpath_loc+ "["+ l + "]/div/span[2]", waitTime);

										this.verifyToolTipData_MarketingCalendarPage(driver,testName, blotTitle_Topic,
												blogStatus, doctorFirstName, blogType);
										super.assertContains_Text(driver,testName, "date verification", dateValue,
												super.getText(driver,xpath
														+ "/html/body/app-root/app-publish/div/div/div/div/div/div/div[2]/div/ng-fullcalendar/div[2]/div/div/div[1]/span[2]",
														waitTime));
										break outerloop;
									}

									if (l == listCount_More) {
										super.click(driver,plusMorePopuCloseIcon_loc,waitTime);
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