
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown_12 {

    public static void main(String[] args) throws InterruptedException {

        // Set the system property for ChromeDriver executable path
        System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser using WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the dropdown practice website
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Click on the 'From' city dropdown to display the list
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // Select the origin city (Bangalore - BLR)
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        // Pause to allow destination options to load
        Thread.sleep(2000);

        // Select the destination city (Chennai - MAA) using index [2nd match]
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        // Alternatively, select the same destination using parent-child XPath (more specific)
        driver.findElement(By.xpath(
                "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
                .click();

        // Note: The last line tries to select MAA again (optional or redundant)
    }
}
