package pl.ait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Init {

	static WebDriver driver = null;

	public static WebDriver getDriver() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\sot_m\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		System.out.println("wewnątrz metody getDriver");
		
		if (driver == null) {
			
			System.out.println("-----------wewnątrz IFa, FF jest już uruchomiony ----------");

			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com");
			return driver;
		
		}else {
			return driver;
		}
	}

	public static void endTest() {
		driver.quit();
		driver = null;
	}
//	public static void sleep(long milis) {
//		try {
//			Thread.sleep(milis);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * usypia wątek na X sekund
	 * @param seconds
	 */
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void log(String tekst) {
		System.out.print("--- ");
		System.out.print(tekst);
		System.out.println(" ---");
	}

}
