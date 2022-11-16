package com.github.inFoger;

import java.util.List;
import java.util.Objects;

/**
 * Класс Attribute хранит в себе атрибут(свойство животного) и его возможные значения
 */

public class Attribute {
    private final String title;
    private final List<String> possibleValues;

    public Attribute(String title, List<String> possibleValues) {
        this.title = title;
        this.possibleValues = possibleValues;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return title.equals(attribute.title) && Objects.equals(possibleValues, attribute.possibleValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, possibleValues);
    }
}
