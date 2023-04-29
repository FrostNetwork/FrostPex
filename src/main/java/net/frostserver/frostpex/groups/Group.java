package net.frostserver.frostpex.groups;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Group {

    @Getter private final String id;
    @Getter private final String name;

    @Override
    public String toString() {
        return this.id;
    }
}
