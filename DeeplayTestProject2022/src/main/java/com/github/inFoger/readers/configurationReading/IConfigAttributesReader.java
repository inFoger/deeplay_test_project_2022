package com.github.inFoger.readers.configurationReading;

import com.github.inFoger.Attribute;

import java.io.IOException;
import java.util.List;

public interface IConfigAttributesReader {
    List<Attribute> readAttributes(String filePath) throws IOException;
}
