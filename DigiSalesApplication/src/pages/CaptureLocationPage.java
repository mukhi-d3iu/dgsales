package pages;

import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CaptureLocationPage extends BasePage {
	WebDriverWait ewait = new WebDriverWait(driver, 60);

	public CaptureLocationPage(AndroidDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
	}

	/*----------------------------------------Page Objects-------------------------------------------------------------*/

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/Id_ic_search")
	public AndroidElement SearchIconBTN;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/places_autocomplete_edit_text")
	public AndroidElement SearchEditTxtField;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/places_autocomplete_list")
	public AndroidElement SearchDropdownField;

	//@AndroidFindBy(xpath = "//android.widget.TextView[@text='Kandivali, Evershine Millennium Paradise, Thakur Village, Kandivali East, Mumbai, Maharashtra, India']")
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Mahatma Gandhi Road, Halasuru, Yellappa Chetty Layout, Sivanchetti Gardens, Bengaluru, Karnataka, India']")
	public AndroidElement expSociety;

	@AndroidFindBy(id = "android:id/content")
	public AndroidElement confirmSocietyPopup;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/Id_tv_address")
	public AndroidElement confirmAddressText;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/Id_btn_confirm")
	public AndroidElement confirmpopupOkBTN;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/map")
	public AndroidElement googleMap;

	@AndroidFindBy(xpath = "//android.view.View[@index='1']")
	//@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"NA. \"]")
	public AndroidElement buildingMarker;

	// public String expSocName = "Kandivali, Evershine Millennium Paradise, Thakur
	// Village, Kandivali East, Mumbai, Maharashtra, India";

	/*----------------------------------------Page Methods-------------------------------------------------------------*/

	// TO search Society in capture location field
	public void searchSocietyLocation(String expSocName, String expsocietyShortName) {
		try {
			ewait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/action_bar_root"))); // explicitwait
			SearchIconBTN.click();
			if (SearchEditTxtField.isDisplayed()) {
				SearchEditTxtField.sendKeys(expsocietyShortName);
				ewait.until(ExpectedConditions.visibilityOf(SearchDropdownField));
				if (SearchDropdownField.isDisplayed()) {
					if (expSociety.getText().equals(expSocName)) {
						// System.out.println(expSociety.getText());
						expSociety.click();
					} else {
						System.out.println("Society Not Found");
					}

				}
			} else {
				System.out.println("Search Textfield is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
	}

	// On click of Confirm Society Popup
	public void confirmSocietyPopup() {
		try {
			ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/tv_title"))); // explicitwait
			if (confirmSocietyPopup.isDisplayed() && confirmAddressText.isDisplayed()) {
				// String expAdd = "Halley Towers, Kandivali, Evershine Millennium Paradise,
				// Thakur Village, Kandivali East, Mumbai, Maharashtra 400101, India";
				// String actAdd = confirmAddressText.getText();
				confirmpopupOkBTN.click();
			} else {
				System.out.println("Confirm Location Popup not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}

	}

	// On click of Confirm Building Popup
	public void confirmBuildingPopup() {
		try {
			ewait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/map"))); // explicitwait
			if (googleMap.isDisplayed()) {
				//System.out.println("Buiding Name is : "+buildingMarker.getText());
				buildingMarker.click();				
			} else {
				System.out.println("Map not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
