package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
String browser = System.getProperty("browser");
        
        if(browser != null) {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if(browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
            }
        } else {
            throw new IllegalArgumentException("Browser system property not set. Please provide a valid browser.");
        }
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Maximize the browser window
        driver.manage().window().maximize();
        // Navigate to Google
        driver.get("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        // Quit the driver instance
        if (driver != null) {
            driver.quit();
        }
    }
}
