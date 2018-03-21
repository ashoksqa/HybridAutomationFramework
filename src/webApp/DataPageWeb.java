package webApp;

import frameworkLibrary.DriverActions;

public class DataPageWeb extends DriverActions { // Next Extends : LoginPageWeb

	// ========================= Home Page : Add Lead
	
	protected String firstName_ALHW = "AfnALHW_" + super.randomString(3);
	protected String lastName_ALHW = "LnALHW_" + super.randomString(3);
	protected String emailId_ALHW = "EmailALHW_" + super.randomString(4) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String phoneNumber_ALHW = "5" + super.randomNumString(9);
	protected String city_ALHW = "cityALHW_" + super.randomString(5);
	protected String area_ALHW = "AareaALHW_" + super.randomString(5);
	protected String remarks_ALHW = "RemarksALHW_" + super.randomString(5);
	protected String tagName_ALHW = "TagALHW_" + super.randomString(5);

	// ========================= Home Page : Add Visit

	protected String firstName_AVHW = "AfnAVHW_" + super.randomString(3);
	protected String lastName_AVHW = "LnAVHW_" + super.randomString(3);
	protected String emailId_AVHW = "EmailAVHW_" + super.randomString(3) + "@" + super.randomString(3)+"."
			+ super.randomString(3);
	protected String amount_AVHW = super.randomNumString(3);
	protected String phoneNumber_AVHW = "4" + super.randomNumString(9);
	protected String city_AVHW = "CityAVHW_" + super.randomString(6);
	protected String area_AVHW = "AreaAVHW_" + super.randomString(6);
	protected String remarks_AVHW = "RemarksAVHW_" + super.randomString(4);
	protected String tagName_AVHW = "TagAVHW_" + super.randomString(4);

	// ========================= Leads Page : Add Lead

	protected String firstName_ALLW = "AfnALLW_" + super.randomString(5);
	protected String lastName_ALLW = "LnALLW_" + super.randomString(5);
	protected String emailId_ALLW = "EmailALLW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);
	protected String phoneNumber_ALLW = "5" + super.randomNumString(9);
	protected String city_ALLW = "CityALLW_" + super.randomString(5);
	protected String area_ALLW = "AreaALLW_" + super.randomString(5);
	protected String remarks_ALLW = "RemarksALLW_" + super.randomString(5);
	protected String tagName_ALLW = "TagALLW_" + super.randomString(5);

	// ========================= Visits Page

	protected String firstName_AVVW = "AfnAVVW_" + super.randomString(3);
	protected String lastName_AVVW = "LnAVVW_" + super.randomString(3);
	protected String emailId_AVVW = "EmailAVVW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);
	protected String amount_AVVW = super.randomNumString(3);
	protected String phoneNumber_AVVW = "4" + super.randomNumString(9);
	protected String city_AVVW = "CityAVVW_" + super.randomString(6);
	protected String area_AVVW = "AreaAVVW_" + super.randomString(6);
	protected String remarks_AVVW = "RemarksAVVW_" + super.randomString(4);
	protected String tagName_AVVW = "TagAVVW_" + super.randomString(4);

	// ========================= Publish Page =================
	// ANBP - Add new blog in Publish Page webApp
	protected String tagName_Editor_ANBPW = super.randomString(5);
	protected String blogTitle_Editor_ANBPW = "Autoblog Title A" + super.randomString(15);
	protected String description_Editor_ANBPW = "Auto Description A" + super.randomString(30);

	// Below details common for WebApp and NativeApp

	protected String blogTitle_AddNewBlog = "Empty";
	protected String tagName_AddNewBlog = "Empty";
	protected String description_AddNewBlog = "Empty";

	// ========================= Marketing Calendar Page =================

	protected String newTopic_MarketingCalendarPage = "Autoblog Title A" + super.randomString(5);

	
	// ========================= Users Page =================
	
	protected String firstName_Doctor_AUW = "AfnADUW_" + super.randomString(3);
	protected String firstName_FrontDesk_AUW = "AfnAFUW_" + super.randomString(3);
	protected String firstName_JuniorDoctor_AUW = "AfnAJUW_" + super.randomString(3);
	protected String firstName_BusinessHead_AUW = "AfnABUW_" + super.randomString(3);
	
	protected String lastName_AUW = "LnAUW_" + super.randomString(3);
	
	protected String emailId_Doctor_AUW = "EmailADUW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);
	protected String emailId_FrontDesk_AUW = "EmailAFUW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);
	protected String emailId_JuniorDoctor_AUW = "EmailAJUW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);
	protected String emailId_BusinessHead_AUW = "EmailABUW_" + super.randomString(3) + "@" +super.randomString(3) + "."
			+ super.randomString(3);

	protected String userName_Doctor_AUW = super.randomString(3) + "Dr" ;
	protected String userName_FrontDesk_AUW =  super.randomString(3)+"Fd";
	protected String userName_JuniorDoctor_AUW =  super.randomString(3)+"Jd";
	protected String userName_BusinessHead_AUW = super.randomString(3)+"Bh";
	
	protected String password_AUW = super.randomString(6);
	
	protected String subject_AskQuestionWebsite_AUW = "SubjectAskQuestionGC S" + super.randomString(5);
	protected String message_AskQuestionWebsite_AUW = "MessageAskQuestionGC M" + super.randomString(5);
	protected String name_AskQuestionWebsite_AUW = "AskQuestionNameGC A" + super.randomString(5);
	protected String email_AskQuestionWebsite_AUW = "AskQuestionEmailGC_" + super.randomString(3) + "@"
			+ super.randomString(3) + "." + super.randomString(3);
	protected String age_AskQuestionWebsite_AUW = super.randomNumString(2);
	protected String mobileNumber_AskQuestionWebsite_AUW = "5" + super.randomNumString(9);

	protected String name_AskQueryWebSite_AUW = "AskQueryName A" + super.randomString(5);
	protected String email_AskQueryWebSite_AUW= "AskQueryEmail_" + super.randomString(3) + "@" + super.randomString(3)
			+ "." + super.randomString(3);
	protected String mobileNumber_AskQueryWebSite_AUW = "5" + super.randomNumString(9);

	protected String queryText_AskQueryWebSite_AUW= "AskQueryText A" + super.randomString(9);

}
