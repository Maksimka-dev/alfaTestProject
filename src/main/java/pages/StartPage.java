package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.InitialDriver.getDriver;

public class StartPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.alfabank.qapp:id/etUsername\"]")
    private WebElement loginField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.alfabank.qapp:id/etPassword\"]")
    private WebElement passwordField;
    @AndroidFindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private WebElement loginBtn;
    @AndroidFindBy(id = "com.alfabank.qapp:id/tvError")
    private WebElement errorMessage;
    @AndroidFindBy(id = "com.alfabank.qapp:id/loader")
    private WebElement loader;
    @AndroidFindBy(id = "com.alfabank.qapp:id/tvTitle")
    private WebElement titleTxt;
    @AndroidFindBy(id = "com.alfabank.qapp:id/text_input_end_icon")
    private WebElement visiblePas;

    @Step("Получение текста тайтла")
    public String getTitlePage() {
        return titleTxt.getText();
    }
    @Step("Получение имени кнопки входа")
    public String getNameButton() {
        return loginBtn.getText();
    }

    @Step("Получение текста ошибки ввода")
    public String getErrorText() {
        return errorMessage.getText();
    }

    @Step("Получение лэйбла из поля логина")
    public String getLoginLabel() {
        return loginField.getText();
    }

    @Step("Получение лэйбла из поля пароля")
    public String getPassLabel() {
        return passwordField.getText();
    }

    @Step("Получение текста из поля логина")
    public String getLoginFieldText() {
        return loginField.getText();
    }

    @Step("Ввод логина")
    public StartPage fillLoginFields(String text) {
        loginField.sendKeys(text);
        return this;
    }

    @Step("Ввод пароля")
    public StartPage fillPasswordFields(String text) {
        passwordField.sendKeys(text);
        return this;
    }

    @Step("Нажатие кнопки входа")
    public StartPage clickLogin() {
        loginBtn.click();
        return this;
    }

    @Step("Курсор в поле пароля")
    public StartPage clickPasswordField() {
        passwordField.click();
        return this;
    }

    @Step("Лоадер исчез")
    public boolean waitDisappearLoader() {
        try {
            return new WebDriverWait(getDriver(), Duration.ofSeconds(5L))
                    .until(ExpectedConditions.invisibilityOf(loader));
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Нажатие на кнопку маскирования пароля")
    public StartPage maskVisabilityBtnClick() {
        visiblePas.click();
        return this;
    }

    public boolean checkVisabilityPassword() {
        boolean isPass = passwordField.getAttribute("password").equals("false");
        return isPass;
    }

}
