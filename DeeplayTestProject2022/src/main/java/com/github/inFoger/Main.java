package com.github.inFoger;

import com.github.inFoger.readers.configurationReading.ConfigAttributesFileReader;
import com.github.inFoger.readers.entityReading.EntityFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ConfigAttributesFileReader reader = new ConfigAttributesFileReader();
        List<Attribute> attributeList = reader.readAttributes("configAttributes.ini");
        Attribute[] attributes = attributeList.toArray(new Attribute[0]);
        EntityFileReader entityFileReader = new EntityFileReader(attributes);
        List<Entity> entityList = entityFileReader.readEntities("animals");
        System.out.println(entityList.toArray());
    }
}