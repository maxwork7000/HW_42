package facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Edge {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger.getLogger("").setLevel(Level.OFF);

		String driverPath = "";

		if (!System.getProperty("os.name").contains("Windows"))
			throw new IllegalArgumentException("MS Edge is available only on Windows");

		System.setProperty("webdriver.edge.driver", driverPath);
		System.out.println("Browser: MS Edge");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
//
		
//
		driver.get("https://www.facebook.com/");
		System.out.println("Title: " + driver.getTitle());
		driver.quit();
	}
}
