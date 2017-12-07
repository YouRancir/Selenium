package com.test.login;//使用页面对象模式编写登陆信呼系统之后进入指定页面的测试用例(1条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class LoginPageTest extends BaseTest{
	Login_Action action=null;
	
	@BeforeMethod
	public void be(){
		webtest.open("http://localhost:8032/xinhu/");//打开信呼登录页面
	}
	
	@Test
	public void test() throws InterruptedException{	
		LoginPageObject page = new LoginPageObject(driver);
		page.successlogin();
		Thread.sleep(3000);
		assertTrue(webtest.getHtmlSource().contains("个人办公"));//断言
	}	
}
