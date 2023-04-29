package net.frostserver.frostpex.groups;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Group {

    @Getter private final String id;
    @Getter private final String name;

    @Getter private final String prefix;
    @Getter private final String color;

    private final boolean def;

    @Override
    public String toString() {
        return this.id;
    }

    public boolean isDefault() {
        return this.def;
    }
}
