package tests.day19_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MycoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginDataProvider {

    // Negatif login testi için verilen 10 adet
    @DataProvider
    public static  Object[][] kullanıcıDataProvider (){

        Object [][] kullanıcıBilgileri = {{},
                                          {},
                                          {},
                                          {},
                                          {},
                                          {},
                                          {},
                                          {},
                                          {},
                                          {}};
        return  kullanıcıBilgileri;
    }


    @Test (dataProvider = "kullanıcıDataProvider")
    public void negatifÇokluTest (String email, String password){

        MycoursedemyPage mycoursedemyPage = new MycoursedemyPage();

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        mycoursedemyPage.cookies.click();
        // login linkine basin
        mycoursedemyPage.loginLinki.click();
        // 1- Verilen listeden kullanıcı adı ve pssword yazalımyanlis kullanici adi
        mycoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("email"));
        mycoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("password"));

        // Login butonuna basarak login olmaya calisin
        mycoursedemyPage.loginButonu.click();

        ReusableMethods.bekle(2);
        // Basarili olarak giris yapilamadigini test edin
        // bunun için hala login linkinin görünür olduğunu test edin
        Assert.assertTrue(mycoursedemyPage.loginLinki.isEnabled());

    }
}
