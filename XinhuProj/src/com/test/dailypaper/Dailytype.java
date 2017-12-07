package com.test.dailypaper;//新增日报类型(1条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Dailytype extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void type() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//点击工作日报
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
		webtest.click("xpath=//button[@click='clickwin,0']");//点击新增
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//select[@class='inputs']");//点击日报类型显示下拉菜单内容
		webtest.selectByIndex("name=type", 1);//点击选择日报
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
}
