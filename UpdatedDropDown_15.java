import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert; // TestNG assertion library

public class UpdatedDropDown_15 {

    public static void main(String[] args) throws InterruptedException {

        // Set path for Edge WebDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Edge browser
        WebDriver driver = new EdgeDriver();

        // Navigate to the dropdown practice site
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Verify 'Senior Citizen Discount' checkbox is not selected by default
        // Using CSS selector with partial matching (*) for ID
        Assert.assertFalse(
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click the 'Senior Citizen Discount' checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Verify the checkbox is now selected
        Assert.assertTrue(
                driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Print the number of checkboxes on the page
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        // Open the passenger dropdown
        driver.findElement(By.id("divpaxinfo")).click();

        // Wait 2 seconds for dropdown to fully load
        Thread.sleep(2000);

        // Print initial passenger info text
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Click the '+' button for adult passenger 4 times to make total 5 adults
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert that the displayed passenger count is "5 Adult"
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        // Print final passenger info
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
