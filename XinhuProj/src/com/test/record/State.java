package com.test.record;//人员档案页面对全部状态按钮的点击操作进行验证(7条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class State extends BaseTest{
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
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='0']");//试用期
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("试用期"));//断言
	}
	
	@Test
	public void state2() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='1']");//正式
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("正式"));//断言
	}
	
	@Test
	public void state3() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='2']");//实习生
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("实习生"));//断言
	}
	
	@Test
	public void state4() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='3']");//兼职
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("兼职"));//断言
	}
	
	@Test
	public void state5() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='4']");//临时工
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("临时工"));//断言
	}
	
	@Test
	public void state6() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='5']");//离职
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("离职"));//断言
	}
	
	@Test
	public void state7() throws InterruptedException{
		webtest.click("xpath=//select[@class='form-control']");//点击全部状态下拉按钮
		webtest.click("xpath=//option[@value='']");//全部状态
		webtest.click("xpath=//button[@click='searchbtn']");//点击搜索
		assertTrue(webtest.getHtmlSource().contains("全部状态"));//断言
	}
}
