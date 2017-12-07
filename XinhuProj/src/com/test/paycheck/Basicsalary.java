package com.test.paycheck;//基本工资字段验证(2条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Basicsalary extends BaseTest {
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void salary1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//div[@id='menu_list_num98']");//点击薪资管理
		webtest.click("xpath=//div[@id='menu_list_num99']");//进入薪资核算页面
		webtest.click("xpath=//button[@class='btn btn-primary']");//点击新增核算	
		
		webtest.enterFrame("openinputiframe");//进入子页面
		webtest.click("xpath=//a[@id='btnchange_uname']");//点击选择
		webtest.click("xpath=//td[@deptxu='1_1']");//点击管理层
		webtest.click("xpath=//input[@xname='磐石']");//勾选磐石
		webtest.click("xpath=//input[@value='确定']");//点击确定
		webtest.type("xpath=//input[@name='base']","0");//修改基本工资
		webtest.click("xpath=//input[@value='保存(S)']");//点击保存
		assertTrue(webtest.getHtmlSource().contains("请先初始数据"));//断言
		webtest.leaveFrame();
	}
	
	@Test
	public void salary2() throws InterruptedException{
		webtest.click("xpath=//a[@id='btnchange_uname']");//点击选择
		webtest.click("xpath=//td[@deptxu='1_1']");//点击管理层
		webtest.click("xpath=//input[@xname='磐石']");//勾选磐石
		webtest.click("xpath=//input[@value='确定']");//点击确定
		webtest.type("xpath=//input[@name='base']","0");//修改基本工资
		webtest.click("xpath=//input[@value='初始数据']");//点击初始数据
		assertTrue(webtest.getHtmlSource().contains("初始化完成"));//断言
	}
}
