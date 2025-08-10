

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow_37
{

    public static void main(String[] args) throws IOException {

        // ---------------------------
        // 1. Set up WebDriver (Chrome)
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // ---------------------------
        // 2. Open the parent page
        // ---------------------------
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // ---------------------------
        // 3. Open a new browser window
        // ---------------------------
        driver.switchTo().newWindow(WindowType.WINDOW);
        // driver.switchTo().newWindow(WindowType.TAB); // Alternative for new tab

        // ---------------------------
        // 4. Get all window handles
        // ---------------------------
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();

        // ---------------------------
        // 5. Switch to child window and navigate to course site
        // ---------------------------
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        // ---------------------------
        // 6. Get the second course name from the list
        // ---------------------------
        String courseName = driver.findElements(
            By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")
        ).get(1).getText();

        // ---------------------------
        // 7. Switch back to parent window and enter course name
        // ---------------------------
        driver.switchTo().window(parentWindowId);
        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
        nameField.sendKeys(courseName);

        // ---------------------------
        // 8. Take a screenshot of the name input field only
        // ---------------------------
        File screenshotFile = nameField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("NewWindow37.png"));

        // ---------------------------
        // 9. Close browser
        // ---------------------------
        driver.quit();
    }
}
