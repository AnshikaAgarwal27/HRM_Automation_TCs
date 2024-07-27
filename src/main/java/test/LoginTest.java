package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.DriverFactory;
import utils.Property;

public class LoginTest {
    Login login;
    public WebDriver driver;
    @BeforeClass
    public void launchWebsite() throws InterruptedException {
        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
        driver.get(Property.getConfig("url"));
        Thread.sleep(1000*10);
        login =new Login(driver);
    }

    @Test(priority = 1)
    public void isWebsiteLogoPresentOnLoginPage(){
        Assert.assertTrue(login.isWebsiteLogoPresent());
    }
    @Test(priority =2)
    public void isUsernameFieldClickable(){
        Assert.assertTrue(login.isUsernameClickable());
    }
    @Test(priority =3)
    public void isPasswordFieldClickable(){
        Assert.assertTrue(login.isPasswordClickable());
    }
    @Test(priority = 4)
    public void isLoginButtonOnLoginPageClickable(){
        Assert.assertTrue(login.isLoginButtonClickable());}
    @Test(priority = 5)
    public void isRequiredMessageAppearsForUsername(){
        Assert.assertTrue(login.isRequiredMessagesAppearForUsername());}
    @Test(priority = 6)
    public void isRequiredMessageAppearsForPassword(){
        Assert.assertTrue(login.isRequiredMessagesAppearForPassword());}
    @Test(priority = 7)
    public void isInvalidCredentialPopUpAppears(){
        Assert.assertTrue(login.isWrongInfoGivingErrorPopup());}
    @Test(priority = 8)
    public void isForgotPasswordBtnRedirectsToResetPage(){
        Assert.assertTrue(login.isForgotPwdRedirectsToResetPage());
        driver.navigate().back();
    }
    //  Assert.assertTrue(login.isSociaLinkRedirectsCorrectly());}
    @Test(priority = 9)
    public void isCorrectCredentialsRedirectsToDashboardPage(){
        Assert.assertTrue(login.isRedirectLoginBtnCorrectly());}
    @Test(priority = 10)
    public void allRequiredQuickLaunchPresentOnDashboard(){
        Assert.assertTrue(login.allRequiredQuickLaunchPresentOnDashboard());}
}
