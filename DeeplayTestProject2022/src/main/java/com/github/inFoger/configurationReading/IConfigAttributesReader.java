package com.github.inFoger.configurationReading;

import com.github.inFoger.IAttribute;

import java.io.IOException;
import java.util.List;

public interface IConfigAttributesReader {
    List<IAttribute> readAttributes(String filePath) throws IOException;
}
