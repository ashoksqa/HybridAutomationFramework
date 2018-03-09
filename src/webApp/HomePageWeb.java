package webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class HomePageWeb extends LoginPageWeb { // Next Extends : PublishPageWeb

	// =======================HomePage
	// Locators=================================================================================

	private String notification_NothanksBtn_loc = xpath + "//*[@id=\"onesignal-popover-cancel-button\"]";
	private String notification_AllowBtn_loc = xpath + "//*[@id=\"onesignal-popover-allow-button\"]";
	private String OkBtn_Popup_loc = xpath + "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div/div";
	private String successMsg_Popup_loc = xpath + "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/p";

	private String addNewBtn_loc = cls + "add_new";
	private String calendarIcon_loc = cls + "cal-date";
	private String tabsListXpathStart_loc = xpath
			+ "/html/body/app-root/app-home/div/div/app-dashboard/div/div[2]/ul/li[";

	// -------------Leads_HomePage

	private String firstName_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[1]";
	private String lastName_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[1]";
	private String email_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[2]";
	private String phoneNumber_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[2]";
	private String DOB_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[3]/div/owl-date-time/div/div[1]";
	private String DOBCalendaStartXpath_loc = "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[3]/div/owl-date-time/div/div[3]/div/div[2]/table/tbody/tr[";

	private String city_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[4]";
	private String area_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[4]";
	private String remarks_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[2]/ul/li[1]";
	private String tag_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[2]/ul/li[2]/tag-input/div/div/tag-input-form/form/input";
	private String submitBtn_loc = xpath
			+ "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div/div[2]/div/form/div[3]/button[1]";

	public void click_CalendarIcon_HomePage(WebDriver driver) {
		super.click(driver,calendarIcon_loc, waitTime);
		super.sleep(5000);
	}

	public void click_AddNew_HomePage(WebDriver driver) {
		super.click(driver,addNewBtn_loc, waitTime);
	}

	public void click_SideMenuTabs_HomePage(WebDriver driver,int tabNumber) {
		super.sleep(2000);
		String tab = tabsListXpathStart_loc + tabNumber + "]";
		super.click(driver,tab, waitTime);
		super.sleep(7000);
	}

	public void clickOptions_QuickStartPopup_HomePage(WebDriver driver,int option) {
		String opt = xpath + "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div[2]/div/a[" + option + "]";
		click_AddNew_HomePage(driver);
		super.click(driver,opt, waitTime);
		super.sleep(1000);
	}

	public void click_QuickStartPopup_StartBlogOptions_HomePage(WebDriver driver,int option) {
		String opt = xpath + "/html/body/app-root/app-home/div/div/div/app-header/div[2]/div[2]/div/div[2]/div/button["
				+ option + "]";
		this.clickOptions_QuickStartPopup_HomePage(driver,4);
		super.click(driver,opt, waitTime);
		super.sleep(3000);
	}

	public void click_NoTahnks_Notification(WebDriver driver) {
		try {
			super.click(driver,notification_NothanksBtn_loc, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + notification_NothanksBtn_loc);
		}
		super.sleep(3000);
	}

	public void click_Allow_Notification(WebDriver driver) {
		try {
			super.click(driver,notification_AllowBtn_loc, waitTime);
			super.waitForElement_InVisibility(driver,notification_AllowBtn_loc, waitTime);
		} catch (Exception e) {
			System.out.println("Elemnt Not found : " + notification_AllowBtn_loc);
		}

	}

	public void okBtn_Popup_HomePage(WebDriver driver) {
		super.click(driver,OkBtn_Popup_loc, waitTime);
	}

	public String getSuccessMsg_Popup_HomePage(WebDriver driver) {
		String successMsg = super.getTextOptional(driver,successMsg_Popup_loc, waitTime);
		return successMsg;
	}

	public void logout(WebDriver driver) {
		String logout = xpath + "/html/body/app-root/app-home/div/div/div/app-header/div/div/button";
		super.click(driver,logout, waitTime);
	}

	public void addLead_HomePage(WebDriver driver,String testName,String firstName_addLead_HomePage, String lastName_addLead_HomePage,
			String emailId_addLead_HomePage, String phoneNumber_addLead_HomePage, String city_addLead_HomePage,
			String area_addLead_HomePage, String remarks_addLead_HomePage, String tagName_addLead_HomePage) throws IOException {

		super.setText_ByActions(driver,firstName_loc, firstName_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,lastName_loc, lastName_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,email_loc, emailId_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,phoneNumber_loc, phoneNumber_addLead_HomePage, waitTime);
		super.selectDateFromCalender(driver,DOB_loc, DOBCalendaStartXpath_loc, super.getTodayDate(), "owl-calendar-outFocus");
		super.setText_ByActions(driver,city_loc, city_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,area_loc, area_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,remarks_loc, remarks_addLead_HomePage, waitTime);
		super.setText_ByActions(driver,tag_loc, tagName_addLead_HomePage, waitTime);
		super.kepad_Enter_Web(driver,tag_loc, waitTime);
		super.click(driver,submitBtn_loc, waitTime);
		super.assertEquals_Text(driver,testName, "SuccessMsg_Popup", this.getSuccessMsg_Popup_HomePage(driver),
				"Lead added successfully.");
		this.okBtn_Popup_HomePage(driver);

	}

}
