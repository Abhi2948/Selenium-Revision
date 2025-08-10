import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Scope_Count_Links_28 {

    public static void main(String[] args) throws InterruptedException {

        // Set system property for EdgeDriver
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the practice page
        driver.get("http://qaclickacademy.com/practice.php");

        // Count and print total number of links on the entire page
        System.out.println("Total links on page: " + driver.findElements(By.tagName("a")).size());

        // Get the footer section of the page using its ID
        WebElement footerSection = driver.findElement(By.id("gf-BIG"));

        // Count and print the number of links in the footer section
        System.out.println("Links in footer: " + footerSection.findElements(By.tagName("a")).size());

        // Locate the first column inside the footer (first <td> containing a <ul>)
        WebElement firstColumn = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        // Count and print the number of links in the first column of the footer
        System.out.println("Links in first column: " + firstColumn.findElements(By.tagName("a")).size());

        // Open each link in a new tab starting from index 1
        for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
            // Open link in a new tab using Control + Enter
            String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab);
            Thread.sleep(5000L); // Wait for tabs to load
        }

        // Get all window handles (IDs of all open tabs)
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> windowIterator = windowHandles.iterator();

        // Iterate through each window/tab and print its title
        while (windowIterator.hasNext()) {
            driver.switchTo().window(windowIterator.next());
            System.err.println(driver.getTitle()); // Using System.err to make titles appear in red
        }

        // Note: Browser will stay open. You can close with driver.quit() if needed.
    }
}
