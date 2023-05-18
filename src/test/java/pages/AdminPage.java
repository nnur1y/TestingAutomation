package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    WebDriver driver;
    @FindBy(partialLinkText = "Admin") WebElement adminBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button") WebElement addBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]") WebElement roleDrDw;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input") WebElement empNameFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]") WebElement statusFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input") WebElement usernameFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input") WebElement pwdFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input") WebElement confirmPassFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]") WebElement saveBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input") WebElement searchUserFld;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]") WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]") WebElement downBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div") WebElement record;

    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAdminPage(){
        adminBtn.click();
    }
    public void clickAddBtn(){
        addBtn.click();
    }
    public void selectRole(String role){
        roleDrDw.sendKeys(role + Keys.ENTER);
    }
    public void fillEmpName(String name) throws InterruptedException {
        empNameFld.sendKeys(name);
        Thread.sleep(2500);
        //empNameFld.sendKeys(Keys.ARROW_DOWN,Keys.ENTER,Keys.ESCAPE);

        downBtn.click();
    }
    public void selectStatus(String status){
        statusFld.sendKeys(status + Keys.ENTER);
    }
    public void fillUsername(String username){
        usernameFld.clear();
        usernameFld.sendKeys(username);
    }
    public void fillPassword(String psw){
        pwdFld.clear();
        pwdFld.sendKeys(psw);
    }
    public void fillConfirmPass(String confpass){
        confirmPassFld.sendKeys(confpass);
    }
    public void clickSaveBtn(){
        saveBtn.click();
    }
    public void fillSearchUser(String sUser){
        searchUserFld.sendKeys(sUser);
    }
    public void clickSearchBtn(){
        searchBtn.click();
    }
    public Boolean checkTest() throws InterruptedException {
        new PIMpage(driver);
        Thread.sleep(2500);
        return driver.getPageSource().contains("Record Found");
    }
}
