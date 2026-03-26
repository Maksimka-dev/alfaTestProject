package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StartPage;

import static constants.Constants.*;

public class UIStartPageTest extends BaseTest {

    @Test
    @Description("Tест кейс проверки названий кнопок и textField")
    public void namingTest()  {
        StartPage startPage = new StartPage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(
                WELCOME_TITLE_START_PAGE, startPage.getTitlePage(), "Заголовок не'Вход в Alfa-Test'");
        softAssert.assertEquals(
                ENTER_BUTTON_START_PAGE, startPage.getNameButton(),"Имя кнопки входа не 'Вход'");
        softAssert.assertEquals(
                LOGIN_LABEL_START_PAGE, startPage.getLoginLabel(),"Лэйбл в поле логина не 'Логин'");
        softAssert.assertEquals(
                PASS_LABEL_START_PAGE, startPage.getPassLabel(),"Лэйбл в поле пароля не 'Пароль'");
        softAssert.assertAll();
    }
}