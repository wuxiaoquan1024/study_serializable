package com.stduy.serializable.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Wife extends Woman implements Externalizable {

    /**
     * 需要手动提供，不然无法兼容不同的版本
     * 如果没有手动提供，在类结构发生变化，反序列化时将抛出 java.io.InvalidClassException
     */
    private final static long serialVersionUID = 1L;

    private int childCount;

    private String face;

    public int age;

    public boolean open;

    public Leg leg = new Leg();

    /**
     * 实现了Externaliable接口的类，必须提供空构造函数。如果没有空构造函数，则在反序列化的时，将抛出java.io.InvalidClassException: com.stduy.serializable.bean.Wife; no valid constructor 异常
     */
    public Wife() {

    }

    public Wife(int childCount, String face, int age) {
        this.childCount = childCount;
        this.face = face;
        this.age = age;
        this.ban = 3;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(childCount);
        out.writeObject(face);
//        out.writeInt(age);
        out.writeInt(ban);
        out.writeObject(leg);
    }

    @Override
    public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
        this.childCount = in.readInt();
        this.face = (String) in.readObject();
//        this.age = in.readInt();
        this.ban = in.readInt();
        this.leg = (Leg) in.readObject();
    }

    @Override
    public String toString() {
        return "Wife{" +
                "childCount=" + childCount +
                ", face='" + face + '\'' +
                ", age=" + age +
                ", ban=" + ban +
                ", leg=" + leg.size +
                '}';
    }
}
