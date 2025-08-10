import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown_10 {

    public static void main(String[] args) {

        // Set the path for the Edge browser driver
        System.setProperty("webdriver.edge.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");

        // Initialize WebDriver for Microsoft Edge
        WebDriver driver = new EdgeDriver();

        // Navigate to the practice site with the dropdown
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Locate the static dropdown element by its ID
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        // Create a Select object to interact with the dropdown
        Select dropdown = new Select(staticDropdown);

        // Select dropdown option by index (index starts from 0)
        dropdown.selectByIndex(3);
        // Print the currently selected option's visible text
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // Select dropdown option by visible text "AED"
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // Select dropdown option by the value attribute "INR"
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // (Optional) You may close the browser after execution using driver.quit();
    }
}
