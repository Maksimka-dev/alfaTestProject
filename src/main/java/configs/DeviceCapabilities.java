package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:device.properties",
})
public interface DeviceCapabilities extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("automationName")
    String automationName();

    @Key("myAppPackage")
    String myAppPackage();

    @Key("myAppActivity")
    String myAppActivity();

    @Key("appiumServer")
    String appiumServer();
}
