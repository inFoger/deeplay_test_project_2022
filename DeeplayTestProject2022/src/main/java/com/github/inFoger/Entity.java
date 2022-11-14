package com.github.inFoger;

import java.util.Map;

public class Entity {
    private final Map<String, String> attributes;

    public Entity(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
