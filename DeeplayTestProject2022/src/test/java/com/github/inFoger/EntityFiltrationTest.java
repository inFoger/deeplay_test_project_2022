package com.github.inFoger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EntityFiltrationTest {

    @org.junit.jupiter.api.Test
    void entityListFiltration() {
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
                () -> EntityFiltration.entityListFiltration(null, null));
        assertThrows(NullPointerException.class,
                () -> EntityFiltration.entityListFiltration(entityListEmpty, null));
        assertThrows(NullPointerException.class,
                () -> EntityFiltration.entityListFiltration(null, filterPartsEmpty));
        assertThrows(NullPointerException.class,
                () -> EntityFiltration.entityListFiltration(entityList1, null));
        assertThrows(NullPointerException.class,
                () -> EntityFiltration.entityListFiltration(null, filterParts1));

        assertDoesNotThrow(() -> {EntityFiltration.entityListFiltration(entityListEmpty, filterPartsEmpty);});
        assertDoesNotThrow(() -> {EntityFiltration.entityListFiltration(entityList1, filterPartsEmpty);});
        assertDoesNotThrow(() -> {EntityFiltration.entityListFiltration(entityListEmpty, filterParts1);});
        assertEquals(0, EntityFiltration.entityListFiltration(entityListEmpty, filterPartsEmpty).size());
        assertEquals(entityList1.size(), EntityFiltration.entityListFiltration(entityList1, filterPartsEmpty).size());
        assertEquals(0, EntityFiltration.entityListFiltration(entityListEmpty, filterParts1).size());

        try {
            List<Entity> result = EntityFiltration.entityListFiltration(entityList1, filterParts1);
            assertEquals(List.of(entity2, entity3), result);
            result = EntityFiltration.entityListFiltration(entityList1, filterParts2);
            assertEquals(List.of(entity2), result);
            result = EntityFiltration.entityListFiltration(entityList1, filterParts3);
            assertEquals(List.of(), result);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }



    }
}