import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class IMP_fluentWait_24 {

    public static void main(String[] args) {
        // Set system property for EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the dynamic loading page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Click the 'Start' button to initiate loading
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        // Configure FluentWait:
        // - Timeout after 30 seconds
        // - Poll every 3 seconds
        // - Ignore NoSuchElementExceptions
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        // Apply custom wait condition using lambda or anonymous Function class
        WebElement resultText = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(By.cssSelector("[id='finish'] h4"));
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });

        // Print the dynamically loaded text
        System.out.println(resultText.getText());

        // Optional: Close the browser
        driver.quit();
    }
}
