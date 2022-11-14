package com.github.inFoger.readers.queryReading;

import com.github.inFoger.Query;

import java.io.IOException;
import java.util.List;

public interface IQueryReader {
    List<Query> readQuery(String filePath) throws IOException;
}
