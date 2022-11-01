package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

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






}
