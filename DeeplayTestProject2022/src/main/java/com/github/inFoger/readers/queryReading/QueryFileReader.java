package com.github.inFoger.readers.queryReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.Query;
import com.github.inFoger.entityOperations.TotalEntitiesOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryFileReader implements IQueryReader{
    private final String orCommand = "||";
    private final String negationCommand = "!";
    private final String equalsCommand = "=";

    private final int commandPositionInQueryParts = 0;
    private final List<Attribute> attributeList;

    public QueryFileReader(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    @Override
    public List<Query> readQuery(String filePath) {
        List<Query> queryList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String[] queryParts = readLine.split(" ");
                if(isExistCommand(queryParts[commandPositionInQueryParts])) {
                    List<String> filterParts = new ArrayList<>();
                    for(int i = 1; i < queryParts.length; i++) {
                        if(queryParts[i].equals(orCommand)) {
                            continue;
                        }
                        String[] attributeValueCouple = queryParts[i].split(equalsCommand);
                        if(!isExistAttributeAndValue(attributeValueCouple)) {
                            throw new IOException();
                        }
                        filterParts.add(queryParts[i]);
                    }
                    queryList.add(new Query(queryParts[commandPositionInQueryParts], filterParts.toArray(new String[0])));
                }
                readLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryList;
    }

    private boolean isExistCommand(String command) {
        return command.toUpperCase().equals(TotalEntitiesOperation.getCommandName());
    }

    private boolean isExistAttributeAndValue(String[] attributeValueCouple) {
        //убираем у значения знак отрицания в начале
        if(attributeValueCouple[1].startsWith(negationCommand)) {
            attributeValueCouple[1] = attributeValueCouple[1].substring(1);
        }
        for(Attribute attribute : attributeList) {
            if(attribute.getTitle().equals(attributeValueCouple[0])
                    && attribute.getPossibleValues().contains(attributeValueCouple[1])) {
                return true;
            }
        }
        return false;
    }

}
