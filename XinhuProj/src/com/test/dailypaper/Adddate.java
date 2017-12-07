package com.test.dailypaper;//��������(9����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Adddate extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void adddate1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//��������ձ�
		webtest.click("xpath=//div[@id='menu_list_num193']");//���������ձ�ҳ��
		webtest.click("xpath=//button[@click='clickwin,0']");//�������
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.click("xpath=//select[@class='inputs']");//����ձ�������ʾ�����˵�����
		webtest.selectByIndex("name=type", 1);//���ѡ���ձ�
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//a[text()='���']");//������
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("���ڲ���Ϊ�� "));//����
	}
	
	@Test(priority=1)
	public void adddate2() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//a[text()='����']");//�������
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
	
	@Test(priority=2)
	public void adddate3() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//td[text()='23']");//���23
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
	
	@Test(priority=3)
	public void adddate4() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//a[text()='�ر�']");//����ر�
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	assertTrue(webtest.getHtmlSource().contains("�������� "));//����
    	webtest.leaveFrame();
	}
	
	@Test(priority=4)
	public void adddate5() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//td[@title='��һ��']");//���������Ұ�ť
		webtest.click("xpath=//td[@title='��һ��']");//���������Ұ�ť
		webtest.click("xpath=//td[@title='��һ��']");//����������ť
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
	
	@Test(priority=5)
	public void adddate6() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//td[@title='�¸���']");//����·����Ұ�ť
		webtest.click("xpath=//td[@title='�¸���']");//����·����Ұ�ť
		webtest.click("xpath=//td[@title='�ϸ���']");//����·�����ť
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
	
	@Test(priority=6)
	public void adddate7() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//td[@title='����']");//�������
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	assertTrue(webtest.getHtmlSource().contains("�������� "));//����
    	webtest.leaveFrame();
	}
	
	@Test(priority=7)
	public void adddate8() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//a[text()='����']");//�������
		webtest.click("xpath=//input[@name='enddt']");//�����ֹ������ʾ��������
		webtest.click("xpath=//td[@title='��һ��']");//���������Ұ�ť
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("��������ɹ� "));//����
	}
	
	@Test(priority=8)
	public void adddate9() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//������ҳ��
		webtest.type("xpath=//textarea[@name='content']","�ձ�");//����Ϸ�����(������)
		
		webtest.click("xpath=//input[@name='dt']");//���������ʾ��������
		webtest.click("xpath=//a[text()='����']");//�������
		webtest.click("xpath=//input[@name='enddt']");//�����ֹ������ʾ��������
		webtest.click("xpath=//td[@title='��һ��']");//����������ť
		webtest.click("xpath=//a[text()='ȷ��']");//���ȷ��
		
    	webtest.click("xpath=//input[@class='webbtn']");//�������
    	assertTrue(webtest.getHtmlSource().contains("���ڲ��Ϸ�"));//����
    	webtest.leaveFrame();
	}
}
