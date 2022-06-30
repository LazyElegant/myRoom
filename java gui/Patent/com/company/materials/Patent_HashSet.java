package com.company.materials;


import java.util.LinkedHashSet;


public class Patent_HashSet {


    private Date date;
    private LinkedHashSet<IPC> ipcset;
    private LinkedHashSet<CPC> cpcset;
    private char postion;
    private char value;


    private final static String SEPERATOR = ",";

    public Patent_HashSet(String date, String ipcset, String cpcset, char postion, char value) {
        this.date = new Date(date);
        this.postion = postion;
        this.value = value;

        String[] ipcsParts = ipcset.toString().split(SEPERATOR);
        this.ipcset = new LinkedHashSet<IPC>();
        for (String ipcsPart : ipcsParts) {
            this.ipcset.add(new IPC(ipcsPart.trim()));
        }
        String[] cpcsParts = cpcset.toString().split(SEPERATOR);
        this.cpcset = new LinkedHashSet<CPC>();
        for (String cpcsPart : cpcsParts) {
            this.cpcset.add(new CPC(cpcsPart.trim(), postion, value));
        }
    }


    public Date getDate() {
        return date;
    }

    public LinkedHashSet<IPC> getIpcs() {
        return ipcset;
    }

    public LinkedHashSet<CPC> getCpcs() {
        return cpcset;
    }

    public char getPostion() {
        return postion;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setIpcs(LinkedHashSet<IPC> ipcset) {
        this.ipcset = ipcset;
    }

    public void setCpcs(LinkedHashSet<CPC> cpcset) {
        this.cpcset = cpcset;
    }

    public void setPostion(char postion) {
        this.postion = postion;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Patent{" +
                ", date=" + date +
                ", ipcs=" +ipcset +
                ", cpcs=" + cpcset +
                '}';
    }


}


