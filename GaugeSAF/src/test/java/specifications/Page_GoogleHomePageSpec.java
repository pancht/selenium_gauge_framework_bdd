package specifications;

import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.gauge.Step;

import pages.google.Page_GoogleHomePage;
import pages.google.search_result_page.Page_GoogleSearchResult;
import test_configurations.DriverFactory;


public class Page_GoogleHomePageSpec {

	private final WebDriver driver;
	Page_GoogleHomePage page_GoogleHomePage = null ;
	
    public Page_GoogleHomePageSpec() {
        this.driver = DriverFactory.getDriver();
        
    }
    
    public String localPart() {
        // Creating a random local part of an email address also used as username
        return UUID.randomUUID().toString();
    }
    
    @Step("Open google home page")
    public void navigateToSignUpPage() {
    	page_GoogleHomePage = PageFactory.initElements(driver, Page_GoogleHomePage.class);
        driver.get(Page_GoogleHomePage.google_url);
    }

    @Step("Type <sSearchText> in search field")
    public void typeSearchTextInSearchField(String sSearchText) {
        page_GoogleHomePage.typeSearchText(sSearchText);
    }
    
    @Step("Click google search button")
    public Page_GoogleSearchResult clickButton_GoogleSearch() {
    	WebDriverWait wait = new WebDriverWait(driver, 60);
    	wait.until(ExpectedConditions.elementToBeClickable(page_GoogleHomePage.btnSearchButton));
        page_GoogleHomePage.clickButton_Search();
        
        return new Page_GoogleSearchResult();
    }
    
    
    
    
}
