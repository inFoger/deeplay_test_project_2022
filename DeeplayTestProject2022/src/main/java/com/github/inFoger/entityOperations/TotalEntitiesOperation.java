package com.github.inFoger.entityOperations;

import com.github.inFoger.Entity;

import java.util.Map;

public class TotalEntitiesOperation implements IEntityOperations {
    private static final String commandName = "TOTAL";
    public static int getTotal(Entity[] allEntities, Map<String, String> filterAttributes) {
        //TODO проверять всё на Null ?
        if(filterAttributes == null || filterAttributes.isEmpty()) {
            return allEntities.length;
        }
        int totalAmount = 0;
        //Можно использовать Stream и лямбды, но читаемость просядет
        for (Entity currentEntity : allEntities) {
            if(isFitsConditions(currentEntity, filterAttributes)) {
                totalAmount++;
            }
        }
        return totalAmount;
    }

    private static boolean isFitsConditions(Entity entity, Map<String, String> filterAttributes) {
        Map<String, String> entityAttributes = entity.getAttributes();
        for(String currentAttribute : entityAttributes.keySet()) {
            if(!entityAttributes.get(currentAttribute).equals(filterAttributes.get(currentAttribute))) {
                return false;
            }
        }
        return true;
    }

    public static String getCommandName() {
        return commandName;
    }
}
