package webApp;

import java.io.IOException;

public class LeadsPage extends QueriesPage {// Next Extends : DesignPostersPage

	private String addLeadBtn_loc = xpath + "/html/body/app-root/app-leads/div/div/div/div/div/div[1]/div[2]/button";

	private String firstName_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[1]";
	private String lastName_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[1]";
	private String email_locr = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[2]";
	private String phoneNumber_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[2]";
	private String DOB_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[3]/div/owl-date-time/div/div[1]";
	private String DOBCalendarStartXpath_loc = "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[3]/div/owl-date-time/div/div[3]/div/div[2]/table/tbody/tr[";

	private String city_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[1]/li[4]";
	private String area_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[1]/ul[2]/li[4]";
	private String remarks_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[2]/ul/li[1]";
	private String tag_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[2]/ul/li[2]/tag-input/div/div/tag-input-form/form/input";

	private String submitBtn_loc = xpath
			+ "/html/body/app-root/app-leads/div[1]/div[2]/div/div[2]/div/form/div[3]/button[1]";

	private String OkBtn_loc = xpath + "/html/body/app-root/app-leads/div[1]/div[2]/div/div/div";
	private String successMsg_loc = xpath + "/html/body/app-root/app-leads/div[1]/div[2]/div/p";

	private String leadsStartXpath_LeadsPage = xpath
			+ "/html/body/app-root/app-leads/div/div/div/div/div/div[2]/table/tbody/tr[";
	private String pagerStartXpath_LeadsPage = xpath + "/html/body/app-root/app-leads/div/div/div/div/div/div[2]/div/div/a[";

	public void click_AddLead_LeadsPage() {
		super.click(addLeadBtn_loc, waitTime);
	}

	public void addLead_LeadsPage(String firstName_addLead_LeadsPage, String lastName_addLead_LeadsPage,
			String emailId_addLead_LeadsPage, String phoneNumber_addLead_LeadsPage, String city_addLead_LeadsPage,
			String area_addLead_LeadsPage, String remarks_addLead_LeadsPage, String tagName_addLead_LeadsPage) {

		super.setText_ByActions(firstName_loc, firstName_addLead_LeadsPage, waitTime);
		super.setText_ByActions(lastName_loc, lastName_addLead_LeadsPage, waitTime);
		super.setText_ByActions(email_locr, emailId_addLead_LeadsPage, waitTime);
		super.setText_ByActions(phoneNumber_loc, phoneNumber_addLead_LeadsPage, waitTime);
		super.selectDateFromCalender(DOB_loc, DOBCalendarStartXpath_loc,
				super.getTodayDate(), "owl-calendar-outFocus");
		super.setText_ByActions(city_loc, city_addLead_LeadsPage, waitTime);
		super.setText_ByActions(area_loc, area_addLead_LeadsPage, waitTime);
		super.setText_ByActions(remarks_loc, remarks_addLead_LeadsPage, waitTime);
		super.setText_ByActions(tag_loc, tagName_addLead_LeadsPage, waitTime);
		super.kepad_Enter(tag_loc, waitTime);
		super.click(submitBtn_loc, waitTime);
	}

	public void okBtn_Popup_LeadsPage() {
		super.click(OkBtn_loc, waitTime);
		super.sleep(3000);
	}

	public String getSuccessMsg_Popup_LeadsPage() {
		String successMsg = super.getTextOptional(successMsg_loc, waitTime);
		return successMsg;
	}

	public int verifyData_LeadsPage(String methodName, String firstName, String gender_Male_Female, String age,
			String phoneNumber, String emailId, String source, String tagName) throws IOException {
		int row = 0;
		String mailID = "";
		String p = "Empty";
		outerloop: for (int pager = 2; pager <= 50; pager++) {
			for (int i = 3; i <= 25; i++) {
				mailID = this.getTextOptional(leadsStartXpath_LeadsPage + i + "]/td[7]", waitTime);
				if (mailID.equals(emailId)) {
					String locator = leadsStartXpath_LeadsPage + i + "]/td[";
					super.assertEquals_Text(methodName ,"firstName", super.getText(locator + 3 + "]", waitTime),
							firstName);
					super.assertEquals_Text(methodName ,"gender_Male_Female",
							super.getText(locator + 4 + "]", waitTime), gender_Male_Female);
					super.assertEquals_Text(methodName ,"age", super.getText(locator + 5 + "]", waitTime), age);
					super.assertEquals_Text(methodName ,"phoneNumber", super.getText(locator + 6 + "]", waitTime),
							phoneNumber);
					super.assertEquals_Text(methodName ,"emailId", super.getText(locator + 7 + "]", waitTime),
							emailId);
					super.assertEquals_Text(methodName ,"source", super.getText(locator + 8 + "]", waitTime), source);
					super.assertEquals_Text(methodName ,"tagName", super.getText(locator + 9 + "]", waitTime),
							tagName);
					break outerloop;
				}
				if(i%8==0) {
					super.scrollDown(1, 150);
				}
			}
			p = this.getTextOptional(pagerStartXpath_LeadsPage + pager + "]", waitTime);
			if (p.equals("Next") || p.equals("") || p.isEmpty()) {
				break;
			} else if (super.convertStrToInt(p) == pager) {
				this.click(pagerStartXpath_LeadsPage + pager + "]", waitTime);
			} else {
				break;
			}
		}
		return row;
	}

}
