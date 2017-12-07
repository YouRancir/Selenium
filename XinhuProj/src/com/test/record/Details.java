package com.test.record;//点击详情显示页面(1条测试用例)

import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Details extends BaseTest{
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
		webtest.click("xpath=//li[@temp='0']");//点击详情
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//img[@align='absmiddle']");//点击处理记录右侧下拉图标
		webtest.click("xpath=//img[@align='absmiddle']");//再次点击处理记录右侧下拉图标
		webtest.click("xpath=//a[@temp='clo']");//点击处理记录右侧删除图标
		webtest.click("xpath=//a[@temp='clo']");//点击查阅记录右侧删除图标
		assertFalse(webtest.getHtmlSource().contains("查阅记录"));//断言
		webtest.click("xpath=//div[@id='winiframe_spancancel']");//点击退出详情页面
		webtest.leaveFrame();
	}
}
