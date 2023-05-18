package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(name="username") WebElement username;
    @FindBy(name="password") WebElement password;
    @FindBy(className = "oxd-button") WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String name){
        username.sendKeys(name);
    }
    public void fillPassword(String pswd){
        password.sendKeys(pswd);
    }

    public void clickLoginBtn(){
        loginBtn.click();
        new BuzzPage(driver);
    }

    public Boolean checkTest() {
        return driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
