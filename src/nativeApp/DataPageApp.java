package nativeApp;

import webApp.MarketingCalendarPageWeb;

public class DataPageApp extends MarketingCalendarPageWeb { // Next Extends : LoginPageApp
	
	
	// ========================= Leads Page

	protected String firstName_addLead_LeadsPage = "FnALLW_" + super.randomString(5);
	protected String lastName_addLead_LeadsPage = "LnALLW_" + super.randomString(5);
	protected String emailId_addLead_LeadsPage = "EmailALLW_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String phoneNumber_addLead_LeadsPage = "5" + super.randomNumString(9);
	protected String city_addLead_LeadsPage = "CityALLW_" + super.randomString(5);
	protected String area_addLead_LeadsPage = "AreaALLW_" + super.randomString(5);
	protected String remarks_addLead_LeadsPage = "RemarksALLW_" + super.randomString(5);
	protected String tagName_addLead_LeadsPage = "TagALLW_" + super.randomString(5);

	// ========================= Visits Page

	protected String firstName_addVisit_VisitsPage = "FnAVVW_" + super.randomString(3);
	protected String lastName_addVisit_VisitsPage = "LnAVVW_" + super.randomString(3);
	protected String emailId_addVisit_VisitsPage = "EmailAVVW_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String amount_addVisit_VisitsPage = super.randomNumString(3);
	protected String phoneNumber_addVisit_VisitsPage = "4" + super.randomNumString(9);
	protected String city_addVisit_VisitsPage = "CityAVVW_" + super.randomString(6);
	protected String area_addVisit_VisitsPage = "AreaAVVW_" + super.randomString(6);
	protected String remarks_addVisit_VisitsPage = "RemarksAVVW_" + super.randomString(4);
	protected String tagName_addVisit_VisitsPage = "TagAVVW_" + super.randomString(4);

	// ========================= Publish Page  =================
	
	protected String tagName_Editor_AddNewBlog_PublishPage= super.randomString(5);
	protected String blogTitle_Editor_AddNewBlog_PublishPage= "Autoblogweb Title A"
			+ super.randomString(15);
	protected String description_Editor_AddNewBlog_PublishPage= "Auto Descriptionweb A"
			+ super.randomString(30);

	protected String blogTitle_AddNewBlog="Empty";
	protected String tagName_AddNewBlog="Empty";
	protected String description_AddNewBlog="Empty";
	
	// ========================= Marketing Calendar Page  =================

	protected String newTopic_MarketingCalendarPage="Autoblog Title A"+super.randomString(5);
	

	
	// ========================= Web-site Ask Question Page =================
	protected String subject_AskQuestionGC_WebPage_QueriesPage = "AutoAskQuestion Subject S" + super.randomString(5);
	protected String message_AskQuestionGC_WebPage_QueriesPage = "AutoAskQuestion Message M" + super.randomString(5);
	protected String name_AskQuestionGC_WebPage_QueriesPage = "AutoName A" + super.randomString(5);
	protected String email_AskQuestionGC_WebPage_QueriesPage = "AutoAskQuestion_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String age_AskQuestionGC_WebPage_QueriesPage = super.randomNumString(2);
	protected String mobileNumber_AskQuestionGC_WebPage_QueriesPage = "55" + super.randomNumString(7);
	
	protected String subject_AskQuestionS1_WebPage_QueriesPage = "AutoAskQuestion Subject S" + super.randomString(5);
	protected String message_AskQuestionS1_WebPage_QueriesPage = "AutoAskQuestion Message M" + super.randomString(5);
	protected String name_AskQuestionS1_WebPage_QueriesPage = "AutoName A" + super.randomString(5);
	protected String email_AskQuestionS1_WebPage_QueriesPage = "AutoAskQuestion_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String age_AskQuestionS1_WebPage_QueriesPage = super.randomNumString(2);
	protected String mobileNumber_AskQuestionS1_WebPage_QueriesPage = "55" + super.randomNumString(7);
	
	protected String subject_AskQuestionS2_WebPage_QueriesPage = "AutoAskQuestion Subject S" + super.randomString(5);
	protected String message_AskQuestionS2_WebPage_QueriesPage = "AutoAskQuestion Message M" + super.randomString(5);
	protected String name_AskQuestionS2_WebPage_QueriesPage = "AutoName A" + super.randomString(5);
	protected String email_AskQuestionS2_WebPage_QueriesPage = "AutoAskQuestion_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String age_AskQuestionS2_WebPage_QueriesPage = super.randomNumString(2);
	protected String mobileNumber_AskQuestionS2_WebPage_QueriesPage = "55" + super.randomNumString(7);
	
	
	protected String name_AskQuery_WebPage_QueriesPage = "AutoName A" + super.randomString(5);
	protected String email_AskQuery_WebPage_QueriesPage = "AutoAskQuestion_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String mobileNumber_AskQuery_WebPage_QueriesPage = "55" + super.randomNumString(8);
	
	protected String queryText_AskQuery_WebPage_QueriesPage = "AutoQuery A" +super.randomString(9);

	
	
}
