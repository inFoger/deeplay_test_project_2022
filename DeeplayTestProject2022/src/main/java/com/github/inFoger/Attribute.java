package com.github.inFoger;

import java.util.List;

public class Attribute implements IAttribute {
    private String title;
    private List<String> possibleValues;

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
}
