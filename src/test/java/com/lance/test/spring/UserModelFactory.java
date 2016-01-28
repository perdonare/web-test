package com.lance.test.spring;

/**
 * Created by perdonare on 2015/12/13.
 */
public class UserModelFactory {
    private static UserModelFactory userModelFactory = new UserModelFactory();
    private static UserModel userModel = new UserModel();
    private static UserModel userModel2 = new UserModel();

    public UserModelFactory(){}

    public static UserModelFactory getUserFactory() {
        return userModelFactory;
    }

    public  UserModel getUserModel() {
        return userModel;
    }

    public  UserModel getUserModel1() {
        return userModel2;
    }

}
