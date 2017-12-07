package com.test.dailypaper;//分页验证(1条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Page extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void page() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//点击工作日报
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
		webtest.click("xpath=//button[@title='下一页']");//点击>按钮
		webtest.click("xpath=//button[@title='上一页']");//点击<按钮
		webtest.click("xpath=//button[@title='尾页']");//点击》按钮
		webtest.click("xpath=//button[@title='首页']");//点击《按钮
    	assertTrue(webtest.getHtmlSource().contains("2017 "));//断言
	}
}
