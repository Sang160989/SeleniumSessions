package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//div[text()='Add-ons']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		Thread.sleep(2000);
		WebElement options = driver.findElement(By.xpath("//div[text()='Senior Citizen Discount']"));
		options.click();

	}

}
