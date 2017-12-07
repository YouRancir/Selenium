package com.test.record;//������е�����ť(2����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Allrecord extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void all1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//������Ա����ҳ��
		webtest.click("xpath=//button[@click='changatype,all']");//������е�����ť
		assertTrue(webtest.getHtmlSource().contains("���е���"));//����
	}
	
	@Test
	public void all2() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//������Ա����ҳ��
		webtest.type("xpath=//input[@placeholder='�ؼ���']","����");//����ؼ��������,�����¼��Ϣ���ѱ������Ĺؼ��֣����磺����
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		webtest.click("xpath=//button[@click='changatype,all']");//������е�����ť
		assertTrue(webtest.getHtmlSource().contains("���е���"));//����
	}
}
