package com.stduy.serializable.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BigScumbag extends Scumbag {

    private void writeObject(ObjectOutputStream oos) throws IOException {
        // oos.defaultWriteObject();
        oos.writeObject(name);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        // ois.defaultReadObject();
        name = (String) ois.readObject();
    }

}
