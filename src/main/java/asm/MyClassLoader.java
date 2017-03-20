package asm;

/**
 * Created by yangyu on 2017/3/14.
 */
public class MyClassLoader extends ClassLoader {

    public static MyClassLoader newInstance(){
        return new MyClassLoader();
    }

    public Class defineClass(String name,byte[] bytes){
        return defineClass(name,bytes,0,bytes.length);
    }
}
