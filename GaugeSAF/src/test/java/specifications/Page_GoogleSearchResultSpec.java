package specifications;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.gauge.Step;

import pages.google.Page_GoogleHomePage;
import pages.google.search_result_page.Page_GoogleSearchResult;
import test_configurations.DriverFactory;

public class Page_GoogleSearchResultSpec {
	private final WebDriver driver;
	
	Page_GoogleSearchResult page_GoogleSearchResult;
	
	public Page_GoogleSearchResultSpec() {
        this.driver = DriverFactory.getDriver();
        
    }

	
	@Step("First link in search result should be <upwork_profile_link>")
    public void checkThatGivenLinkIsOnTopOfSearch(String sUpwork_Profile_Link) {
		page_GoogleSearchResult = PageFactory.initElements(driver, Page_GoogleSearchResult.class);
		WebElement first_search_result = page_GoogleSearchResult.get_SearchResults().get(0);
    	Assert.assertEquals(sUpwork_Profile_Link, page_GoogleSearchResult.getTextLink(first_search_result));
    }
	
}
