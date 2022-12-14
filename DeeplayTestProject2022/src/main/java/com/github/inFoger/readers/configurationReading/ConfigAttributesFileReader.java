package com.github.inFoger.readers.configurationReading;

import com.github.inFoger.Attribute;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Класс ConfigAttributesFileReader считывает настройки из конфигурационного файла
 * В нём(файле) прописываются атрибуты и их возможные значения
 * Возвращается список атрибутов, с которым мы будем сверяться дальше
 */

public class ConfigAttributesFileReader implements IConfigAttributesReader {
    private final Logger logger = Logger.getLogger(ConfigAttributesFileReader.class.getName());
    public List<Attribute> readAttributes(String filePath) throws Exception {
        if(filePath == null) {
            logger.warning("String argument is null");
            throw new NullPointerException("String argument is null");
        }
        Properties propsFromConfig = new Properties();
        List<Attribute> attributeList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filePath)){
            propsFromConfig.load(inputStream);
            for(String attributeTitle : propsFromConfig.stringPropertyNames()) {
                List<String> possibleValues = List.of(propsFromConfig.getProperty(attributeTitle).split(","));
                attributeList.add(new Attribute(attributeTitle, possibleValues));
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw new Exception(e);
        }

        return attributeList;
    }

}
