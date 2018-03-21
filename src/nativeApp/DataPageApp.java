package nativeApp;

import webApp.MarketingCalendarPageWeb;

public class DataPageApp extends MarketingCalendarPageWeb { // Next Extends : LoginPageApp
	
	
	
	// ========================= Publish Page  =================
	
	protected String tagName_Editor_AddNewBlog_PublishPage= super.randomString(5);
	protected String blogTitle_Editor_AddNewBlog_PublishPage= "Autoblogapp Title A"
			+ super.randomString(15);
	protected String description_Editor_AddNewBlog_PublishPage= "Auto Descriptionapp A"
			+ super.randomString(30);

	// ========================= Marketing Calendar Page  =================

	protected String newTopic_MarketingCalendarPageApp="Autoblog Title A"+super.randomString(5);
	

	
	// ========================= Web-site Ask Question Page =================
		// GC-General Category, S1 and S2 are categories. SO - S One and ST - S Two
		// categories --- _AskQuestionWebPage_QPA - Ask question web site - Queries page
		// NativeApp
		protected String subject_AskQuestionWebsiteGC_QPA = "SubjectAskQuestionGC S" + super.randomString(5);
		protected String message_AskQuestionWebsiteGC_QPA = "MessageAskQuestionGC M" + super.randomString(5);
		protected String name_AskQuestionWebsiteGC_QPA = "AskQuestionNameGC A" + super.randomString(5);
		protected String email_AskQuestionWebsiteGC_QPA = "AskQuestionEmailGC_" + super.randomString(3) + "@"
				+ super.randomString(3) + "." + super.randomString(3);
		protected String age_AskQuestionWebsiteGC_QPA = super.randomNumString(2);
		protected String mobileNumber_AskQuestionWebsiteGC_QPA = "5" + super.randomNumString(9);

		protected String subject_AskQuestionWebsiteS1_QPA = "SubjectAskQuestionSO S" + super.randomString(5);
		protected String message_AskQuestionWebsiteS1_QPA = "MessageAskQuestionSO M" + super.randomString(5);
		protected String name_AskQuestionWebsiteS1_QPA = "AskQuestionNameSO A" + super.randomString(5);
		protected String email_AskQuestionWebsiteS1_QPA = "AskQuestionEmailSO_" + super.randomString(3) + "@"
				+ super.randomString(3) + "." + super.randomString(3);
		protected String age_AskQuestionWebsiteS1_QPA = super.randomNumString(2);
		protected String mobileNumber_AskQuestionWebsiteS1_QPA = "5" + super.randomNumString(9);

		protected String subject_AskQuestionWebsiteS2_QPA = "SubjectAskQuestionST S" + super.randomString(5);
		protected String message_AskQuestionWebsiteS2_QPA = "MessageAskQuestionST M" + super.randomString(5);
		protected String name_AskQuestionWebsiteS2_QPA = "AskQuestionNameST A" + super.randomString(5);
		protected String email_AskQuestionWebsiteS2_QPA = "AskQuestionEmailST_" + super.randomString(3) + "@"
				+ super.randomString(3) + "." + super.randomString(3);
		protected String age_AskQuestionWebsiteS2_QPA = super.randomNumString(2);
		protected String mobileNumber_AskQuestionWebsiteS2_QPA = "5" + super.randomNumString(9);

		protected String name_AskQueryWebSite_QPA = "AskQueryName A" + super.randomString(5);
		protected String email_AskQueryWebSite_QPA = "AskQueryEmail_" + super.randomString(3) + "@" + super.randomString(3)
				+ "." + super.randomString(3);
		protected String mobileNumber_AskQueryWebSite_QPA = "5" + super.randomNumString(9);

		protected String queryText_AskQueryWebSite_QPA = "AskQueryText A" + super.randomString(9);
	
}
