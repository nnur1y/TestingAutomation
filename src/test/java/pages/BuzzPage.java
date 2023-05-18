package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuzzPage {
    WebDriver driver;
    String now;
    String post;

    @FindBy(linkText = "Buzz") WebElement buzzBtn;
    @FindBy(className = "oxd-buzz-post-input") WebElement postArea;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[1]/div[2]/form/div/div/button") WebElement postBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div") WebElement lastPost;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/div") WebElement likeBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/button[1]") WebElement commBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div/div[4]/div/form/div/div[2]/input") WebElement commInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div/div[2]/li/button") WebElement dot3Btn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[3]/div[1]/div/div[1]/div/div[2]/li/ul/li[2]") WebElement editBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/form/div[1]/div[2]/div/textarea") WebElement changingArea;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/form/div[3]/button") WebElement changingPostBtn;


    public BuzzPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBuzzPage(){
        buzzBtn.click();
    }
    public void fillPostArea(String postText){
        postArea.sendKeys(postText);
    }
    public void clickPostBtn(){
        getDate();
        postBtn.click();

    }
    public void getDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        now =  dateFormat.format(date);
    }

    public void addLike(){
        likeBtn.click();
    }
    public void addComment(String commentText) {
        commBtn.click();
        commInput.sendKeys(commentText + Keys.ENTER);
    }

    public Boolean checkPost(String postText){
        post = lastPost.getText();
        return post.contains(postText);
    }

    public Boolean checkDate(){
        return post.contains(now);
    }


    public Boolean checkLike(){
        return lastPost.getText().contains("1 Like");
    }

    public void click3dotBtn(){
        dot3Btn.click();
    }
    public void clickEditBtn(){
        editBtn.click();
    }

    public void changePost(String text){
        changingArea.sendKeys(text);
    }
    public void postChanges(){
        changingPostBtn.click();
    }

    public Boolean checkingLast(){
        new AdminPage(driver);
       return !post.equals(lastPost.getText());
    }


}
