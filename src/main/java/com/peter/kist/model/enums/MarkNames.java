package com.peter.kist.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MarkNames {
    A("A", 95, 100),
    B("B", 85, 94),
    C("C", 75, 84),
    D("D", 65, 74),
    E("E", 60, 64);

    private String keyName;

    private int min;
    private  int max;

    MarkNames(String keyName, int min, int max) {
        this.keyName = keyName;
        this.min = min;
        this.max = max;
    }

    @JsonCreator
    public MarkNames fromString(String value) {
        return Arrays.stream(MarkNames.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
