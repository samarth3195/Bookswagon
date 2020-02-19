package com.bookswagon.utilitiy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
 
	public ReadConfig() {
		File src = new File("./resource/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getEmail()
	{
		String email=pro.getProperty("email");
		return email;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	public String getXLpath()
	{
		String xlPath = pro.getProperty("xlPath");
		return xlPath;
	}

}