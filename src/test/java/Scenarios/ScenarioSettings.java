package Scenarios;

import UserHelper.UserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public abstract class ScenarioSettings {

    private final String driverDirectory = "./src/test/resources/drivers/chromedriver.exe";

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverDirectory);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void closeBrowser() {
        UserManager.getInstance().refreshInstance();
        driver.quit();
    }

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface ArtifactId {
        int artifactId();
    }

    protected int getArtifactIdFromMethod(Class classArg, String methodName) {
        int res;
        try {
            Method method = classArg.getMethod(methodName);
            res = method.getAnnotation(ArtifactId.class).artifactId();
            return res;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("\"В классе \"" + classArg.getName() + " не найден метод \"" + methodName + "\"");
        }
    }
}
