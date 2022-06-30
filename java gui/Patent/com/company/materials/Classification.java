//专利文档中不仅有IPC分类号，还有CPC分类号，CPC的格式与IPC类似，但多了两个字段position和value，
// 这两个字段取值为单个字符，请重写Ipc类和Cpc类，并增加一个父类Classification；
package com.company.materials;

public class Classification {
    protected char section, subclass;
    protected int clazz, main_group, subgroup;
    final char SEPARATOR = '/';

    public Classification(char section, int clazz, char subclass, int main_group, int subgroup) {
        this.section = section;
        this.clazz = clazz;
        this.subclass = subclass;
        this.main_group = main_group;
        this.subgroup = subgroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classification)) return false;

        Classification that = (Classification) o;

        if (section != that.section) return false;
        if (subclass != that.subclass) return false;
        if (clazz != that.clazz) return false;
        if (main_group != that.main_group) return false;
        if (subgroup != that.subgroup) return false;
        return SEPARATOR == that.SEPARATOR;
    }

    @Override
    public int hashCode() {
        int result = section;
        result = 31 * result + (int) subclass;
        result = 31 * result + clazz;
        result = 31 * result + main_group;
        result = 31 * result + subgroup;
        result = 31 * result + (int) SEPARATOR;
        return result;
    }

    public Classification(String Classification) {
        this.section = Classification.charAt(0);
        this.clazz = Integer.parseInt(Classification.substring(1, 3));
        this.subclass = Classification.charAt(3);
        int pos = Classification.indexOf(SEPARATOR);
        this.main_group = Integer.parseInt(Classification.substring(4, pos).trim());
        this.subgroup = Integer.parseInt(Classification.substring(pos + 1));
    }

    public char getSection() {
        return section;
    }

    public char getSubclass() {
        return subclass;
    }

    public int getClazz() {
        return clazz;
    }

    public int getMain_group() {
        return main_group;
    }

    public int getSubgroup() {
        return subgroup;
    }

    @Override
    public String toString() {
        return section
                + String.format("%2s", clazz).replace(' ', '0')
                + subclass + String.format("%4s", main_group)
                + SEPARATOR + subgroup;
    }
}
