package com.centrilli.step_definitions;

import com.centrilli.pages.DashboardPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer_StepDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    int totalNumber;
    Faker faker = new Faker();
    String name;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @When("I click on the Create button")
    public void ı_click_on_the_create_button() {

        dashboardPage.createBtn.click();
    }

    @When("I enter a valid name for the Customer")
    public void ı_enter_a_valid_name_for_the_customer() {

        name = faker.name().firstName();
        dashboardPage.inputField.sendKeys(name);
//        if (dashboardPage.radioBtnPerson.isSelected()) {
//            dashboardPage.inputField.sendKeys(ConfigurationReader.getProperty("customerName"));
//        } else {
//            dashboardPage.radioBtnPerson.click();
//            dashboardPage.inputField.sendKeys(ConfigurationReader.getProperty("customerName"));
//        }
    }

    @When("I click on the Save button")
    public void ı_click_on_the_save_button()  {
        //Thread.sleep(5000);
        dashboardPage.saveBtn.click();
    }

    @Then("the page title should contain the new Customer name")
    public void the_page_title_should_contain_the_new_customer_name()  {
        //Thread.sleep(5000);

        //wait.until(ExpectedConditions.visibilityOf(dashboardPage.msgOfCreation));

        //wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        wait.until(ExpectedConditions.titleContains(name));
        String actual = Driver.getDriver().getTitle();
        String expected = name;
        System.out.println("actual = " + actual);
        System.out.println("expected = " + expected);
        Assert.assertTrue(actual.contains(expected));
    }

    @Then("a {string} message should be displayed")
    public void a_message_should_be_displayed(String expectedMsg) {
        String actualMsg = dashboardPage.msgOfCreation.getText();
        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Then("the new Customer should be listed in the Customers list")
    public void the_new_customer_should_be_listed_in_the_customers_list()  {
        // Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        dashboardPage.customersBtn.click();
         //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.searchBox));
        dashboardPage.searchBox.sendKeys(name + Keys.ENTER);
        // Thread.sleep(5000);
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        String expectedSearch = name;
        String actualSearch = dashboardPage.firstMatch.getText();
        System.out.println("expectedSearch = " + expectedSearch + " actualSearch = " + actualSearch);
        Assert.assertEquals(expectedSearch, actualSearch);
    }

    @When("I leave the name field empty")
    public void ı_leave_the_name_field_empty() {
        if (!(dashboardPage.inputField.getText().isEmpty())){
            dashboardPage.inputField.clear();
        }
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(dashboardPage.errorMsg.isDisplayed());
    }

    @When("I click on the Discard button")
    public void ı_click_on_the_discard_button() {
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        dashboardPage.discardBtn.click();
    }

    @Then("I should be redirected back to the Customers page")
    public void ı_should_be_redirected_back_to_the_customers_page() {
        Assert.assertEquals("Customers".toLowerCase(), dashboardPage.customersPageTitle.getText().toLowerCase());
    }

    @When("I select Kanban or List option the Customers display should change accordingly")
    public void ISelectKanbanOrListOptionTheCustomersDisplayShouldChangeAccordingly() {

        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        dashboardPage.buttonList.click();

        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        Assert.assertTrue(dashboardPage.tableOfList.isDisplayed());

        dashboardPage.buttonKanban.click();
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));

        Assert.assertTrue(dashboardPage.firstImage.isDisplayed());
    }

    @When("I count the number of Customers")
    public void ıCountTheNumberOfCustomers() {
        totalNumber = Integer.parseInt(dashboardPage.totalNumberOfCustomer.getText());
        System.out.println("totalNumber = " + totalNumber);
    }

    @Then("the number of Customers should increase by {int}")
    public void theNumberOfCustomersShouldIncreaseBy(int arg0) {
        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        dashboardPage.customersBtn.click();

        wait.until(ExpectedConditions.invisibilityOf(dashboardPage.loadingBar));
        Assert.assertTrue(totalNumber == Integer.parseInt(dashboardPage.totalNumberOfCustomer.getText()) - arg0);

    }

}
