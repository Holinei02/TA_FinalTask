package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@data-testid='header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//a[contains(@data-testid,'BagIcon')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@data-testid='topbar']//button[contains(@data-testid,'country-selector-btn')]")
    private WebElement countryButton;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countrySelector;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencySelector;

    @FindBy(xpath = "//button[contains(@data-testid,'myAccount')]")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[contains(@data-testid,'signin')]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@data-testid,'signup')]")
    private WebElement registerButton;



    @FindBy(xpath = "//button[contains(@data-testid,'close-btn')]")
    private WebElement signInPopupCloseButton;

    @FindBy(xpath = "//div[@class='header-store parbase']//span[contains(@class,'global-store__content__section__store-name')]")
    private WebElement storeButton;

    @FindBy(xpath = "//div[@class='global-store__popup-wrapper']//div[@class='store-search']")
    private WebElement storePopup;

    @FindBy(xpath = "//input[contains(@type,'search')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[@id='global-search__submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='gigya-screen-dialog-main']")
    private WebElement signInPopup;

    @FindBy(xpath = "//div[contains(@class,'wishlist-button')]//div[contains(@class,'items-count')]")
    private WebElement wishListProductsCount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isCartIconVisible() {
        cartIcon.isDisplayed();
    }

    public void isMyAccountButtonVisible() { myAccountButton.isDisplayed();}

    public String getLanguageButtonText() {
        return countryButton.getText();
    }

    public void isSignInButtonVisible() {
        signInButton.isDisplayed();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void isRegisterButtonVisible() {
        registerButton.isDisplayed();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }



    public WebElement getSignInPopup() {
        return signInPopup;
    }

    public void clickSignInPopupCloseButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signInPopupCloseButton);
    }

    public void clickStoreButton() {
        storeButton.click();
    }

    public boolean isCountrySelectorVisible() { return countrySelector.isDisplayed();}

    public boolean isCurrencySelectorVisible() { return currencySelector.isDisplayed();}

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void clickCartButton() {
        cartIcon.click();
    }

    public void clickMyAccountButton() { myAccountButton.click();}

    public void clickCountryButton() {
        countryButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getWishListProductsCount() {
        return wishListProductsCount;
    }

    public String getAmountOfProductsInWishList() {
        return wishListProductsCount.getText();
    }

}
