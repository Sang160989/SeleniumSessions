package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NatureBasketMultiLevelHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.naturesbasket.co.in/");
		Thread.sleep(3000);
		
		WebElement l1ele = driver.findElement(By.xpath("//span[text()='shop by category']"));
		
		WebElement l2ele= driver.findElement(By.xpath("//div[@class='divLeftSearchSideBarhome']//div[@title='Bakery & Dairy']"));
		WebElement l3ele = driver.findElement(By.linkText("Cakes & Brownies"));
		
		Actions act = new Actions(driver);
		act.moveToElement(l1ele).build().perform();
		act.moveToElement(l2ele).build().perform();
		act.moveToElement(l3ele).click().build().perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
