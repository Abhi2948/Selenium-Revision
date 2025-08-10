

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*; // For Relative Locators

public class RelativeLocator_35 {

    public static void main(String[] args) {

        // ---------------------------
        // 1. Set up WebDriver (Chrome)
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        // ---------------------------
        // 2. Navigate to target page
        // ---------------------------
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // ---------------------------
        // 3. Use 'above()' Relative Locator
        // Find the label above the Name input field
        // ---------------------------
        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        String labelAboveName = driver.findElement(
            with(By.tagName("label")).above(nameInput)
        ).getText();
        System.out.println("Label above Name field: " + labelAboveName);

        // ---------------------------
        // 4. Use 'below()' Relative Locator
        // Click the Date of Birth field found below its label
        // ---------------------------
        WebElement dobLabel = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(
            with(By.tagName("input")).below(dobLabel)
        ).click();

        // ---------------------------
        // 5. Use 'toLeftOf()' Relative Locator
        // Click checkbox to the left of "Love IceCreams!" label
        // ---------------------------
        WebElement iceCreamLabel = driver.findElement(
            By.xpath("//label[text()='Check me out if you Love IceCreams!']")
        );
        driver.findElement(
            with(By.tagName("input")).toLeftOf(iceCreamLabel)
        ).click();

        // ---------------------------
        // 6. Use 'toRightOf()' Relative Locator
        // Get label text to the right of the radio button
        // ---------------------------
        WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
        String labelRightOfRadio = driver.findElement(
            with(By.tagName("label")).toRightOf(radioButton)
        ).getText();
        System.out.println("Label right of Radio Button: " + labelRightOfRadio);

        // ---------------------------
        // 7. Close the browser
        // ---------------------------
//        driver.quit();
    }
}
