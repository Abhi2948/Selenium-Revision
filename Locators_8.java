import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators_8 {

	public static void main(String[] args) throws InterruptedException {

		// Set the path for the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Launch Chrome browser
		WebDriver driver = new ChromeDriver();

		// Navigate to the practice page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// ----------- XPath Traversals -----------

		// Child to sibling traversal (fetching the second button using
		// following-sibling)
		// Select the first button, then move to its next sibling (which is button[2])
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		// Parent to child traversal (accessing the second button directly from the
		// parent div)
		// Select the parent of button[1] (i.e., <div>) and directly select its second
		// child button
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());

	}
}
