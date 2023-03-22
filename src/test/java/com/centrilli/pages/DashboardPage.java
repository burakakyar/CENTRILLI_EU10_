package com.centrilli.pages;

import com.centrilli.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement accountElement;

    @FindBy(xpath = "/html/body/nav/div[2]/ul[1]/li[6]/a/span")
    public WebElement salesBtn;

    //Sales Page----------------------------
    @FindBy(xpath = "//a[@data-menu='447']")
    public WebElement customersBtn;

    //Customer Page-------------------------
    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement inputField;

    @FindBy(xpath = "//div[@class='o_radio_item'][1]")
    public WebElement radioBtnPerson;

    @FindBy(xpath = "//div[@class='o_radio_item'][2]")
    public WebElement radioBtnCompany;

    @FindBy(xpath = "//button[contains(@class, 'o-kanban-button-new')]")
    public WebElement customerCreateBtn;

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[@accesskey='j']")
    public WebElement discardBtn;

    @FindBy(xpath = "//div[@class='o_notification_title']")
    public WebElement warningMsg;

    @FindBy(xpath = "//div[@class='o_control_panel']//li[@class='active']")
    public WebElement customersPageTitle;

    @FindBy(xpath = "//*[.='Contact created']")
    public WebElement msgOfCreation;

    @FindBy(css = "input[class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//strong[@class='o_kanban_record_title oe_partner_heading'])[1]")
    public WebElement firstMatch;

    @FindBy(xpath = "//div[@class=\"o_notification undefined o_error\"]")
    public WebElement errorMsg;

    @FindBy(xpath = "//button[@accesskey='k']")
    public WebElement buttonKanban;

    @FindBy(xpath = "//button[@accesskey='l']")
    public WebElement buttonList;

    @FindBy(xpath = "(//img[@modifiers='{}'])[1]")
    public WebElement firstImage;


    @FindBy(xpath = "//table[contains(@class, 'table')]")
    public WebElement tableOfList;

    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement totalNumberOfCustomer;
    
    



    
}
