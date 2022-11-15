package com.github.inFoger;

import com.github.inFoger.entityOperations.TotalEntitiesOperation;

import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {
    public static void execute(List<Query> queryList, List<Entity> entityList) throws Exception {
        //TODO проверки на нул и пустоту везде, где надо
        for(Query currentQuery : queryList) {
            if(!isCorrectQuery(currentQuery)){
                throw new Exception();
            }
            if(currentQuery.getCommand().equals(TotalEntitiesOperation.getCommandName())) {
                TotalEntitiesOperation.getTotal(entityList, currentQuery.getFilterParts());
            }
        }
    }

    private static boolean isCorrectQuery(Query query) {
        //TODO написать проверку
        return true;
    }


}
