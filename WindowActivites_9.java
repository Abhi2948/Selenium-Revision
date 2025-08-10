import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivites_9 {

    public static void main(String[] args) {

        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open Google (note: the URL has a missing slash, should be http://)
        driver.get("http:/google.com");  // Invalid URL format, should be http://google.com

        // Navigate to Rahul Shetty Academy site
        driver.navigate().to("http:/rahulshettyacademy.com");  // Invalid URL format, should be http://rahulshettyacademy.com

        // Navigate back to the previous page (Google)
        driver.navigate().back();

        // Navigate forward to Rahul Shetty Academy again
        driver.navigate().forward();
    }
}
