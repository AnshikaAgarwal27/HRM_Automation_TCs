package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;
import utils.Selenium;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Buzz {
    WebDriver driver;
    Selenium selenium;
    public Buzz(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        selenium = new Selenium(driver);
    }

    public WebElement postONBuzz(String todo){
        String s = "//div[@class=\"oxd-buzz-post oxd-buzz-post--active\"]//"+ todo;
        WebElement e  = driver.findElement(By.xpath(s));
        return e;
    }
    @FindBy(xpath = "//div[@class=\"orangehrm-buzz-post-body\"]/p[1]")
    WebElement textOfPost;
    @FindBy(xpath = "//ul[@class=\"oxd-dropdown-menu\"]//i")
    List<WebElement> deleteEditPost;
    @FindBy(xpath = "//div[@role=\"document\"]//p")
    WebElement deleteConfirmationText;
    @FindBy(xpath = "//div[@class=\"orangehrm-modal-footer\"]/button")
    List<WebElement> cancelNDeleteBtnOptn;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement postBtn;
    @FindBy (xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-buzz-post-time\"]")
    List<WebElement>  dateNTime;
    @FindBy(xpath = "//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]//div[@class=\"orangehrm-buzz-post-footer\"]//p")
    List<WebElement> likeCommentShareCounts;
    @FindBy(xpath = "//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]//input")
    WebElement commentField;
    public void enterSomePost(){
        selenium.gotofunctionalities("Buzz");
        //selenium.pause(5);
        selenium.waitToClick(postONBuzz("textarea"));
        selenium.enterText(postONBuzz("textarea"), "post");
        selenium.waitToClick(postBtn);
        selenium.clickOn(postBtn);
        selenium.waitToAppear(textOfPost);
    }
    public boolean textOfPostIsCorrect(){
        enterSomePost();
        return selenium.CompareText(textOfPost,Property.getConfig("post"));
    }
    public boolean verifyDateNTime(){
        enterSomePost();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM hh:mm a");// Create object of SimpleDateFormat class and decide the format
        Date datenTimeObj = new Date();//get current date time with Date()
        String deviceDatenTimeObj= dateFormat.format(datenTimeObj);// Now format the date
        System.out.println("Current date and time is " +deviceDatenTimeObj);// Print the Date
        int i=0;
        int flag=0;

        for(WebElement e: dateNTime){
            i++;
            if(i==1){
                if(deviceDatenTimeObj.equalsIgnoreCase(e.getText())){
                    System.out.println("Post's date and Time: "+e.getText());
                    flag=1;
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        if(flag==1){
            return true;
        }
        else {
            return false;
        }
    }
    public WebElement likeCommentShareBtnXPATH(String likeCommentShareBtn){
        WebElement e = driver.findElement(By.xpath("//div[@class=\"oxd-grid-1 orangehrm-buzz-newsfeed-posts\"]/div[1]//div[@class=\"orangehrm-buzz-post-footer\"]//div[1]/"+likeCommentShareBtn));
        return e;
    }
    public boolean isLikeBtnPresent(){
        selenium.gotofunctionalities("Buzz");
        // selenium.pause(2);
        selenium.waitToAppear(likeCommentShareBtnXPATH("div"));
        return selenium.checkDisplay(likeCommentShareBtnXPATH("div"));
    }
    public boolean isCommentBtnPresent(){
        selenium.gotofunctionalities("Buzz");
        //selenium.pause(2);
        selenium.waitToAppear(likeCommentShareBtnXPATH("button[1]"));
        return selenium.checkDisplay(likeCommentShareBtnXPATH("button[1]"));
    }
    public boolean isShareBtnPresent(){
        selenium.gotofunctionalities("Buzz");
        //selenium.pause(5);
        selenium.waitToAppear(likeCommentShareBtnXPATH("button[2]"));
        return selenium.checkDisplay(likeCommentShareBtnXPATH("button[2]"));
    }
    public boolean isLikeBtnClickable(){
        selenium.gotofunctionalities("Buzz");
        // selenium.pause(2);
        selenium.waitToAppear(likeCommentShareBtnXPATH("div"));
        return selenium.checkClickable(likeCommentShareBtnXPATH("div"));
    }
    public boolean isCommentBtnClickable(){
        selenium.gotofunctionalities("Buzz");
        //selenium.pause(2);
        selenium.waitToAppear(likeCommentShareBtnXPATH("button[1]"));
        return selenium.checkClickable(likeCommentShareBtnXPATH("button[1]"));
    }
    public boolean isShareBtnClickable(){
        selenium.gotofunctionalities("Buzz");
        //selenium.pause(2);
        selenium.waitToAppear(likeCommentShareBtnXPATH("button[2]"));
        return selenium.checkClickable(likeCommentShareBtnXPATH("button[2]"));
    }
    public boolean checkLikeCommentShareCountWorkingFine(String likeCmntShareCount, int count){
        selenium.pause(5);
        int i=0;
        int flag=0;
        for(WebElement e: likeCommentShareCounts){
            i++;
            if(i==count){
                System.out.println("in 1if"+flag);
                System.out.println(e.getText());
                System.out.println(Property.getConfig(likeCmntShareCount));
                if(selenium.CompareText(e,Property.getConfig(likeCmntShareCount))){//count
                    flag=1;
                    System.out.println("in if:"+flag);
                }
                else{
                    break;
                }
            }
        }
        System.out.println("out of if:"+flag);
        if(flag==1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isLikeCountWorkingFine(){
        selenium.gotofunctionalities("Buzz");
//        selenium.pause(4);
        selenium.waitToClick(likeCommentShareBtnXPATH("div"));
        selenium.clickOn(likeCommentShareBtnXPATH("div"));
        selenium.pause(2);
        return checkLikeCommentShareCountWorkingFine("LikeCount",1);
    }
    public boolean isCommentCountWorkingFine(){
        selenium.gotofunctionalities("Buzz");
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        WebElement aboutMe;
        //      aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_me")));

        //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        //   wait.until(ExpectedConditions.elementToBeClickable(likeCommentShareBtnXPATH("button[1]")));

//        selenium.pause(4);
        selenium.waitToClick(likeCommentShareBtnXPATH("button[1]"));
        selenium.clickOn(likeCommentShareBtnXPATH("button[1]"));
        // selenium.pause(2);
        selenium.waitToClick(commentField);
        selenium.enterText(commentField,"comment");
        //  selenium.pause(2);
        selenium.waitToClick(commentField);
        selenium.pressEnter(commentField);
        selenium.pause(2);
        return checkLikeCommentShareCountWorkingFine("CommentCount",2);
    }
    public boolean deletePost(){
        int i=0;
        for(WebElement e: deleteEditPost){
            i++;
            if(i==1){
                selenium.clickOn(e);
                selenium.pause(2);
            }
        }
        int f=0;
        int flag=0;
        for(WebElement e: cancelNDeleteBtnOptn){
            f++;
            if(f==1){
                //checked cancel button appears or not
                if(selenium.checkDisplay(e)){
                    flag=1;
                    System.out.println("a");
                }
            }
            else if(f==2){
                //checked delete button appears or not
                if(selenium.checkDisplay(e)){
                    flag=1;
                    System.out.println("b");

                }
            }
            else{
                break;
            }
            System.out.println("c");
            System.out.println(flag);
        }
        System.out.println("d");
        System.out.println(flag);
        if(flag==1){
            return true;
        }
        else{
            return false;
        }
    }
}
