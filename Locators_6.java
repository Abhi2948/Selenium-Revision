import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_6 {

    public static void main(String[] args) throws InterruptedException {

        // Setting system property for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open the login page
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Enter username and password
        driver.findElement(By.id("inputUsername")).sendKeys("abhishek");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // Click the Sign In button
        driver.findElement(By.className("signInBtn")).click();

        // Print error message after failed login
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Click on 'Forgot your password?' link
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Wait for the transition to complete
        Thread.sleep(1000); // Used when the application changes view/state

        // Fill in the reset password form
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ankur"); 
        // XPath using attribute-->Xpath=//tagname[@attribute='value']
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("ankur@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); // XPath using index to target second text input
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("anshul@gmail.com");

//      driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("anshul@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210"); // XPath using parent-to-child structure

        // Click 'Reset Password' button
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Print the message shown after reset
        System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // CSS for form > p

        // Click 'Go to Login' button
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        // Wait for the transition back to login
        Thread.sleep(1000);

        // Re-enter credentials and log in
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("abhishek");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); // Partial match using '*'
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // XPath using contains()
    }

}
