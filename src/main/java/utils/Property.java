package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    private static Properties loadProperties(String propertyFilePath) {
        Properties property = new Properties();
        try (FileInputStream input = new FileInputStream(propertyFilePath)) {//for speed purpose
            property.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
    public static String getConfig(String key) {
        return loadProperties("config.properties").getProperty(key).trim();
    }
}
