import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLcheck_31 {

    public static void main(String[] args) {

        // ---------------------------
        // 1. Configure Chrome Options
        // ---------------------------
        ChromeOptions options = new ChromeOptions();

        // ---------------------------
        // 2. Set up Proxy (Optional)
        // ---------------------------
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444"); // Replace with your proxy IP and port
        options.setCapability("proxy", proxy);

        // ---------------------------
        // 3. Set Browser Preferences
        // ---------------------------
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/directory/path"); // Custom download folder
        options.setExperimentalOption("prefs", prefs);

        // ---------------------------
        // 4. Accept Insecure Certificates
        // ---------------------------
        options.setAcceptInsecureCerts(true);

        // ---------------------------
        // 5. Set ChromeDriver Executable Path
        // ---------------------------
        System.setProperty(
            "webdriver.chrome.driver",
				"D:\\1.Mypreparation4ccee\\2.Automation QA testing\\Rahul Shetty Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ---------------------------
        // 6. Initialize WebDriver with Options
        // ---------------------------
        WebDriver driver = new ChromeDriver(options);

        // ---------------------------
        // 7. Navigate to a site with an expired SSL certificate
        // ---------------------------
        driver.get("https://expired.badssl.com/");

        // ---------------------------
        // 8. Print page title
        // ---------------------------
        System.out.println("Page Title: " + driver.getTitle());

        // ---------------------------
        // 9. Close the browser (Optional)
        // ---------------------------
//        driver.quit();
    }
}

/*
 * Note:
 * - You may see a Selenium warning about CDP (Chrome DevTools Protocol) version mismatch:
 *   "Unable to find an exact match for CDP version 133..."
 *   This is harmless for basic browsing but can be fixed by updating Selenium and ChromeDriver to match your Chrome browser version.
 */
