package com.test.paycheck;//新增核算对应人字段验证(3条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Addperson extends BaseTest{
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
		webtest.click("xpath=//button[@class='btn btn-primary']");//点击新增核算	
		
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//a[@id='btnchange_uname']");//点击选择
		webtest.click("xpath=//td[@deptxu='1_1']");//点击管理层
		webtest.click("xpath=//input[@xname='磐石']");//勾选磐石
		webtest.click("xpath=//input[@value='确定']");//点击确定
		webtest.click("xpath=//input[@value='保存(S)']");//点击保存
		assertTrue(webtest.getHtmlSource().contains("月份超前了"));//断言
		webtest.leaveFrame();
	}
	
	@Test
	public void tick2() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//a[@class='webbtn']");//点击清除
		webtest.click("xpath=//input[@value='初始数据']");//点击初始数据
		assertTrue(webtest.getHtmlSource().contains("请选择人员"));//断言
		webtest.leaveFrame();
	}
	
	@Test
	public void tick3() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//a[@id='btnchange_uname']");//点击选择
		webtest.click("xpath=//td[@deptxu='1_1']");//点击管理层
		webtest.click("xpath=//input[@xname='磐石']");//勾选磐石
		webtest.click("xpath=//input[@value='确定']");//点击确定
		webtest.click("xpath=//a[@class='webbtn']");//点击清除
		webtest.click("xpath=//input[@value='保存(S)']");//点击保存
		assertTrue(webtest.getHtmlSource().contains("对应人不能为空"));//断言
		webtest.leaveFrame();
	}
}
