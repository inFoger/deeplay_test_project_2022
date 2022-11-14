package com.github.inFoger;

public class Query {
    private final String command;
    private final String[] filters;

    public Query(String command, String[] filters) {
        this.command = command;
        this.filters = filters;
    }

    public String getCommand() {
        return command;
    }

    public String[] getFilters() {
        return filters;
    }
}
