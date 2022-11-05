package tests.day15_pagesObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C03_PagesKullanımı {

    /*
    Pages class'ları bir websayfasında locate etmek istediğimiz
    webElementleri locate edip sonrasında ihtiyacıöız oldukça kullanmak için oluşturulur


    pages class'larında locate edilen webElement'lere erişebilmek için
    test class'ımızda ilgili page class'ından bir obje oluştururuz
     */

    @Test
    public void test01(){

        //amazon ana sayfasına gidin
        Driver.getDriver().get("https://www.amazon.com");
        AmazonPage amazonPage= new AmazonPage();

        // Nutella için arama yapın
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuçların Nutella içerdiğini test edin
        String actualSonuçYazısı = amazonPage.aramaSonuçElementi.getText();
        String expectedKelime= "Nutella";

        Assert.assertTrue(actualSonuçYazısı.contains(expectedKelime));

        Driver.closeDriver();

    }
}
