package com.github.inFoger.configuration;

import com.github.inFoger.Attribute;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfigFileRulesReader implements IConfigRulesReader {
    public List<Attribute> readAttributes(String filePath) throws IOException {
        Properties propsFromConfig = new Properties();
        propsFromConfig.load(new FileInputStream(filePath));

        List<Attribute> attributeList = new ArrayList<>();
        for(String attributeTitle : propsFromConfig.stringPropertyNames()) {
            List<String> possibleValues = List.of(propsFromConfig.getProperty(attributeTitle).split(","));
            attributeList.add(new Attribute(attributeTitle, possibleValues));
        }
        return attributeList;
    }

}
