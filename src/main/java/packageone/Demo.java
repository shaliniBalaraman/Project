package packageone;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Test
	public void testBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		String title = driver.getTitle();//ctrl2l-shortcut
        System.out.println(title);  
        driver.findElement(By.id("username")).sendKeys("Demosalaesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.close();      
	}
	public static void main(String[] args) {
		Demo d = new Demo();
		d.testBrowser();
	}
}
