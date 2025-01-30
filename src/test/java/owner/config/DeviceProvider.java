package owner.config;

import org.aeonbits.owner.ConfigFactory;

public class DeviceProvider {
    public static final DeviceConfig DEVICE_CONFIG = ConfigFactory.create(DeviceConfig.class, System.getProperties());
}
