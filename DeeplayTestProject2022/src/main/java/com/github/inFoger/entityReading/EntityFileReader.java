package com.github.inFoger.entityReading;

import com.github.inFoger.AnimalEntity;
import com.github.inFoger.Attribute;
import com.github.inFoger.IAttribute;
import com.github.inFoger.IEntity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityFileReader implements IEntityReader {
    private IAttribute[] orderedAttributes;

    public EntityFileReader(IAttribute[] orderedAttributes) {
        this.orderedAttributes = orderedAttributes;
    }

    public List<IEntity> readEntities(String filePath) throws IOException {
        List<IEntity> entities = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                Map<String, String> currentAnimalAttributes = new HashMap<>();
                String[] splittedLine = readLine.split(",");
                for (int i = 0; i < splittedLine.length; i++) {
                    if(!isExistAttributeValue(splittedLine[i], i)) {
                        throw new IOException(); //TODO сделать своё исключение
                    }
                    currentAnimalAttributes.put(orderedAttributes[i].getTitle(), splittedLine[i]);
                }
                entities.add(new AnimalEntity(currentAnimalAttributes));
                readLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    private boolean isExistAttributeValue(String attributeValue, int attributeOrderNumber) {
        return orderedAttributes[attributeOrderNumber].getPossibleValues().contains(attributeValue);
    }

}
