package packageone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Shalini\\eclipse-workspace\\MyProject\\src\\main\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		//prop.getProperty("username");
		//System.out.println(	prop.getProperty("username"));
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.className("decorativeSubmit")).click();
		
	}

}
