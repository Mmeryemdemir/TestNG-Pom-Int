package tests.day14_dependsOnMethods_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssert {

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
