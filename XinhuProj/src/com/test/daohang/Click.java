package com.test.daohang;//���ڵ�½ϵͳ�������Ա����ҳ��֮ǰ�ĵ����������֤(1����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Click extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void click() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");//������µ���
		webtest.click("xpath=//div[@id='menu_list_num85']");//�����Ա����
		assertTrue(webtest.getHtmlSource().contains("��Ա����"));//����
	}
}
