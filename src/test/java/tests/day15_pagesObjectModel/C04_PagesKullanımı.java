package tests.day15_pagesObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C04_PagesKullanımı {

    // Amazon anasayfaya gidin
    // 3 test method'u oluşturun
    // Herbir method'da  Nutella, Java ve Bicycle için arama yapıp,
    // sonuçların arama yaptığımız kelimeleri içerdiğini test edin

    AmazonPage amazonPage = new AmazonPage();

    @Test(dependsOnMethods = "bicycleTest")
    public void nutellaTest(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Nutella"+Keys.ENTER);
        String actualAramaSonucu= amazonPage.aramaSonuçElementi.getText();
        String expectedKelime = "Nutella";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }

    @Test( dependsOnMethods = "bicycleTest")
    public void javaTest(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("Java"+Keys.ENTER);
        String actualAramaSonucu= amazonPage.aramaSonuçElementi.getText();
        String expectedKelime = "Java";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
    }


    @Test
    public void bicycleTest(){

        Driver.getDriver().get("https://www.amazon.com");
         amazonPage.aramaKutusu.sendKeys("Bicycle"+ Keys.ENTER);
       String actualAramaSonucu= amazonPage.aramaSonuçElementi.getText();
        String expectedKelime = "Bicycle";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
    }
}
