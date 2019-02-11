package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quanta.base.TestBase;
import com.quanta.pages.Homepage;
import com.quanta.pages.Loginpage;
import com.quanta.pages.Myservicepage;
import com.quanta.pages.Profilepage;

public class ProfilePageTest  extends TestBase {
	
	Loginpage loginPageTest;
	Homepage homepagetest;
	Profilepage profilepageTest;
	
	public ProfilePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPageTest = new Loginpage();
		homepagetest = new Homepage();
		profilepageTest = new Profilepage();
		homepagetest.clickOnlogin();
		loginPageTest.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void profilePageTest() throws InterruptedException{
		Myservicepage Myservicepage = profilepageTest.profilepage();
		Assert.assertNotNull(Myservicepage);
	}
	
	@Test(priority=2)
	public void getEmailAddress() throws InterruptedException{
		profilepageTest.profilepage();
		String title = profilepageTest.getemailaddress();
		Assert.assertEquals(title, prop.getProperty("username"));
	}
	
	@Test(priority=3)
	public void validateMobileNumber(){
		profilepageTest.profilepage();
		boolean isValid = profilepageTest.mobilenumber();
		Assert.assertTrue(isValid);
	}
	
	@Test(priority=4)
	public void takeScreenshot() throws IOException{
		profilepageTest.profilepage();
		boolean isValid = profilepageTest.takingscreenshot();
		Assert.assertTrue(isValid);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
