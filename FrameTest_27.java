import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest_27 {

    public static void main(String[] args) {

        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize WebDriver for Microsoft Edge
        WebDriver driver = new EdgeDriver();

        // Navigate to the jQuery UI Droppable demo page
        driver.get("http://jqueryui.com/droppable/");

        // Print the total number of iframes on the page
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // Switch to the first iframe on the page to access draggable/droppable elements
        driver.switchTo().frame(0);

        // (Alternative frame switch — using iframe selector)
        // driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        // (Optional click on draggable element - not required for dragAndDrop)
        // driver.findElement(By.id("draggable")).click();

        // Create Actions class instance to perform complex user gestures
        Actions action = new Actions(driver);

        // Locate source (draggable) and target (droppable) elements
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // Perform drag-and-drop from source to target
        action.dragAndDrop(sourceElement, targetElement).build().perform();

        // Switch back to the default content (main page)
        driver.switchTo().defaultContent();
    }
}
