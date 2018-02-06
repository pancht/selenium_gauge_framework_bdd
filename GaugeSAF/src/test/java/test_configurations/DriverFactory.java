package test_configurations;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

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
        String gridHubUrl = System.getenv("GridHubUrl");
        
        DesiredCapabilities capability = new DesiredCapabilities();
        
        //System.out.println(">>>>>>>>>>>>>>>>>>>" + browser + "<<<<<<<<<<<<<<<<<<<<<");
        
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(FIREFOX)) {
            //FirefoxDriverManager.getInstance().setup();
        	//System.out.println(">>>>>>>>>>>>>>>>>>>Firefox<<<<<<<<<<<<<<<<<<<<<");
        	
            //driver = new FirefoxDriver();
        	
        	capability = DesiredCapabilities.firefox();

			capability.setCapability("marionette", true);
			
        } else if (browser.toLowerCase().equals(IE)) {
            //InternetExplorerDriverManager.getInstance().setup();
        	//System.out.println(">>>>>>>>>>>>>>>>>>>Internet Explorer<<<<<<<<<<<<<<<<<<<<<");
        	
        	capability = DesiredCapabilities.internetExplorer();
        	
        	
            //driver = new InternetExplorerDriver();
        } else {
           // ChromeDriverManager.getInstance().setup();
        	/*System.out.println(">>>>>>>>>>>>>>>>>>>INSIDE CHROME<<<<<<<<<<<<<<<<<<<<<");
        	System.setProperty("webdriver.chrome.driver", "C:\\testing\\chromedriver.exe");*/
        	capability = DesiredCapabilities.chrome();

			ChromeOptions chromeOptions = getChromeOptions();

			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			
            //driver = new ChromeDriver(chromeOptions);
            
            
        }
        
        try {
			driver = new RemoteWebDriver(new URL(gridHubUrl), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
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