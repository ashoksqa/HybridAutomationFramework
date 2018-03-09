package webApp;

import org.openqa.selenium.WebDriver;


public class LoginPageWeb extends DataPageWeb { // Next Extends : HomePageWeb

	protected String doctorFullName = "Dr Ramesh Ramesh";

	
	
	public void openWebAppUrl(WebDriver driver) {
		
		String r=super.pvWebApp("runIn");
		super.getPage(driver,super.pvWebApp("siteUrl"+r));

	}
	public void openWebsiteUrl(WebDriver driver) {
		String r=super.pvWebApp("runIn");
		super.getPage(driver,super.pvWebApp("webUrl"+r));


	}
	public String login(WebDriver driver,String userId, String password) {
		String uid = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[1]/div[2]/input";
		String pwd = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[2]/div[2]/input";
		String submitBtn = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div[1]/div[3]/button";
		super.setText(driver,uid, super.pvWebApp("uid"), waitTime);
		super.setText(driver,pwd, super.pvWebApp("pwd"), waitTime);
		super.click(driver,submitBtn, waitTime);
		super.sleep(9000);
		doctorFullName = super.getText(driver,xpath + "/html/body/app-root/app-home/div/div/div/app-header/div/label",
				waitTime).substring(6);
		System.out.println("Doctor Full Name Is :" + doctorFullName);
		return doctorFullName;
	}

	// --------Reusable Methods ------------//

}
