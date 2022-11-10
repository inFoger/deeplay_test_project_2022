package com.github.inFoger;

import java.util.List;

public interface IAttribute {
    String getTitle();
    int getPriorityOrder();
    List<String> getPossibleValues();

}
