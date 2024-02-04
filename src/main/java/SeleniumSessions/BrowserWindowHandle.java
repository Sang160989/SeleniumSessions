package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandle {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

driver = new ChromeDriver();
driver.get("https://www.orangehrm.com/");
driver.manage().window().maximize();
Thread.sleep(3000);
String parentWID= driver.getWindowHandle();
driver.findElement(By.xpath("//a[@title='Accept Cookies']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//img[contains(@src,'facebook.png')]")).click();
String WID1= driver.getWindowHandle();
driver.switchTo().window(WID1);
System.out.println(driver.getCurrentUrl());
driver.close();
driver.switchTo().window(parentWID);


Set <String> handles= driver.getWindowHandles();
Iterator <String> it =handles.iterator();
while(it.hasNext()) {
	String id= it.next();
	driver.switchTo().window(id);
	System.out.println(driver.getCurrentUrl());
	if(!id.equals(parentWID)) {
		driver.close();
	}
	
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
