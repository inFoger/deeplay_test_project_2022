package com.github.inFoger;

import com.github.inFoger.readers.configurationReading.ConfigAttributesFileReader;
import com.github.inFoger.readers.entityReading.EntityFileReader;
import com.github.inFoger.readers.queryReading.QueryFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ConfigAttributesFileReader reader = new ConfigAttributesFileReader();
            List<Attribute> attributeList = reader.readAttributes("configAttributes.ini");
            Attribute[] attributes = attributeList.toArray(new Attribute[0]);
            EntityFileReader entityFileReader = new EntityFileReader(attributes);
            List<Entity> entityList = entityFileReader.readEntities("animals");
            QueryFileReader queryFileReader = new QueryFileReader(attributeList);
            List<Query> queryList = queryFileReader.readQuery("queryFile");
            QueryExecutor.execute(queryList, entityList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}