package pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitPage {
    WebDriver driver;
    @FindBy(partialLinkText = "Recruitment") WebElement recBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement addBtn;
    @FindBy(name = "firstName") WebElement firstnameFld;
    @FindBy(name = "middleName") WebElement middlenameFld;
    @FindBy(name = "lastName") WebElement lastnameFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]")
    WebElement vacancyDrDw;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement emailFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement phoneFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div/div[2]/input")
    WebElement resumeFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]")
    WebElement saveBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]")  WebElement shortlistBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement save2Btn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]") WebElement scheduleInterviewBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div/input")
    WebElement interviewerFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div/input")
    WebElement dateOfInt;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input") WebElement interviewTitleFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement save3Btn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]") WebElement markIntPassed;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement save4Btn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]") WebElement offerJobBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement save5Btn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[3]") WebElement hireBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement save6Btn;

    public RecruitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goRec(){
        recBtn.click();
    }
    public void clickAddBtn(){
        addBtn.click();
    }
    public void fillFirstname(String fname){
        firstnameFld.sendKeys(fname);
    }
    public void fillMiddlename(String mname){
        middlenameFld.sendKeys(mname);
    }
    public void fillLastname(String lname){
        lastnameFld.sendKeys(lname);
    }
    public void selectVacancy() throws InterruptedException {
        Thread.sleep(1000);
        vacancyDrDw.sendKeys(Keys.DOWN, Keys.ENTER);
    }
    public void fillEmail(String mail){
        emailFld.sendKeys(mail);
    }
    public void fillPhone(String number){
        phoneFld.sendKeys(number);
    }
    public void sendResume(String res){
        resumeFld.sendKeys(res);
    }
    public void clickSave() throws InterruptedException {
        Thread.sleep(1000);
        saveBtn.click();
        Thread.sleep(1000);
        shortlistBtn.click();
        Thread.sleep(1000);
        save2Btn.click();
        Thread.sleep(1000);
        scheduleInterviewBtn.click();

    }
    public void fillInterviewTitle(String title) throws InterruptedException {
        Thread.sleep(1500);
        interviewTitleFld.sendKeys(title);
    }

    public void fillInterviewer(String name) throws InterruptedException {
        interviewerFld.sendKeys(name);
        Thread.sleep(2500);
        interviewerFld.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void fillDateInterview(String date){
        dateOfInt.sendKeys(date);
    }

    public void clickButtons() throws InterruptedException {
        save3Btn.click();
        Thread.sleep(1000);
        markIntPassed.click();
        Thread.sleep(2000);
        save4Btn.click();
        Thread.sleep(1000);
        offerJobBtn.click();
        Thread.sleep(2000);
        save5Btn.click();
        Thread.sleep(1000);
        hireBtn.click();
        Thread.sleep(2000);
        save6Btn.click();

    }

    public Boolean checkTest(String name) throws InterruptedException {
        Thread.sleep(2500);
        return driver.getPageSource().contains(name);
    }

}
