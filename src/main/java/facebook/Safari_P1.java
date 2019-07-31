package facebook;

import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Safari_P1 {

	static String url = "http://facebook.com/";
	static String email = "**************";
	static String password = "******************";

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		Logger.getLogger("").setLevel(Level.OFF);

		System.out.println("Browser: Safari");
		
		driver = new SafariDriver();
		
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.manage().window().maximize();
		driver.get(url);
		// driver.findElement(By.id("email")).sendKeys(email);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(email);

		// driver.findElement(By.id("pass")).sendKeys(password);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pass"))).sendKeys(password);

		// driver.findElement(By.id("u_0_2")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_2"))).click();

		// driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"))).click();

		// String friends = driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getText();
		String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/ul/li[3]/a/span[1]"))).getText();

		// driver.findElement(By.id("userNavigationLabel")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userNavigationLabel"))).click();

		// driver.findElement(By.linkText("Log Out")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Out"))).click();
		driver.quit();
		System.out.println("You have " + friends + " friends");
	}
}
