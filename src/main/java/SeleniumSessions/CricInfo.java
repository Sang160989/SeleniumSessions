package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricInfo {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-in-south-africa-2023-24-1387592/south-africa-vs-india-2nd-test-1387604/full-scorecard");

		System.out.println(getWicketTaker("Aiden Markram"));
		System.out.println(getScoreCard("Tony de Zorzi"));
		driver.quit();
	}

	public static String getWicketTaker(String batsmen) {
		By batsmenloca = By.xpath("//span[text()='" + batsmen + "']/ancestor::td/following-sibling::td//span/span");
		String score = driver.findElement(batsmenloca).getText();
		return score;
	}

	public static List<String> getScoreCard(String batsmen) {
		List<WebElement> score = driver.findElements(By.xpath("//span[text()='" + batsmen
				+ "']/ancestor::td/following-sibling::td[contains(@class,'ds-text-right')]"));

		List<String> playerscorelist = new ArrayList<String>();
		for (WebElement e : score) {
			String scoretext = e.getText();

			playerscorelist.add(scoretext);

		}

		return playerscorelist;

	}

}
