package com.github.inFoger.entityOperations;

import com.github.inFoger.Entity;
import com.github.inFoger.EntityFiltration;

import java.util.List;

public class TotalEntitiesOperation implements IEntityOperations {
    private static final String commandName = "TOTAL";
    public static int getTotal(List<Entity> allEntities, String[] filterParts) {
        //TODO проверять всё на Null ?
        if(filterParts == null || filterParts.length < 1) {
            return allEntities.size();
        }
        return EntityFiltration.entityListFiltration(allEntities, filterParts).size();
    }

    public static String getCommandName() {
        return commandName;
    }
}
