package com.stduy.serializable;

import android.content.Context;

import com.stduy.serializable.bean.Scumbag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerialHelper {

    public void serial(Context context, Object obj) {
        writeToFile(context, "serial.s", obj);
    }

    public Object deserial(Context context) {
        return readObject(context, "serial.s");
    }

    private void writeToFile(Context context, String fileName, Object object) {
        File file = new File(context.getCacheDir(), fileName);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Object readObject(Context context, String fileName) {
        File file = new File(context.getCacheDir(), fileName);
        ObjectInputStream oos = null;
        try {
            oos = new ObjectInputStream(new FileInputStream(file));
            return oos.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
