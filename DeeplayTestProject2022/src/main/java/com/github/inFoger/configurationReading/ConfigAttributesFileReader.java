package com.github.inFoger.configurationReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.IAttribute;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigAttributesFileReader implements IConfigAttributesReader {
    private final int priorityOrderStart = 1;
    public List<IAttribute> readAttributes(String filePath) throws IOException {
        Properties propsFromConfig = new Properties();
        propsFromConfig.load(new FileInputStream(filePath));

        List<IAttribute> attributeList = new ArrayList<>();
        int priorityOrder = priorityOrderStart;
        for(String attributeTitle : propsFromConfig.stringPropertyNames()) {
            List<String> possibleValues = List.of(propsFromConfig.getProperty(attributeTitle).split(","));
            attributeList.add(new Attribute(attributeTitle, priorityOrder, possibleValues));
            priorityOrder++;
        }
        return attributeList;
    }

}
