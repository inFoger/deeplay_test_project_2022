package com.github.inFoger;

import java.util.*;

public class EntityFiltration {
    private static final String orCommand = "||";
    private static final String negationCommand = "!";
    private static final String equalsCommand = "=";

    public static List<Entity> entityListFiltration(List<Entity> entityList, String[] filterParts) {
        Set<Entity> resultEntitySet = new HashSet<>();
        List<Entity> partOfResultList = new ArrayList<>(entityList);
        for(int i = 0; i < filterParts.length; i++) {
            if(filterParts[i].equals(orCommand)) {
                resultEntitySet.addAll(partOfResultList);
                partOfResultList = new ArrayList<>(entityList);
                continue;
            }
            String[] attributeValueCouple = filterParts[i].split(equalsCommand);
            if(attributeValueCouple[1].startsWith(negationCommand)){
                partOfResultList = getAllWithoutAttributeValue(partOfResultList, attributeValueCouple[0],
                        attributeValueCouple[1].substring(1)); //берём подстроку без знака отрицания
            } else {
                partOfResultList = getAllWithAttributeValue(partOfResultList, attributeValueCouple[0],
                        attributeValueCouple[1]);
            }
        }
        resultEntitySet.addAll(partOfResultList);
        return new ArrayList<>(resultEntitySet);
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
