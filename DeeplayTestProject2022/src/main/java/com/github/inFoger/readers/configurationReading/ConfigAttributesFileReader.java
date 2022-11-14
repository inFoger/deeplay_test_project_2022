package com.github.inFoger.readers.configurationReading;

import com.github.inFoger.Attribute;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigAttributesFileReader implements IConfigAttributesReader {
    private final int priorityOrderStart = 1;
    public List<Attribute> readAttributes(String filePath) {
        Properties propsFromConfig = new Properties();
        List<Attribute> attributeList = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filePath)){
            propsFromConfig.load(inputStream);
            int priorityOrder = priorityOrderStart;
            for(String attributeTitle : propsFromConfig.stringPropertyNames()) {
                List<String> possibleValues = List.of(propsFromConfig.getProperty(attributeTitle).split(","));
                attributeList.add(new Attribute(attributeTitle, priorityOrder, possibleValues));
                priorityOrder++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attributeList;
    }

}
