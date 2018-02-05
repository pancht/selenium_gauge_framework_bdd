package test_configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.thoughtworks.gauge.*;

public class DriverFactory {
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";
    private static final String DEFAULT = "chrome";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void Setup() {
        // Uses chrome driver by default
        String browser = System.getenv("BROWSER");
        
        //System.out.println(">>>>>>>>>>>>>>>>>>>" + browser + "<<<<<<<<<<<<<<<<<<<<<");
        
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(FIREFOX)) {
            //FirefoxDriverManager.getInstance().setup();
        	//System.out.println(">>>>>>>>>>>>>>>>>>>Firefox<<<<<<<<<<<<<<<<<<<<<");
        	
            driver = new FirefoxDriver();
        } else if (browser.toLowerCase().equals(IE)) {
            //InternetExplorerDriverManager.getInstance().setup();
        	//System.out.println(">>>>>>>>>>>>>>>>>>>Internet Explorer<<<<<<<<<<<<<<<<<<<<<");
        	
            driver = new InternetExplorerDriver();
        } else {
           // ChromeDriverManager.getInstance().setup();
        	/*System.out.println(">>>>>>>>>>>>>>>>>>>INSIDE CHROME<<<<<<<<<<<<<<<<<<<<<");
        	System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver.exe");*/
        	ChromeOptions chromeOptions = getChromeOptions();
            driver = new ChromeDriver(chromeOptions);
        }
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
        driver.quit();
    }
    
    private static ChromeOptions getChromeOptions() {

		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		chromeOptions.addArguments("test-type");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--js-flags=--expose-gc");
		chromeOptions.addArguments("--enable-precise-memory-info");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--disable-default-apps");
		chromeOptions.addArguments("--disable-infobars");

		return chromeOptions;
	}
}