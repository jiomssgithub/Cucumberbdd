package StepDefinition;

import org.openqa.selenium.WebDriver;

import Pageobject.Loginpg;

public class BaseClass{
	public  WebDriver driver;
	public Loginpg loginpage;
    
	
	
	public void browserQuit() {
		driver.close();
		driver.quit();
	}
}
