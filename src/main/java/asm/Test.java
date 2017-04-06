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

    /**
     * 可以输出该class字节码
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("bean.People");
        TraceClassVisitor cv = new TraceClassVisitor(new PrintWriter("/Users/yangyu/Downloads/write"));
        cr.accept(cv,0);
    }

    /**
     * 可以输出如何通过ASM构建该Class
     * @throws Exception
     */
    @org.junit.Test
    public void testASMifier() throws Exception {
        String[] strings = {"bean.People"};
        ASMifier.main(strings);
    }
}
