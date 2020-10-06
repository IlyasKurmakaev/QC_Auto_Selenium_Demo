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
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        Assert.assertEquals(signInPage.getUserNamePlaceholder(), signInPage.getExpectedUserNamePlaceholder());
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        Assert.assertEquals(signInPage.getPasswordPlaceholder(), signInPage.getExpectedPasswordPlaceholder());
        signInPage.fillPassword(user.getPassword());
        signInPage.checkVisibilityRememberMeCheckBox();

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        Assert.assertTrue(signInPage.checkVisibilitySubmitAnotherUserButton(), "Кнопка \"Войти(другая учётная запись)\" не отображается");
        Assert.assertTrue(signInPage.checkVisibilitySubmitCurrentUserButton(), "Кнопка \"Войти(текущая учётная запись)\" не отображается");

        signInPage.pressSubmit();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.checkSuccessLoading(), "Страница не загрузилась");
    }

    @Test
    @ArtifactId(artifactId = 2)
    public void signInWrongUserName() { //кейс - неверный логин
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongUserName");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorWrongUserNameOrLoginText() , "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 3)
    public void signInWrongPassword() { // кейс - неверный пароль
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongPassword");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка \"Войти\" не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorWrongUserNameOrLoginText() , "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 4)
    public void signInWrongUserNameAndPassword() { // кейс - неверные логин и пароль
        int id = getArtifactIdFromMethod(this.getClass(), "signInWrongUserNameAndPassword");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorWrongUserNameOrLoginText() , "Текст не совпадает с ожидаемым");
    }


    @Test
    @ArtifactId(artifactId = 5)
    public void signInEmptyUserName() { // кейс - логин не введён P.S. признаюсь, я не смог понять как отловить всплывающее сообщение о просьбе заполнить пустое поле
        int id = getArtifactIdFromMethod(this.getClass(), "signInEmptyUserName");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkInvisibilityError(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkInvisibilityError(), "Ошибка отображается");
        Assert.assertTrue(signInPage.checkVisibilityCentralBlock());
    }

    @Test
    @ArtifactId(artifactId = 6)
    public void signInEmptyPassword() { // кейс - пароль не введён
        int id = getArtifactIdFromMethod(this.getClass(), "signInEmptyPassword");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkInvisibilityError(), "Ошибка отображается");
        Assert.assertTrue(signInPage.checkVisibilityCentralBlock());
    }

    @Test
    @ArtifactId(artifactId = 7)
    public void signInEmptyFields() { // кейс - не введены логин и пароль
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка войти не отображается");
        signInPage.pressSubmit();

        Assert.assertTrue(signInPage.checkInvisibilityError(), "Ошибка отображается");
        Assert.assertTrue(signInPage.checkVisibilityCentralBlock(), "Мы перешли на другую страницу");
    }

    @Test
    @ArtifactId(artifactId = 8)
    public void signInUserNameWrongRegister() { // кейс - проверка логина на чувствительность к регистру PS интуитивно понятно, что не должна учитываться чувствительность, но уверенности до конца нет, я бы спросил у ручника как должно быть или у системного аналитика
        int id = getArtifactIdFromMethod(this.getClass(), "signInUserNameWrongRegister");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка \"Войти\" не отображается");
        signInPage.pressSubmit();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.checkSuccessLoading(), "Страница не загрузилась");
    }

    @Test
    @ArtifactId(artifactId = 9)
    public void signInPasswordWrongRegister() { // кейс - проверка пароля на чувствительность к регистру
        int id = getArtifactIdFromMethod(this.getClass(), "signInPasswordWrongRegister");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка \"Войти\" не отображается");
        signInPage.pressSubmit();
        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorWrongUserNameOrLoginText() , "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 10)
    public void signInNotRememberMe() { // кейс - без чекбокса не запоминает пользователя
        int id = getArtifactIdFromMethod(this.getClass(), "signInNotRememberMe");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        signInPage.checkVisibilityRememberMeCheckBox();
        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка \"Войти\" не отображается");

        signInPage.pressSubmit();

        signInPage.open();
        Assert.assertTrue(signInPage.checkVisibilityCentralBlock());
    }

    @Test
    @ArtifactId(artifactId = 11)
    public void signInRememberMe() { // кейс - с чекбоксом, запоминает пользователя
        int id = getArtifactIdFromMethod(this.getClass(), "signInRememberMe");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilityRememberMeCheckBox(), "Чекбокс не отображается");
        Assert.assertTrue(signInPage.checkVisibilitySubmitButton(), "Кнопка \"Войти\" не отображается");

        signInPage.pressCheckBox();
        signInPage.pressSubmit();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.checkSuccessLoading(), "Домашняя страница загрузилась");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signInPage.open();
        Assert.assertTrue(homePage.checkSuccessLoading(), "Домашняя страница загрузилась");


    }

    /*                                     (о двух дополнительных кнопках входа)
        Я не думаю что имеет смысл перебирать все комбинации правильных и неправильных паролей, так как я не встретил
        корреляций результатов от перебора(значит логика в чём-то другом). Также я не понимаю, позитивных тестов с этими кнопками,
        На рабочем месте я связялся бы через ALM(Application lifecycle management) c ручным тестировщиком и спросил бы о них
    */

    @Test
    @ArtifactId(artifactId = 12)
    public void signInNegativeAnotherAccount() { // Ошибка при нажатии на кнопку "Войти(другая учётная запись)"
        int id = getArtifactIdFromMethod(this.getClass(), "signInNegativeAnotherAccount");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitAnotherUserButton(), "Кнопка \"Войти(другая учётная запись)\" не отображается");
        signInPage.pressSubmitAnother();

        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorAuthenticationFailedText() , "Текст не совпадает с ожидаемым");
    }

    @Test
    @ArtifactId(artifactId = 13)
    public void signInNegativeCurrentAccount() { // Ошибка при нажатии на кнопку "Войти(текущая учётная запись)"
        int id = getArtifactIdFromMethod(this.getClass(), "signInNegativeCurrentAccount");
        User user = UserManager.getInstance().getNextUser(id);

        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.open();

        Assert.assertTrue(signInPage.checkVisibilityUserNameField(), "Поле логина не отображается");
        signInPage.fillUserName(user.getUserName());

        Assert.assertTrue(signInPage.checkVisibilityPasswordField(), "Поле пароля не отображается");
        signInPage.fillPassword(user.getPassword());

        Assert.assertTrue(signInPage.checkVisibilitySubmitCurrentUserButton(), "Кнопка \"Войти(текущая учётная запись)\" не отображается");
        signInPage.pressSubmitCurrent();

        Assert.assertTrue(signInPage.checkVisibilityError(), "Ошибка не отображается");
        Assert.assertEquals(signInPage.getErrorText(), signInPage.getExpectedErrorAuthenticationFailedText(), "Текст не совпадает с ожидаемым");
    }

    /*
       ещё можно было бы проверить на мин/макс длину, но без подходящих тестовых данных я не могу выявить этих ограничений
       также и с проверкой на спецсимволы
    */
}