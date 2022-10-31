package testcases;

import org.testng.annotations.Test;

import pages.HomePage;

public class HomescreenTest extends BaseTest{
  @Test
  public void homescreen() throws InterruptedException {
	  //System.out.println("Mukhi");
	  HomePage homepage = new HomePage(driver);
	  homepage.skipCheckInAndCheckOut();
	  homepage.clickOnNewCustomerBTN();
	  //Thread.sleep(10000);
  }
}
