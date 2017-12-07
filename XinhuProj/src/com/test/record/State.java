package com.test.record;//��Ա����ҳ���ȫ��״̬��ť�ĵ������������֤(7����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class State extends BaseTest{
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
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='0']");//������
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("������"));//����
	}
	
	@Test
	public void state2() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='1']");//��ʽ
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("��ʽ"));//����
	}
	
	@Test
	public void state3() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='2']");//ʵϰ��
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("ʵϰ��"));//����
	}
	
	@Test
	public void state4() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='3']");//��ְ
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("��ְ"));//����
	}
	
	@Test
	public void state5() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='4']");//��ʱ��
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("��ʱ��"));//����
	}
	
	@Test
	public void state6() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='5']");//��ְ
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("��ְ"));//����
	}
	
	@Test
	public void state7() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//���ȫ��״̬������ť
		webtest.click("xpath=//option[@value='']");//ȫ��״̬
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("ȫ��״̬"));//����
	}
}
