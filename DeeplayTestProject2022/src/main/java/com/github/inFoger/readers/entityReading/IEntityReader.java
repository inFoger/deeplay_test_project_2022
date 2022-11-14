package com.github.inFoger.readers.entityReading;

import com.github.inFoger.Entity;

import java.io.IOException;
import java.util.List;

public interface IEntityReader {
    List<Entity> readEntities(String filePath) throws IOException;
}
