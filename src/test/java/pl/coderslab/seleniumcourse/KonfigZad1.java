package pl.coderslab.seleniumcourse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KonfigZad1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchInput = driver.findElement(By.name("q")); // nie dziala przez popup o bezpieczenstwie
        searchInput.sendKeys("java");
        searchInput.submit();
    }
}


