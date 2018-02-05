package pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.google.search_result_page.Page_GoogleSearchResult;

public class Page_GoogleHomePage extends BasePage {
	
	public static String google_url = "https://www.google.com" ;

	@FindBy( name = "q" ) 
	public WebElement txtSearchField;
	
	@FindBy( name = "btnK" )
	public WebElement btnSearchButton;
	
	public void typeSearchText(String sSearchText) {
		//txtSearchField.clear();
		txtSearchField.sendKeys(sSearchText);
	}

	public Page_GoogleSearchResult clickButton_Search() {
		btnSearchButton.click();	  
		
		return new Page_GoogleSearchResult();
	}
	

}
