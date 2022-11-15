package com.github.inFoger.readers.queryReading;

import com.github.inFoger.Attribute;
import com.github.inFoger.Query;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryFileReader implements IQueryReader{
    private final String totalOperationCommand = "TOTAL";
    private final int commandPositionInQueryParts = 0;
    private final List<Attribute> attributeList;

    public QueryFileReader(List<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    @Override
    public List<Query> readQuery(String filePath) throws IOException {
        List<Query> queryList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                String[] queryParts = readLine.split(" ");
                if(isExistCommand(queryParts[commandPositionInQueryParts])) {
                    List<String> filterParts = new ArrayList<>();
                    for(int i = 1; i < queryParts.length; i++) {
                        //TODO добавить проверку на специальные символы(отрицания и ИЛИ)
                        String[] attributeValueCouple = queryParts[i].split("=");
                        if(!isExistAttributeAndValue(attributeValueCouple)) {
                            throw new IOException();
                        }
                        filterParts.add(queryParts[i]);
                    }
                    queryList.add(new Query(queryParts[commandPositionInQueryParts], filterParts.toArray(new String[0])));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return queryList;
    }

    public boolean isExistCommand(String command) {
        return command.toUpperCase().equals(totalOperationCommand);
    }

    private boolean isExistAttributeAndValue(String[] attributeValueCouple) {
        for(Attribute attribute : attributeList) {
            if(attribute.getTitle().equals(attributeValueCouple[0])
                    && attribute.getPossibleValues().contains(attributeValueCouple[1])) {
                return true;
            }
        }
        return false;
    }

}
