package com.test.login;//对登陆操作进行封装

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	
	WebDriverEngine webtest=null;
	
	public Login_Action(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	
	public void login(String username,String passwd) throws InterruptedException{
		webtest.open("http://localhost:8032/xinhu/");//打开信呼登录页面
		webtest.type("name=adminuser", username);
		webtest.type("xpath=//input[@type='password']", passwd);
		webtest.click("xpath=//button[@name='button']");//以管理员身份登录信呼系统
		Thread.sleep(1000);
    }	
}
