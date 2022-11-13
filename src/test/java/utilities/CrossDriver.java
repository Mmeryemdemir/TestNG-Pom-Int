package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver(){

        // Singleton pattern konsepti ile
        // driver class'ından obje oluşturmayı engellemek için bu cons.'ı oluşturduk

    }

    static WebDriver driver;
    public static WebDriver getDriver(String browser){

        browser= browser== null ? ConfigReader.getProperty("browser") : browser;

        if (driver==null){


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
