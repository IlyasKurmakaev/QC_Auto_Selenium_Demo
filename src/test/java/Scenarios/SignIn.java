package Scenarios;

import Pages.HomePage;
import Pages.SignInPage;
import UserHelper.User;
import UserHelper.UserManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn extends ScenarioSettings {

    @Test
    @ArtifactId(artifactId = 1)
    public void signIn() {
        int id = getArtifactIdFromMethod(this.getClass(), "signIn");
        User user = new UserManager().getUserById(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();

        Assert.assertTrue(true);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.checkSuccessLoading(), "Страница не загрузилась");
    }

    @Test
    @ArtifactId(artifactId = 2)
    public void signInWrongUserName() { //кейс - неверный логин
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongUserName");
        User user = new UserManager().getUserById(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertTrue(signInPage.checkErrorText(), "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 3)
    public void signInWrongPassword() { // кейс - неверный пароль
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongPassword");
        User user = new UserManager().getUserById(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertTrue(signInPage.checkErrorText(), "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 4)
    public void signInWrongUserNameAndPassword() { // кейс - неверные логин и пароль
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongUserNameAndPassword");
        User user = new UserManager().getUserById(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertTrue(signInPage.checkErrorText(), "Текст не совпадает с ожидаемым");
    }
}
