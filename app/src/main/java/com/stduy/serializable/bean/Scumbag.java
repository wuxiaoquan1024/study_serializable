package com.stduy.serializable.bean;

import java.io.Serializable;

public class Scumbag extends Man {

    public static final long serialVersionUID = 1l;

    public int scumLevel;

    public Handler handler;

    public static int age;

    public transient  int max;

    public Scumbag() {
        age = 20;
        max = 10;
    }

    public Scumbag(String name, int scumLevel) {
        this();
        this.name = name;
        this.scumLevel = scumLevel;
        handler = new Handler("fix");
    }

    @Override
    public String toString() {
        return "Scumbag{" +
                "scumLevel=" + scumLevel +
                ", handler=" + handler.finger +
                ", max=" + max +
                ", name='" + name + '\'' +
                '}';
    }
}
