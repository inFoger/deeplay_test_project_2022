package com.github.inFoger;

import java.util.List;

public class Attribute implements IAttribute {
    private String title;
    private int priorityOrder;
    private List<String> possibleValues;

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
}
