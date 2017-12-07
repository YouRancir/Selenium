package com.test.login;//页面对象模式-登录

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	public WebDriver _driver;
	@FindBy(name="adminuser")
	public WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(name="button")
	public WebElement loginbutton;
	
	public LoginPageObject(WebDriver driver){
		this._driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void successlogin() throws InterruptedException{
		this.username.sendKeys("admin");
		this.password.sendKeys("123456");
		this.loginbutton.click();		
    }
}
