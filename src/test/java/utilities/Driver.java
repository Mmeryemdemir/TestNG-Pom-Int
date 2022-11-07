package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    private Driver(){

        // Singleton pattern konsepti ile
        // driver class'ından obje oluşturmayı engellemek için bu cons.'ı oluşturduk

    }
   static WebDriver driver;
    public static WebDriver getDriver(){


        if (driver==null){

            String browser= ConfigReader.getProperty("browser");

           switch (browser){
               case "chrome":
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
                   break;

               case "firefox":
                   WebDriverManager.firefoxdriver().setup();
                   driver= new FirefoxDriver();
                   break;

               default:
                   WebDriverManager.chromedriver().setup();
                   driver = new ChromeDriver();
           }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

      return driver;
    }

    public static void closeDriver(){

        if (driver!=null) {

            driver.close();
            driver=null;
        }
    }
}
