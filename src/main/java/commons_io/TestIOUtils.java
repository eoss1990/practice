package commons_io;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by yangyu on 2017/3/19.
 */
public class TestIOUtils {

    public static void main(String[] args) throws Exception {
        InputStream in = new URL( "http://commons.apache.org" ).openStream();
        try {
            System.out.println( IOUtils.toString( in , StandardCharsets.UTF_8 ));
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
