package com.test.dailypaper;//点击所有日报按钮(3条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Allpaper extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void all1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//点击工作日报
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
		webtest.click("xpath=//button[@click='changatype,all']");//点击所有日报按钮
		assertTrue(webtest.getHtmlSource().contains("所有日报"));//断言
	}
	
	@Test(dependsOnMethods="all1")
	public void all2() throws InterruptedException{
		webtest.type("xpath=//input[@placeholder='关键字']","开发部");//点击关键字输入框,输入记录信息中已被包含的关键字，例如：开发部
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		webtest.click("xpath=//button[@click='changatype,all']");//点击所有日报按钮
		assertTrue(webtest.getHtmlSource().contains("所有日报"));//断言
	}
	
	@Test(dependsOnMethods="all2")
	public void all3() throws InterruptedException{
		webtest.type("xpath=//input[@placeholder='关键字']","啦啦啦");//点击关键字输入框,输入记录信息中不被包含的关键字，例如：啦啦啦
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		webtest.click("xpath=//button[@click='changatype,all']");//点击所有日报按钮
		assertTrue(webtest.getHtmlSource().contains("所有日报"));//断言
	}
}
