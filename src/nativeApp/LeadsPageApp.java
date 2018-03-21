package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class LeadsPageApp extends QueriesPageApp {// Next Extends : DesignPostersPageApp

	// ========================= Leads Page

		protected String firstName_ALHA = "AfnALHA_" + super.randomString(3);
		protected String lastName_ALHA = "LnALHA_" + super.randomString(3);
		protected String emailId_ALHA = "EmailALHA_" + super.randomString(4) + "@" + super.randomString(3)
				+ super.randomString(3);
		protected String phoneNumber_ALHA = "5" + super.randomNumString(9);
		protected String city_ALHA = "cityALHA_" + super.randomString(5);
		protected String area_ALHA = "AareaALHA_" + super.randomString(5);
		protected String remarks_ALHA = "RemarksALHA_" + super.randomString(5);
		protected String tagName_ALHA = "TagALHA_" + super.randomString(5);
	
	
	private String leadsListStartXpath_LeadsPage = xpath
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
	private String leadsListEndXpath_LeadsPage = "]/android.widget.RelativeLayout/android.widget.TextView";

	
	public String addLead_LeadsPageApp(AppiumDriver<?> driver, String firstName_addLead, String lastName_addLead,
			String emailId_addLead, String phoneNumber_addLead, String city_addLead, String area_addLead,
			String remarks_addLead, String tagName_addLead, String gender_M_F) throws IOException {

		this.click_AddLeadFromFooter_HomePageApp(driver);

		super.setText(driver, id + "lead_firstname", locator_iOS, firstName_addLead, waitTime);
		super.keypadNext(driver);
		super.setText(driver, id + "lead_lastname", locator_iOS, lastName_addLead, waitTime);
		super.keypadClose(driver);

		if (gender_M_F.equals("M") || gender_M_F.equals("Male")) {
			super.click(driver, id + "leadMale", locator_iOS, waitTime);
		} else if (gender_M_F.equals("F") || gender_M_F.equals("Female")) {
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
	
	
	public void verifyData_LeadsPageApp(AppiumDriver<?> driver, String testName, String firstName, String lastName,
			String gender_Male_Female, String age, String phoneNumber, String emailId, String city, String area,
			String source, String tagName, String remarks) throws IOException {
		String leadName = "";
		outerloop: 
			for (int i = 1; i <= 7; i++) {
				leadName = this.getText(driver, leadsListStartXpath_LeadsPage + i + leadsListEndXpath_LeadsPage,
						locator_iOS, waitTime);
				System.out.println("Lead Name is :" + leadName);
				if (leadName.equals(firstName + " " + lastName)) {

					super.click(driver, leadsListStartXpath_LeadsPage + i + "]", locator_iOS, waitTime);

					super.assertContains_Text(driver, testName, "firstName",
							super.getText(driver, id + "lead_name", locator_iOS, waitTime), firstName);
					super.assertEquals_Text(driver, testName, "phoneNumber",
							super.getText(driver, id + "leads_input_phone", locator_iOS, waitTime), phoneNumber);
					super.assertEquals_Text(driver, testName, "EmailId",
							super.getText(driver, id + "leads_input_email", locator_iOS, waitTime), emailId);
					super.assertEquals_Text(driver, testName, "DOB",
							super.getText(driver, id + "leads_input_dob", locator_iOS, waitTime), age);
					super.assertEquals_Text(driver, testName, "Gender",
							super.getText(driver, id + "leads_input_gender", locator_iOS, waitTime),
							gender_Male_Female);
					super.assertEquals_Text(driver, testName, "City",
							super.getText(driver, id + "leads_input_city", locator_iOS, waitTime), city);
					super.assertEquals_Text(driver, testName, "Area",
							super.getText(driver, id + "leads_input_Area", locator_iOS, waitTime), area);
					super.scrollDown_Mobile(driver, 5);
					super.assertEquals_Text(driver, testName, "Source",
							super.getText(driver, id + "leads_input_source", locator_iOS, waitTime), source);
					super.sleep(2000);
					super.assertEquals_Text(driver, testName, "TagName",
							super.getText(driver, id + "leads_input_groups", locator_iOS, waitTime), tagName);
					super.assertEquals_Text(driver, testName, "Remarks",
							super.getText(driver, id + "leads_input_remarks", locator_iOS, waitTime), remarks);
					break outerloop;
				}
				if (i == 7) {
					super.scrollDown_Mobile(driver, 2);
					i = 1;
				}
			}

		}
	
}
