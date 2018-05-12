package pl.ait;

import org.junit.*;
import org.openqa.selenium.WebDriver;


import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.Reservation2Page;
import pl.lait.pageObjects.ReservationPage;

public class Login2Test {
	WebDriver driver = null;
	
	@Ignore
	@Before
	public void open() {
		driver = Init.getDriver();
	}
	
	@Ignore
	@Test
	public void loginWithPageObjects() {
		//System.out.println("--test3");
		//powyższe zastąpione metodą log z klasy Init
		Init.log("Test z logowaniem i wypełnieniem formularza"
				+ " rezerwacji lotu");
		
		LoginPage loginPage = new LoginPage();
		ReservationPage reservPage = new ReservationPage();
		Reservation2Page reserv2Page = new Reservation2Page();
		
		loginPage.goToLoginPage();
		loginPage.login("tutorial", "tutorial");
		Init.printScr(driver);
		Init.sleep(10);
		
		// poniższe opóznienie zastąpione metodą sleep - z klasy Init 
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		reservPage.oneWayRadioClick();
		reservPage.roundTripRadioClick();
		reservPage.setPassengersCount("2");
		reservPage.setFromDate("May", "10");
		reservPage.setDepartingFromDest("London");
		Init.sleep(3);
		reservPage.setToDate("May", "15");
		reservPage.setArrivingInDest("Paris");
		reservPage.setBusinessClass();
		reservPage.setAirline("Pangea Airlines");
		Init.sleep(3);
		reservPage.continueButtonClick();
		Init.sleep(5);
		reserv2Page.departRadioClick();
		reserv2Page.returnRadioClick();
		reserv2Page.continueButtonClick();
		Init.sleep(5);
		
		Init.printScr(driver);
	}
	
	@After
	public void tearDown() {
		Init.endTest();
	}

}
