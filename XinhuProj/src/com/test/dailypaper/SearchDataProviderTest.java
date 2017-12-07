package com.test.dailypaper;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

//关键字搜索字段验证使用数据驱动(5条测试用例)
public class SearchDataProviderTest extends BaseTest{
	Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
		webtest.click("xpath=//span[@pmenuid='27']");//点击人事考勤
		webtest.click("xpath=//span[@id='menu_down_isons_num192']");//点击工作日报
		webtest.click("xpath=//div[@id='menu_list_num193']");//进入所有日报页面
    } 
	
	@Test(dataProvider="TD1",dataProviderClass=SearchDataProvider.class)
	public void test1(String keyword){
		webtest.typeAndClear("xpath=//input[@placeholder='关键字']", keyword);//参数化输入关键字
		webtest.click("xpath=//button[text()='搜索']");//点击搜索
	}
}
