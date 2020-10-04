import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final String webAddress = "https://gdcloud.ru/release-17/auth/login";

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

    public void open() {
        driver.get(webAddress);
    }

    public void fillUserName(String userNameArg) {
        username.sendKeys(userNameArg);
    }

    public void fillPassword(String passwordArg) {
        password.sendKeys(passwordArg);
    }



}
