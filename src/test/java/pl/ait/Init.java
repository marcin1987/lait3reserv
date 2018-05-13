package pl.ait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {
	
	static WebDriver driver = null;
	
	static DesiredCapabilities cap = DesiredCapabilities.firefox();
	
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\sot_m\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		log("Wewnątrz metody getDriver");
		
		if(driver == null) {
			
			log( "Wewnątrz IFa, FF jest już uruchomiony");
			
			URL seleniumAdress = null;
			try {
				seleniumAdress = new URL("http://192.168.0.122:4444/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//driver = new FirefoxDriver();
			driver = new RemoteWebDriver(seleniumAdress, cap);
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
	
	/**
	 * Usypia wątek na X sekund
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
	
	public static void printScr(WebDriver driver) {
    	
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
    	Long milis = timestamp.getTime();
    	
    	WebDriver driver_tmp = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot)driver_tmp).getScreenshotAs(OutputType.FILE);
        
        try {
			FileUtils.copyFile(srcFile, new File("target/screenshot-"+milis+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
