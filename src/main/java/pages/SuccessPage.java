package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement welcomeText;

    public String getTitleSuccessPage() {
        return welcomeText.getText();
    }

}
