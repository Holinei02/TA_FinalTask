package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[contains(@class,'email-textbox')]")
    private WebElement emailInRegisterField;

    @FindBy(xpath = "//input[contains(@class,'password-textbox')]")
    private WebElement passwordInRegisterField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[contains(@id,'Error')]")
    private WebElement validationErrorMessage;


    public boolean isEmailFieldVisible() {
        return emailInRegisterField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordInRegisterField.isDisplayed();
    }
    public void enterEmailInField(final String email) {
        emailInRegisterField.clear();
        emailInRegisterField.sendKeys(email);
    }

    public void enterPasswordInField(final String password) {
        passwordInRegisterField.clear();
        passwordInRegisterField.sendKeys(password);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }

    public void openLoginPage(String url) { driver.get(url); }

    public boolean isValidationErrorMessageVisible() {return validationErrorMessage.isDisplayed();}

    public LoginPage(WebDriver driver) { super(driver);}
}
