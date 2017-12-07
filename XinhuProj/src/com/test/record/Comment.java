package com.test.record;//�����ֶ���֤(6����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Comment extends BaseTest{
    Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void commentyes() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//������Ա����ҳ��
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//�������
		webtest.click("xpath=//li[@temp='2']");//�������
		webtest.click("xpath=//button[@sattr='yes']");//����������ֱ�ӵ��ȷ��
		assertTrue(webtest.getHtmlSource().contains("û������"));//���� 
	}
	
	@Test(priority=1)
	public void commentno() throws InterruptedException{
		webtest.click("xpath=//button[@sattr='no']");//����������ֱ�ӵ��ȡ��
		assertTrue(webtest.getHtmlSource().contains("���е���"));//���� 
	}
	
	@Test(priority=2)
	public void commentinput1() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//�������
		webtest.click("xpath=//li[@temp='2']");//�������
		webtest.type("xpath=//textarea[@class='input']","������");//����Ϸ�˵������
		webtest.click("xpath=//button[@sattr='yes']");//���ȷ��
		assertTrue(webtest.getHtmlSource().contains("����ɹ�"));//���� 
	}
	
	@Test(priority=3)
	public void commentinput2() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//�������
		webtest.click("xpath=//li[@temp='2']");//�������
		webtest.type("xpath=//textarea[@class='input']","������");//����Ϸ�˵������
		webtest.click("xpath=//button[@sattr='no']");//���ȡ��
		assertTrue(webtest.getHtmlSource().contains("���е���"));//����
	}
	
	@Test(priority=4)
	public void commentinput3() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//�������
		webtest.click("xpath=//li[@temp='2']");//�������
		webtest.type("xpath=//textarea[@class='input']","\t%%%%%%");//���벻�Ϸ�˵������
		webtest.click("xpath=//button[@sattr='yes']");//���ȷ��
		assertTrue(webtest.getHtmlSource().contains("���ݲ��Ϸ�"));//����
	}
	
	@Test(priority=5)
	public void commentinput4() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//�������
		webtest.click("xpath=//li[@temp='2']");//�������
		webtest.type("xpath=//textarea[@class='input']","����������ʷ�������������ģ�������ǿ����Կ͹��������Ӧ����֪���������ྫ��׷��"
				+ "�ܱ�����������Ͽɺͽ��ܵ����ľ��񡢷��������Լ��������׵��ܺ͡�������ʹ��������Ұ��״̬�����������Ϊ����Ȼ��Ϊ���ɵļ��ϣ���Щ��"
				+ "�����ٰ���������Ҫ�أ����������ߡ����ԡ����֡��������ڽ̹�����ɡ��ǰ�͹��ҵȵȡ����ڸ�������Ҫ����ʱ��͵����ϵķֲ���������"
				+ "�������˾����Զ��׼�����ĸ������������嵽�ִ�����������������������������������������ӡ�������Ĵ��������Լ��ɶ�����������ں��γɵ�"
				+ "����˹���������������������������Ͷ�������������ĳ������Ҫ�������ֳ��������ʵ���������");//���볬���޶����ȵ�˵������
		webtest.click("xpath=//button[@sattr='yes']");//���ȷ��
		assertTrue(webtest.getHtmlSource().contains("���ݳ����ַ�����"));//����
	}
}
