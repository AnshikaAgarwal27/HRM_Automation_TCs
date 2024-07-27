package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin;
import pages.Login;
import utils.DriverFactory;
import utils.Property;
import utils.Selenium;

public class AdminTest {
    Login login;
    Admin admin;
    Selenium selenium;
    public WebDriver driver;
    @BeforeClass
    public void launchWebsite() throws InterruptedException {
        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
        driver.get(Property.getConfig("url"));
        Thread.sleep(1000*10);
        login =new Login(driver);
        admin =new Admin(driver);
        selenium = new Selenium(driver);
    }
    @BeforeMethod
    public void login(){
        login.isRedirectLoginBtnCorrectly();
    }
    @Test(priority = 1)
    public void isAdminBtnRedirectsCorrectly(){
        Assert.assertTrue(admin.isAdmin());
        // admin.enterDetailsInSystemUserForm();
    }
    @Test(priority = 2)
    public void isAllLinksOnAdminPagePresent(){
        Assert.assertTrue(admin.isAllRequiredLinksPresentOnAdminPage());}
    @Test(priority = 3)
    public void isAllLinksOnAdminPagePresentClickable(){
        Assert.assertTrue(admin.isAllRequiredLinksPresentOnAdminPageClickable());
    }
    @Test(priority = 4)
    public void isChangeModuleFunctionalityWorkingFine(){
        Assert.assertTrue(admin.switchOffModule());
        Assert.assertTrue(admin.switchOnModule());
    }
    // @Test(priority = 16)
    public void isHelpBtnOnAdminPageRedirectsCorrectly(){
        //login.displayUserName();
        //Assert.assertTrue(admin.checkDropdownText());
        Assert.assertTrue(admin.isHelpBtnOnAdminPageRedirectsCorrectly());
        // Assert.assertTrue(pim.addEmployee());
    }
    @Test(priority = 6)
    public void isNationalitiesAddBtndisplayed(){
        Assert.assertTrue(admin.nationalitiesAddBtndisplayed());
    }
    @Test(priority = 7)
    public void isnationalitiesAddBtnclickable(){
        Assert.assertTrue(admin.nationalitiesAddBtnClickable());
    }
    @Test(priority = 8)
    public void isnationalitiesAddBtnRedirectsCorrectly(){
        Assert.assertTrue(admin.nationalitiesAddBtnRedirectsCorrectly());
    }
    @Test(priority = 9)
    public void isNameFieldPresentOnAddNationalitiesPage(){
        Assert.assertTrue(admin.nameFieldPresentOnAddNationalitiesPage());
    }
    @Test(priority = 10)
    public void isNameFieldPresentOnAddNationalitiesPageClickable(){
        Assert.assertTrue(admin.nameFieldPresentOnAddNationalitiesPageClickable());
    }
    @Test(priority = 11)
    public void isRequiredTextPresentOnAddNationalitiesPage(){
        Assert.assertTrue(admin.requiredTextPresentOnAddNationalitiesPage());
    }
    @Test(priority = 12)
    public void isCancelNSaveBtnPresentOnAddNationalitiesPage(){
        Assert.assertTrue(admin.cancelNSaveBtnPresentOnAddNationalitiesPage());
    }
    @Test(priority = 13)
    public void isCancelNSaveBtnClickableOnAddNationalitiesPage(){
        Assert.assertTrue(admin.cancelNSaveBtnClickableOnAddNationalitiesPage());
    }
    @Test(priority = 14)
    public void isRequiredPopUpAppearsOnEmptyNationality(){
        Assert.assertTrue(admin.isRequiredPopupAppearsOnEmptyNationality());
    }
    @Test(priority = 15)
    public void isAlreadyExistsPopAppearsOnAddingExistingNationality(){
        Assert.assertTrue(admin.alreadyExistsPopAppearsOnAddingExistingNationality());
    }
    @Test(priority = 16)
    public void isTotalNationalitiesSameBeforeAndAfterAddingNewNationality(){
        Assert.assertFalse(admin.totalNumberOfNationalitiesSameBeforeAndAfterAddingNewNationality());
    }
    @AfterMethod
    public void logout(){
        admin.logout();
    }
}