package Suite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.Admin;
import pages.Buzz;
import pages.Login;
import pages.Maintenance;
import utils.DriverFactory;
import utils.Property;
import utils.Selenium;

public class Common {

    public WebDriver driver;
    public Admin admin;
    public Buzz buzz;
    public Maintenance maintenance;
    public Login login;

    @BeforeSuite
    public void launchWebsite() throws InterruptedException {
        System.out.println("before Suite in common");
        driver = DriverFactory.launchDriver(Property.getConfig("browserName"));
        driver.get(Property.getConfig("url"));
        System.out.println(driver);
        Thread.sleep(1000*10);
        admin = new Admin(driver);
        buzz = new Buzz(driver);
        maintenance=new Maintenance(driver);
        login=new Login(driver);
    }
    @AfterSuite
    public void logout(){
        admin.logout();
    }
}
