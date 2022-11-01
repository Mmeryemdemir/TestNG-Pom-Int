package tests.day14_dependsOnMethods_softAssert;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    /*
    İki test method'u dependsOnMethods ile birbirine bağlandıysa

    Sadece bağlanan method'u çalıştırmak isterseniz,
    dependsOnMethods özelliği tanımlı olduğundan
    önce bağlı olunan method'u çalıştırır,
    o test passed olursa bağlı olan test'i de çalıştırır.

    Ancak bağlı olan testler ikiden fazla ise;
    2. testen sonraki test method'larını çalıştırmak isterseniz

    "no test found" uyarı verir ve hiç bir testi çalıştırmaz
     */


    @Test
    public void test01(){
        System.out.println("1.test çalıştı");
    }


    @Test (dependsOnMethods = "test01")
    public void test02(){
        System.out.println("2.test çalıştı");
    }


    @Test(dependsOnMethods =  "test02")
    public void test03(){
        System.out.println("3.test çalıştı");
    }


}
