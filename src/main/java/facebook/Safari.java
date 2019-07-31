package facebook;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;

public class Safari {

	static String url = "http://facebook.com/";
	static String email = "*********************";
	static String password = "*********************";

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger.getLogger("").setLevel(Level.OFF);

		System.out.println("Browser: Safari");
		
		driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("u_0_2")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).click();
		
		Thread.sleep(3000);
		
		String friends = driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getText();

		driver.findElement(By.id("userNavigationLabel")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");
	}
}
