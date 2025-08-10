

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow_36 {

    public static void main(String[] args) {

        // ---------------------------
        // 1. Set up WebDriver (Chrome)
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // ---------------------------
        // 2. Open the first page (parent window)
        // ---------------------------
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // ---------------------------
        // 3. Open a new browser window (or use WindowType.TAB for new tab)
        // ---------------------------
        driver.switchTo().newWindow(WindowType.WINDOW);
        // driver.switchTo().newWindow(WindowType.TAB); // Alternative

        // ---------------------------
        // 4. Handle multiple windows
        // ---------------------------
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();

        // ---------------------------
        // 5. Switch to the child window and navigate to a new page
        // ---------------------------
        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        // ---------------------------
        // 6. Get course name from the second link in course list
        // ---------------------------
        String courseName = driver.findElements(
            By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")
        ).get(1).getText();

        // ---------------------------
        // 7. Switch back to parent window and use course name in a form field
        // ---------------------------
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);

        // ---------------------------
        // 8. (Optional) Close driver
        // ---------------------------
//        driver.quit();
    }
}
