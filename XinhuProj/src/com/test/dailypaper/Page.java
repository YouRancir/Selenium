package com.test.dailypaper;//��ҳ��֤(1����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Page extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void page() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//��������ձ�
		webtest.click("xpath=//div[@id='menu_list_num193']");//���������ձ�ҳ��
		webtest.click("xpath=//button[@title='��һҳ']");//���>��ť
		webtest.click("xpath=//button[@title='��һҳ']");//���<��ť
		webtest.click("xpath=//button[@title='βҳ']");//�������ť
		webtest.click("xpath=//button[@title='��ҳ']");//�������ť
    	assertTrue(webtest.getHtmlSource().contains("2017 "));//����
	}
}
