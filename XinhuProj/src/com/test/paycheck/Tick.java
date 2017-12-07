package com.test.paycheck;//勾选记录、取消勾选(2条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Tick extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void tick1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//div[@id='menu_list_num98']");//点击薪资管理
		webtest.click("xpath=//div[@id='menu_list_num99']");//进入薪资核算页面
		
		webtest.click("xpath=//input[@value='22']");
		webtest.click("xpath=//input[@value='21']");//勾选第3、4条记录
		
		webtest.click("xpath=//input[@value='22']");
		webtest.click("xpath=//input[@value='21']");//取消勾选第3、4条记录
		assertTrue(webtest.getHtmlSource().contains("人事考勤"));//断言
	}
	
	@Test
	public void tick2() throws InterruptedException{
		webtest.click("xpath=//input[starts-with(@id,'seltablecheck')]");//点击列名勾选框，勾选所有
		webtest.click("xpath=//input[starts-with(@id,'seltablecheck')]");//再次点击列名勾选框，勾选所有
		assertTrue(webtest.getHtmlSource().contains("人事考勤"));//断言
	}
}
