package tests.day19_CrossBrowserTest;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {

    @Test
    public void test01(){
        // amazon anasayfaya gidin
        driver.get(ConfigReader.getProperty("amazonUrl"));
        // Nutella için arama yapalım

        // sonuçların Nutella içerdiğini test edin

    }

}
