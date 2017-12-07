package com.test.dailypaper;//新增日期(9条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Adddate extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void adddate1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//点击工作日报
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
		webtest.click("xpath=//button[@click='clickwin,0']");//点击新增
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//select[@class='inputs']");//点击日报类型显示下拉菜单内容
		webtest.selectByIndex("name=type", 1);//点击选择日报
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//a[text()='清空']");//点击清空
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("日期不能为空 "));//断言
	}
	
	@Test(priority=1)
	public void adddate2() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//a[text()='现在']");//点击现在
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
	
	@Test(priority=2)
	public void adddate3() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//td[text()='23']");//点击23
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
	
	@Test(priority=3)
	public void adddate4() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//a[text()='关闭']");//点击关闭
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	assertTrue(webtest.getHtmlSource().contains("已申请了 "));//断言
    	webtest.leaveFrame();
	}
	
	@Test(priority=4)
	public void adddate5() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//td[@title='下一年']");//点击年份向右按钮
		webtest.click("xpath=//td[@title='下一年']");//点击年份向右按钮
		webtest.click("xpath=//td[@title='上一年']");//点击年份向左按钮
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
	
	@Test(priority=5)
	public void adddate6() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//td[@title='下个月']");//点击月份向右按钮
		webtest.click("xpath=//td[@title='下个月']");//点击月份向右按钮
		webtest.click("xpath=//td[@title='上个月']");//点击月份向左按钮
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
	
	@Test(priority=6)
	public void adddate7() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//td[@title='当月']");//点击当月
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	assertTrue(webtest.getHtmlSource().contains("已申请了 "));//断言
    	webtest.leaveFrame();
	}
	
	@Test(priority=7)
	public void adddate8() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//a[text()='现在']");//点击现在
		webtest.click("xpath=//input[@name='enddt']");//点击截止日期显示日期内容
		webtest.click("xpath=//td[@title='下一年']");//点击年份向右按钮
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	webtest.leaveFrame();
    	assertTrue(webtest.getHtmlSource().contains("新增保存成功 "));//断言
	}
	
	@Test(priority=8)
	public void adddate9() throws InterruptedException{
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.type("xpath=//textarea[@name='content']","日报");//输入合法内容(必填项)
		
		webtest.click("xpath=//input[@name='dt']");//点击日期显示日期内容
		webtest.click("xpath=//a[text()='现在']");//点击现在
		webtest.click("xpath=//input[@name='enddt']");//点击截止日期显示日期内容
		webtest.click("xpath=//td[@title='上一年']");//点击年份向左按钮
		webtest.click("xpath=//a[text()='确定']");//点击确定
		
    	webtest.click("xpath=//input[@class='webbtn']");//点击保存
    	assertTrue(webtest.getHtmlSource().contains("日期不合法"));//断言
    	webtest.leaveFrame();
	}
}
