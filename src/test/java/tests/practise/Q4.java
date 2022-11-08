package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q4 {


    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *   `Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01(){
        Driver.getDriver().get("https://www.saucedemo.com/");

        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        WebElement dropdown = Driver.getDriver().findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropdown);

        select.selectByVisibleText("Price (low to high )");

        String expected = "PRİCE (LOW TO HİGH)";
        String actual = Driver.getDriver().findElement(By.xpath("//option[@value='lohi']")).getText();



        softAssert.assertEquals(actual,expected,"Aktif secenekteki yazı expected data'dan farklı");

        softAssert.assertAll();



    }

@Test
    public void  saucedemoTest2(){

    Driver.getDriver().get("https://www.saucedemo.com/");

    Driver.getDriver().findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
    Driver.getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

    Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

    List<WebElement> fiyatlar = Driver.getDriver().findElements(By.className("inventory_item_price"));

    ArrayList<Double> fiyatlarDouble = new ArrayList<>();


    for (WebElement fiyat:fiyatlar
    ) {

        //  String fiyatStr = fiyat.getText().replaceAll("$","");

        String fiyatStr = fiyat.getText().replaceAll("^\\D","");
        fiyatlarDouble.add(Double.parseDouble(fiyatStr));

        System.out.println(fiyatStr);

    }

    ArrayList<Double> kontrolList = new ArrayList<>(fiyatlarDouble);

    Collections.sort(kontrolList);



}

}



