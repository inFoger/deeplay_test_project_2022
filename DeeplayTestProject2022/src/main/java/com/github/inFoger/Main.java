package com.github.inFoger;

import com.github.inFoger.configuration.ConfigFileRulesReader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ConfigFileRulesReader reader = new ConfigFileRulesReader();
        List<Attribute> attributeList = reader.readAttributes("configRules.ini");
        System.out.println();
    }
}