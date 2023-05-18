package tests;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class Orangehrmlive {
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsername("Admin");
        loginPage.fillPassword("admin123");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.checkTest());
    }

    @Test(priority = 2)
    public void buzzTest(){
        String text = "I want to test your demo site";
        String comment = "do it =)";
        BuzzPage buzzPage = new BuzzPage(driver);
        buzzPage.clickBuzzPage();
        buzzPage.fillPostArea(text);
        buzzPage.clickPostBtn();
        buzzPage.addLike();
        buzzPage.addComment(comment);
        Assert.assertTrue(buzzPage.checkPost(text));
        Assert.assertTrue(buzzPage.checkDate());
     //   Assert.assertTrue(buzzPage.checkLike());
        buzzPage.click3dotBtn();
        buzzPage.clickEditBtn();
        buzzPage.changePost(" :o");
        buzzPage.postChanges();
        Assert.assertTrue(buzzPage.checkingLast());
    }

    @Test(priority = 3)
    public void adminTest() throws InterruptedException {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAdminPage();
        adminPage.clickAddBtn();
        adminPage.selectRole("a");//admin
        adminPage.fillEmpName("Sara  Tencrady");
        adminPage.selectStatus("e");// enabled
        Faker faker = new Faker();
        String username = faker.superhero().prefix()+faker.name().firstName()+faker.address().buildingNumber();
        String password = "Qwerty123";
        adminPage.fillUsername(username);
        adminPage.fillPassword(password);
        adminPage.fillConfirmPass(password);
        adminPage.clickSaveBtn();
        adminPage.fillSearchUser(username);
        adminPage.clickSearchBtn();
        Assert.assertTrue(adminPage.checkTest());

    }

    @Test(priority = 4)
    public void pimTest() throws InterruptedException {
        PIMpage piMpage = new PIMpage(driver);
        piMpage.goPIM();
        piMpage.fillEmpNameHint("Linda Jane Anderson");
        piMpage.clickSearchBtn();

        int count = piMpage.findCountOfRec();
        if(count==0){
            Assert.assertTrue(piMpage.checkTest());
        }else {
            for (int i = 0; i < count; i++) {
                piMpage.deleteRecord();
            }
            Assert.assertTrue(piMpage.checkTest());
        }
    }

    @Test(priority = 5)
    public void recruitTest() throws InterruptedException {
        RecruitPage recPage = new RecruitPage(driver);
        recPage.goRec();
        recPage.clickAddBtn();
        recPage.fillFirstname("Nurly");
        recPage.fillMiddlename("Quanyshqyzy");
        recPage.fillLastname("Altynali");
        recPage.selectVacancy();
        recPage.fillEmail("nurly125@mail.ru");
        recPage.fillPhone("87762467770");
        recPage.sendResume("C:\\Users\\Admin\\Desktop\\ResumeNurly.pdf");
        recPage.clickSave();
        Thread.sleep(1000);
        recPage.fillInterviewTitle("QA");
        recPage.fillInterviewer("Odis  Adalwin");
        recPage.fillDateInterview("2023-05-18");
        recPage.clickButtons();
        Assert.assertTrue(recPage.checkTest("Nurly"));




    }


    @AfterSuite
    public void close(){
        driver.quit();
    }
}