package tests.practise;

import org.testng.annotations.Test;
import utilities.TestBase;

public class Q2 extends TestBase {


    /*
    - Birbirine bagimli testler olusturun.
    - beforeClass olusturup setUp ayarlarini yapin.
    - Birbirine bagimli testlr olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    -driver'i kapatin.
     */

    @Test
    public void facebookTest(){
        driver.get("https://www.facebook.com");
    }

    @Test (dependsOnMethods = "facebookTest")
    public void googleTest(){
        driver.get("https://www.google.com");

    }

    @Test (dependsOnMethods = "googleTest")
    public void amazontesti(){
        driver.get("https://www.amazon.com");
    }
}
