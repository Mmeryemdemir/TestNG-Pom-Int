package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 extends TestBase {

    /*
      - go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
      - Task 1 - Find Dropdown on Multi Selection
      - Task 2 - Find all Dropdown Elements
      - Task 3 - Printout Dropdown Elements' number
      - Task 4 - Choose all Dropdown elements and printout Dropdown elements' name on Multi Selection
      - Task 5 - Check until choice 5
    */

    @Test
    public void test01(){
    driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

    WebElement dropdown = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
            dropdown.click();


        List<WebElement> dropList = driver.findElements(By.className("ComboTreeItemChlid"));

        System.out.println("Dropdownlardaki element sayısı = " + dropList.size());


        for (int i = 0; i < dropList.size(); i++) {

            String text= dropList.get(i).getText();
            System.out.println("text = " + text);

            if (!text.isEmpty()){
                dropList.get(i).click();

            }

            if (text.equals("choice 5")){
                break;
            }


        }



    }


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























    @Test
    public void test010(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basın

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // 3. Login kutusuna "username" yazın

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // 4. Password kutusuna "password" yazdırın

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // 5. Sign in butonuna basın

        driver.findElement(By.name("submit")).click();
        driver.navigate().back();

        // 6. Online banking menusu içinde Pay Bills sayfasına gidin

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // 7. "Purchase Foreign Currency" tuşuna basın

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8. "Currency" drop down menusune Eurozone'u seçin

        WebElement dropdownMenu= driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdownMenu);
        select.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (euro)" seçildiğini test edin

        SoftAssert softAssert= new SoftAssert();

        String expectedOption = "Eurozone (euro)";
        String actualOption = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualOption,expectedOption,"Eurozone seçilmedi");

        fotografCek("EurozoneResmi");

        // 10. soft assert kullanarak DropDown listesinin şu şeçenekleri olduğunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String [] expectedKurlarArr =
                {"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
                        "China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
                        "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                        "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)" };

        List<String> expectedKurlarListesi = Arrays.asList(expectedKurlarArr);

        List<WebElement> actualKurlarElementiList = select.getOptions();

        List<String> actualKurlarListesi = new ArrayList<>();

        for (WebElement eachElement:actualKurlarElementiList
        ) {
            actualKurlarListesi.add(eachElement.getText());
        }

        softAssert.assertEquals(actualKurlarListesi,expectedKurlarListesi,"Kurlar listesi farklı");


        softAssert.assertAll();
        bekle(6);


    }


    @Test
    public void heardAssertTest(){

        // verilen bir sifrenin sartlari saglayip saglamadigini test edin
        // 1- Ilk harf Buyuk harf olmali
        // 2- Son harf kucuk harf olmali
        // 3- sifre bosluk icermemeli
        // 4- uzunlugu en az 8 karakter olmali
        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin


        /*
        assertion işlemi yapılırken
        ilk bulunan hatada kodun çalışması durdurulur (stop execution)

        Asser class'ındaki method'lar static oldukları için
         !!  classIsmi.methodİsmi ile çağrılırlar

         */

        String şifre ="JavAjava";

        // 1- Ilk harf Buyuk harf olmali

        boolean ilkHarfKontrolu = şifre.charAt(0)>='A' && şifre.charAt(0)<='Z';
        Assert.assertTrue(ilkHarfKontrolu,"İlk harf büyük olmalı");

        // 2- Son harf kucuk harf olmali

        boolean sonHanrfKontrolu= şifre.charAt(şifre.length()-1)>='a' && şifre.charAt(şifre.length()-1)<='z';
        Assert.assertTrue(sonHanrfKontrolu,"Son harf küçük olmalı");

        // 3- sifre bosluk icermemeli

        Assert.assertFalse(şifre.contains(" "),"Şifre boşluk içermemeli");

        // 4- uzunlugu en az 8 karakter olmali

        Assert.assertTrue(şifre.length()>=8,"Şifre en az 8 karakter olmalı");

        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin

        System.out.println("Şifreniz başarılı ile kaydedildi");
    }

    @Test
    public void softAssertTest(){

        /*
        jUnit'de de kullandığımız Assert class'ı ilk failed olan assertion'da
        çalışmayı durdururlar ve hatayı mesajı verir

        Eğer ilk hatada durmasını değil, devam edip sona kadar tüm testleri yapmasını
        ve en son durumu raporlayıp, failed olan varsa
        çalışmayı durdurmasını istiyorsak
        SoftAssert class'ını kullanabiliriz

        SoftAssert class'ındakı method'lar static değildir,
        SoftAssert class'ındaki method'ları kullanabilmek için obje oluşturmalıyız

        Genellikle
        hard Assrtion kullanmamız istendiğinden test edin (Test)

        soft Assertion kullanmamız istendiğinde doğrulayın (Verify) kelimeleri kullanılır.

         */



        // A. adım softAssert objesi oluştur

        SoftAssert softAssert= new SoftAssert();

        // B. istenen tüm assertion'ları softAssert objesini kullanarak yapın

        String şifre = "JavAhJava";

        // 1- Ilk harf Buyuk harf olmali

        boolean ilkHarfKontrolu = şifre.charAt(0)>='A' && şifre.charAt(0)<='z';
        softAssert.assertTrue(ilkHarfKontrolu,"İlk harf büyük harf olmalı");

        // 2- Son harf kucuk harf olmali

        boolean sonHarfKontrolun = şifre.charAt(şifre.length()-1)>='a' && şifre.charAt(şifre.length()-1)<='z';

        // 3- sifre bosluk icermemeli

        softAssert.assertFalse(şifre.contains(" "),"Şifre boş karakter içermemeli");

        // 4- uzunlugu en az 8 karakter olmali

        softAssert.assertTrue(şifre.length()>=8,"Şifre en az 8 karakter olmalı");

        // C. Tüm testler bitince, işimiz bitti yapılan tüm assert'leri raporla dememiz gerekir

        // bir tane bile failed varsa bu satırda kodun çalışması durdurulur

        softAssert.assertAll();

        // 5- Tüm satırları sağlıyorsa şifre basarı ile kaydedildi yazdırın

        System.out.println("Şifreniz başarıyla kaydedildi");
    }






}







