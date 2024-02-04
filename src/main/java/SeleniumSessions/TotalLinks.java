package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new EdgeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();

		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		int linkscount = linkslist.size();
		System.out.println("The total number of links in the page " + linkscount);

		for (WebElement e : linkslist) {
			String text = e.getText();
			System.out.println(text);
		}

		System.out.println("--------------------");
		
		int counter = 0;
		for (int i = 0; i < linkscount; i++) {

			String text1 = linkslist.get(i).getText();
			if (text1.length() > 0) {
				System.out.println(text1);
				counter++;
			}

		}

		System.out.println(counter);
		
		int blanklinks = linkscount - counter;
		System.out.println("The number of blank links " + blanklinks);
		driver.quit();

	}

}
