package com.Dunblare.testCases;
import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.Dunblare.testPages.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException, InterruptedException {
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setEmailID(emailID);
		logger.info("Email ID entered");
		lp.setPassword(password);
		logger.info("Password is Entered");
		lp.clickLetMeIn();
		if(driver.getTitle().equals("3PL-Warehouse Management")) {
			Assert.assertTrue(true);
			logger.info("Test Case is passed");
		}
		else {
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Test case is Failed");
		}
	}
}
