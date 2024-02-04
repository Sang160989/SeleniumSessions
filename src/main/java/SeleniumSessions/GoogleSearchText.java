package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchText {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("naveen automation");
		
		Thread.sleep(3000);
		

		By googlesugglistlocator = By.xpath("//li[@role='presentation']//div[@class='wM6W7d']/span");
		//li[@role='presentation']//div[@class='wM6W7d']/span

		List<WebElement> sugglist = driver.findElements(googlesugglistlocator);
		System.out.println("The total no of suggestions " + sugglist.size());
		for (WebElement e : sugglist) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("naveen automationlabs playwright")) {
				e.click();
			}

		}
		driver.quit();
	}

}
