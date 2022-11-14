package com.github.inFoger.entityReading;

import com.github.inFoger.Entity;

import java.io.IOException;
import java.util.List;

public interface IEntityReader {
    List<Entity> readEntities(String filePath) throws IOException;
}
