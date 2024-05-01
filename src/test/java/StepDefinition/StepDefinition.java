package StepDefinition;
import StepDefinition.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pageobject.Loginpg;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends BaseClass
{
	
		// TODO Auto-generated constructor stub
	
	@Before("@regression")
	public void setup() {
		//WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   System.out.println("Setup method executed");
	}
	
	
	
	   

	
	@Given("Browser launch")
	public void browser_launch() {
		
		   loginpage=new Loginpg(driver);
		 

		   
	}
	
	@Given("User open the URL {string}")
	public void user_open_the_url(String url) {
		driver.get(url);
	   
	}

	@When("User enters Userid as {string} password as {string}")
	public void user_enters_userid_as_password_as(String userid, String password) {
		loginpage.enterUser(userid);
		loginpage.enterPass(password);
		
	}

	@When("click on Submit")
	public void click_on_submit() {
		loginpage.submitRq();
	   
	}

	@Then("success message should be {string}")
	public void success_message_should_be(String string) {
		loginpage.Success();
	   
	}

	@Then("Logout")
	public void logout() {
		loginpage.logOut();
	   
	}
	@AfterStep()
	   public void Screenshotforfailed(Scenario scenerio) throws IOException
	   {  Calendar cal=Calendar.getInstance();
	      java.util.Date time=cal.getTime();
	      String timeStamp=time.toString().replace(":", "").replace(" ", "");
		  if(scenerio.isFailed()==true) {
			  String filepath="./Cucumberbdd/Screenshotfolder/testing"+timeStamp+".png";
			  File desti=new File(filepath);
			  TakesScreenshot ts=(TakesScreenshot) driver;
			  File src=ts.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, desti);
			  System.out.println("screenshot captured");
			  
		  }
		   
	   }
	   
	 @After
	   public void tearDown()
	   {
		   browserQuit();
		   System.out.println("tearDown method executed");
	   }


}
