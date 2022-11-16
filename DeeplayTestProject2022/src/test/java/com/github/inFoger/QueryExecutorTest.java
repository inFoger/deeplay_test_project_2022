package com.github.inFoger;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class QueryExecutorTest {

    @Test
    void execute() {
        List<Query> queryListEmpty = new ArrayList<>();  //пустой
        List<Entity> entityListEmpty = new ArrayList<>();  //пустой
        List<Query> queryList1 = new ArrayList<>();
        List<Entity> entityList1 = new ArrayList<>();
        //заполнение
        {
            queryList1.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE"}));
            queryList1.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE", "HEIGHT=SMALL", "||",
                    "TYPE=CARNIVORE", "HEIGHT=SMALL"}));
            queryList1.add(new Query("TOTAL", new String[]{"TYPE=OMNIVORE", "HEIGHT=!SMALL"}));
            Map<String, String> mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "LIGHT");
            mapForEntityList3.put("HEIGHT", "SMALL");
            mapForEntityList3.put("TYPE", "OMNIVORE");
            entityList1.add(new Entity(mapForEntityList3));
            mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "HEAVY");
            mapForEntityList3.put("HEIGHT", "SMALL");
            mapForEntityList3.put("TYPE", "HERBIVORE");
            entityList1.add(new Entity(mapForEntityList3));
            mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "HEAVY");
            mapForEntityList3.put("HEIGHT", "SHORT");
            mapForEntityList3.put("TYPE", "HERBIVORE");
            entityList1.add(new Entity(mapForEntityList3));
        }

        try {
            QueryExecutor.execute(queryList1, entityList1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertDoesNotThrow(() -> QueryExecutor.execute(queryListEmpty, entityList1));
        assertDoesNotThrow(() -> QueryExecutor.execute(queryList1, entityListEmpty));
        assertThrows(NullPointerException.class, () -> QueryExecutor.execute(null, entityList1));
        assertThrows(NullPointerException.class, () -> QueryExecutor.execute(queryList1, null));
        assertThrows(NullPointerException.class, () -> QueryExecutor.execute(null, null));
        assertThrows(NullPointerException.class, () -> QueryExecutor.execute(queryListEmpty, null));
        assertThrows(NullPointerException.class, () -> QueryExecutor.execute(null, entityListEmpty));

    }
}