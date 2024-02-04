package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver=null;
		String browser = "Chrome";
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please pass the correct browser");
			break;
		}
		
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		String url =driver.getCurrentUrl();
		System.out.println(url);
		if(url.contains("amazon")) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		
//		String pgsrc=driver.getPageSource();
//		System.out.println(pgsrc);
		
		
		
		
		
		
		
		
		
		
		driver.quit();

	}

}
