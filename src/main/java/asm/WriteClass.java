package asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

/**
 * Created by yangyu on 2017/3/14.
 */
public class WriteClass {

    public static void main(String[] args) throws FileNotFoundException {
        ClassWriter cw = new ClassWriter(0);

        /**
         * TraceClassVisitor可以将visit委托给visitor以及printWrite
         */
        TraceClassVisitor cv = new TraceClassVisitor(cw,new PrintWriter("/Users/yangyu/Downloads/write"));

        cv.visit(V1_8,ACC_PUBLIC+ACC_ABSTRACT+ACC_INTERFACE,
                "asm/Comparable",null,"java/lang/Object",null);
        cv.visitField(ACC_PUBLIC+ACC_FINAL+ACC_STATIC,"LESS","I",null,new Integer(-1)).visitEnd();
        cv.visitMethod(ACC_PUBLIC+ACC_ABSTRACT,"compareTo","(Ljava/lang/Object;)I",null,null).visitEnd();
        cv.visitEnd();


        byte[] bytes = cw.toByteArray();
        Class cls =MyClassLoader.newInstance().defineClass("asm.Comparable",bytes);
        System.out.println(cls.getName());
    }
}
