package com.test.dailypaper;//�����ձ�����(1����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Dailytype extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void type() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//��������ձ�
		webtest.click("xpath=//div[@id='menu_list_num193']");//���������ձ�ҳ��
		webtest.click("xpath=//button[@click='clickwin,0']");//�������
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.click("xpath=//select[@class='inputs']");//����ձ�������ʾ�����˵�����
		webtest.selectByIndex("name=type", 1);//���ѡ���ձ�
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
}
