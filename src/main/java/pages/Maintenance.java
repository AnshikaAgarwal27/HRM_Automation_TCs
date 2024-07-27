package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Property;
import utils.Selenium;

public class Maintenance {
    WebDriver driver;
    Selenium selenium;
    public Maintenance(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        selenium = new Selenium(driver);
    }
    @FindBy(xpath = "//div[@class=\"orangehrm-admin-access-button-container\"]/button[2]")
    WebElement confirmBtn;
    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement pswdBtn;
    @FindBy(xpath = "//p[normalize-space()='Invalid credentials']")
    WebElement invalidText;
    @FindBy(xpath = "//span[normalize-space()='Required']")
    WebElement requiredText;
    @FindBy(xpath = "//h6[normalize-space()='Maintenance']")
    WebElement maintenanceText;
    public boolean isAdministratorAccessibleWithoutPswd(){
        selenium.gotofunctionalities("Maintenance");
        //selenium.pause(5);
        selenium.waitToClick(confirmBtn);
        selenium.clickOn(confirmBtn);
        //  selenium.pause(2);
        selenium.waitToAppear(requiredText);
        return selenium.checkDisplay(requiredText);
    }
    public boolean isAdministratorAccessibleWithWrongPswd(){
        selenium.gotofunctionalities("Maintenance");
        // selenium.pause(5);
        enterPassword("WrongPassword");
        return selenium.checkDisplay(invalidText);
    }
    public boolean isAdministratorAccessibleWithCorrectPswd(){
        selenium.gotofunctionalities("Maintenance");
        //selenium.pause(5);
        enterPassword("CorrectPassword");
        // selenium.pause(4);
        selenium.waitToAppear(maintenanceText);
        return selenium.checkDisplay(maintenanceText);
    }
    public void enterPassword(String password){
        selenium.waitToAppear(pswdBtn);
        selenium.enterText(pswdBtn, password);
        //selenium.pause(2);
        selenium.waitToClick(confirmBtn);
        selenium.clickOn(confirmBtn);
        selenium.pause(2);
    }
}