import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Flight_booking {

    public static void main(String[] args) throws InterruptedException {

        // Set system property for EdgeDriver
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Navigate to the target URL
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Select 'One Way' trip option
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        // Click on 'From' city dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select origin city (DEL)
        driver.findElement(By.xpath("//a[@value='DEL']")).click();

        // Wait for destination dropdown to load
        Thread.sleep(2000);

        // Select destination city (MAA) using parent-child XPath
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
                .click();

        // Select current date from the calendar
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        // Validate that return date section is disabled for one-way trip
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("Return date is disabled (as expected for one-way)");
            Assert.assertTrue(true);
        } else {
            Assert.fail("Return date is enabled for one-way trip");
        }

        // Check 'Senior Citizen Discount' checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Open passenger selection dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        // Increase number of adults to 5 (from default 1)
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        // Close the passenger dropdown
        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assertion to verify adult count
        String passengerInfo = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(passengerInfo, "5 Adult");
        System.out.println(passengerInfo);

        // Click on 'Search' button to search for flights
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // Optionally: you can close the browser
         driver.quit();
    }
}
