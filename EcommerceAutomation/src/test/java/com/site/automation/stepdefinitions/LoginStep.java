/*In steps java class as we are not declaring any codes and locators to make the framework reusable, readable, and easy to maintain.*/

package com.site.automation.stepdefinitions;

import com.site.automation.driver.DriverFactory;
import com.site.automation.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginStep 
{
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("Open the Infoez portal")
    public void openApplication() throws InterruptedException 
	{
        loginPage.openApplication("https://d2mojgetgp5xie.cloudfront.net/");
    }
	
	@And("Verify Infoez homepage is opened")
    public void verifyInfoezHomepageIsOpened() throws InterruptedException 
	{
        loginPage.verifyInfoezHomepageIsOpened();
    }
	
	@Then("Click on {string} button")
    public void clickTheButton(String buttonName) throws InterruptedException 
	{
		//System.out.println(buttonName);
        LoginPage.clickTheButton(buttonName);
    }

    @When("User logs in with username {string} and password {string}")
    public void loginToInfoez(String username, String password) throws InterruptedException 
    {
        loginPage.enterUsernameAndPassword(username, password);
    }
    
    @Then("Verify user is logged in to the Infoez portal")
    public void verifyUserLoggedInToInfoezPage() throws InterruptedException 
    {
    	loginPage.verifyUserLoggedInToInfoezPage();
    }
    
    @When("User click on {string} menu in the navigation bar")
    public void clickMenuInNavigationBar(String navigationMenu) throws InterruptedException 
    {
    	loginPage.clickMenuInNavigationBar(navigationMenu);
    }
    
    @When("Click on user profile and select {string} option")
    public void clickOptionUnderUserProfile(String profileOptions) throws InterruptedException 
    {
    	loginPage.clickOptionUnderUserProfile(profileOptions);
    }

    @Then("Update user details and save the changes")
    public void updateUserDetails() 
    {
        loginPage.updateUserDetails();
    }
    
    @Then("Verify updated value is reflect in the profile")
    public void verifyUpdatedValueInUserProfile() throws InterruptedException 
    {
        loginPage.verifyUpdatedValueInUserProfile();
    }

    @Then("Verify explore tab is opened")
    public void verifyExploreTabIsOpened() 
    {
        loginPage.verifyExploreTabIsOpened();
    }
    
    @When("User enter the business name {string} in Search bar")
    public void user_enter_the_business_name_in_search_bar(String businessName) 
    {
        loginPage.user_enter_the_business_name_in_search_bar(businessName);
    }
    
    @Then("Verify the search result has matching business name in dashboard")
    public void verify_the_search_result_has_matching_business_name_in_dashboard() throws InterruptedException 
    {
        loginPage.verify_the_search_result_has_matching_business_name_in_dashboard();
    }
    
    @When("User enter the City name {string} in city bar")
    public void user_enter_the_city_name_in_city_bar(String city) 
    {
        loginPage.user_enter_the_city_name_in_city_bar(city);
    }
    
    @Then("Verify the search result has matching city name in dashboard")
    public void verify_the_search_result_has_matching_city_name_in_dashboard() throws InterruptedException 
    {
        loginPage.verify_the_search_result_has_matching_city_name_in_dashboard();
    }
    
    @Then("Verify the search result should not listed based on business name or city")
    public void verifyTheSearchedBusinessOrCityIsNotListed() throws InterruptedException 
    {
        loginPage.verifyTheSearchedBusinessOrCityIsNotListed();
    }
    
    @Then("Clear the search results")
    public void clearTheSearchResults() throws InterruptedException 
    {
        loginPage.clearTheSearchResults();
    }
    
    @When("User selects the first business as favorites")
    public void user_selects_the_first_business_as_favorites() throws Exception 
    {
        loginPage.user_selects_the_first_business_as_favorites();
    }
    
    @Then("verify selected business is listed under favorites page")
    public void verify_selected_business_is_listed_under_favorites_page() throws InterruptedException 
    {
        loginPage.verify_selected_business_is_listed_under_favorites_page();
    }
    
    @When("User opens the first displayed business")
    public void user_opens_the_first_displayed_business() throws InterruptedException 
    {
        loginPage.user_opens_the_first_displayed_business();
    }
    
    @Then("Verify send enquiry button is visible")
    public void verify_send_enquiry_button_is_visible() 
    {
        loginPage.verify_send_enquiry_button_is_visible();
    }
    
    @Then("Verify {string} button is visible inside the business")
    public void verify_button_is_visible_Inside_Business(String buttonName) throws Exception 
    {
        loginPage.verify_button_is_visible_Inside_Business(buttonName);
    }
    
    @Then("Feed the enquiry message and submit it")
    public void feed_the_enquiry_message_and_submit() throws Exception 
    {
        loginPage.feed_the_enquiry_message_and_submit();
    }
    
    @Then("Verify the recent enquiry is listed under my enquires page")
    public void verifyRecentEnquiry() 
    {
    	loginPage.verifyRecentEnquiry();
    }
    
    @Then("Provide a reason for the ownership claim")
    public void provideReasonForTheBusiness() 
    {
    	loginPage.provideReasonForTheBusiness();
    }
    
    @Then("Verify claim submitted successfully notification")
    public void verifyPopupNotification() 
    {
    	loginPage.verifyPopupNotification();
    }
    
    @Then("Provide rating and comments for the business")
    public void provideRatingAndCommentsForTheBusiness() 
    {
    	loginPage.provideRatingAndCommentsForTheBusiness();
    }
    
    @Then("Verify the given rating and comments are listed")
    public void verifyTheRatingAndComments() 
    {
    	loginPage.verifyTheRatingAndComments();
    }
    
    @Then("Delete the review posted")
    public void deleteTheReviewPosted() 
    {
    	loginPage.deleteTheReviewPosted();
    }
    
    @Then("Verify the review is removed")
    public void verifyReviewIsRemoved() throws InterruptedException 
    {
    	loginPage.verifyReviewIsRemoved();
    }
    
    @When("User Click on All Categories dropdown")
    public void user_click_on_all_categories_dropdown() throws InterruptedException 
    {
        loginPage.user_click_on_all_categories_dropdown();
    }
//    @When("User selects {string} option")
//    public void user_selects_option(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("Verify the business page is opened")
//    public void verify_the_business_page_is_opened() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    
    
}
