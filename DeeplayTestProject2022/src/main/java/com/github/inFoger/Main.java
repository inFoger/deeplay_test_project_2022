package com.github.inFoger;

import com.github.inFoger.configurationReading.ConfigAttributesFileReader;
import com.github.inFoger.entityReading.EntityFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ConfigAttributesFileReader reader = new ConfigAttributesFileReader();
        List<IAttribute> attributeList = reader.readAttributes("configAttributes.ini");
        IAttribute[] attributes = attributeList.toArray(new IAttribute[0]);
        EntityFileReader entityFileReader = new EntityFileReader(attributes);
        List<IEntity> entityList = entityFileReader.readEntities("animals");
        System.out.println(entityList.toArray());
    }
}