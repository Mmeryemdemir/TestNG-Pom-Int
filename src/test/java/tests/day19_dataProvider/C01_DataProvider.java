package tests.day19_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {

    @DataProvider
    public static  Object[][] aranacakKelimeProvider(){
        Object [][] aranacak = {{"Nutela"},{"Java"},{"Apple"}, {"Samsung"}, {"Tv"}};


        return aranacak;
    }

    // Amazon anasayfaya gidin
    // Nutella , Java ,Apple , Samsung, Tv için arama yapın
    // arama sonuçlarının aranan keklime içerdiğini test edin


    @Test
    public void amazonTest ( String aranacakKelime){

    }
}
