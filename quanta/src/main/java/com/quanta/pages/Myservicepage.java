package com.quanta.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quanta.base.TestBase;

public class Myservicepage extends TestBase  {

	@FindBy(xpath=".//button[@class='btn btn-green-bordered'] [text()='launch']")
	WebElement Quantra;
	
	@FindBy(xpath=".//button[@class='btn btn-blue-bordered'] [text()='enroll']")
	WebElement Epat;
	
	@FindBy(xpath=".//a[text()='Logout']")
	WebElement logoutButton;
	
	//Initializing the Page Objects:
	public Myservicepage(){
		PageFactory.initElements(driver, this);
	}
	
	public String quantraclicking(){
		Quantra.click();
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
			
	public void returnback(){
		driver.navigate().back();
	}
				
	public String epathome(){
		Epat.click();
		String title = driver.getTitle();
		System.out.println(title);
		return title;
		
	}
				
	public void returnbackeat(){
		driver.navigate().back();
	}
	
	public void logOut(){
		logoutButton.click();
	}
}
