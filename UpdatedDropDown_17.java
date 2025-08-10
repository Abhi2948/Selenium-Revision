import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class UpdatedDropDown_17 {

    public static void main(String[] args) throws InterruptedException {

        // Set system property for Edge WebDriver executable
        System.setProperty("webdriver.edge.driver",
                "D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize Edge WebDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the dropdown practice website
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Assert that 'Senior Citizen Discount' checkbox is NOT selected initially
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click on 'Senior Citizen Discount' checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Assert that the checkbox is now selected
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Print the 'style' attribute of the Return Date container before clicking 'Round Trip'
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

        // Select 'Round Trip' radio button to enable Return Date calendar
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        // Print the updated 'style' attribute to observe change
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

        // Check if Return Date calendar is enabled based on style (opacity 1 means enabled)
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("It's disabled");
            Assert.assertTrue(false);  // Will fail intentionally if opacity is 0.5
        } else {
            System.out.println("It's enabled");
            Assert.assertTrue(true);
        }

        // Count and print number of checkboxes present on the page
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        // Open the passenger selection dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000); // Wait for the dropdown to load

        // Print the current passenger count
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Increment adult passengers to 5
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert the passenger count is now "5 Adult"
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        // Print the updated passenger count
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
