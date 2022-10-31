package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage{
	WebDriverWait ewait = new WebDriverWait(driver, 60);

	public HomePage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*----------------------------------------Page Objects-------------------------------------------------------------*/

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
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Document Upload']")
	public AndroidElement documentUploadTile;
	
	@AndroidFindBy(id = "com.mobicule.tatasky_bb:id/Id_customer_onboarding")
	public AndroidElement newCustomerBTN;
	
	
	/*----------------------------------------Page Methods-------------------------------------------------------------*/
	
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
	
	//New Customer Onboarding
	public void clickOnNewCustomerBTN(){
		newCustomerBTN.click();
		/*
		 * driver.findElement(By.xpath("//*[@id='Id_ic_search']")).click();
		 * driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_2']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_2_4']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_2']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_3']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_1_1']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_1_5']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_7']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_2_6']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_2']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_space']]]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_4']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_8']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_1']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_2']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@class='android.widget.TextView' and ./parent::*[@id='key_pos_0_3']]"
		 * )).click(); driver.findElement(By.
		 * xpath("//*[@text='Kandivali, Evershine Millennium Paradise, Thakur Village, Kandivali East, Mumbai, Maharashtra, India']"
		 * )).click(); driver.findElement(By.xpath("//*[@text='OK']")).click();
		 */
       
	}

}
