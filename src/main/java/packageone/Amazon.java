package packageone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	@Test
	public void details() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// maximize the window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// load the url
		driver.get("https://www.amazon.in/");
		// Type on the search
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("refrigerator");
		search.sendKeys(Keys.ENTER);
		// name of the item
		System.out.println("");

		int list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).size();
		System.out.println("List of Refrigerator: " + list);

		// driver.findElements

		String name = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"))
				.getText();
		System.out.println("Title of that Item:  " + name);
		// review
		String review = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("Reviews:  " + review);
		// price
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price1: " + price);
		// saving money
		String save = driver.findElement(By.xpath("//span[@class='a-letter-space']/following-sibling::span")).getText();
		System.out.println("Saving Amount:  " + save.substring(6));
		// click on that item
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		// move control to that next window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handleList = new ArrayList<String>(windowHandles);
		String secondHandle = handleList.get(1);
		driver.switchTo().window(secondHandle);
		// price of that item
		String price1 = driver.findElement(By.xpath("(//td[@class='a-span12']//span)[1]")).getText();
		String actualPrice = price1.substring(1, 7);
		System.out.println("Price2:  " + actualPrice);
		System.out.println("");
		// compare that 2 prices
		if (price.equalsIgnoreCase(actualPrice)) {
			System.out.println("Both price are same");
		} else {
			System.out.println("The Price is not Same");
		}

		System.out.println("");

		List<WebElement> h = driver.findElements(By.xpath("//*[@role='rowheader']"));
		List<WebElement> r = driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']"));
		//System.out.println("List of rows in table: " + row.size());
		Iterator<WebElement> i = r.iterator();
		Iterator<WebElement> j = h.iterator();
		while (i.hasNext()) {
			
			WebElement row = i.next();
			WebElement rowh = j.next();
			String str = "Brand Name";
			if(str.equals(rowh.getText())) {
				System.out.println(row.getText());
			}
			
		}

		/*
		 * System.out.println(""); // brandname String brandName =
		 * driver.findElement(By.xpath("//tr[@class='comparison_other_attribute_row']"))
		 * .getText(); System.out.println("Brand Names: " + brandName); // capacity
		 * String capacity = driver.findElement(By.xpath(
		 * "(//tr[@class='comparison_other_attribute_row'])[2]")).getText();
		 * System.out.println("Capacity   : " + capacity);
		 */
		// driver.quit();
	}
}
