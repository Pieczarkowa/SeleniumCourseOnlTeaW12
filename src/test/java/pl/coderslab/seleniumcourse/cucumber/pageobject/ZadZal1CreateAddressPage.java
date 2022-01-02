package pl.coderslab.seleniumcourse.cucumber.pageobject;

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
    //   @FindBy(id = "years")
    //   private WebElement years;
    //   @FindBy(id = "newsletter")
    //   private WebElement newsletterCheckbox;
    //   @FindBy(id = "optin")
    //   private WebElement specialOffersCheckbox;
    //  @FindBy(id = "submitAccount")
//    private WebElement registerButton;

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
}
   //     lastNameInput.sendKeys(userData.getLastName());
  //      if (!userData.getEmail().equals("")) {
   //         emailInput.clear();
  //          emailInput.sendKeys(userData.getEmail());
 //       }
 //       passwordInput.sendKeys(userData.getPassword());
//   //     days.sendKeys(String.valueOf(userData.getDays()));
//    //    months.sendKeys(userData.getMonth().name());
//    //    years.sendKeys(String.valueOf(userData.getYears()));
//       setCheckbox(newsletterCheckbox, userData.isNewsletter());
//        setCheckbox(specialOffersCheckbox, userData.isGetSpecialOffers());
//    }

 //   private void setCheckbox(WebElement checkbox, boolean desiredCheckedState) {
 //       if (checkbox.isSelected() != desiredCheckedState) {
 //           checkbox.click();
 //       }
//    }

 //   public void clickRegister() {
  //      registerButton.click();
 //   }

 //   public boolean areMandatoryInputsAccessible() {
  //      boolean isFirstNameInputInteractable = firstNameInput.isDisplayed() && firstNameInput.isEnabled();
  //      boolean isLastNameInputInteractable = lastNameInput.isDisplayed() && lastNameInput.isEnabled();
  //      boolean isPasswordInputInteractable = passwordInput.isDisplayed() && passwordInput.isEnabled();

   //     return isFirstNameInputInteractable
   //             && isLastNameInputInteractable
    //            && isPasswordInputInteractable;
 //   }

 //   public String getEmail() {
 //       return emailInput.getAttribute("value");
  //  }
// }

