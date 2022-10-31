package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePage {
	WebDriverWait ewait = new WebDriverWait(driver, 60);

	public LoginPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	/*----------------------------------------Page Objects-------------------------------------------------------------*/

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/et_enter_etop_number")
	public AndroidElement mobileNoField;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/tv_enter_verify_otp")
	public AndroidElement getOtpButton;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/tvDiagnostic")
	public AndroidElement diagnosticButton;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/id_linear_layout_ok_one")
	public AndroidElement dialogBox;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/id_txt_alert_dialog_msg")
	public AndroidElement dialogText;

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/id_btn_alert_dialog_ok_one")
	public AndroidElement dialogBoxOkButton;
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/id_btn_alert_dialog_cancel")
	public AndroidElement dialogBoxNoButton;
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/id_btn_alert_dialog_ok")
	public AndroidElement dialogBoxYesButton;
	

	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/et_verify_otp")
	public AndroidElement otpNoField;
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/tv_login")
	public AndroidElement loginButton;
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/commonDialogTitleLayout")
	public AndroidElement syncDialogBox;	
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/yesButton")
	public AndroidElement syncDialogBoxButton;
	
	
	

	// Sorry. Our system is down. We'll be up and running shortly.

	/*----------------------------------------Page Methods-------------------------------------------------------------*/

	// Validate elements present in Login page
	public boolean validateLoginPage() {
		boolean elements = false;
		ewait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/et_enter_etop_number"))); // explicit wait
		if (mobileNoField.isDisplayed()) {
			if (getOtpButton.isDisplayed()) {
				if (diagnosticButton.isDisplayed()) {
					elements = true;
				}
			}
		} else {
			elements = false;
		}
		return elements;
	}

	//Send Partner login number in the field
	public void LoginNumber(String number) {
		mobileNoField.sendKeys(number);
	}

	//Click on Get OTP
	public void onClickGetOtpButton() {
		getOtpButton.click();
	}

	//Verification otp send Dialog box
	public void MessageSentDialogBoxMessage() {
		ewait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/id_linear_layout_ok_one"))); // explicit wait
		String MessageSentDialogBoxActualMsg = dialogText.getText();
		String MessageSentDialogBoxExpectedMsg = "Please enter the Verification Code sent to the Mobile Number";
		if (dialogBox.isDisplayed()) {
			if (MessageSentDialogBoxExpectedMsg.equals(MessageSentDialogBoxActualMsg)) {
				dialogBoxOkButton.click();
			} else {
				System.out.println(MessageSentDialogBoxActualMsg);
			}
		}
	}
	
	//Check if OTP has been autopopulated and if yes click on Login button and if no send error message
	public void otpVerification() throws InterruptedException {
		Thread.sleep(5000);
		String otpNoFieldActualMsg = otpNoField.getText();
		String otpNoFieldExpectedMsg = "Enter OTP";
		if (otpNoField.isDisplayed()) {
			if (otpNoFieldExpectedMsg.equals(otpNoFieldActualMsg)) {
				System.out.println("Didn't receive otp");
			} else {
				System.out.println("OTP received successfully");
				loginButton.click();
			}
		} else {
			System.out.println("Verify Otp field not displayed");
		}
	}
	
	
	//OTP verified dialog box
		public void OtpVerifiedDialogBoxMessage() {
			ewait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/id_linear_layout_ok_one"))); // explicit wait
			String OtpVerifiedDialogBoxActualMsg = dialogText.getText();
			String OtpVerifiedDialogBoxExpectedMsg = "OTP Verified Successfully. Lets get started.";
			if (dialogBox.isDisplayed()) {
				if (OtpVerifiedDialogBoxExpectedMsg.equals(OtpVerifiedDialogBoxActualMsg)) {
					dialogBoxOkButton.click();
				} else {
					System.out.println(OtpVerifiedDialogBoxActualMsg);
				}
			}
		}
		
	//Sync dialog box
	public void syncSuccessDialogBoxMessage() {
		ewait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/commonDialogTitleLayout"))); // explicit wait
		if (syncDialogBox.isDisplayed()) {			
			syncDialogBoxButton.click();
			} else {
				System.out.println("Sync not successfull");
			}
		}
	
	//skip checkin popups to view homescreen
	public void skipCheckInAndCheckOut() throws InterruptedException {
		ewait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.mobicule.tatasky_bb:id/id_linear_layout_ok_one"))); // explicit
																											// wait

		// String CheckInCheckOutActualMsg = dialogText.getText();
		String CheckInCheckOutExpectedMsg = "Do you want to check in?";
		String AbsentExpectedMsg = "If you do not check in to the app, your visit will be marked as Absent for the day. Do you want to cancel?";
		String SetReminderExpectedMsg = "Do you want to set reminder for check in?";

		if (dialogBox.isDisplayed()) {
			if (CheckInCheckOutExpectedMsg.equals(dialogText.getText())) {
				dialogBoxNoButton.click();
				// ewait.until(ExpectedConditions.textToBePresentInElement(dialogText,AbsentExpectedMsg));
				if (AbsentExpectedMsg.equals(dialogText.getText())) {

					dialogBoxYesButton.click();
				} else {
					System.out.println("Absent mark for the day Dialog Box not present");
				}
				if (SetReminderExpectedMsg.equals(dialogText.getText())) {
					dialogBoxNoButton.click();
				} else {
					System.out.println("Set Reminder Dialog Box not present");
				}
			} else {
				System.out.println("Check In Check Out Dialog Box not present");
			}
		} else {
			System.out.println("Dialog Box not displayed");
		}

	}

}
