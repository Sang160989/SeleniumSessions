package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownwithXpath {
static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.get("https://www.microchip.com/prochiplicensing/#/");
		
				
				driver.findElement(By.xpath("(//select[@id='productionYear']/option)[2]")).click();
		
		By locator = By.xpath("//label[text()='Which CPLD will you be using?']/preceding-sibling::select");
		WebElement loc = driver.findElement(locator);
		
		Select select =new Select(loc);
		select.selectByVisibleText("ATF1504");
		
		

	}

}
