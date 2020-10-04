import DateBaseHelper.DataBaseManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends ScenarioSettings {

    @Test
    @ArtifactId(artifactId = 1)
    public void signIn() {
        DataBaseManager dbManager = new DataBaseManager();
        int id = getArtifactIdFromMethod(this.getClass(), "signIn");
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();
        signInPage.fillUserName(dbManager.getUserName(id));
        signInPage.fillPassword(dbManager.getPassword(id));
        Assert.assertTrue(false);
    }
}
