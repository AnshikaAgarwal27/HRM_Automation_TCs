package test;

import Suite.Common;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Admin;
import pages.Buzz;
import pages.Login;
import utils.DriverFactory;
import utils.Property;
import utils.Selenium;

public class BuzzTest extends Common  {

//    Buzz buzz;
//   Login login;
//    Admin admin;
//   Selenium selenium;
//   WebDriver driver ;

   BuzzTest(WebDriver driver){
       this.driver = driver;
   }

   @BeforeClass
    public void launchWebsite() throws InterruptedException {
       System.out.println("before Suite in buzz");
//        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
//        driver.get(Property.getConfig("url"));
//        Thread.sleep(1000*10);
      //buzz= new Buzz(driver);
//        admin=new Admin(driver);
//       selenium = new Selenium(driver);
//        login =new Login(driver);
//       admin =new Admin(driver);
//       selenium = new Selenium(driver);
       //System.out.println("before class in buzz " + driver);
    }
    @BeforeMethod
    public void login(){
        System.out.println("login method in buzz " + driver);
        login.isRedirectLoginBtnCorrectly();
    }
    @Test(priority = 1)
    public void isDateNTimeOfPostIsCorrect() {
        Assert.assertTrue(buzz.verifyDateNTime());
    }
    @Test(priority = 2)
    public void isTextOfPostIsCorrect() {
        Assert.assertTrue(buzz.textOfPostIsCorrect());
    }
    @Test(priority = 3)
    public void isLikeBtnPresentOnPost() {
        Assert.assertTrue(buzz.isLikeBtnPresent());}
    @Test(priority = 4)
    public void isCommentBtnPresentOnPost(){
        Assert.assertTrue(buzz.isCommentBtnPresent());
    }
    @Test(priority = 5)
    public void isShareBtnPresentOnPost() {
        Assert.assertTrue(buzz.isShareBtnPresent());}
    @Test(priority =6)
    public void isLikeBtnPresentOnPostClickable() {
        Assert.assertTrue(buzz.isLikeBtnClickable());}
    @Test(priority = 7)
    public void isCommentBtnPresentOnPostClickable() {
        Assert.assertTrue(buzz.isCommentBtnClickable());}
    @Test(priority =8)
    public void isShareBtnPresentOnPostClickable() {
        Assert.assertTrue(buzz.isShareBtnClickable());}
    @Test(priority =9)
    public void isLikeCounterPresentOnPostWorkingFine() {
        Assert.assertTrue(buzz.isLikeCountWorkingFine());}
    @Test(priority = 10)
    public void isCommentCounterPresentOnPostWorkingFine() {
        Assert.assertTrue(buzz.isCommentCountWorkingFine());
    }
    @AfterMethod
    public void logout(){
        admin.logout();
    }
}
