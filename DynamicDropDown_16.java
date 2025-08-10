import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown_16 {

    public static void main(String[] args) throws InterruptedException {

        // Set the system property to point to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the dropdowns practice site
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Click on the 'From' dropdown to open the origin city list
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select the origin city (BLR - Bangalore)
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        // Wait for destination options to load (important when dynamic content is involved)
        Thread.sleep(2000);

        // Select the destination city (MAA - Chennai) using parent-child format
        driver.findElement(By.xpath(
                "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
                .click();

        // Select the current date from the date picker (active highlighted date)
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        // (Optional) You can add assertion or verification steps here
    }
}
