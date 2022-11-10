package com.github.inFoger;

import com.github.inFoger.configurationReading.ConfigAttributesFileReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ConfigAttributesFileReader reader = new ConfigAttributesFileReader();
        List<IAttribute> attributeList = reader.readAttributes("configAttributes.ini");
        System.out.println();
    }
}