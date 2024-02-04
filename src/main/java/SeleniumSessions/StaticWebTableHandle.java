package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		getContact();
		getCountry();
	}

	public static void getContact() {
		String beforepath ="//table[@id='customers']//tr[";
		String afterpath="]/td[2]";
		
		for(int i=2; i<=7;i++) {
			String xpath = beforepath+i+afterpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}
	
	public static void getCountry() {
		String beforepath ="//table[@id='customers']//tr[";
		String afterpath="]/td[3]";
		
		for(int i=2; i<=7;i++) {
			String xpath = beforepath+i+afterpath;
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	}
}
