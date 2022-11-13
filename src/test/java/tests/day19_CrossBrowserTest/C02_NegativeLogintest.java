package tests.day19_CrossBrowserTest;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C02_NegativeLogintest extends TestBaseCross {

    @Test
    public void negativeTest(){

        // mycoursedemy anasayfaya gidin
        driver.get(ConfigReader.getProperty("myUrl"));
        driver.findElement(By.xpath("//a[@onclick=\"cookieAccept();\"]")).click();
        // login butonuna basın
      WebElement loginLinki = driver.findElement(By.xpath("//a[text()='Log in']"));
              loginLinki.click();
        // email ve password için geçersiz değerler girin
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        // login butonuna basın
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        // giriş yapılamadığını test edin

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log in']")).isDisplayed());


    }
}
