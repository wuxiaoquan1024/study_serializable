package com.stduy.serializable.bean;

import java.io.Serializable;

public class Man implements People, Serializable {

    public String name;

    private String fun;

    public Man() {
        fun = "BB";
    }

}
