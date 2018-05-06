package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.ait.Init;



public class LoginPage {

		WebDriver driver;
		
		@FindBy(name = "userName")
		WebElement loginField;
		
		@FindBy(name = "password")
		WebElement passwordField;
		
		@FindBy(linkText = "SIGN-ON")
		WebElement signOnBtn;
		
		@FindBy(name = "login")
		WebElement loginBtn;
		
		public LoginPage() {
			driver = Init.getDriver();
			PageFactory.initElements(driver, this);
		}
		
		public void login(String login, String password) {
			Init.log("Loguje się jako: " + login + " " + password);
			loginField.sendKeys(login);
			passwordField.sendKeys(password);
			Init.log("Klikam w login");
			loginBtn.click();
		}
		
		public void goToLoginPage() {
			signOnBtn.click();
		}
}
