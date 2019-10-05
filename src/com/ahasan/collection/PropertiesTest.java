package com.ahasan.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties properties=new Properties();
		FileInputStream fileInputStream=new FileInputStream("abc.properties");
		properties.load(fileInputStream);
		System.out.println(properties);
		String string = (String) properties.get("ahasan");
		System.out.println(string);
		properties.setProperty("medha", "pundir");
		FileOutputStream fileOutputStream=new FileOutputStream("abc.properties");
		properties.store(fileOutputStream, "Updated By Ahasan Siddiqui for demo Store method : ");
		
		
	}
}
