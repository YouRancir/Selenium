package com.test.record;//��Ա����ҳ��Թؼ��������ֶμ���ť����֤(5����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Search extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void searchsuccess() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//������Ա����ҳ��
		webtest.type("xpath=//input[@placeholder='�ؼ���']","����");//����ؼ��������,�����¼��Ϣ���ѱ������Ĺؼ��֣����磺����
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("����"));//����
	}
	
	@Test(priority=1)
	public void searchfail1(){
		webtest.type("xpath=//input[@placeholder='�ؼ���']","������");//����ؼ��������,�����¼��Ϣ�в������Ĺؼ��֣����磺������
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("����"));//����
	}
	
	@Test(priority=2)
	public void searchfail2(){
		webtest.type("xpath=//input[@placeholder='�ؼ���']","\t%%%");//����ؼ��������,���벻�Ϸ��Ĺؼ��֣����磺\t%%%
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("����"));//����
	}
	
	@Test(priority=3)
	public void searchfail3(){
		webtest.type("xpath=//input[@placeholder='�ؼ���']","2017-01-05");//����ؼ��������,����Ϸ������ڹؼ��֣����磺2017-01-05
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("2017-01-05"));//����
	}
	
	@Test(priority=4)
	public void searchfail4(){
		webtest.type("xpath=//input[@placeholder='�ؼ���']","����Ա");//����ؼ��������,����Ϸ��Ĺؼ��֣����磺����Ա
		webtest.click("xpath=//button[@click='searchbtn']");//�������
		assertTrue(webtest.getHtmlSource().contains("����Ա"));//����
	}
} 
