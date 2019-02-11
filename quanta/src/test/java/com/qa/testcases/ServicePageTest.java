package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quanta.base.TestBase;
import com.quanta.pages.Homepage;
import com.quanta.pages.Loginpage;
import com.quanta.pages.Myservicepage;
import com.quanta.pages.Profilepage;
import com.quanta.utility.Util;

public class ServicePageTest  extends TestBase {
	
	Loginpage loginPageTest;
	Homepage homepagetest;
	Profilepage profilepageTest;
	Myservicepage MyservicepageTest;
	
	public ServicePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPageTest = new Loginpage();
		homepagetest = new Homepage();
		profilepageTest = new Profilepage();
		MyservicepageTest = new Myservicepage();
		homepagetest.clickOnlogin();
		loginPageTest.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void servicePageTest() throws InterruptedException{
		profilepageTest.profilepage();
		Myservicepage MyservicepageObj = profilepageTest.goToMyServices();
		Assert.assertNotNull(MyservicepageObj);
	}
	
	@Test(priority=2)
	public void EpatButtonClick() throws InterruptedException{
		profilepageTest.profilepage();
		profilepageTest.goToMyServices();
		String title = MyservicepageTest.epathome();
		Util.switchToNewTab(2);
		Assert.assertNotNull(title);
	}
	
	@Test(priority=3)
	public void quantraButtonClick() throws InterruptedException{
		profilepageTest.profilepage();
		profilepageTest.goToMyServices();
		String title = MyservicepageTest.quantraclicking();
		Util.switchToNewTab(2);
		Assert.assertNotNull(title);
	}
	
	@Test(priority=4)
	public void logOutTest() throws InterruptedException{
		profilepageTest.profilepage();
		profilepageTest.goToMyServices();
		MyservicepageTest.logOut();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
