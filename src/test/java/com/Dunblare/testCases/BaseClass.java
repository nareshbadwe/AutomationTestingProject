package com.Dunblare.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Dunblare.utilities.ReadConfig;

public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	
	//Reading data from ReadConfig.java file.
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String emailID=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException {
		logger=Logger.getLogger("Dunblare");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}else if(br.equals("edge")){
			System.setProperty("webdriver.edge.driver",readconfig.getIEPath());
			driver=new EdgeDriver();
		}else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
			driver=new FirefoxDriver();
		}			
		driver.manage().window().maximize();		
		driver.get(baseURL);
		//Thread.sleep(10000);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		//File target=new File("./Screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot Taken");
	}
}
