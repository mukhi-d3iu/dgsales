package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
static AndroidDriver<AndroidElement> driver;
	
	@BeforeSuite
	public void getAndroidDriver() {		
		try {
			//File appDir = new File("src");
			//File app = new File(appDir, "tpf_11_10_2022_whatsapp_consent.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // physical android device
			// cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5_API_25"); // emulator
			//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // path of the app
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Automation Name
			cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true); // Grant all permissions for the app	
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			//cap.setCapability(MobileCapabilityType.FULL_RESET, true);
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobicule.tatasky_bb");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".kotaklogin.view.SplashActivity");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap); // wd=webdriver
		}

		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
