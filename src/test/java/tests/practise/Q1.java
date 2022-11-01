package tests.practise;

import org.testng.annotations.Test;
import utilities.TestBase;

public class Q1 extends TestBase {

    /*
       > TestNG default olarak @Test methodlarini alfabetik siraya gore run eder,
       yukaridan asagiya dogru degil.
       > priority annotation testlere oncelik vermek icin kullanilir,
        kucuk olan numara daha once calisir.
       > priority : TestNG testlerinde , testler konsola alfabetik sira ile yazdirilir.
       > priority default degeri sifirdir.
       > enabled = false methodu : Testi gormezden gelmek icin @Test 'in yanina yazilir.
        */

    @Test (priority = 300)
    public void b(){
        System.out.println("b");
    }


    @Test (priority = -300)
    public void a(){
        System.out.println("a");
    }


    @Test(priority = 301)
    public void c(){
        System.out.println("c");
    }


    @Test (priority = -301 , enabled = false)
    public void d(){
        System.out.println("d");
    }


    @Test (dependsOnMethods = "c")
    public void e(){
        System.out.println("e");
    }


    @Test (dependsOnMethods = "c")
    public void f(){
        System.out.println("f");
    }


    @Test
    public void g(){
        System.out.println("g");
    }


    @Test
    public void h(){
        System.out.println("h");
    }

}
