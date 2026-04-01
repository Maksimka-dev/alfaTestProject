package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.StartPage;

import static configs.ConfigReader.LOGIN_CAP;
import static org.assertj.core.api.Assertions.assertThat;

public class MaskTest extends BaseTest {

    @Test
    @Description("Tест что работает кнопка маскирование")
    public void maskTest()  {
        StartPage startPage = new StartPage();

        boolean isPasswordMasked = startPage.fillLoginFields(LOGIN_CAP.login())
                .fillPasswordFields(LOGIN_CAP.wrongpass())
                .maskVisabilityBtnClick()
                .checkVisabilityPassword();

        assertThat(isPasswordMasked).as("Пароль не маскирован").isTrue();
    }

}

