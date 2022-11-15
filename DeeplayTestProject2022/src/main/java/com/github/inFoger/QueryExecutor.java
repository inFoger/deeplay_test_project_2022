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
                entityListFiltration(entityList, currentQuery.getFilterParts());
            }
        }
    }

    private static boolean isCorrectQuery(Query query) {
        //TODO написать проверку
        return true;
    }

    private static List<Entity> entityListFiltration(List<Entity> entityList, String[] filterParts) {
        List<Entity> resultEntityList = new ArrayList<>(entityList);
        for(int i = 0; i < filterParts.length; i++) {
            //TODO можно вынести эти строки(символы) в константы
            String[] attributeValueCouple = filterParts[i].split("=");
            if(attributeValueCouple[i].startsWith("!")){
                resultEntityList.addAll(getAllWithoutAttributeValue(resultEntityList, attributeValueCouple[0],
                        attributeValueCouple[1].substring(1))); //берём подстроку без восклицательного знака
            } else {
                resultEntityList.addAll(getAllWithAttributeValue(resultEntityList, attributeValueCouple[0],
                        attributeValueCouple[1]));
            }
        }
        return resultEntityList;
    }

    private static List<Entity> getAllWithAttributeValue(List<Entity> entityList, String attribute, String value) {
        List<Entity> resultEntityList = new ArrayList<>();
        for(Entity entity : entityList) {
            if(entity.getAttributes().get(attribute).equals(value)) {
                resultEntityList.add(entity);
            }
        }
        return resultEntityList;
    }

    private static List<Entity> getAllWithoutAttributeValue(List<Entity> entityList, String attribute, String value) {
        List<Entity> resultEntityList = new ArrayList<>();
        for(Entity entity : entityList) {
            if(!entity.getAttributes().get(attribute).equals(value)) {
                resultEntityList.add(entity);
            }
        }
        return resultEntityList;
    }


}
