package webApp;

import org.openqa.selenium.WebDriver;

public class LoginPage extends DataPage { // Next Extends : HomePage

	protected String doctorFullName = "Dr Ramesh Ramesh";

	public void openWebAppUrl(WebDriver driver) {
		String r=super.pvd("runIn");
		super.getPage(driver,"siteUrl"+r);

	}
	public void openWebsiteUrl(WebDriver driver) {
		String r=super.pvd("runIn");
		super.getPage(driver,"webUrl"+r);

	}
	public String login(WebDriver driver,String userId, String password) {
		String uid = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[1]/div[2]/input";
		String pwd = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[2]/div[2]/input";
		String submitBtn = xpath + "/html/body/app-root/app-login/div/div/div/div[2]/div/form/div/div[3]/button";
		super.setText(driver,uid, userId, waitTime);
		super.setText(driver,pwd, password, waitTime);
		super.click(driver,submitBtn, waitTime);
		super.sleep(9000);
		doctorFullName = super.getText(driver,xpath + "/html/body/app-root/app-home/div/div/div/app-header/div/label",
				waitTime).substring(6);
		System.out.println("Doctor Full Name Is :" + doctorFullName);
		return doctorFullName;
	}

	// --------Reusable Methods ------------//

}
