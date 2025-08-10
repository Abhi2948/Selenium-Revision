
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo_33 {

	public static void main(String[] args) {

		// ---------------------------
		// 1. Set up WebDriver (Chrome)
		// ---------------------------
		System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// ---------------------------
		// 2. Navigate to target URL
		// ---------------------------
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// ---------------------------
		// 3. Click on column header to sort product names
		// ---------------------------
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// ---------------------------
		// 4. Capture the list of product names after sorting
		// ---------------------------
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// Original list (as displayed on the page)
		List<String> originalList = elementsList.stream().map(WebElement::getText).collect(Collectors.toList());

		// Sorted list using Java Streams
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// ---------------------------
		// 5. Verify the list is sorted correctly
		// ---------------------------
		Assert.assertTrue(originalList.equals(sortedList), "Table is not sorted as expected.");

		// ---------------------------
		// 6. Search for a specific vegetable ("Rice") and get its price
		// Loop until found or until last page
		// ---------------------------
		List<String> priceList;
		do {
			// Capture all product names from the current page
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			// Filter for "Rice" and map to its price using helper method
			priceList = rows.stream().filter(s -> s.getText().contains("Rice")).map(LiveDemo_33::getPriceVeggie)
					.collect(Collectors.toList());

			// Print prices found on this page
			priceList.forEach(price -> System.out.println("Price: " + price));

			// If not found, click "Next" to go to the next page
			if (priceList.isEmpty()) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

		} while (priceList.isEmpty());

		// ---------------------------
		// 7. Close the browser
		// ---------------------------
//        driver.quit();
	}

	/**
	 * Helper method to get the price of the vegetable in the same row as the given
	 * element.
	 * 
	 * @param element WebElement representing the vegetable name cell
	 * @return Price value as a string
	 */
	private static String getPriceVeggie(WebElement element) {
		return element.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
}
