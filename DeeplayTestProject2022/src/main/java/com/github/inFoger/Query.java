package com.github.inFoger;

public class Query {
    private final String command;
    private final String[] filterParts;

    public Query(String command, String[] filterParts) {
        this.command = command;
        this.filterParts = filterParts;
    }

    public String getCommand() {
        return command;
    }

    public String[] getFilterParts() {
        return filterParts;
    }
}
