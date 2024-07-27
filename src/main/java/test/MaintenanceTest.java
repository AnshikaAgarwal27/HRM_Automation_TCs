package test;

import Suite.Common;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Admin;
import pages.Buzz;
import pages.Login;
import pages.Maintenance;
import utils.DriverFactory;
import utils.Property;
import utils.Selenium;

import java.sql.SQLOutput;

public class MaintenanceTest extends Common {
    Login login;
    Maintenance maintenance;
    Selenium selenium;
    Admin admin;
    public WebDriver driver;
  // @BeforeSuite
//    public void launchWebsite() throws InterruptedException {
//       System.out.println("before Suite in maintainance");
//        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
//        driver.get(Property.getConfig("url"));
//        Thread.sleep(1000*10);
//        login =new Login(driver);
//        maintenance= new Maintenance(driver);
//        admin=new Admin(driver);
//        selenium = new Selenium(driver);
//    }
   @BeforeMethod
    public void login(){
        login.loginWithCorrectCredentials();
    }
    @Test(priority = 1)
    public void isAdministratorAccessibleWithoutPassword(){
        Assert.assertTrue(maintenance.isAdministratorAccessibleWithoutPswd());
    }
    @Test(priority = 2)
    public void isInvalidTextAppearWithWrongPassword(){
        Assert.assertTrue(maintenance.isAdministratorAccessibleWithWrongPswd());
    }
    @Test(priority = 3)
    public void isAdministratorAccessibleWithCorrectPswd(){
        Assert.assertTrue(maintenance.isAdministratorAccessibleWithCorrectPswd());
    }
    @AfterMethod
    public void logout(){
        selenium.pause(4);
        // driver.navigate().back();
        driver.navigate().to(Property.getConfig("url"));
        selenium.pause(2);
        admin.logout();
    }
}