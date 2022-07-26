package com.Dunblare.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	
	public ReadConfig() {
		//reading the data from config.properties file
		File src=new File("./Configuration\\config.properties");
		try {
			//open file into reading mode
			FileInputStream fis=new FileInputStream(src);
			//pro object is intiated
			pro=new Properties();
			//load is a method that load the complete config.properties file during run time
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName() {
		String userID=pro.getProperty("emailID");
		return userID;
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromePath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEPath() {
		String epath=pro.getProperty("edgepath");
		return epath;
	}
	public String getFireFoxPath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
