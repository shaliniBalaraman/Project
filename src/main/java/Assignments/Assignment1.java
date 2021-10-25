package Assignments;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	@Test
	public static void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		String actualResult = driver.getTitle();
		System.out.println(actualResult.substring(0, 8));
		String expectedResult = "Facebook";
		Assert.assertEquals(actualResult.substring(0, 8), expectedResult);
		driver.close();
	}

	@Test
	public static void edgeDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		String actualResult = driver.getTitle();
		System.out.println(actualResult.substring(0, 8));
		String expectedResult = "Facebook";
		Assert.assertEquals(actualResult.substring(0, 8), expectedResult);
		driver.close();
	}

	@Test
	public static void fireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		String actualResult = driver.getTitle();
		System.out.println(actualResult.substring(0, 8));
		String expectedResult = "Facebook";
		Assert.assertEquals(actualResult.substring(0, 8), expectedResult);
		driver.close();

	}
}
