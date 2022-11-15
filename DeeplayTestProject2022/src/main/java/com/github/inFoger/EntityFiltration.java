package com.github.inFoger;

import java.util.ArrayList;
import java.util.List;

public class EntityFiltration {
    public static List<Entity> entityListFiltration(List<Entity> entityList, String[] filterParts) {
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
