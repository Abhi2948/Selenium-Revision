import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_explicit_wait_23 {

    public static void main(String[] args) throws InterruptedException {
        // Set system property for EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");


        // Initialize Edge browser
        WebDriver driver = new EdgeDriver();

        // Create explicit wait instance with 5 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Array of vegetables to add to cart
        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

        // Navigate to the practice shopping site
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Wait for page to fully load (temporary pause - not best practice)
        Thread.sleep(3000);

        // Call method to add selected items to the cart
        addItems(driver, itemsNeeded);

        // Open the cart
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        // Proceed to checkout
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        // Wait until promo code input is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        // Enter promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        // Click on the Apply button
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Wait for promo message to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        // Print promo message to console
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    // Method to find and add specific items to the cart
    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int itemsAdded = 0;

        // Get all product names from the page
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            // Extract product name (e.g., "Brocolli - 1 Kg" → "Brocolli")
            String[] nameParts = products.get(i).getText().split("-");
            String formattedName = nameParts[0].trim();

            // Convert array to List for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            // If the product name is in our desired list, click "Add to cart"
            if (itemsNeededList.contains(formattedName)) {
                itemsAdded++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Break once all items are added
                if (itemsAdded == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}
