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

public class NewWindow_38 {

    public static void main(String[] args) throws IOException {

        // ---------------------------
        // 1. Set up WebDriver (Chrome)
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        // ---------------------------
        // 2. Open the parent window
        // ---------------------------
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // ---------------------------
        // 3. Open a new browser window
        // ---------------------------
        driver.switchTo().newWindow(WindowType.WINDOW);
        // driver.switchTo().newWindow(WindowType.TAB); // Alternative

        // ---------------------------
        // 4. Get window handles
        // ---------------------------
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();

        // ---------------------------
        // 5. Switch to child window and open target site
        // ---------------------------
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        // ---------------------------
        // 6. Capture course name from second course link
        // ---------------------------
        String courseName = driver.findElements(
            By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")
        ).get(1).getText();

        // ---------------------------
        // 7. Switch back to parent window and fill name field
        // ---------------------------
        driver.switchTo().window(parentWindowId);

        WebElement nameField = driver.findElement(By.cssSelector("[name='name']"));
        nameField.sendKeys(courseName);

        // ---------------------------
        // 8. Take a screenshot of the name field only
        // ---------------------------
        File screenshotFile = nameField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("NewWindow38.png"));

        // ---------------------------
        // 9. Print element dimensions
        // ---------------------------
        System.out.println("Height: " + nameField.getRect().getDimension().getHeight());
        System.out.println("Width : " + nameField.getRect().getDimension().getWidth());

        // ---------------------------
        // 10. Close browser
        // ---------------------------
//        driver.quit();
    }
}
