package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	private WebDriver driver;
	
	public WebDriver initBrowser(String browser) {
	
	switch(browser)
	{
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

	driver.manage().window().maximize();
	return driver;
}
	
	public void launchUrl(String url) {
		if(url==null) {
			System.out.println("pls enter the correct url");
		}
		
		if(url.indexOf("https")==0) {
			driver.get(url);
		}
		
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the page is " + title);
		return title;
	}
	
	
	public String getPageUrl() {
		String pageurl = driver.getCurrentUrl();
		System.out.println("The page url is "+ pageurl);
		return pageurl;
	}
	
	
	public void quitBrowser() {
		if(driver!=null) {
		driver.quit();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

