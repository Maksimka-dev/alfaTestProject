package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.StartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MaskTest extends BaseTest {

    @Test
    @Description("Tест что работает кнопка маскирование")
    public void maskTest()  {
        StartPage startPage = new StartPage();

        boolean isPasswordMasked = startPage.fillLoginFields("Login")
                .fillPasswordFields("12345")
                .maskVisabilityBtnClick()
                .checkVisabilityPassword();

        assertThat(isPasswordMasked).as("Пароль не маскирован").isTrue();
    }

}

