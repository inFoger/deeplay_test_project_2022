package com.github.inFoger;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QueryExecutorTest {

    @Test
    void executeWithNull() {
        List<Query> queryList1 = new ArrayList<>();  //пустой
        List<Entity> entityList1 = new ArrayList<>();  //пустой
        List<Query> queryList2 = new ArrayList<>();
        List<Entity> entityList2 = new ArrayList<>();
        //заполнение
        {
            queryList2.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE"}));
            queryList2.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE", "HEIGHT=SMALL", "||",
                    "TYPE=CARNIVORE", "HEIGHT=SMALL"}));
            queryList2.add(new Query("TOTAL", new String[]{"TYPE=OMNIVORE", "HEIGHT=!SMALL"}));
            Map<String, String> mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "LIGHT");
            mapForEntityList3.put("HEIGHT", "SMALL");
            mapForEntityList3.put("TYPE", "OMNIVORE");
            entityList2.add(new Entity(mapForEntityList3));
            mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "HEAVY");
            mapForEntityList3.put("HEIGHT", "SMALL");
            mapForEntityList3.put("TYPE", "HERBIVORE");
            entityList2.add(new Entity(mapForEntityList3));
            mapForEntityList3 = new HashMap<>();
            mapForEntityList3.put("WEIGHT", "HEAVY");
            mapForEntityList3.put("HEIGHT", "SHORT");
            mapForEntityList3.put("TYPE", "HERBIVORE");
            entityList2.add(new Entity(mapForEntityList3));
        }

        try {
            QueryExecutor.execute(queryList2, entityList2);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        assertThrows(Exception.class, () -> {QueryExecutor.execute(queryList1, entityList2);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(queryList2, entityList1);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(null, entityList2);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(queryList2, null);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(null, null);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(queryList1, null);});
        assertThrows(Exception.class, () -> {QueryExecutor.execute(null, entityList1);});

    }
}