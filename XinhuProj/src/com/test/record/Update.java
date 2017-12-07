package com.test.record;//对更新数据按钮点击的验证(2条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Update extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void state1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//进入人员档案页面
		webtest.click("xpath=//button[@class='btn btn-success']");//点击更新数据
		assertTrue(webtest.getHtmlSource().contains("更新了"));//断言
	}
	
	@Test
	public void state2() throws InterruptedException{
		webtest.click("xpath=//td[@cell='1']");//选中一条数据
		webtest.click("xpath=//button[@class='btn btn-success']");//再点击更新数据
		assertTrue(webtest.getHtmlSource().contains("更新了"));//断言
	}
}
