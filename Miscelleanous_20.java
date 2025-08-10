import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils; // Make sure commons-io jar is added to the build path

public class Miscelleanous_20 {

    public static void main(String[] args) throws IOException {

        // Set path for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Delete all browser cookies
        driver.manage().deleteAllCookies();

        // Optional: delete a specific cookie by name
        // driver.manage().deleteCookieNamed("sessionKey");

        // Navigate to Google homepage
        driver.get("http://google.com");

        // Capture screenshot and store it as a file object
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot to the specified path
        FileUtils.copyFile(src, new File("D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Selenium_Introduction_1\\New_SS_logo.png"));

        // Optional: close the browser after screenshot
//         driver.quit();
    }
}
