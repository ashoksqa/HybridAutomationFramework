package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class LeadsPage extends QueriesPage {// Next Extends : DesignPostersPage

	private String leadsListStartXpath_LeadsPage = xpath
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
	private String leadsListEndXpath_LeadsPage = "]/android.widget.RelativeLayout/android.widget.TextView";

	public void verifyData_LeadsPage(AppiumDriver<?> driver,String testName, String firstName,String lastName, String gender_Male_Female, String age,
			String phoneNumber, String emailId, String city, String area, String source, String tagName, String remarks) throws IOException {
		String leadName = "";
		outerloop: for (int pager = 2; pager <= 50; pager++) {
			for (int i = 1; i <= 11; i++) {
				leadName = this.getText(driver,leadsListStartXpath_LeadsPage + i + leadsListEndXpath_LeadsPage,locator_iOS, waitTime);
				System.out.println("Lead Name is :"+leadName);
				if (leadName.equals(firstName+" "+lastName)) {
					
					super.click(driver,leadsListStartXpath_LeadsPage + i + "]",locator_iOS, waitTime);					
					
					super.assertContains_Text(driver,testName ,"firstName", super.getText(driver,id + "lead_name",locator_iOS, waitTime),
							firstName);
					super.assertEquals_Text(driver,testName ,"phoneNumber", super.getText(driver,id + "leads_input_phone",locator_iOS, waitTime),phoneNumber);
					super.assertEquals_Text(driver,testName ,"EmailId", super.getText(driver,id + "leads_input_email",locator_iOS, waitTime),
							emailId);
					super.assertEquals_Text(driver,testName ,"DOB", super.getText(driver,id+ "leads_input_dob",locator_iOS, waitTime), age);
					super.assertEquals_Text(driver,testName ,"Gender",
							super.getText(driver,id + "leads_input_gender",locator_iOS, waitTime).substring(0, 1), gender_Male_Female);
					super.assertEquals_Text(driver,testName ,"City", super.getText(driver,id + "leads_input_city",locator_iOS, waitTime),
							city);
					super.assertEquals_Text(driver,testName ,"Area", super.getText(driver,id + "leads_input_Area",locator_iOS, waitTime),
							area);
					super.scrollDown_Mobile(driver,5);
					super.assertEquals_Text(driver,testName ,"Source", super.getText(driver,id+ "leads_input_source",locator_iOS, waitTime), source);
					super.assertEquals_Text(driver,testName ,"TagName", super.getText(driver,id + "leads_input_groups",locator_iOS, waitTime),
							tagName);
					super.assertEquals_Text(driver,testName ,"Remarks", super.getText(driver,id + "leads_input_remarks",locator_iOS, waitTime),
							remarks);
					break outerloop;
				}
				if(i==11) {
					super.scrollDown_Mobile(driver,3);
					i=1;
				}
				}

		}
	}
}
