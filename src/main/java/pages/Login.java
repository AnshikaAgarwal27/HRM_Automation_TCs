package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Property;
import utils.Selenium;

import java.util.*;

public class Login {
    WebDriver driver;
    Selenium selenium;
    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenium = new Selenium(driver);
    }
    @FindBy(xpath = "//img[@alt=\"company-branding\"]")
    WebElement companyLogo;
    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement usernameField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions orangehrm-login-action\"]/button")
    WebElement loginButton;
    @FindBy(xpath = "//div[@role=\"alert\"]//p")
    WebElement invalidCredentialPopUp;
    @FindBy(xpath = "//span[normalize-space()=\"Required\"]")
    WebElement requiredMessageForUsername;
    @FindBy(xpath = "//span[normalize-space()=\"Required\"]")
    WebElement requiredMessageForPassword;
    @FindBy(xpath = "//h6[@class=\"oxd-text oxd-text--h6 orangehrm-forgot-password-title\"]")
    WebElement resetPasswordText;
    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-login-forgot-header\"]")
    WebElement forgotPasswordBtn;
    @FindBy(xpath = "//div[@class=\"orangehrm-login-footer-sm\"]/a")
    List<WebElement> socialSiteLinks;
    @FindBy(xpath = "//span/h6[normalize-space()=\"Dashboard\"]")
    WebElement dashboardText;



    //--------------------------Methods---------------------------------------
    public boolean isWebsiteLogoPresent() {
        return companyLogo.isDisplayed();
    }
    public boolean isUsernameClickable() {
        return usernameField.isEnabled();
    }
    public boolean isPasswordClickable() {
        return usernameField.isEnabled();
    }
    public boolean isLoginButtonClickable() {
        return loginButton.isEnabled();
    }
    public WebElement usernamePswdXPATH(String usernameORPswd){
        WebElement e = driver.findElement(By.xpath("//input[@name=\""+usernameORPswd+"\"]"));
        return e;
    }
    public boolean isForgotPwdRedirectsToResetPage() {
        forgotPasswordBtn.click();
        //selenium.pause(10);
        selenium.waitToAppear(resetPasswordText);
        return resetPasswordText.isDisplayed();
    }
    public void enterUsernamePswd(String correctIncorrectName, String correctIncorrectPswd, WebElement waitForText){
        selenium.waitToClick(usernamePswdXPATH("username"));
        selenium.enterText(usernamePswdXPATH("username"), correctIncorrectName);
        //selenium.pause(1);
        selenium.waitToClick(usernamePswdXPATH("password"));
        selenium.enterText(usernamePswdXPATH("password"),correctIncorrectPswd);
        //selenium.pause(1);
        selenium.waitToClick(loginButton);
        selenium.clickOn(loginButton);
        selenium.waitToAppear(waitForText);
    }
    public boolean isWrongInfoGivingErrorPopup() {
        enterUsernamePswd("WrongUsername","WrongPassword", invalidCredentialPopUp);
        return invalidCredentialPopUp.isDisplayed();
    }
    public void loginWithCorrectCredentials() {
        enterUsernamePswd("CorrectUsername", "CorrectPassword", dashboardText);
    }

    public boolean isRedirectLoginBtnCorrectly() {
        loginWithCorrectCredentials();
        return dashboardText.isDisplayed();
    }
    public boolean isRequiredMessagesAppearForUsername() {
        loginButton.click();
        //selenium.pause(2);
        selenium.waitToAppear(requiredMessageForUsername);
        return requiredMessageForUsername.isDisplayed();
    }
    public boolean isRequiredMessagesAppearForPassword() {
        loginButton.click();
        //selenium.pause(2);
        selenium.waitToAppear(requiredMessageForPassword);
        return requiredMessageForPassword.isDisplayed();
    }

    public boolean isSociaLinkRedirectsCorrectly() {
        driver.navigate().back();
        int i = 0;
        int flag = 0;
        for (WebElement e : socialSiteLinks) {
            flag = 0;
            i++;
            e.click();
            selenium.pause(5);
            Set<String> handles = driver.getWindowHandles();
            Iterator it = handles.iterator();
            String parentid = (String) it.next();
            String childid = (String) it.next();
            driver.switchTo().window(childid);
            selenium.pause(5);
//            selenium.windowSwitch();
            if (driver.getTitle().equalsIgnoreCase(Property.getConfig("LinkedinTitle"))) {
                flag = 1;
                System.out.println(driver.getTitle());
                driver.close();
                driver.switchTo().window(parentid);
                selenium.pause(5);
            } else if (driver.getTitle().equalsIgnoreCase((Property.getConfig("facebookTitle")))) {
                flag = 1;
                System.out.println(driver.getTitle());
                driver.close();
                driver.switchTo().window(parentid);
                selenium.pause(5);
            } else if (driver.getTitle().equalsIgnoreCase((Property.getConfig("twitterTitle")))) {
                flag = 1;
                System.out.println(driver.getTitle());                driver.close();
                driver.switchTo().window(parentid);
                selenium.pause(15);
            } else if (driver.getTitle().equalsIgnoreCase((Property.getConfig("youTubeTitle")))) {
                flag = 1;
                System.out.println(driver.getTitle());                driver.close();
                driver.switchTo().window(parentid);
                selenium.pause(5);
            } else {
                break;
            }

//            driver.close();
//            selenium.pause(5);
//            driver.switchTo().window(parentid);
            selenium.pause(5);
        }
        if (flag == 1) {
            return true;
        } else {
            return false;
        }
    }


//    public void allModulesDirectsCorrectly(){
//        selenium.gotofunctionalities();
//    }

    //----------Dashboard Page---------------------------
    @FindBy(xpath = "//div[@class=\"oxd-grid-3 orangehrm-quick-launch\"]//p")
    List<WebElement> textOfAllQuickLaunchOptnOnDashboard;
    public boolean allRequiredQuickLaunchPresentOnDashboard() {
        //selenium.pause(5);
        selenium.waitToAppear(dashboardText);
        int i = 0;
        boolean flag = false;
        for (WebElement e : textOfAllQuickLaunchOptnOnDashboard) {
            i++;
            flag = false;
            if (selenium.checkDisplay(e)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        if (flag == true) {
            return true;
        } else {
            return false;
        }
    }
}