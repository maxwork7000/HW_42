package facebook;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari_P2 {

	static String url = "http://facebook.com";
	static String email = System.getenv("fb_email");
	static String password = System.getenv("fb_password");
	static Properties p = new Properties();

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		Logger.getLogger("").setLevel(Level.OFF);		
		p.load(new FileInputStream("./input.properties"));
		System.out.println("Browser: Safari");
		driver = new SafariDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);		
		driver.manage().window().maximize();
		driver.get(url);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_email")))).sendKeys(email);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_password")))).sendKeys(password);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_login")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_timeline")))).click();
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(p.getProperty("xpath_friends")))).getText();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(p.getProperty("id_settings")))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(p.getProperty("linktext_logout")))).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");
	}
}
