package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverBasics {
	static WebDriver driver;

	public static void main(String[] args) {
        //WebDriver driver=null;
		String browser = "chrome";
		switch (browser) {
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
		}

		// Automation
		// when the object of chromedriver is created, internally constructor will be
		// called and the browser will be launched

		driver.get("https://www.google.com");// https is important here, otherwise invalid argument exception. without
												// www. we can use it

		String title = driver.getTitle(); // title is the tab name of the website
		System.out.println(title);

		// Validation
		if (title.equals("Google")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		// Automation+validation=Automation Testing

		driver.quit();
	}

}
