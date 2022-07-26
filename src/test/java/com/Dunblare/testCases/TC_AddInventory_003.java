package com.Dunblare.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.Dunblare.testPages.AddInventory;
import com.Dunblare.testPages.LoginPage;

public class TC_AddInventory_003 extends BaseClass{

@Test
	public void addInventory() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setEmailID(emailID);
		lp.setPassword(password);
		lp.clickLetMeIn();
		Thread.sleep(5000);

		AddInventory addInv=new AddInventory(driver);
		
		addInv.clickOnInventory();
		Thread.sleep(1000);
		addInv.clickOnAddNew();
		Thread.sleep(5000);
		addInv.setDivision("Thinker Steps");
		Thread.sleep(500);
		addInv.setName("Cooler_"+randomString());
		Thread.sleep(500);
		addInv.setShortDescription("Summer Product to keep home cool");
		Thread.sleep(500);
		addInv.setSKU("Cool Summer_"+randomString());
		Thread.sleep(500);
		addInv.setFamily("Thinker Steps Family");		
		Thread.sleep(500);
		addInv.setLength(randonNumeric());
		Thread.sleep(500);
		addInv.setWidth(randonNumeric());
		Thread.sleep(500);
		addInv.setHeight(randonNumeric());
		Thread.sleep(500);
		addInv.setWeight(randonNumeric());
		Thread.sleep(500);
		addInv.setProductCode("Cooler_"+randonNumeric());
		Thread.sleep(500);
		addInv.setBarCode("Cooler_"+randonNumeric());
		Thread.sleep(500);
		addInv.clickOnSave();	
		Thread.sleep(500);
	}
	public String randomString() {
		return (RandomStringUtils.randomAlphabetic(4));
	}
	public String randonNumeric() {
		return(RandomStringUtils.randomNumeric(3));
	}
}
