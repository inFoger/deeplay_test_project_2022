package com.github.inFoger;

import com.github.inFoger.entityOperations.TotalEntitiesOperation;

import java.util.List;
import java.util.logging.Logger;

/**
 * Класс QueryExecutor отвечает за исполнение запросов(Query)
 */

public class QueryExecutor {
    private static final Logger logger = Logger.getLogger(QueryExecutor.class.getName());
    public static void execute(List<Query> queryList, List<Entity> entityList) throws NullPointerException {
        if(queryList == null || entityList == null) {
            logger.warning("Null Collection");
            throw new NullPointerException("Null Collection");
        }
        if(queryList.isEmpty() || entityList.isEmpty()) {
            logger.warning("Empty collection");
        }
        for(Query currentQuery : queryList) {
            if(currentQuery.getCommand().equals(TotalEntitiesOperation.getCommandName())) {
                int result = TotalEntitiesOperation.getTotal(entityList, currentQuery.getFilterParts());
                logger.info("Result is " + result);
            }
        }
    }

}
