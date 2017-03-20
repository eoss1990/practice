package asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import javax.swing.*;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.V1_6;

/**
 * Created by yangyu on 2017/3/15.
 */
public class TransForm {

    static class ChangeVersionAdapter extends ClassVisitor{

        public ChangeVersionAdapter(ClassVisitor cv) {
            super(ASM4, cv);
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            super.visit(V1_6, access, name, signature, superName, interfaces);
        }
    }

    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ChangeVersionAdapter(cw);
        ClassReader cr = new ClassReader("bean.People");
        cr.accept(cv,0);
        byte[] bytes = cw.toByteArray();

        MyClassLoader.newInstance().defineClass("bean.People",bytes);
    }
}
