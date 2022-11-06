package tests.day16_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C01_ConfigReaderKullanımı {



    @Test
    public void method1(){

    //amazon ana sayfasına gidin
        // driver.get(https://www.amazon.com)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    // Nutella için arama yapın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAramaKelimesi")+ Keys.ENTER);

    // sonuçların arama yaptığımız kelimeyi içerdiğini test edin

        String expectedKelime = ConfigReader.getProperty("amazonAramaKelimesi");
        String actualAramaSonuçu= amazonPage.aramaSonuçElementi.getText();

        Assert.assertTrue(actualAramaSonuçu.contains(expectedKelime));

        ReusableMethods.bekle(3);
        Driver.closeDriver();


}


}
