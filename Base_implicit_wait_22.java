import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Base_implicit_wait_22 {

	public static void main(String[] args) throws InterruptedException {

		// Set path for EdgeDriver executable
		System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

		// Initialize EdgeDriver instance
		WebDriver driver = new EdgeDriver();

		// Apply implicit wait to all elements
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//old version-->replacing Thread.sleep() with WebDriverWait
		// driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));// new version
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// new version

		// Array of items to add to cart
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		// Navigate to the practice shopping site
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Wait for page to fully load product list
		Thread.sleep(3000); // Prefer WebDriverWait in real-world tests

		// Call reusable method to add selected items to cart
		addItems(driver, itemsNeeded);

		// Click on cart icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		// Click "Proceed to Checkout" button
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		// Enter promo code
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		// Click apply promo button
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// Print the result of the promo code application
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	// Reusable method to add desired items to cart
	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0; // Counter for added items

		// Get list of all product names displayed
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			// Each product name is in format: "Brocolli - 1 Kg", so split by "-"
			String[] name = products.get(i).getText().split("-");

			// Get cleaned product name (e.g., "Brocolli")
			String formattedName = name[0].trim();

			// Convert array to List for easy lookup
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			// If product is one of the required items, click "Add to cart"
			if (itemsNeededList.contains(formattedName)) {
				j++;

				// Click corresponding "Add to cart" button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// Exit loop early if all required items are added
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
