package asm.method;

import asm.MyClassLoader;
import bean.People;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * Created by yangyu on 2017/3/15.
 */
public class AddTimer {

    public static void main(String[] args) throws Exception {
        ClassReader cr = new ClassReader("bean.People");
        ClassWriter cw = new ClassWriter(cr,0);
        AddTimerAdpter adpter = new AddTimerAdpter(cw);
        TraceClassVisitor cv = new TraceClassVisitor(adpter,new PrintWriter("/Users/yangyu/Downloads/write"));
        cr.accept(cv,0);
        byte[] bytes = cw.toByteArray();
        MyClassLoader myClassLoader = MyClassLoader.newInstance();
        Class cls = myClassLoader.defineClass("bean.People",bytes);
        Object object = cls.newInstance();
        Method method = cls.getMethod("say",String.class);
        if (method!=null)
            method.invoke(object,"yangyu");

        Class clz = Class.forName("bean.People",true,myClassLoader);
        Object object1 = clz.newInstance();
        Method method1 = clz.getMethod("say",String.class);
        method1.invoke(object1,"lalala");

    }
}
