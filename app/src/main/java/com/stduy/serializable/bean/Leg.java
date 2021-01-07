package com.stduy.serializable.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Leg implements Serializable /*implements Externalizable*/ {

    private final static long serialVersionUID = 1L;

    public int size = 10;

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeInt(size);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
//        this.size = in.readInt();
//    }
}
