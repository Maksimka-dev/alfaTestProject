package tests;

import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.InitialDriver.*;


public class BaseTest {

    @BeforeMethod
    @Step("Создание драйвера")
    public static void instantiateDriver() {
        getDriver();
    }

    @AfterMethod
    @Step("Закрытие драйвера")
    public void afterMobileTests() {
        quitDriver();

    }
}
