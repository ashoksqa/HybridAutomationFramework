package webApp;

public class QueriesPage extends VisitsPage { // Next Extends : LeadsPage

	private String patientInfo_WebPage_loc = xpath + "/html/body/div[2]/header/div/div[3]/div/nav[1]/ul/li[5]";

	private String askQuestion_WebPage_loc = patientInfo_WebPage_loc + "/li[6]/a";
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

	public void navigateToAskQuestionPage_WebPAge_QueriesPage() {
		super.click(patientInfo_WebPage_loc, waitTime);
		super.click(askQuestion_WebPage_loc, waitTime);
	}
	
	public void askQuestion_Website_QueriesPage(int dropDownNumber_Category,
			String subject_AskQuestion_WebPage_QueriesPage, String message_AskQuestion_WebPage_QueriesPage,
			String name_AskQuestion_WebPage_QueriesPage, String email_AskQuestion_WebPage_QueriesPage,
			String age_AskQuestion_WebPage_QueriesPage, String mobileNumber_AskQuestion_WebPage_QueriesPage,
			int dropDownNumber_Gender) {

		super.selectDropDownValue(selectCategory_WebPage_loc, dropDownNumber_Category);
		super.setText(subject_WebPage_loc, subject_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(message_WebPage_loc, message_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(name_WebPage_loc, name_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(email_WebPage_loc, email_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(age_WebPage_loc, age_AskQuestion_WebPage_QueriesPage, waitTime);
		super.setText(mobile_WebPage_loc, mobileNumber_AskQuestion_WebPage_QueriesPage, waitTime);
		super.selectDropDownValue(gender_WebPage_loc, dropDownNumber_Gender);
		super.click(submitBtn_WebPage_loc, waitTime);
	}

}
