package com.test.daohang;//对于登陆系统后进入人员档案页面之前的点击操作的验证(1条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Click extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void click() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");//点击人事档案
		webtest.click("xpath=//div[@id='menu_list_num85']");//点击人员档案
		assertTrue(webtest.getHtmlSource().contains("人员档案"));//断言
	}
}
