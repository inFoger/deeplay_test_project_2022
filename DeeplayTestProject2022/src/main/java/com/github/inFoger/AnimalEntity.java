package com.github.inFoger;

import java.util.Map;

public class AnimalEntity implements IEntity {
    private Map<String, String> attributes;

    public AnimalEntity(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
