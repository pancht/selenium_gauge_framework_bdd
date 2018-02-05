package pages.google.search_result_page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.google.BasePage;

public class Page_GoogleSearchResult extends BasePage {

	//Search Result Body
		/**
		 * This is list of search list
		 * Most of the time Google finds great number of matching results 
		 * but only shows top 10 on first page
		 */
		@FindBy(xpath="//div[@class='srg']/div[@class='g']")
		List<WebElement> listSearchResultList;
		  
		/************************************************
		 * Define each search result structure
		 ************************************************/
		
		/**
		 * link of search result ( Clickable )
		 */
		By lnkResult = By.xpath( ".//a");
		
		/**
		 * link to search result ( Text only )
		 */
		By citeResult_actual_real_link = By.xpath(".//cite");
		
		/**
		 * Short description of search result
		 */
		By txtShortDescription = By.xpath(".//span[@class='st']");
		
		/**
		 * Status if you visited it before too
		 * 
		 * May or may not be present.
		 */
		By statusSearchVisits = By.xpath(".//div[@class='_Tib']");
		
		
		/***********************************************************
		 * Specify page actions
		 ***********************************************************/
		
		
		/**
		 * Get All Search results 
		 * 
		 * @return List<WebElement>
		 */
		public List<WebElement> get_SearchResults(){
			return listSearchResultList;
		}
		
		
		/**
		 * Click search result link 
		 * 
		 * @param we_search_result
		 */
		public void clickLinkSearchResult(WebElement we_search_result) {
			we_search_result.findElement(lnkResult).click();
		}
		
		/**
		 * Extract text link from search result
		 * 
		 * @param we_search_result
		 * 
		 * @return text_link_to_search_result
		 */
		public String getTextLink(WebElement we_search_result) {
			return we_search_result.findElement(citeResult_actual_real_link).getText();
		}
		
}
