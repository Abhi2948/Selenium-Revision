import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Scroll_Javascript_executor_30 {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the Automation Practice page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Create a JavaScriptExecutor instance from WebDriver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the main window down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000); // Wait for smooth scroll and visibility

        // Scroll inside the table container with class '.tableFixHead'
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        // Get all values from the 4th column of the scrollable table
        List<WebElement> amountCells = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int calculatedSum = 0;

        // Iterate through the cell values and sum them up
        for (WebElement cell : amountCells) {
            calculatedSum += Integer.parseInt(cell.getText());
        }

        // Print the calculated sum
        System.out.println("Calculated column sum: " + calculatedSum);

        // Extract the total amount text displayed below the table
        String totalAmountText = driver.findElement(By.cssSelector(".totalAmount")).getText();

        // Extract numeric value from text like "Total Amount Collected: 296"
        int displayedTotal = Integer.parseInt(totalAmountText.split(":")[1].trim());

        // Validate that the sum from the table matches the displayed total
        Assert.assertEquals(calculatedSum, displayedTotal, "Mismatch in total calculation!");

        // Optional: Close browser
        // driver.quit();
    }
}
