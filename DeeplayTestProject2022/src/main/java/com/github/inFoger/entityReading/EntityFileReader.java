package com.github.inFoger.entityReading;

import com.github.inFoger.AnimalEntity;
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
    public List<IEntity> readEntities(String filePath, List<IAttribute> allAttributes) throws IOException {
        List<IEntity> entities = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            Map<String, String> currentAnimalAttributes = new HashMap<>();
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String[] splittedLine = readLine.split(",");
                for (int i = 0; i < splittedLine.length; i++) {

                }
            }
        }
        return entities;
    }


}
