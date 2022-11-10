package com.github.inFoger.configuration;

import com.github.inFoger.Attribute;

import java.io.IOException;
import java.util.List;

public interface IConfigRulesReader {
    List<Attribute> readAttributes(String filePath) throws IOException;
}
