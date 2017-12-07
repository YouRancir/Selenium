package com.test.record;//人员档案页面对关键字搜索字段及按钮的验证(5条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Search extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void searchsuccess() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//进入人员档案页面
		webtest.type("xpath=//input[@placeholder='关键字']","财务部");//点击关键字输入框,输入记录信息中已被包含的关键字，例如：财务部
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("财务部"));//断言
	}
	
	@Test(priority=1)
	public void searchfail1(){
		webtest.type("xpath=//input[@placeholder='关键字']","啦啦啦");//点击关键字输入框,输入记录信息中不包含的关键字，例如：啦啦啦
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("搜索"));//断言
	}
	
	@Test(priority=2)
	public void searchfail2(){
		webtest.type("xpath=//input[@placeholder='关键字']","\t%%%");//点击关键字输入框,输入不合法的关键字，例如：\t%%%
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("搜索"));//断言
	}
	
	@Test(priority=3)
	public void searchfail3(){
		webtest.type("xpath=//input[@placeholder='关键字']","2017-01-05");//点击关键字输入框,输入合法的日期关键字，例如：2017-01-05
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("2017-01-05"));//断言
	}
	
	@Test(priority=4)
	public void searchfail4(){
		webtest.type("xpath=//input[@placeholder='关键字']","管理员");//点击关键字输入框,输入合法的关键字，例如：管理员
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("管理员"));//断言
	}
} 
