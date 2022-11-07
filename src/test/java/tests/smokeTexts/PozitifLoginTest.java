package tests.smokeTexts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MycoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {




    @Test
    public void pozitifLogintest(){

        // Mycoursedemy anasayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basın
        MycoursedemyPage mycoursedemyPage= new MycoursedemyPage();
        mycoursedemyPage.cookies.click();
        mycoursedemyPage.loginLinki.click();

        // kullanıcı email'i olarak valid email girin
        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));

        // kullanıcı şifresi olarak valid şifre girin
        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));

        //Login butonuna basarak login olun
        mycoursedemyPage.loginButonu.click();

        // başarılı olarak giriş yapılabildiğini test edin

        Assert.assertTrue(mycoursedemyPage.coursesLinki.isDisplayed());


    }
}
