package pl.coderslab.seleniumcourse.funkcje;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cwiczenia {

    //getText()
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       driver.get("https://pl.wikipedia.org/");
      WebElement element = driver.findElement(By.id("main-page-column1"));
       System.out.println(element.getText());

       //getAttribute()
        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);

     //   getTagName()
        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);

    }
}