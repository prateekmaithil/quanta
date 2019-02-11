package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quanta.base.TestBase;
import com.quanta.pages.Homepage;
import com.quanta.pages.Loginpage;
import com.quanta.pages.Profilepage;

public class LoginPageTest  extends TestBase {
	
	Loginpage loginPageTest;
	Homepage homepagetest;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPageTest = new Loginpage();
		homepagetest = new Homepage();
		homepagetest.clickOnlogin();
	}
	
	@Test(priority=1)
	public void loginPageTest(){
		Profilepage profilePage = loginPageTest.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertNotNull(profilePage);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
