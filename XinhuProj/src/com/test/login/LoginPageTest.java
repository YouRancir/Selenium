package com.test.login;//ʹ��ҳ�����ģʽ��д��½�ź�ϵͳ֮�����ָ��ҳ��Ĳ�������(1����������)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class LoginPageTest extends BaseTest{
	Login_Action action=null;
	
	@BeforeMethod
	public void be(){
		webtest.open("http://localhost:8032/xinhu/");//���ź���¼ҳ��
	}
	
	@Test
	public void test() throws InterruptedException{	
		LoginPageObject page = new LoginPageObject(driver);
		page.successlogin();
		Thread.sleep(3000);
		assertTrue(webtest.getHtmlSource().contains("���˰칫"));//����
	}	
}
