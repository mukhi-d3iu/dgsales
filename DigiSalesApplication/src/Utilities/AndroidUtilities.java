package Utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidUtilities {

	public static AndroidDriver getAndroidDriver() {
		AndroidDriver<AndroidElement> driver = null;
		try {
			File appDir = new File("src");
			File app = new File(appDir,"tpfb_06_10_2022_uat.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // physical android device
			// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5_API_25"); // emulator
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // path of the app
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Automation Name
			cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true); // Grant all permissions for the app																							
			cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap); // wd=webdriver
		}

		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}

}
