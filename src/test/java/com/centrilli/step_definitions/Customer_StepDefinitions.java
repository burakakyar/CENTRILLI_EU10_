package com.centrilli.step_definitions;

import com.centrilli.pages.DashboardPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer_StepDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    int totalNumber;

    @When("I click on the Create button")
    public void ı_click_on_the_create_button() {

        dashboardPage.createBtn.click();
    }

    @When("I enter a valid name for the Customer")
    public void ı_enter_a_valid_name_for_the_customer() {
        if (dashboardPage.radioBtnPerson.isSelected()) {
            dashboardPage.inputField.sendKeys(ConfigurationReader.getProperty("customerName"));
        } else {
            dashboardPage.radioBtnPerson.click();
            dashboardPage.inputField.sendKeys(ConfigurationReader.getProperty("customerName"));
        }
    }

    @When("I click on the Save button")
    public void ı_click_on_the_save_button() throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.saveBtn.click();
    }

    @Then("the page title should contain the new Customer name")
    public void the_page_title_should_contain_the_new_customer_name() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.msgOfCreation));
        String actual = Driver.getDriver().getTitle();
        String expected = ConfigurationReader.getProperty("customerName");
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
    public void the_new_customer_should_be_listed_in_the_customers_list() throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.customersBtn.click();
        Thread.sleep(5000);
        dashboardPage.searchBox.sendKeys((ConfigurationReader.getProperty("customerName") + Keys.ENTER));
        Thread.sleep(5000);
        String expectedSearch = ConfigurationReader.getProperty("customerName");
        String actualSearch = dashboardPage.firstMatch.getText();
        System.out.println("expectedSearch = " + expectedSearch + " actualSearch = " + actualSearch);
        Assert.assertEquals(expectedSearch, actualSearch);
    }

    @When("I leave the name field empty")
    public void ı_leave_the_name_field_empty() {
        // no need to write a code here
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(dashboardPage.errorMsg.isDisplayed());
    }

    @When("I click on the Discard button")
    public void ı_click_on_the_discard_button() throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.discardBtn.click();
    }

    @Then("I should be redirected back to the Customers page")
    public void ı_should_be_redirected_back_to_the_customers_page() {
        Assert.assertEquals("Customers".toLowerCase(), dashboardPage.customersPageTitle.getText().toLowerCase());
    }

    @When("I select Kanban or List option")
    public void ISelectKanbanOrListOption() throws InterruptedException {
// no need to write code here
    }

    @Then("the Customers display should change accordingly")
    public void the_customers_display_should_change_accordingly() throws InterruptedException {

        Thread.sleep(5000);
        dashboardPage.buttonList.click();
        Thread.sleep(5000);
        Assert.assertTrue(dashboardPage.tableOfList.isDisplayed());

        dashboardPage.buttonKanban.click();
        Thread.sleep(5000);
        Assert.assertTrue(dashboardPage.firstImage.isDisplayed());

    }

    int total = 34;

    @When("I count the number of Customers")
    public void ıCountTheNumberOfCustomers() {
        totalNumber = Integer.parseInt(dashboardPage.totalNumberOfCustomer.getText());
        System.out.println("totalNumber = " + totalNumber);

    }

    @Then("the number of Customers should increase by {int}")
    public void theNumberOfCustomersShouldIncreaseBy(int arg0) throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.customersBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(totalNumber == Integer.parseInt(dashboardPage.totalNumberOfCustomer.getText()) - arg0);

    }
}
