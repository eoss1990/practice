package log4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by yangyu on 2017/3/20.
 */
public class TestLogging {

    private static Log log = LogFactory.getLog(TestLogging.class);

    public static void main(String[] args) {
        log.info("this is apache logging");
    }
}
