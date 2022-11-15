package com.github.inFoger;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueryExecutorTest {

    @Test
    void executeWithNull() {
        List<Query> queryList1 = null;
        List<Entity> entityList1 = null;
        List<Query> queryList2 = new ArrayList<>();  //пустой
        List<Entity> entityList2 = new ArrayList<>();  //пустой
        List<Query> queryList3 = new ArrayList<>();
        List<Entity> entityList3 = new ArrayList<>();
        queryList3.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE"}));
        queryList3.add(new Query("TOTAL", new String[]{"TYPE=HERBIVORE", "HEIGHT=SMALL", "||",
                "TYPE=CARNIVORE", "HEIGHT=SMALL"}));
        queryList3.add(new Query("TOTAL", new String[]{"TYPE=OMNIVORE", "HEIGHT=!SMALL"}));
        //сделать entity

    }
}