package com.Dunblare.testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DeliveryRequest {
	WebDriver driver;
	
	public DeliveryRequest(WebDriver driver) {
		this.driver=driver;
	}
	
	//Add webElements
	By Division=By.xpath("//span[@id='select2-Customer_Id-container']");
	By ContainerNo=By.xpath("//input[@id='ContainerNo']");
	By Family=By.xpath("//span[@id='select2-FamilyId-container']");
	By PONo=By.xpath("//input[@id='ponoid']");
	By Active=By.xpath("//input[@id='Active']");
	By DeliveryDate=By.xpath("//input[@id='datetime']");
	By Carrier=By.xpath("//input[@id='Carrier']");
	By Shipper=By.xpath("//span[@id='select2-ShipperId-container']");
	By Manufacturer=By.xpath("//span[@id='select2-ManufacturerId-container']");
	By Comment=By.xpath("//textarea[@id='Notes']");
	By AddProduct=By.xpath("//button[@id='btnAddProductRow']");
	By ImportProduct=By.xpath("//button[@id='btnImportProductRow']");
	
	//set methods for webElements
	public void setDivision(String div) {
		Select dropDown=new Select(driver.findElement(Division));
		dropDown.selectByValue(div);
	}
	public void setContainerNo(String CNo) {
		driver.findElement(ContainerNo).clear();
		driver.findElement(ContainerNo).sendKeys(CNo);
	}
	public void setFamily(String Fm) {
		Select dropDown=new Select(driver.findElement(Family));
		dropDown.selectByValue(Fm);
	}
	public void setPONo(String pNo) {
		driver.findElement(PONo).clear();
		driver.findElement(PONo).sendKeys(pNo);
	}
	public void setActive() {
		if(driver.findElement(Active).isEnabled())
		{}
		else {
			driver.findElement(Active).click();
		}
	}
	public void setDeliveryDate(String date) {
		driver.findElement(DeliveryDate).sendKeys(date);
	}
	public void setCarrier(String carrier) {
		driver.findElement(Carrier).sendKeys(carrier);
	}
	public void setShipper(String shipper) {
		Select dropDown=new Select(driver.findElement(Shipper));
		dropDown.selectByValue(shipper);
	}
	public void setManufacturer(String manufacturer) {
		driver.findElement(Manufacturer).sendKeys(manufacturer);
	}
	
}
