package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) {
		
		BrowserUtil brUtil =new BrowserUtil();
		WebDriver driver=brUtil.initBrowser("chrome");
		
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brUtil.getPageTitle();
		brUtil.getPageUrl();
		
		//By locators
		By fn=By.id("input-firstname");
		By ln =By.name("lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		
		
		
		ElementUtil eleUtil= new ElementUtil(driver);
		eleUtil.doSendkeys(fn, "Sangeetha");
		eleUtil.doSendkeys(ln, "Ramasamy");
		eleUtil.doSendkeys(email,"abc.com");
		eleUtil.doSendkeys(telephone, "87452369");
		
		brUtil.quitBrowser();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
