package com.company.materials;

public class IPC extends Classification {
    public IPC(char section, int clazz, char subclass, int main_group, int subgroup) {
        super(section, clazz, subclass, main_group, subgroup);
    }

    public IPC(String Classification) {
        super(Classification);
    }


}
