import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators_7 {

    public static void main(String[] args) throws InterruptedException {

        // Set the expected username
        String name = "Peter";

        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Get the auto-generated password by calling getPassword()
        String password = getPassword(driver);

        // Navigate to the login page
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Enter username and password
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);

        // Click the login button
        driver.findElement(By.className("signInBtn")).click();

        // Wait for page to load after login
        Thread.sleep(2000);

        // Print the success message after login
        System.out.println(driver.findElement(By.tagName("p")).getText());

        // Assert that the success message is as expected
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        // Assert the greeting message using dynamic name
        Assert.assertEquals(
                driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + name + ",");

        // Click the 'Log Out' button
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        // Close the browser window
//        driver.close();

        // Quit the driver (ensures complete cleanup)
        driver.quit();
    }

    // Method to retrieve password from "Forgot your password?" workflow
    public static String getPassword(WebDriver driver) throws InterruptedException {

        // Navigate to the login page
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Click on 'Forgot your password?' link
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Wait for the password reset page to load
        Thread.sleep(2000);

        // Click on 'Reset Password' button
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Capture the text that contains the password
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();  // e.g., "Please use temporary password 'rahulshettyacademy' to Login."

        // Extract the password from the text using split()
        String[] passwordArray = passwordText.split("'"); // Split by single quote
        String password = passwordArray[1].split("'")[0]; // Get the password part

        return password;
    }

}
