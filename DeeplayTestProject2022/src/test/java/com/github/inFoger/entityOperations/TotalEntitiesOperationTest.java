package com.github.inFoger.entityOperations;

import com.github.inFoger.Entity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TotalEntitiesOperationTest {

    @Test
    void getTotal() {
        List<Entity> entityListEmpty = new ArrayList<>(); //пустой
        List<Entity> entityList1 = new ArrayList<>();
        String[] filterPartsEmpty = new String[0];
        String[] filterParts1 = new String[] {"TYPE=HERBIVORE"};
        String[] filterParts2 = new String[] {"TYPE=HERBIVORE", "HEIGHT=SMALL", "||",
                "TYPE=CARNIVORE", "HEIGHT=SMALL"};
        String[] filterParts3 = new String[]{"TYPE=OMNIVORE", "HEIGHT=!SMALL"};
        //заполнение
        Map<String, String> mapForEntityList3 = new HashMap<>();
        mapForEntityList3.put("WEIGHT", "LIGHT");
        mapForEntityList3.put("HEIGHT", "SMALL");
        mapForEntityList3.put("TYPE", "OMNIVORE");
        Entity entity1 = new Entity(mapForEntityList3);
        entityList1.add(entity1);
        mapForEntityList3 = new HashMap<>();
        mapForEntityList3.put("WEIGHT", "HEAVY");
        mapForEntityList3.put("HEIGHT", "SMALL");
        mapForEntityList3.put("TYPE", "HERBIVORE");
        Entity entity2 = new Entity(mapForEntityList3);
        entityList1.add(entity2);
        mapForEntityList3 = new HashMap<>();
        mapForEntityList3.put("WEIGHT", "HEAVY");
        mapForEntityList3.put("HEIGHT", "SHORT");
        mapForEntityList3.put("TYPE", "HERBIVORE");
        Entity entity3 = new Entity(mapForEntityList3);
        entityList1.add(entity3);
        
        assertThrows(NullPointerException.class,
                () -> TotalEntitiesOperation.getTotal(null, null));
        assertThrows(NullPointerException.class,
                () -> TotalEntitiesOperation.getTotal(entityListEmpty, null));
        assertThrows(NullPointerException.class,
                () -> TotalEntitiesOperation.getTotal(null, filterPartsEmpty));
        assertThrows(NullPointerException.class,
                () -> TotalEntitiesOperation.getTotal(entityList1, null));
        assertThrows(NullPointerException.class,
                () -> TotalEntitiesOperation.getTotal(null, filterParts1));

        assertDoesNotThrow(() -> {TotalEntitiesOperation.getTotal(entityListEmpty, filterPartsEmpty);});
        assertDoesNotThrow(() -> {TotalEntitiesOperation.getTotal(entityList1, filterPartsEmpty);});
        assertDoesNotThrow(() -> {TotalEntitiesOperation.getTotal(entityListEmpty, filterParts1);});

        try {
             assertEquals(2, TotalEntitiesOperation.getTotal(entityList1, filterParts1));
             assertEquals(1, TotalEntitiesOperation.getTotal(entityList1, filterParts2));
             assertEquals(0, TotalEntitiesOperation.getTotal(entityList1, filterParts3));
        } catch (Exception e) {
            fail();
        }
    }
}