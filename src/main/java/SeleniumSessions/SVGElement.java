package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SVGElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");
		Thread.sleep(9000);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		// String xpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and
		// @id='regions']//*[name()='path']";

		//Actions act = new Actions(driver);
		List<WebElement> statelist = driver.findElements(By
				.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']//*[name()='path']"));
		Thread.sleep(2000);
		for (WebElement e : statelist) {
			String statename = e.getAttribute("name");
			System.out.println(statename);
			if (statename.equals("Colorado")) {
				e.click();
				// act.moveToElement(e).click().build().perform();
				break;
			}

		}

		Thread.sleep(3000);
		List<WebElement> countyList = driver.findElements(By
				.xpath("//*[local-name()='g' and @id='colorado']//*[name()='g' and @class='rpath']//*[name()='path']"));
		for (WebElement e : countyList) {
			String countyname = e.getAttribute("name");
			System.out.println(countyname);
			//td[text()='United States']//preceding-sibling::td/input[@type='checkbox']
		}

	}

}
