package com.epam.jwd.core_final.util;


import com.epam.jwd.core_final.domain.ApplicationProperties;
import com.epam.jwd.core_final.exception.UnknownPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public final class PropertyReaderUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(PropertyReaderUtil.class);

    private static final Properties properties = new Properties();

    private PropertyReaderUtil() {
    }

    /**
     * try-with-resource using FileInputStream
     *
     * @see {https://www.netjstech.com/2017/09/how-to-read-properties-file-in-java.html for an example}
     * <p>
     * as a result - you should populate {@link ApplicationProperties} with corresponding
     * values from property file
     */
    public static Properties loadProperties() {
        final String propertiesFileName = "src/main/resources/application.properties";

        try (InputStream inputStream = new FileInputStream(propertiesFileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            // todo
            LOGGER.info("Handled IOException. Can't read file: " + propertiesFileName);
        }

        return properties;
    }
}
