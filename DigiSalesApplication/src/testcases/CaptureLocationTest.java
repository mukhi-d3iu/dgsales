package testcases;

import org.testng.annotations.Test;

import pages.CaptureLocationPage;

public class CaptureLocationTest extends BaseTest{
	@Test
	public void locationScreen() throws InterruptedException {
		//String societyShortName="halley towers";
		String societyShortName="raheja towers halasuru";
		//String societyLoc="Kandivali, Evershine Millennium Paradise, Thakur Village, Kandivali East, Mumbai, Maharashtra, India";
		String societyLoc="Mahatma Gandhi Road, Halasuru, Yellappa Chetty Layout, Sivanchetti Gardens, Bengaluru, Karnataka, India";
		CaptureLocationPage clp=new CaptureLocationPage(driver);		
		clp.searchSocietyLocation(societyLoc,societyShortName);
		clp.confirmSocietyPopup();
		clp.confirmBuildingPopup();
		clp.confirmSocietyPopup();
		Thread.sleep(50000);
	}

}
