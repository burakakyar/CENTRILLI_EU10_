package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='login']")
    public WebElement inputLogin;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;
    

}
