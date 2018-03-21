package nativeApp;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

public class LoginPageApp extends DataPageApp { // Next Extends : HomePageApp

protected String doctorFullName = "Ramesh Ramesh";

	public String loginAfterResetApp(AppiumDriver<?> driver) throws IOException {
		super.sleep(3000);
		super.setText(driver,id + "input_username",locator_iOS, super.pvNativeApp("uid"), waitTime);
		super.keypadNext(driver);
		super.setText(driver,id + "input_password", locator_iOS,super.pvNativeApp("pwd"),waitTime);
		super.keypadClose(driver);
		super.click(driver, id + "btn_login",locator_iOS, waitTime);
		super.click(driver,id+"tvSkip", locator_iOS,waitTime);	
		this.allowPermissionsApp(driver,5);
		doctorFullName=super.getText(driver,id+"login_name", locator_iOS, waitTime);
		System.out.println("Doctor Full Name Is :" + doctorFullName);
		super.sleep(5000);
		return doctorFullName;
		
	}
	
	public void allowPermissionsApp(AppiumDriver<?> driver,int maxCount) {
		for(int i=1;i<=maxCount;i++) {
		super.click(driver,id+"com.android.packageinstaller:id/permission_allow_button", locator_iOS, waitTime);
		}
		}
	
	// --------Reusable Methods ------------//

}
