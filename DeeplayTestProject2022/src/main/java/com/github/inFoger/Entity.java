package com.github.inFoger;

import java.util.Map;
import java.util.Objects;

/**
 * В классе Entity хранятся животные, а в map находится соответствие атрибута и значения
 */

public class Entity {
    private final Map<String, String> attributes;

    public Entity(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(attributes, entity.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributes);
    }
}
