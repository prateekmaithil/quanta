package com.quanta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quanta.base.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath="//a[contains(@class,'openLogin')]")
	WebElement loginb;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	
	public Loginpage clickOnlogin(){
		WaitUntilElementVisible(loginb);
		loginb.click();
		return new Loginpage();
	}
}


	
	
	
