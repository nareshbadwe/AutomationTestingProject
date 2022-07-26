package com.Dunblare.testPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddInventory {
	WebDriver driver;
	
	public AddInventory(WebDriver driver) {
		this.driver=driver;
	}
	
	//Add WebElements
	By Inventory=By.xpath("//body[1]/div[2]/aside[1]/div[1]/section[1]/ul[1]/li[3]/a[1]/span[1]");
	By AddNew=By.xpath("//a[@href='/Product/CreateProduct']");
	By Division=By.xpath("//select[@name='CustomerId']");
	By Name=By.xpath("//input[@id='Name']");
	By ShortDescription=By.xpath("//input[@id='ShortDescription']");
	By SKU=By.xpath("//input[@id='Sku']");
	By Family=By.xpath("//select[@name='SelectedCategoryIds']");
	By Length=By.xpath("//input[@id='Length']");
	By Width=By.xpath("//input[@id='Width']");
	By Height=By.xpath("//input[@id='Height']");
	By Weight=By.xpath("//input[@id='Weight']");
	
	By btnAddProductCode=By.xpath("//button[@id='AddProductMNPN']");
	By txtProductCode=By.xpath("//input[@id='ProductMNPNS_0']");
	
	By btnAddBarcode=By.xpath("//button[@id='AddProductBarcode']");
	By txtBarcode=By.xpath("//input[@id='ProductBarcode_0']");
	
	
	By Save=By.xpath("//button[@name='save']");
	By Cancel=By.xpath("//a[@class='btn btn-danger btn-lg mr-2']");
	
	//Add Methods
	public void clickOnInventory() {
		driver.findElement(Inventory).click();
	}
	public void clickOnAddNew() {
		driver.findElement(AddNew).click();
	}
	public void setDivision(String division) throws InterruptedException {
		Select dropDown=new Select(driver.findElement(Division));
		dropDown.selectByVisibleText(division);
	}
	public void setName(String name) {
		driver.findElement(Name).clear();
		driver.findElement(Name).sendKeys(name);
	}
	public void setShortDescription(String description) {
		driver.findElement(ShortDescription).clear();
		driver.findElement(ShortDescription).sendKeys(description);
	}
	public void setSKU(String sku) {
		driver.findElement(SKU).clear();
		driver.findElement(SKU).sendKeys(sku);
	}
	public void setFamily(String family) {
		Select dropDown=new Select(driver.findElement(Family));
		dropDown.selectByVisibleText(family);
	}
	public void setLength(String length) {
		driver.findElement(Length).clear();
		driver.findElement(Length).sendKeys(length);
	}
	public void setWidth(String width) {
		driver.findElement(Width).clear();
		driver.findElement(Width).sendKeys(width);
	}
	public void setHeight(String height) {
		driver.findElement(Height).clear();
		driver.findElement(Height).sendKeys(height);
	}
	public void setWeight(String weight) {
		driver.findElement(Weight).clear();
		driver.findElement(Weight).sendKeys(weight);
	}
	public void setProductCode(String code) {
		driver.findElement(btnAddProductCode).click();
		driver.findElement(txtProductCode).sendKeys(code);
	}
	public void setBarCode(String code) {
		driver.findElement(btnAddBarcode).click();
		driver.findElement(txtBarcode).sendKeys(code);
	}
	public void clickOnSave() {
		driver.findElement(Save).click();
	}
	public void clickOnCancel() {
		driver.findElement(Cancel).click();
	}
	
}
