import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdatedDropDown_14 {

    public static void main(String[] args) throws InterruptedException {

        // Set path for Edge WebDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver();

        // Open the practice site
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Check if 'Senior Citizen Discount' checkbox is selected (initially should be false)
        // Using partial ID match (*) in CSS selector
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Click the checkbox to select 'Senior Citizen Discount'
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Check again if the checkbox is now selected (should be true)
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Count and print the number of checkboxes on the page
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        // Open the passenger selection dropdown
        driver.findElement(By.id("divpaxinfo")).click();

        // Wait for dropdown to fully appear
        Thread.sleep(2000);

        // Print the current passenger count before increment
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        // Increase number of adult passengers to 5 by clicking 4 times
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Print updated passenger count (should display "5 Adult")
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
