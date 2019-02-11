package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quanta.base.TestBase;
import com.quanta.pages.Homepage;
import com.quanta.pages.Loginpage;

public class HomePageTest extends TestBase {
	
	Homepage homepagetest;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		homepagetest = new Homepage();
	}
	
	@Test(priority=1)
	public void homePageTest(){
		Loginpage loginPage = homepagetest.clickOnlogin();
		Assert.assertNotNull(loginPage);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
