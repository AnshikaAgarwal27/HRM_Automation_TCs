package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Property;
import utils.Selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


    public class Admin {
        WebDriver driver;
        Selenium selenium;
        Login login;
        public Admin(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver,this);
            selenium = new Selenium(driver);
            login = new Login(driver);
        }
        @FindBy(xpath = "//*[@title=\"Help\"]")
        WebElement helpBtn;
        @FindBy(xpath = "//a[normalize-space()='Nationalities']")
        WebElement nationalitiesBtn;
        @FindBy(xpath ="//nav[@class=\"oxd-topbar-body-nav\"]//li")
        List<WebElement> adminNavBar;
        @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
        WebElement naitonalititesAddBtn;
        @FindBy(xpath = "//h6[normalize-space()='Add Nationality']")
        WebElement addNationalityText;
        @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']")
        WebElement nameFieldOnAddNationalitiesPage;
        @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
        WebElement inputOfNameFieldOnAddNationalitiesPage;
        @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/p")
        WebElement requiredTextOnAddNationalitiesPage;
        @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button")
        List<WebElement> cancelNSaveBtnOnAddNationalitiesPage;
        @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]/button[2]")
        WebElement saveBtnOnAddNationalitiesPage;
        @FindBy(xpath = "//span[normalize-space()='Required']")
        WebElement requiredTextOnEmptyNationalities;
        @FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span\"]")
        WebElement totalNationalityRecordFound;
        @FindBy(xpath = "//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//span")
        WebElement alreadyExistTextOnNationalityPage;
        @FindBy(xpath = "//div[@class=\"orangehrm-module-field-row\"]/div")
        List<WebElement> moduleSwitches;
        @FindBy(xpath = "//button[@type=\"submit\"]")
        WebElement saveBtn;
        @FindBy(xpath = "//div[@class=\"oxd-topbar-header-title\"]//span")
        List<WebElement> modulePageTitle;
        @FindBy(xpath = "//ul[@class=\"oxd-main-menu\"]//span")
        List<WebElement> moduleNames;
        @FindBy(xpath = "//li[@class=\"oxd-userdropdown\"]")
        WebElement topRightBtn;
        @FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]/li")
        List<WebElement>  topRightOptionsList;
        @FindBy(xpath = "//*[@class=\"oxd-grid-2 orangehrm-about\"]/div")
        List<WebElement> aboutSectionDetails;
        @FindBy(xpath = "//button[@class=\"oxd-dialog-close-button oxd-dialog-close-button-position\"]")
        WebElement crossBtnOfAboutSection;
        @FindBy(xpath="//a[@class=\"orangehrm-support-link\"]")
        WebElement supportMailText;
        @FindBy(xpath = "//nav[@aria-label=\"Topbar Menu\"]//li")
        List<WebElement> allTopBarLinksOfAdminPage;

        public boolean isAdmin() {
            selenium.gotofunctionalities("Admin");
            //selenium.pause(2);
            selenium.waitToAppear(selenium.ModuleTitle("Admin"));
            return selenium.checkDisplay(selenium.ModuleTitle("Admin"));
        }
        public boolean isAllRequiredLinksPresentOnAdminPage() {
            selenium.gotofunctionalities("Admin");
            selenium.pause(2);
            int i = 0;
            boolean flag = false;
            for (WebElement e : allTopBarLinksOfAdminPage) {
                i++;
                if (i == 1) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link1-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 2) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link2-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 3) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link3-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 4) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link4-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 5) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link5-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 6) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link6-AdminTopBar"))) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 7) {
                    if (e.getText().equalsIgnoreCase(Property.getConfig("Link7-AdminTopBar"))) {
                        flag = true;
                    } else {
                        break;
                    }
                } else break;
            }
            if (flag == true) {
                return true;
            } else {

                return false;
            }
        }
        public boolean isAllRequiredLinksPresentOnAdminPageClickable() {
            selenium.gotofunctionalities("Admin");
            selenium.pause(2);
            int i = 0;
            boolean flag = false;
            for (WebElement e : allTopBarLinksOfAdminPage) {
                i++;
                if (i == 1) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 2) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 3) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 4) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 5) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 6) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                } else if (i == 7) {
                    if (e.isEnabled()) {
                        flag = true;
                    } else {
                        break;
                    }
                } else break;
            }
            if (flag == true) {
                return true;
            } else {

                return false;
            }

        }
        public boolean isHelpBtnOnAdminPageRedirectsCorrectly(){
            selenium.gotofunctionalities("Admin");
//        selenium.pause(2);
            selenium.waitToClick(helpBtn);
            // helpBtn.click();
            selenium.clickOn(helpBtn);
            selenium.pause(5);
            //selenium.windowSwitch();
            Set<String> handles = driver.getWindowHandles();
            Iterator it = handles.iterator();
            String parentid = (String) it.next();
            String childid = (String) it.next();
            driver.switchTo().window(childid);
            selenium.pause(5);
            String title= selenium.TitleOf();
            System.out.println(title);
            driver.close();
            driver.switchTo().window(parentid);
            selenium.pause(2);
            System.out.println(title);
            System.out.println(Property.getConfig("HelpPageTitle"));
            if(title.equalsIgnoreCase(Property.getConfig("HelpPageTitle"))){
                //if(selenium.compareTitle("HelpPageTitlte")){
                //if(selenium.CompareTitle("HelpPageTitle")){
                return true;
            }
            else{
                return false;
            }
        }
        public void nationalitiesFunctions() {
            selenium.gotofunctionalities("Admin");
            selenium.pause(5);
            int i=0;
            for(WebElement e: adminNavBar){
                i++;
                if(i==5){
                    selenium.clickOn(e);
                }
            }
            selenium.pause(5);
        }
        public boolean nationalitiesAddBtndisplayed() {
            nationalitiesFunctions();
            return naitonalititesAddBtn.isDisplayed();
        }
        public boolean nationalitiesAddBtnClickable() {
            nationalitiesFunctions();
            return naitonalititesAddBtn.isEnabled();
        }
        String totalNationalityBeforeAddition;
        public void clickOnNationalitiesAddBtn() {
            nationalitiesFunctions();
            totalNationalityBeforeAddition = totalNationalityRecordFound.getText();
            naitonalititesAddBtn.click();
            selenium.pause(5);
        }
        public boolean nationalitiesAddBtnRedirectsCorrectly() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            return addNationalityText.isDisplayed();
        }

        public boolean nameFieldPresentOnAddNationalitiesPage() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            return nameFieldOnAddNationalitiesPage.isDisplayed();
        }
        public boolean nameFieldPresentOnAddNationalitiesPageClickable() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            return inputOfNameFieldOnAddNationalitiesPage.isEnabled();
        }
        public boolean requiredTextPresentOnAddNationalitiesPage() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            return requiredTextOnAddNationalitiesPage.isDisplayed();
        }
        public boolean cancelNSaveBtnPresentOnAddNationalitiesPage() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            int i = 0;
            int flag = 0;
            for (WebElement e : cancelNSaveBtnOnAddNationalitiesPage) {
                i++;
                if (e.isDisplayed()) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            if (flag == 1) {
                return true;
            } else {
                return false;
            }
        }
        public boolean cancelNSaveBtnClickableOnAddNationalitiesPage() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            int i = 0;
            int flag = 0;
            for (WebElement e : cancelNSaveBtnOnAddNationalitiesPage) {
                i++;
                if (e.isEnabled()) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            if (flag == 1) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isRequiredPopupAppearsOnEmptyNationality(){
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            selenium.clickOn(saveBtnOnAddNationalitiesPage);
            //  selenium.pause(2);
            selenium.waitToAppear(requiredTextOnEmptyNationalities);
            return selenium.checkDisplay(requiredTextOnEmptyNationalities);
        }
        public boolean alreadyExistsPopAppearsOnAddingExistingNationality(){
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            selenium.enterText(inputOfNameFieldOnAddNationalitiesPage, "NationalityExistingInput");
            //  selenium.pause(2);
            selenium.waitToAppear(alreadyExistTextOnNationalityPage);
            return selenium.checkDisplay(alreadyExistTextOnNationalityPage);
        }

        public boolean totalNumberOfNationalitiesSameBeforeAndAfterAddingNewNationality() {
            nationalitiesFunctions();
            clickOnNationalitiesAddBtn();
            // selenium.pause(5);
            selenium.waitToClick(inputOfNameFieldOnAddNationalitiesPage);
            selenium.enterText(inputOfNameFieldOnAddNationalitiesPage, "NationalityInput");
            // selenium.pause(2);
            selenium.waitToClick(saveBtnOnAddNationalitiesPage);
            selenium.clickOn(saveBtnOnAddNationalitiesPage);
            //  selenium.pause(5);
            selenium.waitToAppear(totalNationalityRecordFound);
            if(totalNationalityRecordFound.getText().equalsIgnoreCase(totalNationalityBeforeAddition)){
                return false;
            }
            else {
                return false;
            }
        }
        public void goToswitchOffOnModuleFunctionality(){
            selenium.gotofunctionalities("Admin");
            selenium.pause(4);
            selenium.dropdowns("Configuration","Modules");
            selenium.pause(2);
            int k=0;
            for (WebElement e: moduleSwitches){
                k++;
                if(k==3){
                    selenium.clickOn(e);
                }
            }
//        selenium.pause(2);
            selenium.waitToClick(saveBtn);
            selenium.clickOn(saveBtn);
            selenium.pause(7);
        }
        public boolean switchOffModule(){
            goToswitchOffOnModuleFunctionality();
            int l=0;
            int flag=1;
            for(WebElement e: moduleNames){
                l++;
                if( selenium.CompareText(e, Property.getConfig("switchOffOnModule"))){
                    flag=0;
                    break;
                }
            }
            System.out.println(flag);
            if(flag==1){
                return true;
            }
            else{
                return false;
            }
        }
        public boolean switchOnModule(){
            goToswitchOffOnModuleFunctionality();
            selenium.pause(10);
            int flag=0;
            int l=0;
            for(WebElement e: moduleNames){
                l++;
                String tocompare= e.getText();
                //    if( selenium.CompareText(e, Property.getConfig("switchOffOnModule"))){
                if( tocompare.equalsIgnoreCase(Property.getConfig("switchOffOnModule")) ){
                    flag=1;
                    break;
                }
                else{
                    flag=0;
                }
            }
            System.out.println(flag);
            if(flag==1){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean isAboutDetailsCorrect() {
            topRightOptions(1);
            int i = 0;
            int flag = 0;
            for (WebElement e : aboutSectionDetails) {
                i = i + 2;
                flag = 0;
                if (e.getText().equalsIgnoreCase(Property.getConfig("CompanyName"))) {
                    flag = 1;
                } else if (e.getText().equalsIgnoreCase(Property.getConfig("Version"))) {
                    flag = 1;
                } else if (e.getText().equalsIgnoreCase(Property.getConfig("ActiveEmployees"))) {
                    flag = 1;
                } else if (e.getText().equalsIgnoreCase(Property.getConfig("EmployeesTerminated"))) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            }
            if (flag == 1) {
                return true;
            } else {
                return false;
            }

        }
        public boolean isSupportEmailCorrect(){
            selenium.clickOn(crossBtnOfAboutSection);
            topRightOptions(2);
            return selenium.CompareText(supportMailText, Property.getConfig("supportEmail"));
        }
        public void logout(){
            topRightOptions(4);
            selenium.pause(2);
        }
        public void topRightOptions(int optionNumber){
            topRightBtn.click();
            selenium.pause(2);
            int i=0;
            for(WebElement e:topRightOptionsList ){
                i++;
                if(i==optionNumber){
                    e.click();
                }
            }
            selenium.pause(2);
        }
    }



