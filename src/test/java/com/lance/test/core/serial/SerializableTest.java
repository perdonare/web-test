package com.lance.test.core.serial;

import org.junit.Test;

import java.io.*;

/**
 * Created by perdonare on 2016/4/4.
 */
public class SerializableTest {
    @Test
    public void testSerial() throws IOException, ClassNotFoundException {
        Model model = new Model();
        model.setAge(3);
        model.setName("lance");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/a.serial"));
        oos.writeObject(model);
        //序列化会缓存对象引用，如果有相同对象序列化 ，修改属性不会再次序列化
        model.setName("aaa");
        oos.writeObject(model);


    }

    @Test
    public void testDeSeria() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/a.serial"));
        Model model1 = (Model) ois.readObject();
        System.out.println(model1.getAge());
        System.out.println(model1.getTest());
        System.out.println(model1.getName());
    }
}
