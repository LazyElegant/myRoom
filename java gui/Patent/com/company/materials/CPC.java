package com.company.materials;

import java.util.Objects;

public class CPC extends Classification {
    private char position, value;

    public CPC(char section, int clazz, char subclass, int main_group, int subgroup, char position, char value) {
        super(section, clazz, subclass, main_group, subgroup);
        this.position = position;
        this.value = value;
    }

    public CPC(String Classification, char position, char value) {
        super(Classification);
        this.position = position;
        this.value = value;
    }

    public char getPosition() {
        return position;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return section
                + String.format("%2s", clazz).replace(' ', '0')
                + subclass + String.format("%4s", main_group)
                + SEPARATOR + subgroup + position + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPC)) return false;
        CPC cpc = (CPC) o;
        return Objects.equals(section, cpc.section) && Objects.equals(clazz, cpc.clazz) && Objects.equals(main_group,
                cpc.main_group) && Objects.equals(subgroup, cpc.subgroup) && Objects.equals(subclass, cpc.subclass)&&
                Objects.equals(position, cpc.position)&& Objects.equals(value, cpc.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, value);
    }
}

