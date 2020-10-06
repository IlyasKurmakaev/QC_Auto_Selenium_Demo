package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String webAddress = "https://gdcloud.ru/release-17/";
    private final String errorWrongUserNameOrLoginText = "Неверное имя пользователя или пароль";
    private final String authenticationFailed = "Аутентификация не удалась";
    private final String userNamePlaceholderText = "Номер телефона или E-mail";
    private final String passwordPlaceholderText = "Пароль";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login_button\"]")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"login_button_domain\"]")
    private WebElement submitAnotherUser;

    @FindBy(xpath = "//*[@id=\"login_button_current\"]")
    private WebElement submitCurrentUser;

    @FindBy(xpath = "//*[@id=\"error\"]")
    private WebElement error;

    @FindBy(xpath = "//*[@class=\"login center-block\"]")
    private WebElement centralBlock;

    @FindBy(xpath = "//*[@for=\"remember\"]")
    private WebElement rememberMeCheckBox;

    public void open() {
        driver.get(webAddress);
    }

    public boolean checkVisibilityUserNameField() {
        return username.isDisplayed();
    }

    public boolean checkVisibilityPasswordField() {
        return password.isDisplayed();
    }

    public boolean checkVisibilitySubmitButton() {
        return submit.isDisplayed();
    }

    public boolean checkVisibilitySubmitAnotherUserButton() {
        return submitAnotherUser.isDisplayed();
    }

    public boolean checkVisibilitySubmitCurrentUserButton() {
        return submitCurrentUser.isDisplayed();
    }

    public boolean checkVisibilityError() {
        wait.until(ExpectedConditions.visibilityOf(error));
        return error.isDisplayed();
    }

    public boolean checkInvisibilityError() {
        wait.until(ExpectedConditions.invisibilityOf(error));
        return !error.isDisplayed();
    }

    public boolean checkVisibilityCentralBlock() {
        return centralBlock.isDisplayed();
    }

    public boolean checkVisibilityRememberMeCheckBox() {
        return rememberMeCheckBox.isDisplayed();
    }

    public String getErrorText() {
        return error.getText();
    }

    public String getExpectedErrorWrongUserNameOrLoginText() {
        return errorWrongUserNameOrLoginText;
    }

    public String getExpectedErrorAuthenticationFailedText() {
        return authenticationFailed;
    }

    public String getUserNamePlaceholder() {
        return username.getAttribute("placeholder");
    }

    public String getExpectedUserNamePlaceholder() {
        return userNamePlaceholderText;
    }

    public String getPasswordPlaceholder() {
        return password.getAttribute("placeholder");
    }

    public String getExpectedPasswordPlaceholder() {
        return passwordPlaceholderText;
    }

    public void fillUserName(String userNameArg) {
        username.sendKeys(userNameArg);
    }

    public void fillPassword(String passwordArg) {
        password.sendKeys(passwordArg);
    }

    public void pressSubmit() {
        submit.click();
    }

    public void pressSubmitAnother() {
        submitAnotherUser.click();
    }

    public void pressSubmitCurrent() {
        submitCurrentUser.click();
    }

    public void pressCheckBox() {
        rememberMeCheckBox.click();
    }
}