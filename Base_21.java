import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class Base_21 {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Edge browser
        WebDriver driver = new EdgeDriver();

        // Counter to track how many items we've added to cart
        int j = 0;

        // Items we want to add to cart
        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

        // Navigate to the shopping page
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Wait for page elements to load
        Thread.sleep(3000);

        // Fetch the list of product names on the page
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

            // Get the name of the product and split it to remove quantity (e.g., "Brocolli - 1 Kg")
            String[] name = products.get(i).getText().split("-");

            // Trim whitespace to get clean product name (e.g., "Brocolli")
            String formattedName = name[0].trim();

            // Convert array to list for easy search
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            // Check if current product is in the desired list
            if (itemsNeededList.contains(formattedName)) {
                j++;

                // Click "Add to cart" button using index
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                // Break loop once all required items are added
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }

        // Optional: Close the browser after adding items
//         driver.quit();
    }
}
