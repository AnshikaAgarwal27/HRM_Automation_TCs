package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Selenium;

import java.sql.DriverManager;

public class MyInfo {
    public WebDriver driver;
    Selenium selenium;
    public MyInfo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenium = new Selenium(driver);
    }
    @FindBy(xpath = "//div[@class=\"orangehrm-tabs\"]/div/a[normalize-space()='Qualifications']")
    WebElement qualificationBtn;
    @FindBy(xpath = "//div[@class=\"orangehrm-horizontal-padding orangehrm-top-padding\"]/h6")
    WebElement qualificationText;
    @FindBy(xpath = "//h6[normalize-space()='Work Experience']//following-sibling::button")
    WebElement addWorkExperienceBtn;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button[2]")
    WebElement saveBtn;
    @FindBy(xpath = "//label[normalize-space()='Company']/..//following-sibling::div/input")
    WebElement companyInputField;
    @FindBy(xpath = "//label[normalize-space()='Job Title']/..//following-sibling::div/input")
    WebElement jobTitleInputField;
    @FindBy(xpath = "//h6[normalize-space()='Work Experience']/../..//following-sibling::div//div/span")
    WebElement recordFoundText;
    String recordFoundTextBeforeAddition;
    public void goToQualificationBtnOnInfoPage(){
        selenium.gotofunctionalities("My Info");
        selenium.pause(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
//        selenium.pause(2);
        selenium.waitToClick(qualificationBtn);
        selenium.clickOn(qualificationBtn);
        //  selenium.pause(2);
        selenium.waitToAppear(qualificationText);
    }
    public boolean qualificationBtnRedirectsCorrectly(){
        goToQualificationBtnOnInfoPage();
        return selenium.checkDisplay(qualificationText);
    }
    public WebElement requiredText(String columnName){
        WebElement e = driver.findElement(By.xpath("//label[normalize-space()=\'"+columnName+"\']/..//following-sibling::span"));
        return e;
    }


    public WebElement getElement(String locator, String... text) {
        return driver.findElement(By.xpath(locator.replace("%txt%", text[0])));
    }


    String xpathForCompanyAndJobTitleInputField= "//label[normalize-space()='%txt%']/..//following-sibling::span";
//    WebElement xpathForCompanyreqText = driver.findElement(By.xpath(xpathForCompanyAndJobTitleInputField));
// WebElement xpathForJobTitleReqText= driver.findElement(By.xpath(xpathForCompanyAndJobTitleInputField.replaceAll("Company","Job Title")));

    public void requiredMsgAppearWithNoInput(WebElement requiredTextFor){
        goToQualificationBtnOnInfoPage();
        selenium.waitToClick(addWorkExperienceBtn);
        selenium.clickOn(addWorkExperienceBtn);
        // selenium.pause(2);
        selenium.waitToClick(saveBtn);
        selenium.clickOn(saveBtn);
        // selenium.pause(2);
        selenium.waitToAppear(requiredTextFor);
    }
    public boolean requiredCompanyMsgAppearWithNoInput(){
        requiredMsgAppearWithNoInput(requiredText("Company"));
        //  return selenium.checkDisplay(xpathForCompanyreqText);
        return selenium.checkDisplay(requiredText("Company"));
    }
    public boolean requiredJobMsgAppearWithNoInput(){
        requiredMsgAppearWithNoInput(selenium.getElement(xpathForCompanyAndJobTitleInputField, "Job Title"));
        //return selenium.checkDisplay(xpathForJobTitleReqText);
        return selenium.checkDisplay(selenium.getElement(xpathForCompanyAndJobTitleInputField, "Job Title"));
    }

    public boolean requiredMsgAppearWithInput( WebElement webElementField, String input, String requirementTextFor){
        goToQualificationBtnOnInfoPage();
        selenium.clickOn(addWorkExperienceBtn);
        //selenium.pause(2);
        selenium.waitToClick(webElementField);
        selenium.enterText(webElementField,input);
        //  selenium.pause(1);
        selenium.waitToClick(saveBtn);
        selenium.clickOn(saveBtn);
        //selenium.pause(2);
        selenium.waitToAppear(requiredText(requirementTextFor));
        return selenium.checkDisplay(requiredText(requirementTextFor));
    }
    public boolean requiredCompanyMsgAppearWithJobInput(){
        return requiredMsgAppearWithInput(jobTitleInputField,"JobTitle","Company");
    }
    public boolean requiredJobMsgAppearWithCompanyInput(){
        return requiredMsgAppearWithInput(companyInputField,"Company","Job Title");
    }
    public boolean workExperienceAdded(){
        goToQualificationBtnOnInfoPage();
        recordFoundTextBeforeAddition= recordFoundText.getText();
        selenium.clickOn(addWorkExperienceBtn);
        //selenium.pause(2);
        selenium.waitToClick(jobTitleInputField);
        selenium.enterText(jobTitleInputField,"JobTitle");
        //selenium.pause(1);
        selenium.waitToClick(companyInputField);
        selenium.enterText(companyInputField,"Company");
        //selenium.pause(1);
        selenium.waitToClick(saveBtn);
        selenium.clickOn(saveBtn);
        //selenium.pause(2);
        System.out.println(recordFoundTextBeforeAddition);
        // selenium.pause(2);
        selenium.waitToAppear(recordFoundText);
        //if(recordFoundText.getText().equalsIgnoreCase(recordFoundTextBeforeAddition)){
        if(selenium.CompareText(recordFoundText,recordFoundTextBeforeAddition)){
            return false;
        }
        else{
            return true;
        }
    }
}