package testcases;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.*;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	//AndroidDriver driver = AndroidUtilities.getAndroidDriver();
	
	//HomescreenTest homescreenpage=new HomescreenTest();
	
	@DataProvider
	public Object[][] getData()
	  {
		  //Object[][] xlsData=new Object[2][2];
		  String xlsdirectory= System.getProperty("user.dir");
		  String xlsFilename= xlsdirectory+"\\TestData.xls";
		  //String xlsFilename="C:\\Users\\Mukhi\\Documents\\TestData.xls";
		  File xlsFile= new File(xlsFilename);
		  ExcelUtilities excelUti = new ExcelUtilities();
		  
		  Workbook workbook=excelUti.getScriptWorkbook(xlsFile);
		  int iSheetCount=workbook.getNumberOfSheets();
		  //System.out.println("This workbook contains number of sheets"+iSheetCount);
		  Sheet sheet=workbook.getSheetAt(0);
		  //System.out.println("worksheet name : "+sheet.getSheetName());
		  //System.out.println("Sheet :"+sheet.getSheetName()+" has "+sheet.getLastRowNum()+" no of ");
		  int iNumberofRows=sheet.getLastRowNum();
		  Object[][] xlsData=new Object[iNumberofRows][2];
		  
		  for(int iRow=1;iRow<=iNumberofRows;iRow++)
		  {
			Row currentSheetRow = sheet.getRow(iRow);
			String desc=excelUti.getCellValue(currentSheetRow.getCell(0));
			String value=excelUti.getCellValue(currentSheetRow.getCell(1));

			xlsData[iRow-1][0]=desc;
			xlsData[iRow-1][1]=value;
		  }
		  
		  return xlsData;
	  }

	@Test(dataProvider = "getData")
	public void loginTest(String desc, String value) throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		if (loginpage.validateLoginPage() == true) {
			loginpage.LoginNumber(value);
			loginpage.onClickGetOtpButton();
			loginpage.MessageSentDialogBoxMessage();
			loginpage.otpVerification();
			loginpage.OtpVerifiedDialogBoxMessage();
			loginpage.syncSuccessDialogBoxMessage();
			loginpage.skipCheckInAndCheckOut();
			//homescreenpage.homescreen();
			//Assert.assertEquals(loginpage.validateLoginPage(), true);
		}

	}

}
