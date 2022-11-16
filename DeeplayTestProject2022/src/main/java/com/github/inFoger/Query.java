package com.github.inFoger;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс Query хранит в себе запросы(то, что нужно сделать с животными)
 * Пример запроса: TOTAL TYPE=HERBIVORE HEIGHT=SMALL || TYPE=CARNIVORE HEIGHT=SMALL
 */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Query query = (Query) o;
        return Objects.equals(command, query.command) && Arrays.equals(filterParts, query.filterParts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(command);
        result = 31 * result + Arrays.hashCode(filterParts);
        return result;
    }
}
