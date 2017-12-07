package com.test.record;//评论字段验证(6条测试用例)

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.login.Login_Action;
import com.webtest.core.BaseTest;

public class Comment extends BaseTest{
    Login_Action action=null;
	
	@BeforeClass
	public void beforeAction() throws InterruptedException{
		action =new Login_Action(webtest);
		action.login("admin", "123456");
    } 
	
	@Test(priority=0)
	public void commentyes() throws InterruptedException{
		webtest.click("xpath=//span[@pmenuid='27']");
		webtest.click("xpath=//span[@id='menu_down_isons_num84']");
		webtest.click("xpath=//div[@id='menu_list_num85']");//进入人员档案页面
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='2']");//点击评论
		webtest.click("xpath=//button[@sattr='yes']");//不输入内容直接点击确定
		assertTrue(webtest.getHtmlSource().contains("没有输入"));//断言 
	}
	
	@Test(priority=1)
	public void commentno() throws InterruptedException{
		webtest.click("xpath=//button[@sattr='no']");//不输入内容直接点击取消
		assertTrue(webtest.getHtmlSource().contains("所有档案"));//断言 
	}
	
	@Test(priority=2)
	public void commentinput1() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='2']");//点击评论
		webtest.type("xpath=//textarea[@class='input']","啦啦啦");//输入合法说明内容
		webtest.click("xpath=//button[@sattr='yes']");//点击确定
		assertTrue(webtest.getHtmlSource().contains("处理成功"));//断言 
	}
	
	@Test(priority=3)
	public void commentinput2() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='2']");//点击评论
		webtest.type("xpath=//textarea[@class='input']","啦啦啦");//输入合法说明内容
		webtest.click("xpath=//button[@sattr='no']");//点击取消
		assertTrue(webtest.getHtmlSource().contains("所有档案"));//断言
	}
	
	@Test(priority=4)
	public void commentinput3() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='2']");//点击评论
		webtest.type("xpath=//textarea[@class='input']","\t%%%%%%");//输入不合法说明内容
		webtest.click("xpath=//button[@sattr='yes']");//点击确定
		assertTrue(webtest.getHtmlSource().contains("内容不合法"));//断言
	}
	
	@Test(priority=5)
	public void commentinput4() throws InterruptedException{
		webtest.click("xpath=//a[@oi='2' and @oj='10']");//点击操作
		webtest.click("xpath=//li[@temp='2']");//点击评论
		webtest.type("xpath=//textarea[@class='input']","文明，是历史以来沉淀下来的，有益增强人类对客观世界的适应和认知、符合人类精神追求、"
				+ "能被绝大多数人认可和接受的人文精神、发明创造以及公序良俗的总和。文明是使人类脱离野蛮状态的所有社会行为和自然行为构成的集合，这些集"
				+ "合至少包括了以下要素：家族观念、工具、语言、文字、信仰、宗教观念、法律、城邦和国家等等。由于各种文明要素在时间和地域上的分布并不均匀"
				+ "，产生了具有显而易见区别的各种文明，具体到现代，就是西方文明，阿拉伯文明，东方文明，古印度文明四大文明，以及由多个文明交汇融合形成的"
				+ "俄罗斯文明，土耳其文明，大洋文明和东南亚文明等在某个文明要素上体现出独特性质的亚文明。");//输入超过限定长度的说明内容
		webtest.click("xpath=//button[@sattr='yes']");//点击确定
		assertTrue(webtest.getHtmlSource().contains("内容超过字符限制"));//断言
	}
}
