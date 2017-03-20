package asm;

import org.objectweb.asm.*;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yangyu on 2017/3/15.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("bean.People");
        TraceClassVisitor cv = new TraceClassVisitor(new PrintWriter("/Users/yangyu/Downloads/write"));
        cr.accept(cv,0);
    }

    @org.junit.Test
    public void testASMifier() throws Exception {
        String[] strings = {"bean.People1"};
        ASMifier.main(strings);
    }
}
