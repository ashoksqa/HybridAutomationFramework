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
	
	private String usersProfile_firstName_loc =xpath+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[1]/td[2]/input";
	private String usersProfile_lastName_loc = xpath+"/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[2]/td[2]/input";
	private String usersprofile_mobileNumber_loc =xpath+ "/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[4]/td[2]/input";
	private String usersProfile_email_loc = xpath+"/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[3]/td[2]/input";
	private String usersProfile_Role_loc = xpath+"/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[5]/td[2]/input";
	private String usersProfile_Overview_loc = xpath+"/html/body/app-root/app-settings/div/div/div/div/div/div[1]/form/div[2]/table/tbody/tr[6]/td[2]/textarea";

	public void click_SettingsAndTabs_UsersPageWeb(WebDriver driver, int SettingsTabNuber,int settingSubTabsNumber) {
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

	public void selectQueryDropDown_AddUser_UsersPageWeb(WebDriver driver,
			int selectAll_Opt2_Opt3_Opt1_OptNumber) {
		super.click(driver, selectQuery_loc, waitTime);
		int j = 1;
		if (selectAll_Opt2_Opt3_Opt1_OptNumber == 1) {
			super.click(driver, selectQueryDropDownSelectAllOpt_loc, waitTime);
		} else {
			j =  selectAll_Opt2_Opt3_Opt1_OptNumber-j;
			super.click(driver, selectQueryDropDownStartXpath_loc + j + "]/label", waitTime);
		}
		super.click(driver, selectQuery_loc, waitTime);
	}

	public void adduser_UsersPageWeb(WebDriver driver,String testName, String firstName, String lastName,
			String userName, String emailId, String password, String retypePassword, int userRoleOptNumber_DFJB,int selectAll_Opt2_Opt3_Opt1_QueryOptNumber)
			throws IOException {
// This will be done by business head.So here I am giving 8 number for settings tab
		this.click_SettingsAndTabs_UsersPageWeb(driver, 8,4);
		this.click_AddUserBtnInLists_UsersPageWeb(driver);
		super.setText(driver, firstName_loc, firstName, waitTime);
		super.setText(driver, lastName_loc, lastName, waitTime);
		super.setText(driver, userName_loc, userName, waitTime);
		super.setText(driver, emailId_loc, emailId, waitTime);
		super.setText(driver, password_loc, password, waitTime);
		super.setText(driver, retypePassword_loc, retypePassword, waitTime);
		this.click_UserRole_UsersPageWeb(driver, userRoleOptNumber_DFJB);
		this.selectQueryDropDown_AddUser_UsersPageWeb(driver, selectAll_Opt2_Opt3_Opt1_QueryOptNumber);
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
			
			if (i%3 == 0) {
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

	public void verifyUserProfile_UsersPageWeb(WebDriver driver, int SettingsTabNuber, String testName,String userId, String password,
			String firstName, String lastName, String emailId) throws IOException {

		super.openWebAppUrl(driver);
		doctorFullName = super.loginWebApp(driver, userId, password);
		super.assertEquals_Text(driver, testName, "Users Name In Header", doctorFullName, firstName + " " + lastName);
		this.click_SettingsAndTabs_UsersPageWeb(driver,SettingsTabNuber, 1);

		super.assertEquals_Text(driver, testName, "Users list page first name Header",
				super.getAttributeValue_String(driver, usersProfile_firstName_loc, "value",waitTime), firstName);
		super.assertEquals_Text(driver, testName, "Users list page last name",
				super.getAttributeValue_String(driver, usersProfile_lastName_loc, "value",waitTime), lastName);
		super.assertEquals_Text(driver, testName, "Users list page emailId",
				super.getAttributeValue_String(driver, usersProfile_email_loc, "value",waitTime), emailId);
		super.assertEquals_Text(driver, testName, "User Profile MobileNumber",
				super.getAttributeValue_String(driver, usersprofile_mobileNumber_loc, "value",waitTime), "");
		super.assertEquals_Text(driver, testName, "User Profile Role",
				super.getAttributeValue_String(driver, usersProfile_Role_loc, "value",waitTime), "");
		super.assertEquals_Text(driver, testName, "User Profile Overview",
				super.getAttributeValue_String(driver, usersProfile_Overview_loc, "value",waitTime), "");
	}
}
