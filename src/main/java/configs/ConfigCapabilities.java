package configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties",
})
public interface ConfigCapabilities extends Config {

    @Key("test.retry.count")
    String retryCount();
}
