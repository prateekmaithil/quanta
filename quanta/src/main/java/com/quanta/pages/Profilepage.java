package com.quanta.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quanta.base.TestBase;
import com.quanta.utility.Util;

public class Profilepage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//*[contains(@class,'headerPic') and contains(@class,'learner-profile-alt')]")
	WebElement userloginsymbol;
		
	@FindBy(xpath="//a[@class='profile-icon']")
	WebElement profilepagelink;
		
	@FindBy(xpath="//input[@name='email']")
	WebElement emailaddress;
		
	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//span[contains(text(), 'mobile number field') and contains(@class, 'help is-danger')]")
	WebElement emailaddressValidation;
		
	@FindBy(xpath="//*[contains(text(),'My Services')]")
	WebElement myservices;
			
	//Initializing the Page Objects:
	public Profilepage(){
		PageFactory.initElements(driver, this);
	}
		
	//Actions:
	
		
	public Myservicepage profilepage(){
		waitForPageLoaded();		
	//	WaitUntilElementVisible(By.xpath(".//*[contains(@class,'headerPic') and contains(@class,'learner-profile-alt')]"));
		userloginsymbol.click();
		profilepagelink.click();			
		Util.switchToNewTab(1);
		waitForPageLoaded();
		return new Myservicepage();
	}
	
	public String getemailaddress() throws InterruptedException{	
			String text = emailaddress.getText();
			System.out.println("email ::" + text);
			return text;
	}
		
	public boolean mobilenumber(){		
		mobile.clear();
		mobile.sendKeys(prop.getProperty("mobile"));
		boolean isValid = emailaddressValidation.isDisplayed();
		return isValid;
	}
		
	public boolean takingscreenshot() throws IOException{
		Util screenshot  = new Util();
		screenshot.takeScreenshotAtEndOfTest();	
		return true;
	}
	
	public Myservicepage goToMyServices(){
		myservices.click();
		waitForPageLoaded();	
		return new Myservicepage();
	}
}
	


