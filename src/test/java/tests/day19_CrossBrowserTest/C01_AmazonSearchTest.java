package tests.day19_CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.animation.model.KeyframeStyle;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {

    @Test
    public void test01(){
        // amazon anasayfaya gidin
        driver.get(ConfigReader.getProperty("amazonUrl"));
        // Nutella için arama yapalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        // sonuçların Nutella içerdiğini test edin
        String actualSonuçYazısı = driver
                .findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                 .getText();

        String expectedKelime = "Nutella";

        Assert.assertTrue(actualSonuçYazısı.contains(expectedKelime));


    }

}
