package commons_jci;

import org.apache.commons.jci.compilers.CompilationResult;
import org.apache.commons.jci.compilers.JavaCompiler;
import org.apache.commons.jci.compilers.JavaCompilerFactory;
import org.apache.commons.jci.readers.FileResourceReader;
import org.apache.commons.jci.stores.FileResourceStore;

import java.io.File;

/**
 * Created by yangyu on 2017/3/20.
 */
public class TestJCI {

    public static void main(String[] args) {
        JavaCompiler compiler = new JavaCompilerFactory().createCompiler("eclipse");
        String[] path = {"bean/People.java"};
        File fileSrc = new File("/Users/yangyu/Downloads/compiler/src/java");
        File fileTarget = new File("/Users/yangyu/Downloads/compiler/target/java");
        CompilationResult result = compiler.compile(path,new FileResourceReader(fileSrc),new FileResourceStore(fileTarget));

        System.out.println( result.getErrors().length + " errors");
        System.out.println( result.getWarnings().length + " warnings");
    }
}
