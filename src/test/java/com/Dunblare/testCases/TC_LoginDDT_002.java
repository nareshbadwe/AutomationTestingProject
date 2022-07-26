package com.Dunblare.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dunblare.testPages.LoginPage;
import com.Dunblare.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test (dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setEmailID(user);
		logger.info("User ID is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clickLetMeIn();	
		logger.info("clicked on login button");
		
		if(isAlertPresent()==true) {
			captureScreen(driver, "loginDDT");
			//driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Thread.sleep(5000);
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Clicked on Logout");
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	//Actual data provider method
	@DataProvider (name="LoginData")
	//getting data from excel file and pass this data to loginDDT() method
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Dunblare/testData/LoginData.xls";
		//System.out.println("File read");
		int rowCount=XLUtils.getRowCount(path,"Sheet1");
		//System.out.println("row count done");
		int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
		//System.out.println("col count done");
		String logindata[][]=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1,0
			}
		}
		//System.out.println("data read");
		return logindata;
	}

	
}
