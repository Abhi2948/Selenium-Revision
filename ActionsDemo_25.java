import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo_25 {

    public static void main(String[] args) {
        // Set path for EdgeDriver executable
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Launch Microsoft Edge browser
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // Navigate to Amazon
        driver.get("https://www.amazon.com/");//https://ebay.com

        // Initialize Actions class for simulating user interactions
        Actions actions = new Actions(driver);

        // Target element for mouse hover and right-click
        WebElement accountList = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        // Type "HELLO" in uppercase using SHIFT key, then double-click it in the search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchBox)
               .click()
               .keyDown(Keys.SHIFT)
               .sendKeys("hello")
               .keyUp(Keys.SHIFT)
               .doubleClick()
               .build()
               .perform();

        // Right-click (context click) on "Account & Lists"
        actions.moveToElement(accountList)
               .contextClick()
               .build()
               .perform();

        // Optional: driver.quit(); // to close the browser
    }
}
