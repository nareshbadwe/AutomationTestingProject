package com.Dunblare.testPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Add WebElement
	By txtEmailID=By.name("Email");
	By txtPassword=By.name("Password");
	By btnLetMeEnter=By.xpath("//input[@value='Let me enter']");
	By btnControl=By.xpath("//a[@href='#userSettingsCollapse']");
	By btnLogout=By.xpath("//a[@href='/Customer/Logout']");
	
	//Add respected methods
	
	//set email id
	public void setEmailID(String email) {
		driver.findElement(txtEmailID).clear();
		driver.findElement(txtEmailID).sendKeys(email);
	}
	//set password
	public void setPassword(String pass) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(pass);
	}
	public void clickLetMeIn() throws InterruptedException {
		driver.findElement(btnLetMeEnter).click();
	//	Thread.sleep(10000);
	}
	public void clickLogout() throws InterruptedException {
		System.out.println("Button Control clicked");
		driver.findElement(btnControl).click();
		Thread.sleep(1000);
		driver.findElement(btnLogout).click();
		System.out.println("logout");

	}
	
}
