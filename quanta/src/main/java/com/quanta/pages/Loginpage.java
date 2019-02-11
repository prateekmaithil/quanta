package com.quanta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quanta.base.TestBase;

public class Loginpage extends TestBase {

	//Page Factory - OR:
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
		
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
		
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;		
			
	//Initializing the Page Objects:
	public Loginpage(){
		PageFactory.initElements(driver, this);
	}
		
	//Actions:
	public Profilepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
	    loginBtn.click();
		return new Profilepage();
	}
}
