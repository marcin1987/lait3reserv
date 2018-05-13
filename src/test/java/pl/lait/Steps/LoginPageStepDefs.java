package pl.lait.Steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import pl.lait.pageObjects.LoginPage;
import pl.ait.Init;

public class LoginPageStepDefs extends Init{
	
	WebDriver driver = null;
	LoginPage loginPage;

	@Given("^I open main page$")
	public void i_open_main_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//loginPage = new LoginPage();
		driver = getDriver();
	}

	@When("^I click on the SIGN-ON link$")
	public void i_click_on_the_SIGN_ON_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("SIGN-ON")).click();
	    
	}

	@Then("^System is on SIGN-ON page$")
	public void system_is_on_SIGN_ON_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String title;
		title = driver.getTitle();
		assertTrue(title.equals("Sign-on: Mercury Tours"));
		printScr(driver);
	}
	
	@When("^I click on the \"([^\"]*)\" link$")
	public void i_click_on_the_link(String arg1) throws Throwable {
	    driver.findElement(By.linkText(arg1)).click();
	}
		
	@When("^I login as \"([^\"]*)\" with password \"([^\"]*)\"$")
	public void i_login_as_with_password(String arg1, String arg2) throws Throwable {
	   loginPage = new LoginPage();
	   loginPage.login(arg1, arg2);
	   printScr(driver);
	}

	@Then("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
	    printScr(driver);
	}
	
	@After
	public void finishTest() {
		endTest();
	}
}
