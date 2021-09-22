package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage{

    @FindBy(xpath = "//input[contains(@class,'email-textbox')]")
    private WebElement emailInRegisterField;

    @FindBy(xpath = "//input[contains(@class,'password-textbox')]")
    private WebElement passwordInRegisterField;

    @FindBy(xpath = "//input[contains(@class,'firstname-textbox')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[contains(@class,'lastname-textbox')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[contains(@class,'validation-error')]/span[contains(text(),'email')]")
    private WebElement emailValidationError;

    @FindBy(xpath = "//a[@id='signup-google']")
    private WebElement signUpWithGoogle;

    @FindBy(xpath = "//div[@id='initialView']")
    private WebElement initialGooglePopUp;



    public AuthorizationPage(WebDriver driver) { super(driver); }

    public void openRegisterPage(String url) {
        driver.get(url);
    }

    public boolean isEmailFieldVisible() {
        return emailInRegisterField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordInRegisterField.isDisplayed();
    }

    public boolean isFirstNameFieldVisible() { return firstNameField.isDisplayed();}

    public boolean isLastNameFieldVisible() {
        return lastNameField.isDisplayed();
    }

    public void isSubmitButtonVisible() {
        submitButton.isDisplayed();
    }

    public void isSignUpWithGoogleVisible() { signUpWithGoogle.isDisplayed(); }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickSignUpWithGoogleButton() { signUpWithGoogle.click();}

    public boolean isEmailValidationErrorVisible() {return emailValidationError.isDisplayed();}

    public void isInitialGooglePopUpVisible() { initialGooglePopUp.isDisplayed();}




}
