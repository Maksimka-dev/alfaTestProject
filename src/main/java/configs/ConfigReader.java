package configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final DeviceCapabilities DEVICE_CAP = ConfigFactory.create(DeviceCapabilities.class, System.getProperties());
    public static final LoginCapabilities LOGIN_CAP = ConfigFactory.create(LoginCapabilities.class, System.getProperties());
    public static final ConfigCapabilities CONF_CAP = ConfigFactory.create(ConfigCapabilities.class, System.getProperties());
}
