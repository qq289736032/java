package com.jisen.nettyserializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by jisen on 2018/11/2.
 */
public class TestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserID(100).buildUserName("welcome to netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(userInfo);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is :"+b.length);
        bos.close();
        System.out.println("-------------------------------------------");
        //System.out.println("The byte array serializable length is :" +userInfo.codeC().length);
    }
}
