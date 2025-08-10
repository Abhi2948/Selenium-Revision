import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class CalenderTest_29 {

    public static void main(String[] args) {
        
        // Desired date to be selected
        String monthNumber = "6"; // June (0-based index, so June is index 5)
        String date = "15";
        String year = "2026";
        String[] expectedDateParts = { monthNumber, date, year };

        // Set path for EdgeDriver
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize WebDriver with Edge browser
        WebDriver driver = new EdgeDriver();

        // Open the target page
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click to open the date picker
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

        // Click twice to open year selection (navigating from day → month → year)
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

        // Select the desired year
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        // Select the desired month (index starts from 0, so subtract 1)
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
              .get(Integer.parseInt(monthNumber) - 1)
              .click();

        // Select the desired date
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        // Retrieve the selected date parts (month, day, year)
        List<WebElement> actualDateParts = driver.findElements(
                By.cssSelector(".react-date-picker__inputGroup__input")
        );

        // Assert each part of the selected date against expected values
        for (int i = 0; i < actualDateParts.size(); i++) {
            String actualValue = actualDateParts.get(i).getDomAttribute("value");
            System.out.println("Actual: " + actualValue + " | Expected: " + expectedDateParts[i]);
            Assert.assertEquals(actualValue, expectedDateParts[i], "Mismatch at index " + i);
        }

        // Close the browser
//       driver.close();
//        driver.quit();
    }
}
