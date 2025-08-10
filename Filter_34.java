import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter_34 {

    public static void main(String[] args) {

        // ---------------------------
        // 1. Set up WebDriver (Chrome)
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // ---------------------------
        // 2. Navigate to Offers page
        // ---------------------------
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // ---------------------------
        // 3. Search for "Rice" in the search field
        // ---------------------------
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        // ---------------------------
        // 4. Get all visible vegetables after search
        // ---------------------------
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));

        // ---------------------------
        // 5. Filter list to only include "Rice"
        // ---------------------------
        List<WebElement> filteredList = veggies.stream()
                                               .filter(veggie -> veggie.getText().contains("Rice"))
                                               .collect(Collectors.toList());

        // ---------------------------
        // 6. Validate that search results only contain "Rice"
        // ---------------------------
        Assert.assertEquals(
            veggies.size(),
            filteredList.size(),
            "Search results contain items other than 'Rice'."
        );

        // ---------------------------
        // 7. Close browser
        // ---------------------------
//        driver.quit();
    }
}
