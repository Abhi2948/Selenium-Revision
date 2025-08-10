import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive_13 {

    public static void main(String[] args) throws InterruptedException {

        // Set system property for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the practice website
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Type "ind" into the auto-suggest input field
        driver.findElement(By.id("autosuggest")).sendKeys("ind");

        // Pause for 3 seconds to allow suggestions to appear
        Thread.sleep(3000);

        // Capture all suggestions matching the partial input using CSS selector
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        // Loop through the suggestions to find the exact match "India"
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click(); // Click the matched suggestion
                break;          // Exit the loop after clicking
            }
        }

        // Optionally, you can add a check to verify the selected value here
    }
}
