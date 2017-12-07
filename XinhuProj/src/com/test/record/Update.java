package com.test.record;//�Ը������ݰ�ť�������֤(2����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Update extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void state1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//������Ա����ҳ��
		webtest.click("xpath=//button[@class='btn btn-success']");//�����������
		assertTrue(webtest.getHtmlSource().contains("������"));//����
	}
	
	@Test
	public void state2() throws InterruptedException{
		webtest.click("xpath=//td[@cell='1']");//ѡ��һ������
		webtest.click("xpath=//button[@class='btn btn-success']");//�ٵ����������
		assertTrue(webtest.getHtmlSource().contains("������"));//����
	}
}
