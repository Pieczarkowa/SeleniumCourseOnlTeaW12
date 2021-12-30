package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //tu dodaje zad2
    public void BackToLandingPage() {
        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a"));
        homeButton.click();
    }
    //tu koniec zad 2

    public boolean isAccountCreationConfirmed() {
        WebElement accountCreationConfirmationPanel = driver.findElement(By.cssSelector("p.alert-success"));
        String confirmationText = accountCreationConfirmationPanel.getText();

        return confirmationText.equals("Your account has been created.");
    }
}