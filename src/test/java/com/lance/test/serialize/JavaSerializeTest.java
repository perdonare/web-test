package com.lance.test.serialize;

import com.lance.persistence.model.User;
import org.junit.Test;

import java.io.*;

/**
 * Created by perdonare on 2015/6/28.
 */
public class JavaSerializeTest {
    //使用Object序列化
    //注意 如果User中某个属性标识为Transient那么不会被序列化
    @Test
    public void testSerializeA() throws IOException, ClassNotFoundException {
        //ByteArrayOutputStream byteOUtStream = new ByteArrayOutputStream();
        File file = new File("d:/test");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);
        User user = new User();//User必须先实现序列化接口
        user.setName("lance");
        user.setPassword("lance");
        objectOutStream.writeObject(user);
        objectOutStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User userAfter = (User) objectInputStream.readObject();
        System.out.println(userAfter.getName()+userAfter.getPassword());
    }

    @Test
    public void testSerializeB(){

    }
}
