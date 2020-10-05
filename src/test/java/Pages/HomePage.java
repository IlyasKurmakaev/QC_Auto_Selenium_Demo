package Pages;

import Scenarios.ScenarioSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends ScenarioSettings {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//*[@class=\"username-section\"]")
    private WebElement userBar;

    public boolean checkSuccessLoading() {
        wait.until(ExpectedConditions.visibilityOf(userBar));
        return userBar.isDisplayed();
    }
}
