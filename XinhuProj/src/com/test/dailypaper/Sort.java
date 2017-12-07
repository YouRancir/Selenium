package com.test.dailypaper;//点击排序按钮(3条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Sort extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test
	public void sort1() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
		webtest.click("xpath=//i[@tempsort='2']");//点击日报类型的排序按钮，顺序排序
		webtest.click("xpath=//i[@tempsort='2']");//再次点击日报类型的排序按钮，倒序排序
		assertTrue(webtest.getHtmlSource().contains("日报类型"));//断言
	}
	
	@Test(dependsOnMethods="sort1")
	public void sort2() throws InterruptedException{
		webtest.click("xpath=//i[@tempsort='3']");//点击日期的排序按钮，顺序排序
		webtest.click("xpath=//i[@tempsort='3']");//再次点击日期的排序按钮，倒序排序
		assertTrue(webtest.getHtmlSource().contains("日报类型"));//断言
	}
	
	@Test(dependsOnMethods="sort2")
	public void sort3() throws InterruptedException{
		webtest.click("xpath=//i[@tempsort='6']");//点击操作时间的排序按钮，顺序排序
		webtest.click("xpath=//i[@tempsort='6']");//再次点击操作时间的排序按钮，倒序排序
		assertTrue(webtest.getHtmlSource().contains("日报类型"));//断言
	}
}
