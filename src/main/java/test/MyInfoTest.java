package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Admin;
import pages.Login;
import pages.MyInfo;
import utils.DriverFactory;
import utils.Property;

public class MyInfoTest {
    Login login;
    MyInfo myInfo;
    Admin admin;
    public WebDriver driver;
    @BeforeClass
    public void launchWebsite() throws InterruptedException {
        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
        driver.get(Property.getConfig("url"));
        Thread.sleep(1000*10);
        login =new Login(driver);
        myInfo= new MyInfo(driver);
        admin=new Admin(driver);
    }
    @BeforeMethod
    public void login(){
        login.isRedirectLoginBtnCorrectly();
    }
    @Test(priority = 1)
    public void isQualificationBtnRedirectsCorrectly(){
        Assert.assertTrue(myInfo.qualificationBtnRedirectsCorrectly());}
    @Test(priority = 2)
    public void isRequiredCompanyMsgAppearWithNoInput(){
        Assert.assertTrue(myInfo.requiredCompanyMsgAppearWithNoInput());}
    @Test(priority = 3)
    public void isRequiredJobMsgAppearWithNoInput(){
        Assert.assertTrue(myInfo.requiredJobMsgAppearWithNoInput());
    }
    @Test(priority = 4)
    public void isRequiredCompanyMsgAppearWithJobInput(){
        Assert.assertTrue(myInfo.requiredCompanyMsgAppearWithJobInput());}
    @Test(priority = 5)
    public void isRequiredJobMsgAppearWithCompanyInput(){
        Assert.assertTrue(myInfo.requiredJobMsgAppearWithCompanyInput());}
    @Test(priority = 6)
    public void isWorkExperienceAdded(){
        Assert.assertTrue( myInfo.workExperienceAdded());
    }
    @AfterMethod
    public void logout(){
        admin.logout();
    }
}
