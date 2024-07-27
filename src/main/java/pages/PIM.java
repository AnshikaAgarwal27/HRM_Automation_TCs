package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Property;
import utils.Selenium;

import java.util.List;

public class PIM {
    WebDriver driver;
    Selenium selenium;

    public PIM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selenium = new Selenium(driver);
    }
    @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]/li[2]/a")
    WebElement PIMBtn;
    @FindBy(xpath = "//h5[normalize-space()='Employee Information']")
    WebElement employeeInformationTextOnPIMHomePage;
    @FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]/button")
    WebElement addButtonOnPIMHomePage;
    @FindBy(xpath = "//span[normalize-space()=\"Required\"]")
    WebElement requiredTextForFnameLname;
    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]//input")
    List<WebElement> inputFieldofnameNEmpIDOnAddEmployee;
    @FindBy(xpath = "//div[@class=\"oxd-input-group\"]//input")
    List<WebElement> verifyFnameLnamve;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button")
    List<WebElement> cancelNSaveButtonOnAddEmployee;
    @FindBy(xpath = "//div[@class=\"orangehrm-custom-fields\"]//button")
    WebElement saveBtnOnPersonalInfoPage;
    @FindBy(xpath = "//*[@class=\"oxd-topbar-body\"]//li[2]")
    WebElement employeeListBtn;
    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]//div[2]/input")
    WebElement empIDInputFieldToSearch;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button[2]")
    WebElement searchBtn;
    @FindBy(xpath = "//span[normalize-space()=\"No Records Found\"]")
    WebElement noRecordFoundText;
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordFoundTextForEmployee;
    @FindBy(xpath = "//div[@class=\"oxd-topbar-body\"]//li[1]")
    WebElement configuration;
    @FindBy(xpath = "//div[@class=\"orangehrm-header-container\"]/button/i")
    WebElement addCustomFields;
    @FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]/li[2]/a")
    WebElement customFields;
    @FindBy(xpath = "//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input")
    WebElement fieldName;
    @FindBy(xpath = "//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//i")
    List<WebElement> screenNTypeDropdown;
    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button[2]")
    WebElement saveCustomFieldBtn;
    @FindBy(xpath = "//div[@role=\"listbox\"]//div")
    List<WebElement>  dropdownOptnScreen;
    @FindBy(xpath = "//div[@class=\"oxd-select-dropdown --positon-bottom\"]//div")
    List<WebElement>  dropdownOptnType;
    @FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p --infotext\"]")
    WebElement remainingCustomFields;
    public WebElement requiredXpath(String columnName){
        WebElement e= driver.findElement(By.xpath("//label[normalize-space()=\'"+columnName+"\']/..//following-sibling::span"));
        return e;
    }
    String remainingCustomFieldsBeforeAddition;
    public void goToCustomFields() {
        selenium.gotofunctionalities("PIM");
        selenium.pause(2);
        // selenium.waitToClick();
//        selenium.waitToClickString();
        selenium.dropdowns("Configuration", "Custom Fields");
        //selenium.pause(5);
        selenium.waitToAppear(remainingCustomFields);
        remainingCustomFieldsBeforeAddition = selenium.TextOf(remainingCustomFields);
        selenium.waitToClick(addCustomFields);
        selenium.clickOn(addCustomFields);

        selenium.pause(2);
    }
    public void requiredTextWithNoInput(WebElement requiredTextFor ) {
        goToCustomFields();
        selenium.clickOn(saveCustomFieldBtn);
        //selenium.pause(2);
        selenium.waitToAppear(requiredTextFor);
    }
    public boolean requiredTextForFieldNameWithNoInput() {
        requiredTextWithNoInput(requiredXpath("Field Name"));
        return selenium.checkDisplay(requiredXpath("Field Name"));
    }
    public boolean requiredTextForScreenWithNoInput() {
        requiredTextWithNoInput(requiredXpath("Screen"));
        return selenium.checkDisplay(requiredXpath("Screen"));
    }
    public boolean requiredTextForTypeWithNoInput() {
        requiredTextWithNoInput(requiredXpath("Type"));
        return selenium.checkDisplay(requiredXpath("Type"));
    }
    public boolean requiredTextForScreenNTypeWithFieldInput(WebElement webElement, String input, String requiredText) {
        goToCustomFields();
        selenium.enterText(webElement, input);
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath(requiredText));
    }
    public boolean requiredTextForScreenWithFieldInput() {
        return requiredTextForScreenNTypeWithFieldInput(fieldName,"fieldName","Screen");
    }
    public boolean requiredTextForTypeWithFieldInput() {
        return requiredTextForScreenNTypeWithFieldInput(fieldName,"fieldName","Type");
    }
    public void enterScreenInput() {
        goToCustomFields();
        int i = 0;
        for (WebElement e : screenNTypeDropdown) {
            i++;
            if (i == 1) {
                selenium.clickOn(e);
                int j=0;
                for(WebElement f: dropdownOptnScreen){
                    j++;
                    if(j==2){
                        selenium.clickOn(f);}
                }

            }
        }
    }
    public boolean requiredTextForFieldWithScreenInput() {
        enterScreenInput();
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Field Name"));
    }
    public boolean requiredTextForFieldWithScreenNTypeInput() {
        enterScreenInput();
        someValueForType();
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Field Name"));
    }
    public void someValueForType(){
        int i = 0;
        for (WebElement e : screenNTypeDropdown) {
            i++;
            if (i == 2) {//select type
                selenium.clickOn(e);
                int j=0;
                for(WebElement f:dropdownOptnType){
                    j++;
                    if(j==2){//select some value for type
                        selenium.clickOn(f);}
                }
            }
        }
    }
    public boolean requiredTextForScreenWithFieldNTypeInput() {
        goToCustomFields();
        someValueForType();
        // selenium.pause(2);
        selenium.enterText(fieldName,"fieldName");
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Screen"));
    }
    public boolean requiredTextForScreenWithTypeInput() {
        goToCustomFields();
        someValueForType();
        // selenium.pause(2);
        selenium.waitToClick(saveCustomFieldBtn);
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Screen"));
    }
    public void someValueForScreen() {
        int i=0;
        for (WebElement e : screenNTypeDropdown) {
            i++;
            if (i == 1) {//select Screen
                selenium.clickOn(e);
                int j=0;
                for(WebElement f:dropdownOptnScreen){
                    j++;
                    if(j==2){//select some value for Screen
                        selenium.clickOn(f);}
                }
            }
        }
    }
    public boolean requiredTextForTypeWithScreenInput() {
        goToCustomFields();
        someValueForScreen();
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Type"));
    }

    public boolean requiredTextForTypeWithScreenNFieldInput() {
        goToCustomFields();
        someValueForScreen();
        // selenium.pause(2);
        selenium.waitToClick(fieldName);
        selenium.enterText(fieldName,"fieldName");
        selenium.clickOn(saveCustomFieldBtn);
        return selenium.checkDisplay(requiredXpath("Type"));
    }
    public boolean saveConfigure(){
        goToCustomFields();
        someValueForType();
        someValueForScreen();
        //selenium.pause(2);
        selenium.waitToClick(fieldName);
        selenium.enterText(fieldName,"fieldName");
        selenium.clickOn(saveCustomFieldBtn);
        // selenium.pause(5);
        selenium.waitToAppear(remainingCustomFields);
        if(selenium.CompareText(remainingCustomFields, remainingCustomFieldsBeforeAddition)){
            return false;
        }
        else{
            return true;
        }
    }
}