package com.github.inFoger.readers.queryReading;

import com.github.inFoger.Query;

import java.util.List;

public interface IQueryReader {
    List<Query> readQuery(String filePath) throws Exception;
}
