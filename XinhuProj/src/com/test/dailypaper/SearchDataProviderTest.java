package com.test.dailypaper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

//�ؼ��������ֶ���֤ʹ����������(5����������)
public class SearchDataProviderTest extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
		webtest.click("xpath=//span[@pmenuid='27']");//������¿���
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//��������ձ�
		webtest.click("xpath=//div[@id='menu_list_num193']");//���������ձ�ҳ��
    } 
	
	@Test(dataProvider="TD1",dataProviderClass=SearchDataProvider.class)
	public void test1(String keyword){
		webtest.typeAndClear("xpath=//input[@placeholder='�ؼ���']", keyword);//����������ؼ���
		webtest.click("xpath=//button[text()='����']");//�������
	}
}
