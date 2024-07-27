package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Selenium {
    WebDriver driver;
    public Selenium(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOn(WebElement webElement) {
        webElement.click();
    }
    public boolean checkDisplay(WebElement webElement){
        return webElement.isDisplayed();
    }
    public boolean checkClickable(WebElement webElement){
        return webElement.isEnabled();
    }
    public void windowSwitch(){
        Set<String> handles = driver.getWindowHandles();
        Iterator it = handles.iterator();
        String parentid = (String) it.next();
        String childid = (String) it.next();
        driver.switchTo().window(childid);
        pause(5);
    }
    public String TitleOf(){
        return driver.getTitle();
    }
    public String TextOf(WebElement webElement){
        return webElement.getText() ;
    }
    public boolean CompareText(WebElement webElement, String ToCompareWith){
        return TextOf(webElement).equalsIgnoreCase(ToCompareWith);}
    public void enterText(WebElement webElement,String Text){
        webElement.click();
        pause(1);
        delete(webElement);
        pause(1);
        webElement.sendKeys(Property.getConfig(Text));
    }
    public WebElement ModuleTitle(String title ){
        WebElement e = driver.findElement(By.xpath("//h6[normalize-space()=\""+title+"\"]"));
        return e;
    }
    public void pressEnter(WebElement webElement){
        // sending Ctrl+a by Keys.Chord()
        String s = Keys.chord(Keys.CONTROL, "a");
        webElement.sendKeys(s);
        // sending ENTER key
        webElement.sendKeys(Keys.ENTER);
        pause(2);
    }
    public void delete(WebElement webElement){
        // sending Ctrl+a by Keys.Chord()
        String s = Keys.chord(Keys.CONTROL, "a");
        webElement.sendKeys(s);
        // sending DELETE key
        webElement.sendKeys(Keys.DELETE);
        pause(2);
    }
    public void pause(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void gotofunctionalities(String ModuleName) {
        WebElement e= driver.findElement(By.xpath("//span[text()=\""+ModuleName+"\"]"));
        e.click();
    }
    public void dropdowns(String navbarOptn , String dropdownOptn){
        WebElement f= driver.findElement(By.xpath("//span[normalize-space()=\""+navbarOptn+"\"]/i"));
        clickOn(f);
        System.out.println(f);
        WebElement e = driver.findElement(By.xpath("//li[normalize-space()=\""+dropdownOptn+"\"]/a"));
        System.out.println(e);
        clickOn(e);
    }

    public void waitToClick(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToAppear(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitToClickString(String webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(webElement)));
    }

    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    //  wait.until(ExpectedConditions.elementToBeClickable(likeCommentShareBtnXPATH("button[1]")));
    public WebElement getElement(String locator, String text) {
        return driver.findElement(By.xpath(locator.replace("%txt%", text)));
    }
}
