import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class ScenarioSettings {

    private final String driverDirectory = "./src/test/resources/drivers/chromedriver.exe";

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverDirectory);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterSuite
    public void closeBrowser() {
//        try {
//            Thread.sleep(10 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
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
