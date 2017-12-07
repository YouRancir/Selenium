package com.test.dailypaper;//�������ť(3����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Sort extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void sort1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");
		webtest.click("xpath=//div[@id='menu_list_num193']");//���������ձ�ҳ��
		webtest.click("xpath=//i[@tempsort='2']");//����ձ����͵�����ť��˳������
		webtest.click("xpath=//i[@tempsort='2']");//�ٴε���ձ����͵�����ť����������
		assertTrue(webtest.getHtmlSource().contains("�ձ�����"));//����
	}
	
	@Test(dependsOnMethods="sort1")
	public void sort2() throws InterruptedException{
		webtest.click("xpath=//i[@tempsort='3']");//������ڵ�����ť��˳������
		webtest.click("xpath=//i[@tempsort='3']");//�ٴε�����ڵ�����ť����������
		assertTrue(webtest.getHtmlSource().contains("�ձ�����"));//����
	}
	
	@Test(dependsOnMethods="sort2")
	public void sort3() throws InterruptedException{
		webtest.click("xpath=//i[@tempsort='6']");//�������ʱ�������ť��˳������
		webtest.click("xpath=//i[@tempsort='6']");//�ٴε������ʱ�������ť����������
		assertTrue(webtest.getHtmlSource().contains("�ձ�����"));//����
	}
}
