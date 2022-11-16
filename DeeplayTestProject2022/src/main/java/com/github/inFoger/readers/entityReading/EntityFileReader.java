package com.github.inFoger.readers.entityReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Класс EntityFileReader считывает животных из файла и возвращает их в виде списка Entity
 * isExistAttributeValue() проверят существует ли данное значение атрибута(свойства животного)
 */

public class EntityFileReader implements IEntityReader {
    private final Logger logger = Logger.getLogger(EntityFileReader.class.getName());
    private final Attribute[] attributes;

    public EntityFileReader(Attribute[] attributes) {
        this.attributes = attributes;
    }

    //в порядке
    public List<Entity> readEntities(String filePath) throws Exception {
        if(filePath == null) {
            logger.warning("String argument is null");
            throw new NullPointerException("String argument is null");
        }
        List<Entity> entities = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                Map<String, String> currentAnimalAttributes = new HashMap<>();
                String[] splittedLine = readLine.split(",");
                for (int i = 0; i < splittedLine.length; i++) {
                    if(!isExistAttributeValue(splittedLine[i], i)) {
                        throw new IOException();
                    }
                    currentAnimalAttributes.put(attributes[i].getTitle(), splittedLine[i]);
                }
                entities.add(new Entity(currentAnimalAttributes));
                readLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
            throw new Exception(e);
        }
        return entities;
    }

    private boolean isExistAttributeValue(String attributeValue, int attributeOrderNumber) {
        return attributes[attributeOrderNumber].getPossibleValues().contains(attributeValue);
    }
}
