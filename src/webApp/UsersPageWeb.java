package webApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class UsersPageWeb extends ContactUsPageWeb {// Next Extends : SearchPageWeb

	private String settingsTabsStartXpath_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/app-dashboard/div/div[3]/ul/li[";
	private String userRoleStartXpath_loc = xpath + "/html/body/app-root/app-settings/div[2]/div/div[2]/div[1]/span[";
	private String addUserBtnInLists_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div/div/div/h2";
	private String firstName_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[1]/input";
	private String lastName_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]/input";
	private String userName_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[2]/td[1]/input";
	private String emailId_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[2]/td[2]/input";
	private String password_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[1]/input";
	private String retypePassword_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[2]/input";

	private String addUserBtn_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/table[2]/tbody/tr/td[1]/button";

	private String selectQuery_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/div[2]/angular2-multiselect/div/div[1]/div";
	private String selectQueryDropDownSelectAllOpt_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/div[2]/angular2-multiselect/div/div[2]/div[2]/div[1]/label";
	private String selectQueryDropDownStartXpath_loc = xpath
			+ "/html/body/app-root/app-settings/div[2]/div/div[2]/div[2]/angular2-multiselect/div/div[2]/div[2]/ul/li[";

	private String addUserSuccessMsg_loc = xpath + "/html/body/app-root/app-settings/div[2]/div/p";
	private String addUserPopupOkBtn_loc = xpath + "/html/body/app-root/app-settings/div[2]/div/div/div";

	// ==============================Users List Page ===================

	private String userslist_headerStartXpath_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/ul/li[";
	private String userslist_headerStartEnd_loc = "]/div/div[1]/ul/li[2]/div/h2/b";
	private String userslist_infoStartXpath_loc = xpath + "/html/body/app-root/app-settings/div/div/div/div/div/ul/li[";
	private String userslist_firstName_loc = "]/div/div[2]/table/tbody/tr[1]/td[2]";
	private String userslist_userType_loc = "]/div/div[2]/table/tbody/tr[2]/td[2]";
	private String userslist_email_loc = "]/div/div[2]/table/tbody/tr[3]/td[2]";

	// ==============================Users Profile Page ===================

	private String usersProfile_firstName_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[1]/td[2]/input";
	private String usersProfile_lastName_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[2]/td[2]/input";
	private String usersprofile_mobileNumber_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[4]/td[2]/input";
	private String usersProfile_email_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[3]/td[2]/input";
	private String usersProfile_Role_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[5]/td[2]/input";
	private String usersProfile_Overview_loc = xpath
			+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[6]/td[2]/textarea";

	public void click_SettingsAndTabs_UsersPageWeb(WebDriver driver, int SettingsTabNuber, int settingSubTabsNumber) {
		super.click_SideMenuTabs_HomePageWeb(driver, SettingsTabNuber);
		super.click(driver, settingsTabsStartXpath_loc + settingSubTabsNumber + "]", waitTime);
	}

	public void click_UserRole_UsersPageWeb(WebDriver driver, int userRoleOptNumber_DFJB) {
		super.click(driver, userRoleStartXpath_loc + userRoleOptNumber_DFJB + "]/*[@id='rdblGender_0']", 2);
	}

	public void click_AddUserBtnInLists_UsersPageWeb(WebDriver driver) {
		super.sleep(3000);
		super.click(driver, addUserBtnInLists_loc, waitTime);
	}

	public void selectQueryDropDown_AddUser_UsersPageWeb(WebDriver driver, int Opt1_Opt2_Opt3_SelectAll_OptNumber) {
		super.click(driver, selectQuery_loc, waitTime);
		int j = 1;
		if (Opt1_Opt2_Opt3_SelectAll_OptNumber == 4) {
			super.click(driver, selectQueryDropDownSelectAllOpt_loc, waitTime);
		} else if (Opt1_Opt2_Opt3_SelectAll_OptNumber == 1) {
			super.click(driver, selectQueryDropDownStartXpath_loc + "3]/label", waitTime);
		} else if (Opt1_Opt2_Opt3_SelectAll_OptNumber == 2) {
			super.click(driver, selectQueryDropDownStartXpath_loc + j + "1]/label", waitTime);
		} else if (Opt1_Opt2_Opt3_SelectAll_OptNumber == 3) {
			super.click(driver, selectQueryDropDownStartXpath_loc + j + "2]/label", waitTime);
		}
		super.click(driver, selectQuery_loc, waitTime);
	}

	public void adduser_UsersPageWeb(WebDriver driver, String testName, String firstName, String lastName,
			String userName, String emailId, String password, String retypePassword, int userRoleOptNumber_DFJB,
			int Opt1_Opt2_Opt3_SelectAll_OptNumber) throws IOException {
		// This will be done by business head.So here I am giving 8 number for settings
		// tab
		this.click_SettingsAndTabs_UsersPageWeb(driver, 8, 4);
		this.click_AddUserBtnInLists_UsersPageWeb(driver);
		super.setText(driver, firstName_loc, firstName, waitTime);
		super.setText(driver, lastName_loc, lastName, waitTime);
		super.setText(driver, userName_loc, userName, waitTime);
		super.setText(driver, emailId_loc, emailId, waitTime);
		super.setText(driver, password_loc, password, waitTime);
		super.setText(driver, retypePassword_loc, retypePassword, waitTime);
		this.click_UserRole_UsersPageWeb(driver, userRoleOptNumber_DFJB);
		this.selectQueryDropDown_AddUser_UsersPageWeb(driver, Opt1_Opt2_Opt3_SelectAll_OptNumber);
		super.click(driver, addUserBtn_loc, waitTime);
		super.assertEquals_Text(driver, testName, "Adding User SuccessMsg",
				super.getText(driver, addUserSuccessMsg_loc, waitTime), "User Added Successfully.");
		super.sleep(1500);
		super.click(driver, addUserPopupOkBtn_loc, waitTime);
	}

	public void verifyUserInUsersList_UsersPageWeb(WebDriver driver, String testName, String firstName,
			int userRoleOptNumber_DFJB, String emailId) throws IOException {
		super.sleep(4000);
		for (int i = 1; i <= 40; i++) {

			String actualFirstName = super.getText(driver,
					userslist_headerStartXpath_loc + i + userslist_headerStartEnd_loc, 0);
			if (i == 40) {
				super.assertEquals_Text(driver, testName, "Users list page first name Header", actualFirstName,
						firstName);
			}

			if (i % 3 == 0) {
				super.scrollDown_Web(driver, 1, 300);
			}

			if (actualFirstName.equals(firstName)) {
				super.assertEquals_Text(driver, testName, "Users list page first name Header", actualFirstName,
						firstName);
				super.assertEquals_Text(driver, testName, "Users list page first name",
						super.getText(driver, userslist_infoStartXpath_loc + i + userslist_firstName_loc, waitTime),
						firstName);
				super.assertEquals_Text(driver, testName, "Users list page user type",
						super.getText(driver, userslist_infoStartXpath_loc + i + userslist_userType_loc, waitTime),
						super.pvWebApp("userType" + userRoleOptNumber_DFJB));
				super.assertEquals_Text(driver, testName, "Users list page emailid",
						super.getText(driver, userslist_infoStartXpath_loc + i + userslist_email_loc, waitTime),
						emailId);
				break;
			}

		}
	}

	public void verifyUserProfile_UsersPageWeb(WebDriver driver, int SettingsTabNuber, String testName, String userId,
			String password, String firstName, String lastName, String emailId) throws IOException {

		super.openWebAppUrl(driver);
		doctorFullName = super.loginWebApp(driver, userId, password);
		super.assertEquals_Text(driver, testName, "Users Name In Header", doctorFullName, firstName + " " + lastName);
		this.click_SettingsAndTabs_UsersPageWeb(driver, SettingsTabNuber, 1);

		super.assertEquals_Text(driver, testName, "Users list page first name Header",
				super.getAttributeValue_String(driver, usersProfile_firstName_loc, "value", waitTime), firstName);
		super.assertEquals_Text(driver, testName, "Users list page last name",
				super.getAttributeValue_String(driver, usersProfile_lastName_loc, "value", waitTime), lastName);
		super.assertEquals_Text(driver, testName, "Users list page emailId",
				super.getAttributeValue_String(driver, usersProfile_email_loc, "value", waitTime), emailId);
		super.assertEquals_Text(driver, testName, "User Profile MobileNumber",
				super.getAttributeValue_String(driver, usersprofile_mobileNumber_loc, "value", waitTime), "");
		super.assertEquals_Text(driver, testName, "User Profile Role",
				super.getAttributeValue_String(driver, usersProfile_Role_loc, "value", waitTime), "");
		super.assertEquals_Text(driver, testName, "User Profile Overview",
				super.getAttributeValue_String(driver, usersProfile_Overview_loc, "value", waitTime), "");
	}

	public void addUser_AccessQueries_Website_askQuestion_UsersPageWeb(WebDriver driver, String testName,
			int addUser_UserRoleOptNumber_DFJB, int addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber,
			int SettingsTabNuber, int askQuestion_Opt1_Opt2_Opt3_CategoryNumber) throws IOException {
		String pfKey = addUser_UserRoleOptNumber_DFJB + addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber
				+ askQuestion_Opt1_Opt2_Opt3_CategoryNumber + "_AUVQW";
		String userInfo = super.pvWebApp(pfKey);

		String addUserFirstName = userInfo + super.randomString(3);
		String adduserLastName = userInfo;
		String addUserEmailId = userInfo + "@" + super.randomString(3) + "." + super.randomString(3);
		String userName = userInfo + super.randomString(3);
		String password = super.randomString(6);
		// Ask Question Website Data
		String askQuestionSubject = "SubjectAskQuestion" + userInfo + " S" + super.randomString(5);
		String askQuestionMessage = "MessageAskQuestion" + userInfo + " M" + super.randomString(5);
		String askQuestionName = "AskQuestionName" + userInfo + " A" + super.randomString(5);
		String askQuestionEmailID = "AskQuestionEmail" + userInfo + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String askQuestionAge = addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber + super.randomNumString(1);
		String askQuestionMobileNumber = addUser_UserRoleOptNumber_DFJB
				+ addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber + askQuestion_Opt1_Opt2_Opt3_CategoryNumber
				+ super.randomNumString(7);

		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		this.adduser_UsersPageWeb(driver, testName, addUserFirstName, adduserLastName, userName, addUserEmailId,
				password, password, addUser_UserRoleOptNumber_DFJB, addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber);
		this.verifyUserInUsersList_UsersPageWeb(driver, testName, addUserFirstName, addUser_UserRoleOptNumber_DFJB,
				addUserEmailId);
		this.verifyUserProfile_UsersPageWeb(driver, SettingsTabNuber, testName, userName, password, addUserFirstName,
				adduserLastName, addUserEmailId);
		super.openWebsiteUrl(driver);
		super.navigateToAskQuestionPage_WebPage_QueriesPage(driver);
		int i = 1 + askQuestion_Opt1_Opt2_Opt3_CategoryNumber;
		// By Default creating a query with Female gender
		super.askQuestion_Website_QueriesPage(driver, testName, i, askQuestionSubject, askQuestionMessage,
				askQuestionName, askQuestionEmailID, askQuestionAge, askQuestionMobileNumber, 3);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, askQuestion_Opt1_Opt2_Opt3_CategoryNumber, askQuestionSubject,
				askQuestionMessage, askQuestionName, askQuestionAge, "F", askQuestionMobileNumber, askQuestionEmailID);
	}

	public void addUser_AccessQueries_Website_askQuery_UsersPageWeb(WebDriver driver, String testName,
			int addUser_UserRoleOptNumber_DFJB, int addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber,
			int SettingsTabNuber) throws IOException {
		String pfKey = addUser_UserRoleOptNumber_DFJB + addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber
				 + "4_AUVQW";
		String userInfo = super.pvWebApp(pfKey);

		String addUserFirstName = userInfo + super.randomString(3);
		String adduserLastName = userInfo;
		String addUserEmailId = userInfo + "@" + super.randomString(3) + "." + super.randomString(3);
		String userName = userInfo + super.randomString(3);
		String password = super.randomString(6);

		// Ask Query in web site
		String askQueryName = "AskQueryName" + userInfo + " A" + super.randomString(5);
		String askQueryEmail = "AskQueryEmail"+ userInfo + "@" + super.randomString(3) + "."
				+ super.randomString(3);
		String askQuerynMobileNumber = addUser_UserRoleOptNumber_DFJB
				+ addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber 
				+ super.randomNumString(8);
		
		String askQueryText = "AskQueryText"  + userInfo + super.randomString(9);

		super.openWebAppUrl(driver);
		super.loginWebApp(driver);
		this.adduser_UsersPageWeb(driver, testName, addUserFirstName, adduserLastName, userName, addUserEmailId,
				password, password, addUser_UserRoleOptNumber_DFJB, addUser_Opt1_Opt2_Opt3_SelectAll_QueryAccessNumber);
		this.verifyUserInUsersList_UsersPageWeb(driver, testName, addUserFirstName, addUser_UserRoleOptNumber_DFJB,
				addUserEmailId);
		this.verifyUserProfile_UsersPageWeb(driver, SettingsTabNuber, testName, userName, password, addUserFirstName,
				adduserLastName, addUserEmailId);
		super.openWebsiteUrl(driver);
		super.askQuery_Website_QueriesPage(driver, testName, askQueryName, askQueryEmail, askQuerynMobileNumber, askQueryText);
		super.openWebAppUrl(driver);
		super.loginWebApp(driver, userName, password);
		super.click_SideMenuTabs_HomePageWeb(driver, 4);
		super.verifyData_QueriesPage(driver, testName, 1, askQueryText + "...", askQueryText, askQueryName, "", "", askQuerynMobileNumber,
				askQueryEmail);
	}

}
