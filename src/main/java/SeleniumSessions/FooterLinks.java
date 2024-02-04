package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {
	static WebDriver driver;

	public static List<String> TextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String eletext = e.getText();
			eleTextList.add(eletext);
		}
		return eleTextList;
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By footlink = By.xpath("//footer//a");
		
		List<String>  textfooter =TextList(footlink);
		System.out.println(textfooter);

	}

}
