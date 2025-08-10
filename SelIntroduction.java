import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {
	public static void main(String[] args) {
		// Set Edge Driver system property

		System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		
		// Initialize EdgeDriver
		WebDriver driver = new EdgeDriver();
		// Open HackerRank dashboard
		driver.get("https://www.hackerrank.com/dashboard");

		// Print page title and URL
		System.out.println("Page Title: " + driver.getTitle());
		System.out.println("Current URL: " + driver.getCurrentUrl());

		// Close the browser
		driver.quit();
	}
}
