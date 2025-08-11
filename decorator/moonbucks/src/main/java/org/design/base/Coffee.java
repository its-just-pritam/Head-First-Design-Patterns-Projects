package org.design.base;

import java.util.Map;

public interface Coffee {

    Map<String, Integer> description();
    int cost();
    CoffeeSize size();

}
