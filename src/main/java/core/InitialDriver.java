package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static configs.ConfigReader.DEVICE_CAP;

public class InitialDriver {

    private static AppiumDriver driver;

    private InitialDriver() {}

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                driver = initializeDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        return driver;
    }

    private static AppiumDriver initializeDriver() throws MalformedURLException {
        UiAutomator2Options options = getOptions();

        driver = new AppiumDriver(
                new URL(DEVICE_CAP.appiumServer()),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    private static UiAutomator2Options getOptions() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(DEVICE_CAP.platformName());
        options.setAutomationName(DEVICE_CAP.automationName());
        options.setDeviceName(DEVICE_CAP.deviceName());

        options.setAppPackage(DEVICE_CAP.myAppPackage());
        options.setAppActivity(DEVICE_CAP.myAppActivity());

        return options;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
