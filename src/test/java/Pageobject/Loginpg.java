package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;


public class Loginpg {
		 public WebDriver driver;
			
			@FindBy(id="username")
			WebElement username;
			@FindBy(xpath="//input[@id='password']")
			WebElement password;
			@FindBy(xpath="//button[@id='submit']")
			WebElement Submit;
			@FindBy(xpath="//h1[normalize-space()='Logged In Successfully']")
			WebElement successmessage;
			@FindBy(xpath="//a[normalize-space()='Log out']")
			WebElement Logout;
		
		    public Loginpg(WebDriver driver) {
		    	this.driver=driver;
		    	PageFactory.initElements(driver, this);
		    	
		    }
			public void enterUser(String userid) {
			
				username.sendKeys(userid);
			}
			public void enterPass(String pass) {
				password.sendKeys(pass);
			}
			public void submitRq() {
				Submit.click();
				
				
			}
			public void Success() {
				String str=successmessage.getText();
				
				Assert.assertEquals(str,"Logged In Successfully");
				System.out.println(str+" with page factory");
			}
			public void logOut() {
				Logout.click();
			}
		}




