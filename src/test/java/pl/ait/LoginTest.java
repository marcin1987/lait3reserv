package pl.ait;

//import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static pl.ait.Init.getDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginTest {
	
	WebDriver driver = null;
	
	@Before
	public void openPage() {
		driver = getDriver();
		
	}
	@Ignore
	@Test
	public void clickOnMenuItems() {
		
		System.out.println(driver.getTitle()); //wyświetla tytuł
		assertTrue("Nie odnaleziono strony", driver.getTitle().equals("Welcome: Mercury Tours"));//sprawdza czy pobrany tyt jest zgodny z założeniem/warunkiem
		
		
		System.out.println("test click clickOnMenuItems");
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("CONTACT")).click();
			
	}
	
	@Ignore
	@Test
	public void logIn() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		assertTrue("Nie odnaleziono strony", driver.getTitle().equals("Sign-on: Mercury Tours"));
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
		
	}
	

	@After
	public void tearDown() {
		Init.endTest();
		
	}
}
