package tests.day15_pagesObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_Driverkullanımı {

    @Test
    public void test01(){

        Driver.getDriver().get("https://www.amazon.com");

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Amazon";

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"Başlık Amazon içermiyor");

       WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

       WebElement aramaSonuçElementi =
               Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

       String arananKelime= "Nutella";
       String actualAramaSonucu = aramaSonuçElementi.getText();

       softAssert.assertTrue(actualAramaSonucu.contains(arananKelime),"Aranan kelime nutella içermiyor");

       Driver.getDriver().get("https://wisequarter.com/");

       String arananUrl= "wisequarter";
       String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(arananUrl),"Url wisequater içermiyor");
        softAssert.assertAll();

        ReusableMethods.bekle(5);
        Driver.closeDriver();

    }
}
