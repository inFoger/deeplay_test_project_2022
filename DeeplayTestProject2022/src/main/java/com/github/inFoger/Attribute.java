package com.github.inFoger;

import java.util.List;
import java.util.Objects;

public class Attribute {
    private final String title;
    private final int priorityOrder;
    private final List<String> possibleValues;

    //TODO Нужен ли пиоритет?
    //fixme
    public Attribute(String title, int priorityOrder, List<String> possibleValues) {
        this.title = title;
        this.priorityOrder = priorityOrder;
        this.possibleValues = possibleValues;
    }

    public String getTitle() {
        return title;
    }

    public int getPriorityOrder() {
        return priorityOrder;
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return priorityOrder == attribute.priorityOrder && title.equals(attribute.title) && Objects.equals(possibleValues, attribute.possibleValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, priorityOrder, possibleValues);
    }
}
