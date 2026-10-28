
Feature: Explore the Infoez application

  Background:
    Given Open the Infoez portal
    And Verify Infoez homepage is opened
    Then Click on "Sign in" button
    When User logs in with username "owner@infoez.com" and password "Owner@123"
    Then Verify user is logged in to the Infoez portal

  Scenario: Update user profile
    When Click on user profile and select "Profile" option
    Then Update user details and save the changes
    Then Verify updated value is reflect in the profile
    And Click on user profile and select "Log out" option
    Then Verify Infoez homepage is opened

  Scenario: Search for a business and city that exist
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User enter the business name "Nayudu Mobiles" in Search bar
    Then Click on "Search" button
    And Verify the search result has matching business name in dashboard
    Then Clear the search results
    When User enter the City name "Chennai" in city bar
    Then Click on "Search" button
    And Verify the search result has matching city name in dashboard
    Then Click on user profile and select "Log out" option
    
  Scenario: Search for a business and city that does not exist
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User enter the business name "Sathish Pvt Ltd" in Search bar
    And User enter the City name "US" in city bar
    Then Click on "Search" button
    And Verify the search result should not listed based on business name or city
    Then Click on user profile and select "Log out" option

  Scenario: Verify user can able to add the business as favorites
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User selects the first business as favorites
    Then Click on user profile and select "Favorites" option
    And verify selected business is listed under favorites page

  Scenario: Verify user can able send an enquiry
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User opens the first displayed business
    Then Verify send enquiry button is visible
    And Click on "Send Enquiry" button
    And Feed the enquiry message and submit it
    Then Click on user profile and select "My Enquiries" option
    Then Verify the recent enquiry is listed under my enquires page

  Scenario: Verify user can able mark the business favorite after navigating in the business
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User opens the first displayed business
    Then Verify "Save" button is visible inside the business
    And Click on "Save" button
    Then Click on user profile and select "Favorites" option
    And verify selected business is listed under favorites page

  Scenario: Verify user can access the claim ownership of the business
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User opens the first displayed business
    Then Verify "Claim" button is visible inside the business
    And Click on "Claim" button
    Then Provide a reason for the ownership claim
    And Click on "Submit claim" button
    Then Verify claim submitted successfully notification

  Scenario: Verify user can give review for the business
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User opens the first displayed business
    Then Verify "Write a review" button is visible inside the business
    And Click on "Write a review" button
    Then Provide rating and comments for the business
    Then Click on user profile and select "My Reviews" option
    And Verify the given rating and comments are listed

  Scenario: Verify user can delete the review
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User opens the first displayed business
    Then Verify "Write a review" button is visible inside the business
    And Click on "Write a review" button
    Then Provide rating and comments for the business
    Then Click on user profile and select "My Reviews" option
    And Verify the given rating and comments are listed
    Then Delete the review posted
    And Verify the review is removed
@login
    Scenario: Category filter functionality
    When User click on "Explore" menu in the navigation bar
    Then Verify explore tab is opened
    When User Click on All Categories dropdown
    When User selects "Beauty Clinic" option
    And Verify the business page is opened
    Then Verify send enquiry button is visible
    And Click on "Send Enquiry" button
    And Feed the enquiry message and submit it
    Then Click on user profile and select "Opening time" option
    Then Verify the recent enquiry is listed under my enquires page
    