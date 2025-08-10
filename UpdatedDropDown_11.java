import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdatedDropDown_11 {

    public static void main(String[] args) throws InterruptedException {

        // Set system property for Edge WebDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize WebDriver instance for Microsoft Edge
        WebDriver driver = new EdgeDriver();

        // Open the practice website
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Click on the passenger info dropdown to open it
        driver.findElement(By.id("divpaxinfo")).click();

        // Wait for 2 seconds to ensure the dropdown is fully loaded
        Thread.sleep(2000);

        // Print the current number of adults before selection (e.g., "1 Adult")
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Increase the number of adults to 5 by clicking the "+" button 4 times
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Click on "Done" button to close the passenger selection dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Print the updated number of adults after selection (e.g., "5 Adult")
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
