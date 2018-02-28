package sanityTesting;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import frameworkLibrary.webDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class androidTesting extends webTesting{
	
	
	private AppiumDriverLocalService service;
	AppiumDriver<?> driver;
	private DesiredCapabilities cap;

	// Android App Installation with appium server
	public void androidAppInstall() {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
						.withAppiumJS(new File(appiumJS_Path))
						.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());

		File apk = new File(appDir, this.pvts("Merchant" + Trow) + ".apk");
		System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".apk");

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", this.pvts("Udid" + Trow));
		cap.setCapability("appPackage", super.pvd("appPackage"));
		cap.setCapability("appActivity", super.pvd("appActivity"));
		// cap.setCapability("clearSystemFiles", true);("systemPort",XXXX)
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		service.stop();
	}

	// Android App Installation with appium server
	public AppiumDriver<?> androidAppLaunch() {
		cap = new DesiredCapabilities();
		cap.setCapability("clearSystemFiles", true);

		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExecutablePath))
						.withAppiumJS(new File(appiumJS_Path))
						.withCapabilities(cap).withIPAddress("127.0.0.1").usingAnyFreePort());
		File apk = new File(appDir, this.pvts("Merchant" + Trow) + ".apk");
		System.out.println("APP name is : " + this.pvts("Merchant" + Trow) + ".apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, this.pvts("DeviceName" + Trow));
		cap.setCapability(AndroidMobileCapabilityType.PLATFORM, this.pvts("OS" + Trow));
		cap.setCapability("automationName", "uiautomator2");
		cap.setCapability("udid", this.pvts("Udid" + Trow));
		cap.setCapability("appPackage", super.pvData("appPackage"));
		cap.setCapability("appActivity", super.pvData("appActivity"));
		// cap.setCapability("clearSystemFiles", true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability("PlatformVersion", this.pvts("PlatformVersion" + Trow));
		String systemPort = randomNumString(3);
		String systemPort1 = Trow + systemPort;
		cap.setCapability("systemPort", systemPort1);
		cap.setCapability("app", apk.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(service, cap);
		return driver;
	}

}
