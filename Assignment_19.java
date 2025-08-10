import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment_19 {

	public static void main(String[] args) {

		// Define input text for alert
		String text = "Abhishek";

		// Set system property for EdgeDriver
		System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

		// Initialize WebDriver with Edge browser
		WebDriver driver = new EdgeDriver();

		// Open target URL
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Enter name into the input box
		driver.findElement(By.id("name")).sendKeys(text);

		// Click on "Alert" button
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();

		// Switch to alert and print its text
		System.out.println(driver.switchTo().alert().getText());

		// Accept the alert (clicks "OK")
		driver.switchTo().alert().accept();

		// Click on "Confirm" button
		driver.findElement(By.id("confirmbtn")).click();

		// Print text of confirmation alert
		System.out.println(driver.switchTo().alert().getText());

		// Dismiss the alert (clicks "Cancel")
		driver.switchTo().alert().dismiss();

		// Optional: close the browser
		// driver.quit();
	}
}
