package com.test.paycheck;//��ѡ��¼��ȡ����ѡ(2����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Tick extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void tick1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//div[@id='menu_list_num98']");//���н�ʹ���
		webtest.click("xpath=//div[@id='menu_list_num99']");//����н�ʺ���ҳ��
		
		webtest.click("xpath=//input[@value='22']");
		webtest.click("xpath=//input[@value='21']");//��ѡ��3��4����¼
		
		webtest.click("xpath=//input[@value='22']");
		webtest.click("xpath=//input[@value='21']");//ȡ����ѡ��3��4����¼
		assertTrue(webtest.getHtmlSource().contains("���¿���"));//����
	}
	
	@Test
	public void tick2() throws InterruptedException{
		webtest.click("xpath=//input[starts-with(@id,'seltablecheck')]");//���������ѡ�򣬹�ѡ����
		webtest.click("xpath=//input[starts-with(@id,'seltablecheck')]");//�ٴε��������ѡ�򣬹�ѡ����
		assertTrue(webtest.getHtmlSource().contains("���¿���"));//����
	}
}
