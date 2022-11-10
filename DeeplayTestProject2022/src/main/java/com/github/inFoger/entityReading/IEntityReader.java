package com.github.inFoger.entityReading;

import com.github.inFoger.IAttribute;
import com.github.inFoger.IEntity;

import java.io.IOException;
import java.util.List;

public interface IEntityReader {
    List<IEntity> readEntities(String filePath, List<IAttribute> allAttributes) throws IOException;
}
