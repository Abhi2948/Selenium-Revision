import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandles_26 {

    public static void main(String[] args) {
        // Set system property for EdgeDriver
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the login page
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        // Click the link that opens a new window
        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Get window handles
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        // Store window IDs
        String parentId = it.next();
        String childId = it.next();

        // Switch to child window
        driver.switchTo().window(childId);

        // Get the text containing email info
        String infoText = driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(infoText);

        // Extract email from the text
        String emailId = infoText.split("at")[1].trim().split(" ")[0];

        // Switch back to parent window
        driver.switchTo().window(parentId);

        // Enter the extracted email into the username field
        driver.findElement(By.id("username")).sendKeys(emailId);
    }
}
