package com.test.paycheck;//���������Ӧ���ֶ���֤(3����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Addperson extends BaseTest{
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
		webtest.click("xpath=//button[@class='btn btn-primary']");//�����������	
		
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.click("xpath=//a[@id='btnchange_uname']");//���ѡ��
		webtest.click("xpath=//td[@deptxu='1_1']");//��������
		webtest.click("xpath=//input[@xname='��ʯ']");//��ѡ��ʯ
		webtest.click("xpath=//input[@value='ȷ��']");//���ȷ��
		webtest.click("xpath=//input[@value='����(S)']");//�������
		assertTrue(webtest.getHtmlSource().contains("�·ݳ�ǰ��"));//����
		webtest.leaveFrame();
	}
	
	@Test
	public void tick2() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.click("xpath=//a[@class='webbtn']");//������
		webtest.click("xpath=//input[@value='��ʼ����']");//�����ʼ����
		assertTrue(webtest.getHtmlSource().contains("��ѡ����Ա"));//����
		webtest.leaveFrame();
	}
	
	@Test
	public void tick3() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.click("xpath=//a[@id='btnchange_uname']");//���ѡ��
		webtest.click("xpath=//td[@deptxu='1_1']");//��������
		webtest.click("xpath=//input[@xname='��ʯ']");//��ѡ��ʯ
		webtest.click("xpath=//input[@value='ȷ��']");//���ȷ��
		webtest.click("xpath=//a[@class='webbtn']");//������
		webtest.click("xpath=//input[@value='����(S)']");//�������
		assertTrue(webtest.getHtmlSource().contains("��Ӧ�˲���Ϊ��"));//����
		webtest.leaveFrame();
	}
}
