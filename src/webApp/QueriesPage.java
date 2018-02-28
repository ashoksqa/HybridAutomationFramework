package webApp;

import java.io.IOException;

public class QueriesPage extends VisitsPage { // Next Extends : LeadsPage
	// ================== WebApp
	// Page===========================================================//
	private String queryStartXpath_loc = xpath + "/html/body/app-root/app-queries/div/div/div/div/div[1]/div[2]/ul/li[";

	private String HeaderStartXpath_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[1]/div[1]/div[";
	private String subjectHeader_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[4]";
	private String customerName_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[5]/ul/div/li/div[1]";
	private String customerMessage_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[5]/ul/div/li/span";
	private String profileIcon_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[1]/div[2]/span[2]/img";
	// private String
	// subjectHeader_ChatScreen_loc=xpath+"/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[4]";
	private String replyBtn_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[5]/div/button";

	private String userProfileStartXpath_ChatScreen_loc = xpath
			+ "/html/body/app-root/app-queries/div/div/div/div/div[2]/div/div[1]/div[3]/div/div[2]/table/tbody/tr[";

	// ================== Web
	// Page===========================================================//
	private String patientInfo_WebPage_loc = xpath + "/html/body/div[2]/header/div/div[3]/div/nav[1]/ul/li[5]";

	private String askQuestion_WebPage_loc = patientInfo_WebPage_loc + "/ul/li[6]";
	private String selectCategory_WebPage_loc = xpath
			+ "/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/form/p[1]";
	private String subject_WebPage_loc = id + "subject";
	private String message_WebPage_loc = id + "message";
	private String name_WebPage_loc = id + "name";
	private String email_WebPage_loc = id + "email";
	private String age_WebPage_loc = id + "age";
	private String mobile_WebPage_loc = id + "mobile";
	private String gender_WebPage_loc = xpath
			+ "/html/body/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/form/p[4]";
	private String submitBtn_WebPage_loc = id + "btnShow";

	private String successPopupMsg_askQuestion_WebPAge_loc = id + "dialog";
	private String successPopupTitle_askQuestion_WebPAge_loc = id + "ui-id-1";
	private String successPopupClose_askQuestion_WebPAge_loc = cls + "ui-dialog-titlebar-close";

	private String askQueryBtn_WebPage_loc = xpath + "/html/body/div[6]/div[3]/img";
	private String queryTxt_WebPage_loc = id + "query";
	private String querySubmitBtn_WebPage_loc = id + "submit-btn";

	public void navigateToAskQuestionPage_WebPage_QueriesPage() {
		super.click(patientInfo_WebPage_loc, waitTime);
		super.click(askQuestion_WebPage_loc, waitTime);
	}

	public void askQuestion_Website_QueriesPage(String testName, int dropDownNumber_Category,
			String subject_AskQuestion_WebPage_QueriesPage, String message_AskQuestion_WebPage_QueriesPage,
			String name_AskQuestion_WebPage_QueriesPage, String email_AskQuestion_WebPage_QueriesPage,
			String age_AskQuestion_WebPage_QueriesPage, String mobileNumber_AskQuestion_WebPage_QueriesPage,
			int dropDownNumber_Gender) throws IOException {

		super.selectDropDownValue(selectCategory_WebPage_loc, dropDownNumber_Category);
		super.setText(subject_WebPage_loc, subject_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(message_WebPage_loc, message_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(name_WebPage_loc, name_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(email_WebPage_loc, email_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(age_WebPage_loc, age_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(mobile_WebPage_loc, mobileNumber_AskQuestion_WebPage_QueriesPage, waitTime);
		super.selectDropDownValue(gender_WebPage_loc, dropDownNumber_Gender);
		super.click(submitBtn_WebPage_loc, waitTime);
		super.assertEquals_Text(testName, "askQuestion SuccessMessage Title",
				super.getText(successPopupTitle_askQuestion_WebPAge_loc, waitTime),
				super.pvd("askQuestionSuccessMessagetitle"));
		super.assertEquals_Text(testName, "askQuestion SuccessMessage Subject",
				super.getText(successPopupMsg_askQuestion_WebPAge_loc, waitTime),
				super.pvd("askQuestionSuccessMessage"));
		super.click(successPopupClose_askQuestion_WebPAge_loc, waitTime);
	}

	public void askQuery_Website_QueriesPage(String testName, String name_AskQuery_WebPage_QueriesPage,
			String email_AskQuery_WebPage_QueriesPage, String mobileNumber_AskQuery_WebPage_QueriesPage,
			String queryText_AskQuery_WebPage_QueriesPage) throws IOException {
super.click(askQueryBtn_WebPage_loc, waitTime);
		super.setText(name_WebPage_loc, name_AskQuery_WebPage_QueriesPage, waitTime);
		super.setText(email_WebPage_loc, email_AskQuery_WebPage_QueriesPage, waitTime);
		super.setText(mobile_WebPage_loc, mobileNumber_AskQuery_WebPage_QueriesPage, waitTime);
		super.setText(queryTxt_WebPage_loc, queryText_AskQuery_WebPage_QueriesPage, waitTime);
		super.click(querySubmitBtn_WebPage_loc, waitTime);
		super.sleep(3000);
	}

	public void verifyData_QueriesPage(String testName, int queryCategory_droopDwnNumber, String expectedTitle,
			String expectedMessage, String customerName, String age, String gender_M_F, String mobileNumber,
			String emailId) throws IOException {
		for (int i = 1; i <= 200; i++) {
			String title = super.getTextOptional(queryStartXpath_loc + i + "]/div/div[3]", waitTime);
			if (title.equals(expectedTitle)) {
				super.click(queryStartXpath_loc + i + "]/div/div[3]", waitTime);
				super.sleep(3000);
				super.scrollUp(1);
				super.assertEquals_Text(testName, "Title",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[3]", waitTime), expectedTitle);
				super.assertEquals_Text(testName, "Message",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[4]", waitTime), expectedMessage);
				super.assertEquals_Text(testName, "Customer Name",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[5]/b", waitTime), customerName);
				super.assertEquals_Text(testName, "Query Category",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[5]/span[2]", waitTime),
						"In " + super.pvd("queryCategory" + queryCategory_droopDwnNumber));
				super.assertEquals_Text(testName, "Quck Reply Button",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[6]/a[1]", waitTime), "Quick Reply");
				super.assertEquals_Text(testName, "Reply Button",
						super.getTextOptional(queryStartXpath_loc + i + "]/div/div[6]/a[2]", waitTime), "Reply");

				super.assertEquals_Text(testName, "Customer Name in Chat Screen Header",
						super.getTextOptional(HeaderStartXpath_ChatScreen_loc + "1]", waitTime), customerName);
				super.assertEquals_Text(testName, "Customer Name in Chat Screen Header",
						super.getTextOptional(HeaderStartXpath_ChatScreen_loc + "2]/span[2]", waitTime), age);
				super.assertEquals_Text(testName, "Customer Name in Chat Screen Header",
						super.getTextOptional(HeaderStartXpath_ChatScreen_loc + "2]/span[3]/span", waitTime),
						gender_M_F);

				super.assertEquals_Text(testName, "subjectHeader_ChatScreen",
						super.getTextOptional(subjectHeader_ChatScreen_loc, waitTime), expectedTitle);
				super.assertEquals_Text(testName, "customerName_ChatScreen",
						super.getTextOptional(customerName_ChatScreen_loc, waitTime), customerName);
				super.assertEquals_Text(testName, "customerMessage_ChatScreen",
						super.getTextOptional(customerMessage_ChatScreen_loc, waitTime), expectedMessage);
				super.assertEquals_Text(testName, "replyBtn_ChatScreen",
						super.getTextOptional(replyBtn_ChatScreen_loc, waitTime), "Reply Query");
				super.click(profileIcon_ChatScreen_loc, waitTime);

				super.assertEquals_Text(testName, "Profile Name",
						super.getTextOptional(userProfileStartXpath_ChatScreen_loc + 1 + "]/td[2]", waitTime),
						customerName);
				super.assertEquals_Text(testName, "Profile Age",
						super.getTextOptional(userProfileStartXpath_ChatScreen_loc + 2 + "]/td[2]", waitTime), age);
				super.assertEquals_Text(testName, "Profile Gender",
						super.getTextOptional(userProfileStartXpath_ChatScreen_loc + 3 + "]/td[2]", waitTime)
								.substring(0, 1),
						gender_M_F);
				super.assertEquals_Text(testName, "Profile Mobile Number",
						super.getTextOptional(userProfileStartXpath_ChatScreen_loc + 4 + "]/td[2]", waitTime),
						mobileNumber);
				super.assertEquals_Text(testName, "Profile Mail ID",
						super.getTextOptional(userProfileStartXpath_ChatScreen_loc + 5 + "]/td[2]", waitTime), emailId);

				break;
			}

		}
	}
}
