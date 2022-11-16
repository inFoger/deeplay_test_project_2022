package com.github.inFoger.readers.configurationReading;

import com.github.inFoger.Attribute;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ConfigAttributesFileReaderTest {

    @Test
    void readAttributes() {
        ConfigAttributesFileReader reader = new ConfigAttributesFileReader();
        Attribute attribute1 = new Attribute("WEIGHT", 1, Arrays.asList("LIGHT", "MEDIUM", "HEAVY"));
        Attribute attribute2 = new Attribute("HEIGHT", 1, Arrays.asList("SMALL", "SHORT", "TALL"));
        Attribute attribute3= new Attribute("TYPE", 1, Arrays.asList("HERBIVORE", "CARNIVORE", "OMNIVORE"));
        List<Attribute> attributeList = new ArrayList<>(Arrays.asList(attribute1, attribute2, attribute3));

        assertThrows(Exception.class, () -> reader.readAttributes(null));
        assertThrows(Exception.class, () -> reader.readAttributes("notExistingPath"));
        try {
            List<Attribute> resultList = reader.readAttributes("configAttributes.ini");
            assertEquals(attribute1.getTitle(), resultList.get(0).getTitle());
            assertEquals(attribute1.getPriorityOrder(), resultList.get(0).getPriorityOrder());
            assertEquals(attribute1.getPossibleValues(), resultList.get(0).getPossibleValues());

            assertEquals(attribute2.getTitle(), resultList.get(1).getTitle());
            assertEquals(attribute2.getPriorityOrder(), resultList.get(1).getPriorityOrder());
            assertEquals(attribute2.getPossibleValues(), resultList.get(1).getPossibleValues());

            assertEquals(attribute3.getTitle(), resultList.get(2).getTitle());
            assertEquals(attribute3.getPriorityOrder(), resultList.get(2).getPriorityOrder());
            assertEquals(attribute3.getPossibleValues(), resultList.get(2).getPossibleValues());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}