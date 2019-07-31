package facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		Logger.getLogger("").setLevel(Level.OFF);
		
		String driverPath = "";

		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/geckodriver.sh";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");

		System.setProperty("webdriver.gecko.driver", driverPath);
		System.out.println("Browser: Firefox");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//
		
//
		driver.get("https://www.facebook.com/");
		System.out.println("Title: " + driver.getTitle());
		driver.quit();
	}
}
