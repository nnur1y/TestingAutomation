package pages;

import com.github.javafaker.Bool;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMpage {
    WebDriver driver;
    @FindBy(partialLinkText = "PIM") WebElement pimBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[5]/div/div[2]/div/div/input") WebElement empNameHint;
    @FindBy(className = "orangehrm-left-space") WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span") WebElement countOfRec;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[9]/div/button[1]/i") WebElement deleteBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]") WebElement confirmDeleteBtn;

    public PIMpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goPIM(){
        pimBtn.click();
    }

    public void fillEmpNameHint(String name) throws InterruptedException {
        empNameHint.sendKeys(name);
        Thread.sleep(2500);
        empNameHint.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public int findCountOfRec(){
        String a = countOfRec.getText().split(" ")[0];
        int count;
        if(a.equals("No")){
            count=0;
        }else {
             count=Integer.parseInt(a.substring(1, a.length() - 1));
        }
        return count;
    }
    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void deleteRecord(){
        deleteBtn.click();
        confirmDeleteBtn.click();
    }

    public Boolean checkTest(){
        new RecruitPage(driver);
        return driver.getPageSource().contains("No Records Found");
    }




}
