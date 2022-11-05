package tests.day15_pagesObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverİlkClass {

     /*
    POM de 4 farklı dosyadan ihtiyaçimiz olan bilgileri alırız

    1- Driver class == driver
    2- pages package altındaki page class'ları == locate
    3- configurtaion.properties dosyası == test dataları
    4- Resuable methods class == ihtiyaç duyduğumuz pratik methodlar

    Daha önce kullandığımız extends keyword ile inheritance sadece 1 class'a alabileceğinden
    POM'de tercih edilmemiştir.

    Java'da bir class'daki class üyelerini kullanmanın farklı yolları var

    1- extends ile inherit edip direk kullanma
    2- class üyelerini static tanımlayıp classAdı.uyeAdı şeklinde ulaşabiliriz
    3- istediğimiz class'dan obje oluşturarak class üyelerini kullanabiliriz

    POM 2 yöntemide kullanır.
     */


    @Test
    public void test01(){

        Driver.getDriver().get("https://www.amazon.com");
        /*
        Driver class'ındaki get driver() method'u içerisinde driver = new ChoremeDriver(); satırı her çalıştığında yeni bir driver oluşturur
        yani yeni bir browser açar.

        Bizim istediğimiz bir test çalışmaya başladığından driver' bir kere new ChoreDriver() ile değer atasın
        sonraki çalışmalarda bu satırı pas geçsin

         */
        // arama kutusuna nutella yazdırıp aratalım
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    }
}
