package com.github.inFoger.entityOperations;

import com.github.inFoger.Entity;
import com.github.inFoger.EntityFiltration;

import java.util.List;
import java.util.logging.Logger;

public class TotalEntitiesOperation implements IEntityOperations {
    private static final Logger logger = Logger.getLogger(TotalEntitiesOperation.class.getName());
    private static final String commandName = "TOTAL";
    public static int getTotal(List<Entity> allEntities, String[] filterParts) {
        if(allEntities == null || filterParts == null) {
            logger.warning("Argument is null");
            throw new NullPointerException("Argument is null");
        }
        return EntityFiltration.entityListFiltration(allEntities, filterParts).size();
    }

    public static String getCommandName() {
        return commandName;
    }
}
