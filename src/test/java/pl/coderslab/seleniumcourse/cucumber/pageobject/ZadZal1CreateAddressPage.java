package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZadZal1CreateAddressPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement newAliasInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement addressInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement zipInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement cityInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")
    private WebElement countryInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phoneInput;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement saveAddressBtn;


    public ZadZal1CreateAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillAddressesForm(ZadZal1AddressesData zadZal1AddressesData) {

        newAliasInput.sendKeys(zadZal1AddressesData.getNewAlias());
        addressInput.sendKeys(zadZal1AddressesData.getNewAddress());
        zipInput.sendKeys(zadZal1AddressesData.getZip());
        cityInput.sendKeys(zadZal1AddressesData.getCity());
        countryInput.sendKeys(zadZal1AddressesData.getCountry());
        phoneInput.sendKeys(zadZal1AddressesData.getPhone());


    }


    public void catchExceptionToSave() {
        try {

            saveAddressBtn.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            saveAddressBtn.click();
        }

    }
}

