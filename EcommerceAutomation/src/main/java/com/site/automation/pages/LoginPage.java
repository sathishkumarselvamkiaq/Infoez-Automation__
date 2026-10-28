/*In pages we are defining what to do, Contains page-specific locators and Selenium actions to interact with web elements.*/

package com.site.automation.pages;

import com.site.automation.base.BaseClass;
import com.site.automation.reusable.Reusable;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass
{	
	private String logInButton = "(//button[text()='Sign in'])[2]";
	String profileName = "Kumar", expectedCity ="", companyName = "", favoritesBusiness = "", enquires="", ratingComments="";
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	public void openApplication(String url) throws InterruptedException 
	{
        driver.get(url);
        Thread.sleep(2000);
    }
	
	public void verifyInfoezHomepageIsOpened() 
	{
		//Creating soft assert as a reusable method with failed message and xpath as as argument
		//As it is a resusable method for all validation we can utilize it which helps in reducing repeated codes
		Reusable.softAssert("Infoez home page is not opened", "//button[text()='Sign in']");
    }

	public static void clickTheButton(String buttonName) 
	{
		driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();
	}

	public void enterUsernameAndPassword(String username, String password) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath(logInButton)).click();
		Thread.sleep(5000);
	}

	public void verifyUserLoggedInToInfoezPage() throws InterruptedException 
	{
		Reusable.softAssert("User not logged into Infoez", "//button//span[@class='hidden sm:inline text-sm font-medium']");
		Thread.sleep(2000);
	}

	public void clickMenuInNavigationBar(String navigationMenu) 
	{
		driver.findElement(By.xpath("//a[text()='"+navigationMenu+"']")).click();
	}

	public void clickOptionUnderUserProfile(String profileOptions) throws InterruptedException 
	{
		Thread.sleep(5000);
		//driver.findElement(By.id("radix-:r3:")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radix-:r3:"))).click();
		driver.findElement(By.xpath("//div[text()='"+profileOptions+"']")).click();
		Thread.sleep(2000);
	}

	public void updateUserDetails() 
	{
		driver.findElement(By.xpath("//label[text()='Name']//following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='Name']//following-sibling::input")).sendKeys(profileName);
		driver.findElement(By.xpath("//button[text()='Save changes']")).click();
	}

	public void verifyUpdatedValueInUserProfile() throws InterruptedException 
	{
		Thread.sleep(3000);
		String actualName = driver.findElement(By.xpath("//span[@class='hidden sm:inline text-sm font-medium']")).getText();
		Assert.assertEquals(actualName, profileName, "Value Not matched");
		
		/*CHanging back to the original value*/
		driver.findElement(By.xpath("//label[text()='Name']//following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[text()='Name']//following-sibling::input")).sendKeys("Ravi");
		driver.findElement(By.xpath("//button[text()='Save changes']")).click();
		Thread.sleep(5000);
	}

	public void verifyExploreTabIsOpened() 
	{
		boolean explorePage = driver.findElement(By.xpath("//h1[contains(text(),'Businesses')]")).isDisplayed();
		Assert.assertTrue(explorePage, "Explore tab is not opened");
	}

	public void user_enter_the_business_name_in_search_bar(String businessName) 
	{
		companyName = businessName;
		driver.findElement(By.xpath("//form//input[@placeholder='Search…']")).sendKeys(businessName);
	}

	public void verify_the_search_result_has_matching_business_name_in_dashboard() throws InterruptedException 
	{
    	Thread.sleep(5000);
		String searchResult = driver.findElement(By.xpath("(//div[@class='flex items-start justify-between gap-2']//h3)[1]")).getText();
		Assert.assertEquals(searchResult, companyName, "Searched Business Not matched");
	}

	public void user_enter_the_city_name_in_city_bar(String city) 
	{
		expectedCity = city;
		driver.findElement(By.xpath("//form//input[@placeholder='City']")).sendKeys(city);
	}

	public void verify_the_search_result_has_matching_city_name_in_dashboard() throws InterruptedException 
	{
    	Thread.sleep(3000);
		String searchResult = driver.findElement(By.xpath("(//span[@class='flex items-center gap-1'])[1]")).getText();
		Assert.assertEquals(searchResult, expectedCity, "Searched city Not matched");
	}

	public void verifyTheSearchedBusinessOrCityIsNotListed() throws InterruptedException 
	{
    	Thread.sleep(3000);
		boolean searchResult = driver.findElement(By.xpath("//h3[text()='No businesses found']")).isDisplayed();
		Assert.assertTrue(searchResult, "Wrong result for non exist business or city search");
	}

	public void clearTheSearchResults() throws InterruptedException 
	{
		driver.findElement(By.xpath("//button[text()='Clear']")).click();
		Thread.sleep(2000);
	}

	public void user_selects_the_first_business_as_favorites() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@aria-label='Toggle favorite'])[1]")).click();
		favoritesBusiness = driver.findElement(By.xpath("(//div[@class='flex items-start justify-between gap-2']//h3)[1]")).getText();
		Thread.sleep(5000);
	}

	public void verify_selected_business_is_listed_under_favorites_page() throws InterruptedException 
	{
		String searchResult = driver.findElement(By.xpath("(//div[@class='flex items-start justify-between gap-2']//h3)[1]")).getText();
		Assert.assertEquals(searchResult, favoritesBusiness, "Business which marked as favorite by user is not listed under the favorite page");
		Thread.sleep(2000);
	}

	public void user_opens_the_first_displayed_business() throws InterruptedException 
	{
		Thread.sleep(5000);
		favoritesBusiness = driver.findElement(By.xpath("(//div[@class='flex items-start justify-between gap-2']//h3)[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='flex items-start justify-between gap-2']//h3)[1]")).click();
		Thread.sleep(2000);
	}

	public void verify_send_enquiry_button_is_visible() 
	{
		boolean sendEnquiryButton = driver.findElement(By.xpath("//button[text()='Send Enquiry']")).isDisplayed();
		Assert.assertTrue(sendEnquiryButton, "Send Enquiry button is not visible");
	}

	public void feed_the_enquiry_message_and_submit() throws Exception 
	{
		Thread.sleep(5000);
		enquires = "Requesting for the business details "+Reusable.generateRandomText(5);
		driver.findElement(By.xpath("//label[text()='Message']//following-sibling::textarea")).sendKeys(enquires);
		clickTheButton("Send enquiry");
		Thread.sleep(5000);
	}

	public void verifyRecentEnquiry() 
	{
		String actualEnquiry = driver.findElement(By.xpath("(//div[text()='"+favoritesBusiness+"']/..//following-sibling::p)[1]")).getText();
		Assert.assertEquals(actualEnquiry, enquires, "Enquiry value is not matching");
	}

	public void verify_button_is_visible_Inside_Business(String buttonName) throws Exception 
	{
		String buttonStatus = driver.findElement(By.xpath("//button[contains(@data-testid,'favorite-toggle-btn-')]")).getText();
		if(buttonStatus.equalsIgnoreCase("Saved"))
		{
			driver.findElement(By.xpath("//button[text()='Saved']")).click();
			Thread.sleep(2000);
		}
		boolean sendEnquiryButton = driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).isDisplayed();
		Assert.assertTrue(sendEnquiryButton, buttonName+" button is not visible");
	}

	public void provideReasonForTheBusiness() 
	{
		driver.findElement(By.xpath("//label[text()='Reason']//following-sibling::textarea")).sendKeys("I am the Owner");
	}

	public void verifyPopupNotification() 
	{
		driver.findElement(By.xpath("//span[text()='Close']/..")).click();
		
		boolean notification = driver.findElement(By.xpath("//div[text()='Claim already pending' or text()='Claim submitted. Our team will review shortly.']")).isDisplayed();
		Assert.assertTrue(notification, "Claim not submitted");
	}

	public void provideRatingAndCommentsForTheBusiness() 
	{
		String rating = Reusable.generateRandomNumber(1);
		ratingComments = "Provide good service "+Reusable.generateRandomText(5);
		
		driver.findElement(By.xpath("//button[@data-testid='review-star-"+rating+"']")).click();
		
		driver.findElement(By.xpath("//label[text()='Comment']//following-sibling::textarea")).sendKeys(ratingComments);
		
		clickTheButton("Post review");
	}

	public void verifyTheRatingAndComments() 
	{
		String actualComment = driver.findElement(By.xpath("//a[text()='"+favoritesBusiness+"']//following-sibling::p")).getText();
		Assert.assertEquals(actualComment, ratingComments, "Actual rating comment and Expected were not matched");
	}

	public void deleteTheReviewPosted() 
	{
		driver.findElement(By.xpath("(//button[contains(@data-testid,'delete-review-')])[1]")).click();
		driver.switchTo().alert().accept();
	}

	public void verifyReviewIsRemoved() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Review removed']")).isDisplayed();
	}

	public void user_click_on_all_categories_dropdown() throws InterruptedException 
	{
		
		driver.findElement(By.id("//button[@id='radix-:r3:']")).click();
		Thread.sleep(5000);
	}
	
}
