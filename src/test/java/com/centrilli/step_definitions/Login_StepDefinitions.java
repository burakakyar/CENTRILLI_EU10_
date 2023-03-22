package com.centrilli.step_definitions;

import com.centrilli.pages.DashboardPage;
import com.centrilli.pages.LoginPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions  {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigurationReader.getProperty("centrilli_url");
        Driver.getDriver().get(url);
    }

    @When("User enters the username")
    public void user_enters_the_username() {
        String username = ConfigurationReader.getProperty("centrilli_username");
        loginPage.inputLogin.sendKeys(username);
    }

    @When("User enters the password")
    public void user_enters_the_password() {
        String password = ConfigurationReader.getProperty("centrilli_password");
        loginPage.inputPassword.sendKeys(password);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginBtn.click();
    }

    @Then("User should see the main page")
    public void user_should_see_the_main_page()  {
        String expectedUser = "posmanager10";
        String actualUser = dashboardPage.accountElement.getText().toLowerCase();
        Assert.assertEquals(expectedUser, actualUser);
        System.out.println("expected ="+expectedUser+" actual ="+actualUser);
    }
    @When("User clicks the Sales button")
    public void user_clicks_the_sales_button() throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.salesBtn.click();
    }

    @When("User clicks the Customers button")
    public void user_clicks_the_customers_button() throws InterruptedException {
       Thread.sleep(5000);
        dashboardPage.customersBtn.click();
    }

    @Then("User should see the Customers Page")
    public void user_should_see_the_customers_page() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlToBe("https://qa.centrilli.com/web?#view_type=kanban&model=res.partner&menu_id=447&action=48"));
        String actualTitle = dashboardPage.customersPageTitle.getText();
        String expectedTitle = "Customers";

        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
