package com.github.inFoger.readers.queryReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.Query;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueryFileReaderTest {

    @Test
    void readQuery() {
        Attribute attribute1 = new Attribute("WEIGHT", Arrays.asList("LIGHT", "MEDIUM", "HEAVY"));
        Attribute attribute2 = new Attribute("HEIGHT", Arrays.asList("SMALL", "SHORT", "TALL"));
        Attribute attribute3= new Attribute("TYPE", Arrays.asList("HERBIVORE", "CARNIVORE", "OMNIVORE"));
        List<Attribute> attributeList = new ArrayList<>(Arrays.asList(attribute1, attribute2, attribute3));
        List<Query> queryList = new ArrayList<>();
        queryList.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE"}));
        queryList.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE", "HEIGHT=SMALL", "||",
                "TYPE=CARNIVORE", "HEIGHT=SMALL"}));
        queryList.add(new Query("TOTAL", new String[]{"TYPE=OMNIVORE", "HEIGHT=!SMALL"}));
        QueryFileReader fileReader = new QueryFileReader(attributeList);

        assertThrows(NullPointerException.class, () -> fileReader.readQuery(null));
        assertThrows(Exception.class, () -> fileReader.readQuery("NotExistingFile"));

        try {
            List<Query> resultList = fileReader.readQuery("queryFile");
            assertEquals(queryList, resultList);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}