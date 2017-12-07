package com.test.record;//点击详情(新窗口)显示页面(1条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Detailsnew extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void details() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//进入人员档案页面
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='1']");//点击详情(新窗口)
		assertTrue(webtest.getHtmlSource().contains("人员档案"));//断言
	}
}
