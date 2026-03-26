package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.StartPage;
import pages.SuccessPage;
import retry.RetryAnalyzer;

import static configs.ConfigReader.LOGIN_CAP;
import static constants.Constants.LONG_LOGIN;
import static constants.Constants.SUCCESS_TEXT_SUCCESS_PAGE;
import static constants.Errors.ERROR_TITLE;
import static constants.Errors.INVALID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    @Description("Tест успешной авторизации в системе")
    public void successLoginTest()  {
        StartPage startPage = new StartPage();
        SuccessPage succesPage = new SuccessPage();

        startPage.fillLoginFields(LOGIN_CAP.login())
                .fillPasswordFields(LOGIN_CAP.password())
                .clickLogin()
                .waitDisappearLoader();

        assertThat(succesPage.getTitleSuccessPage()).as("Вход выполнен не успешно").isEqualTo(SUCCESS_TEXT_SUCCESS_PAGE);
    }

    @Description("Tест валидный логин и не валидный пароль")
    @Test
    public void validLoginAndWrongPassTest() {
        StartPage startPage = new StartPage();

        startPage.fillLoginFields(LOGIN_CAP.login())
                .fillPasswordFields(LOGIN_CAP.wrongpass())
                .clickLogin()
                .waitDisappearLoader();

        assertThat(startPage.getErrorText())
                .as("Текст ошибки ввода не соответствует ожидаемому").isEqualTo(ERROR_TITLE);
    }

    @Description("Tест не валидный логин и валидный пароль")
    @Test
    public void validPassAndWrongLoginTest() {
        StartPage startPage = new StartPage();

        startPage.fillLoginFields(LOGIN_CAP.wronglogin())
                .fillPasswordFields(LOGIN_CAP.password())
                .clickLogin()
                .waitDisappearLoader();

        assertThat(startPage.getErrorText())
                .as("Текст ошибки ввода не соответствует ожидаемому").isEqualTo(ERROR_TITLE);
    }

    @Description("Tест ввод в поле логина недопустимого символа")
    @Test
    public void illegalSymbolToLoginTest() {
        StartPage startPage = new StartPage();

        startPage.fillLoginFields("@")
                .clickPasswordField();

        assertThat(startPage.getErrorText())
                .as("Текст ошибки ввода не соответствует ожидаемому").isEqualTo(INVALID_VALUE);
    }

    @Test
    @Description("Tест проверка обрезки больше 50 введенных символов в поле логина")
    public void cutTest() {
        StartPage startPage = new StartPage();

        startPage.fillLoginFields(LONG_LOGIN);
        startPage.clickPasswordField();

        String pattern = "^[A-Za-z]{50}$";

        assertThat(startPage.getLoginFieldText().matches(pattern))
                .as("Длина текста в поле логина должна быть 50 символов").isTrue();
    }
}
