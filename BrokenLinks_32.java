import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks_32 {

	public static void main(String[] args) throws MalformedURLException, IOException {

		// ---------------------------
		// 1. Set up WebDriver
		// ---------------------------
		System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// ---------------------------
		// 2. Navigate to target page
		// ---------------------------
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// ---------------------------
		// 3. Prepare SoftAssert for all validations
		// ---------------------------
		SoftAssert softAssert = new SoftAssert();

		// ---------------------------
		// 4. Find all footer links (CSS selector used for <li class='gf-li'> <a>)
		// ---------------------------
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		// ---------------------------
		// 5. Check each link for broken status
		// ---------------------------
		for (WebElement link : links) {

			// Extract href attribute value
			String url = link.getAttribute("href");

			// Skip null or empty links
			if (url == null || url.isEmpty()) {
				System.out.println("Skipping empty link: " + link.getText());
				continue;
			}

			// Create HTTP connection for the link
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD"); // Only check the header (faster than GET)
			conn.connect();

			// Get HTTP response code
			int responseCode = conn.getResponseCode();

			// Print response code for debugging
			System.out.println("Link: " + url + " | Response Code: " + responseCode);

			// Assert that response code is less than 400 (Not a client/server error)
			softAssert.assertTrue(responseCode < 400,
					"The link with Text++++ '" + link.getText() + "' is broken. HTTP Code: " + responseCode);

		}

		// ---------------------------
		// 6. Assert all results at the end
		// ---------------------------
		softAssert.assertAll();

		// ---------------------------
		// 7. Close the browser
		// ---------------------------
//        driver.quit();
	}
}

/*
 * Notes: - HEAD request is used for efficiency since it doesn't download the
 * full page. - SoftAssert ensures that all broken links are reported at once,
 * instead of stopping at the first one. - Typical codes: 200: OK 301: Moved
 * Permanently 404: Not Found (Broken) - If you want to ignore redirects (301)
 * or specific codes, you can add custom conditions.
 */
