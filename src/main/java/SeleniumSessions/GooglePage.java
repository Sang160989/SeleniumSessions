package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage {

	static WebDriver driver;

	public static void main(String[] args) {
//		fetch footer
//		fetch all languages and store in arraylist
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		By lang = By.xpath("//div[@id='SIvCob']/a");
		List<String> googlelanglist = getlanglist(lang);
		System.out.println(googlelanglist);
		List<String> footertextlist = getGooglefooter();
		System.out.println(footertextlist);

	}

	public static List<String> getlanglist(By locator) {
		By lang = By.xpath("//div[@id='SIvCob']/a");
		List<WebElement> langlist = driver.findElements(lang);

		System.out.println("The total no of languages " + langlist.size());
		List<String> langtext = new ArrayList<String>();
		for (WebElement e : langlist) {
			String text = e.getText();
			langtext.add(text);
		}
		return langtext;
//
	}
	
	public static List<String> getGooglefooter() {
		
		
		List<WebElement>foolinks =driver.findElements(By.xpath("//div[contains(@class,'KxwPGc')]/a"));
		List<String> footext = new ArrayList<String>();
		for(WebElement e: foolinks) {
			String text = e.getText();
			System.out.println(text);
			footext.add(text);
		}
		return footext;
		
		
		//do meenakshi's assignment
				//check xpath tool
				
				//crmpro.com
				//groupautomation
				//govind assignment
				//crmpro create data
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}