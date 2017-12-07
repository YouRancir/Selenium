package com.test.dailypaper;//Êý¾ÝÇý¶¯

import org.testng.annotations.DataProvider;
import com.webtest.dataprovider.FileDataProvider;

public class SearchDataProvider {
	
	@DataProvider(name="TD1")
	public static Object[][] getTxt(){
		FileDataProvider td = new FileDataProvider("TestData");
		return td.getTestDataByTxt();
	}
}
