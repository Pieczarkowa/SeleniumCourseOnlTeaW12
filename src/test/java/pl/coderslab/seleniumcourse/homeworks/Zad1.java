package pl.coderslab.seleniumcourse.homeworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zad1 {
    WebDriver driver;

    @Test
    public void shouldFindBy() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signInBtn = driver.findElement(By.className("user-info"));
        signInBtn.click();
        WebElement createAccBtn = driver.findElement(By.className("no-account"));
        createAccBtn.click();
        driver.navigate().back();
        driver.navigate().back();

    }
    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

}

