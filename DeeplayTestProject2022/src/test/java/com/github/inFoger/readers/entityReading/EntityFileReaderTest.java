package com.github.inFoger.readers.entityReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.Entity;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EntityFileReaderTest {

    @Test
    void readEntities() {
        Attribute attribute1 = new Attribute("WEIGHT", Arrays.asList("LIGHT", "MEDIUM", "HEAVY"));
        Attribute attribute2 = new Attribute("HEIGHT", Arrays.asList("SMALL", "SHORT", "TALL"));
        Attribute attribute3= new Attribute("TYPE", Arrays.asList("HERBIVORE", "CARNIVORE", "OMNIVORE"));
        List<Attribute> attributeList = new ArrayList<>(Arrays.asList(attribute1, attribute2, attribute3));

        List<Entity> entityList1 = new ArrayList<>();
        Map<String, String> mapForEntityList = new HashMap<>();
        mapForEntityList.put("WEIGHT", "LIGHT");
        mapForEntityList.put("HEIGHT", "SMALL");
        mapForEntityList.put("TYPE", "OMNIVORE");
        Entity entity1 = new Entity(mapForEntityList);
        entityList1.add(entity1);
        mapForEntityList = new HashMap<>();
        mapForEntityList.put("WEIGHT", "HEAVY");
        mapForEntityList.put("HEIGHT", "SMALL");
        mapForEntityList.put("TYPE", "HERBIVORE");
        Entity entity2 = new Entity(mapForEntityList);
        entityList1.add(entity2);
        mapForEntityList = new HashMap<>();
        mapForEntityList.put("WEIGHT", "HEAVY");
        mapForEntityList.put("HEIGHT", "SHORT");
        mapForEntityList.put("TYPE", "HERBIVORE");
        Entity entity3 = new Entity(mapForEntityList);
        entityList1.add(entity3);

        EntityFileReader fileReader = new EntityFileReader(attributeList.toArray(new Attribute[0]));

        assertThrows(NullPointerException.class, () -> fileReader.readEntities(null));
        assertThrows(Exception.class, () -> fileReader.readEntities("notExistingFile"));

        try {
            List<Entity> resultList = fileReader.readEntities("animals");
            assertEquals(entityList1, resultList);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }


    }
}