package me.saiti;

import java.io.InputStream;

public  class Util {
    public static InputStream getFileFromResources(String filename) {
        ClassLoader classLoader = Util.class.getClassLoader();
        return classLoader.getResourceAsStream(filename);
    }
}
