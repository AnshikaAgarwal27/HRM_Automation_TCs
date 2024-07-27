package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin;
import pages.Login;
import pages.PIM;
import utils.DriverFactory;
import utils.Property;

public class PIMTest {
    Login login;
    PIM pim;
    Admin admin;
    public WebDriver driver;
    @BeforeClass
    public void launchWebsite() throws InterruptedException {
        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
        driver.get(Property.getConfig("url"));
        Thread.sleep(1000*10);
        login =new Login(driver);
        pim= new PIM(driver);
        admin=new Admin(driver);
    }
    @BeforeMethod
    public void login(){
        login.isRedirectLoginBtnCorrectly();
    }
    @Test(priority = 1)
    public void isRequiredTextForFieldNameWithNoInput(){
        Assert.assertTrue(pim.requiredTextForFieldNameWithNoInput());
    }
    @Test(priority = 2)
    public void isRequiredTextForScreenWithNoInput(){
        Assert.assertTrue(pim.requiredTextForScreenWithNoInput());
    }
    @Test(priority = 3)
    public void isRequiredTextForTypeWithNoInput(){
        Assert.assertTrue(pim.requiredTextForTypeWithNoInput());
    }
    @Test(priority = 4)
    public void isRequiredTextForScreenWithFieldInput(){
        Assert.assertTrue(pim.requiredTextForScreenWithFieldInput());}
    @Test(priority = 5)
    public void isRequiredTextForTypeWithFieldInput(){
        Assert.assertTrue(pim.requiredTextForTypeWithFieldInput());}

    @Test(priority = 6)
    public void isRequiredTextForFieldNameWithScreenInput(){
        Assert.assertTrue(pim.requiredTextForFieldWithScreenInput());
    }
    @Test(priority = 7)
    public void isRequiredTextForFieldNameWithScreenNTypeInput(){
        Assert.assertTrue(pim.requiredTextForFieldWithScreenNTypeInput());
    }
    @Test(priority = 8)
    public void isRequiredTextForScreenWithFieldNTypeInput(){
        Assert.assertTrue(pim.requiredTextForScreenWithFieldNTypeInput());
    }
    @Test(priority =9)
    public void isRequiredTextForScreenWithTypeInput(){
        Assert.assertTrue(pim.requiredTextForScreenWithTypeInput());
    }
    @Test(priority = 10)
    public void isRequiredTextForTypeWithScreenInput(){
        Assert.assertTrue(pim.requiredTextForTypeWithScreenInput());
    }
    @Test(priority = 11)
    public void isRequiredTextForTypeWithScreenNFieldInput(){
        Assert.assertTrue(pim.requiredTextForTypeWithScreenNFieldInput());
    }
    @Test(priority = 12)
    public void isSaveConfigure(){
        Assert.assertTrue(pim.saveConfigure());
    }
    @AfterMethod
    public void logout(){
        admin.logout();
    }
}
