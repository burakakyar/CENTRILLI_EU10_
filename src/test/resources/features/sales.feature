Feature: Sales Functionalities
  US 37 - Sales Functionality (Sales/Orders/Customers)
  Acceptance Criteria:
  1. Verify that user can create a Customer
  2. Verify that user cannot create a Customer without typing name (empty name)
  3. Verify that user can cancel creating by clicking Discard button
  4. Verify that page title is changed to the new Customer name after user create the Customer
  5. Verify that “Contact created” message is displayed at the bottom of the page (after creating a new Customer).
  6. Verify that user can find the new created Customer under Customers list by using search box.
  7. Verify that user can change Customers display to Kanban / List
  8- Verify that all Customers number increased 1

  Background: I am on the Customers page
    Given User is on the login page
    When User enters the username
    And User enters the password
    And User clicks the login button
    And User should see the main page
    And User clicks the Sales button
    And User clicks the Customers button
    Then User should see the Customers Page

  @wip
  Scenario: Verify that user can create a Customer
    When I click on the Create button
    And I enter a valid name for the Customer
    And I click on the Save button
    Then the page title should contain the new Customer name
    And a "Contact created" message should be displayed
    And the new Customer should be listed in the Customers list


  Scenario: Verify that user cannot create a Customer without typing name (empty name)
    When I click on the Create button
    And I leave the name field empty
    And I click on the Save button
    Then an error message should be displayed


  Scenario: Verify that user can cancel creating by clicking Discard button
    When I click on the Create button
    And I click on the Discard button
    Then I should be redirected back to the Customers page


  Scenario: Verify that user can change Customers display to Kanban / List
    When I select Kanban or List option
    Then the Customers display should change accordingly


  Scenario: Verify that all Customers number increased 1
    When I count the number of Customers
    And I click on the Create button
    And I enter a valid name for the Customer
    And I click on the Save button
    Then the number of Customers should increase by 1
