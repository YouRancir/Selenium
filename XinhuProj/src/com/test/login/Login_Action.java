package com.test.login;//�Ե�½�������з�װ

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	
	WebDriverEngine webtest=null;
	
	public Login_Action(WebDriverEngine webtest){
		this.webtest=webtest;
	}
	
	public void login(String username,String passwd) throws InterruptedException{
		webtest.open("http://localhost:8032/xinhu/");//���ź���¼ҳ��
		webtest.type("name=adminuser", username);
		webtest.type("xpath=//input[@type='password']", passwd);
		webtest.click("xpath=//button[@name='button']");//�Թ���Ա��ݵ�¼�ź�ϵͳ
		Thread.sleep(1000);
    }	
}
