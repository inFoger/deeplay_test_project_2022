package com.github.inFoger;

import com.github.inFoger.entityOperations.TotalEntitiesOperation;

import java.util.List;
import java.util.logging.Logger;

public class QueryExecutor {
    private static Logger logger = Logger.getLogger(QueryExecutor.class.getName());
    public static void execute(List<Query> queryList, List<Entity> entityList) {
        //TODO проверки на нул и пустоту везде, где надо
        for(Query currentQuery : queryList) {
            if(!isCorrectQuery(currentQuery)){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(currentQuery.getCommand().equals(TotalEntitiesOperation.getCommandName())) {
                int result = TotalEntitiesOperation.getTotal(entityList, currentQuery.getFilterParts());
                logger.info("Result is " + result);
            }
        }
    }

    private static boolean isCorrectQuery(Query query) {
        //TODO написать проверку
        return true;
    }


}
