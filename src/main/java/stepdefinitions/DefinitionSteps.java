package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    AuthorizationPage authorizationPage;
    LoginPage loginPage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.isCartIconVisible();
    }

    @And("User checks 'My account' button visibility")
    public void CheckMyAccountButtonVisibility() {homePage.isMyAccountButtonVisible();}

    @When("User clicks 'My account' button")
    public void ClickMyAccountButton() {homePage.clickMyAccountButton();}

    @And("User checks that language switcher is {string}")
    public void checkLanguage(final String language) {
        assertTrue(homePage.getLanguageButtonText().equalsIgnoreCase(language));
    }

    @And("User checks register button visibility")
    public void checkRegisterButtonVisibility() {
        homePage.isRegisterButtonVisible();
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @And("User closes sign in popup")
    public void closeSignInPopup() {
        homePage.clickSignInPopupCloseButton();
    }

    @And("User opens shopping bag")
    public void openShoppingBag() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.clickCartButton();
    }

    @And("User checks that current url contains {string} word")
    public void checkCurrentUrl(final String word) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(word));
    }

    @And("User clicks country button")
    public void clickCountryButton() {
        homePage.clickCountryButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that country and currency selectors are visible")
    public void checkStorePopupVisibility() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isCountrySelectorVisible());
        assertTrue(homePage.isCurrencySelectorVisible());
    }

    @When("User clicks 'Join' button")
    public void clickJoinButton() {
        homePage.clickRegisterButton();
    }

    @And("User checks email and password fields visibility")
    public void checkEmailAndPasswordFieldsVisibility() {
        //authorizationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(authorizationPage.isEmailFieldVisible());
        assertTrue(authorizationPage.isPasswordFieldVisible());
    }

    @Then("User checks first and last name fields visibility")
    public void checkFirstAndLastNameFieldsVisibility() {
        authorizationPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(authorizationPage.isFirstNameFieldVisible());
        assertTrue(authorizationPage.isLastNameFieldVisible());
    }

    @Given("User opens {string} authorization page")
    public void userOpensRegisterPageAuthorizationPage(final String regurl) {
        authorizationPage = pageFactoryManager.getAuthorizationPage();
        authorizationPage.openRegisterPage(regurl);
    }

    @And("User checks 'Submit' button visibility")
    public void checkSubmitVisibility() { authorizationPage.isSubmitButtonVisible();}

    @When("User clicks 'Submit' button")
    public void userClicksSubmitButton() {authorizationPage.clickSubmitButton();}

    @Then("User checks validation error messages are visible")
    public void userChecksValidationErrorMessagesAreVisible() {
        authorizationPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(authorizationPage.isEmailValidationErrorVisible());
    }

    @And("User checks 'Sign up with Google' button visibility")
    public void userChecksSignUpWithGoogleButtonVisibility() {authorizationPage.isSignUpWithGoogleVisible();
    }

    @When("User clicks 'Sign up with Google' button")
    public void userClicksSignUpWithGoogleButton() {authorizationPage.clickSignUpWithGoogleButton(); }

    @Then("User checks that google account redirection opens")
    public void userChecksThatGoogleAccountUrlContainsCorrectWord() {
        authorizationPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        authorizationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        authorizationPage.isInitialGooglePopUpVisible();
    }

    @Given("User opens {string} login page")
    public void userOpensLoginPage(final String loginurl) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.openLoginPage(loginurl);
    }

    @And("User checks email and password fields visibility in SignIn page")
    public void userChecksEmailAndPasswordFieldsVisibilityInSignInPage() {
        loginPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        loginPage.isEmailFieldVisible();
        loginPage.isPasswordFieldVisible();
    }

    @When("User enters email {string} in the appropriate field")
    public void userEntersEmailEmailInTheAppropriateField(final String email) {
        loginPage.enterEmailInField(email);
    }

    @And("User enters password {string}")
    public void userEntersPassword(final String password) {
        loginPage.enterPasswordInField(password);
    }

    @When("User clicks 'Sign In' button")
    public void userClicksSignInButton() {loginPage.clickSubmitButton();}

    @Then("User checks validation error message is displayed")
    public void userChecksValidationErrorMessageIsDisplayed() {
        loginPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(loginPage.isValidationErrorMessageVisible());
    }


    @And("User opens shopping cart")
    public void openShoppingCart() {
        homePage.clickCartButton();
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartTitle());
    }



    @And("User checks that shopping cart title visible")
    public void checkShoppingCartTitleVisibility() {
        assertTrue(shoppingCartPage.isShoppingCartTitleVisible());
    }

    @And("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() throws InterruptedException {
        sleep(1500);//потому что баг, вам так делать нельзя!!!
        homePage.clickSearchButton();
    }

    @And("User clicks 'Add to Cart' button on product")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartPopupHeader());
        assertTrue(productPage.isAddToCartPopupVisible());
    }

    @And("User checks 'Continue Shopping' button visibility")
    public void checkContinueShoppingButtonVisibility() {
        productPage.isContinueShoppingButtonVisible();
    }

    @And("User checks 'Continue to Cart' button visibility")
    public void checkContinueToCartButtonVisibility() {
        productPage.isContinueToCartButtonVisible();
    }

    @And("User checks that add to cart popup header is {string}")
    public void checkAddToCartPopupHeader(final String expectedText) {
        assertEquals(productPage.getAddToCartPopupHeaderText(), expectedText);
    }

    @And("User clicks 'Continue to Cart' button")
    public void clickContinueToCartButton() {
        productPage.clickContinueToCartButton();
    }

    @And("User clicks 'Checkout' button")
    public void clickCheckoutButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingCartPage.getShoppingCartItem());
        shoppingCartPage.clickCheckoutButton();
    }

    @And("User clicks payment cart button")
    public void clickPaymentCartButton() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        checkoutPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        checkoutPage.clickPaymentCartButton();
    }

    @And("User checks payment form visibility")
    public void checkPaymentFormVisibility() {
        assertTrue(checkoutPage.isPaymentFormVisible());
    }

    @And("User checks billing form visibility")
    public void checkBillingFormVisibility() {
        assertTrue(checkoutPage.isBillingFormVisible());
    }

    @And("User checks 'Complete Order' button visibility")
    public void checkCompleteOrderButtonVisibility() {
        assertTrue(checkoutPage.isCompleteOrderButtonVisible());
    }

    @And("User clicks wish list on first product")
    public void clickWishList() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickWishListOnFirstProduct();
    }

    @And("User checks that amount of products in wish list are {string}")
    public void checkAmountOfProductsInWishList(final String expectedAmount) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getWishListProductsCount());
        assertEquals(homePage.getAmountOfProductsInWishList(), expectedAmount);
    }

    @After
    public void tearDown() {
        driver.close();
    }



}
