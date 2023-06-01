package net.osandman.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();
    private static final String PROP_FILE = "application.properties";

    static {
        loadProperties();
    }

    private PropertiesUtil() {
    }

    public static String getValue(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream(PROP_FILE)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
