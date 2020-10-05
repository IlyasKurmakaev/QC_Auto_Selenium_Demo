package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String webAddress = "https://gdcloud.ru/release-17/auth/login";
    private final String errorText = "Неверное имя пользователя или пароль";

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

    @FindBy(xpath = "//*[@id=\"error\"]")
    private WebElement error;

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

    public boolean checkVisibilityError() {
        wait.until(ExpectedConditions.visibilityOf(error));
        return error.isDisplayed();
    }

    public boolean checkErrorText() {
        return errorText.equals(error.getText());
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
}
