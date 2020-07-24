package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch(Exception e) {
			System.out.println("Exception is:" +e.getMessage());
			
		}
		
	}
	
	//Adding methods to read each and every variable from config.properties file
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	public String getUserName() {
		String UserName = pro.getProperty("UserName");
		return UserName;
		
	}
	public String getPassword() {
		String pwd = pro.getProperty("Password");
		return pwd;
		
	}
	public String getChromePath() {
		String Chrome = pro.getProperty("ChromePath");
		return Chrome;
		
	}
	public String firefoxPath() {
		String firefox = pro.getProperty("firefox");
		return firefox;
		
	}
	//Add remaining browsers IE and FireFox
	

}
