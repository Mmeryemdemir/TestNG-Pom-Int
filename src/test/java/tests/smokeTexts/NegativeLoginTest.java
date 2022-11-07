package tests.smokeTexts;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MycoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegativeLoginTest {


    MycoursedemyPage mycoursedemyPage= new MycoursedemyPage();

    @BeforeClass
    public void setup(){

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        mycoursedemyPage.cookies.click();
        // login linkine basin
        mycoursedemyPage.loginLinki.click();

    }

    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin
    @Test
    public void yanlışKullanıcıTest(){

        // 1- yanlis kullanici adi, gecerli password

        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));

        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));

        // Login butonuna basarak login olmaya calisin

        mycoursedemyPage.loginButonu.click();

        // Basarili olarak giris yapilamadigini test edin
        // bunun için hala login linkinin görünür olduğunu test edin
        Assert.assertTrue(mycoursedemyPage.loginLinki.isEnabled());

    }

    @Test
    public void yanlışPasswordTest(){

        // 2- gecerli kullanici adi, yanlis password
        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));

        // Login butonnuna basarak login olmaya çalışın
        mycoursedemyPage.loginButonu.click();
        // Başarılı oolarak giriş yapılmaadığını test edin
        Assert.assertTrue(mycoursedemyPage.loginLinki.isEnabled());

    }

    @Test
    public void yanlısEmailSifreTest(){

        // 3- yanlis kullanici adi, yanlis password
        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));

        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));

    // login butonuna basarak login olmaya çalışın

        mycoursedemyPage.loginButonu.click();

        // Başarılı olarak giriş yapılmadığını test edin
        Assert.assertTrue(mycoursedemyPage.loginLinki.isEnabled());
    }


    @AfterClass
    public void teardown(){
        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }

}
