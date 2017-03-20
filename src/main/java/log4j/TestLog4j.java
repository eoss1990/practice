package log4j;

import org.apache.log4j.Logger;

/**
 * Created by yangyu on 2017/3/20.
 */
public class TestLog4j {

    private static Logger logger = Logger.getLogger(TestLog4j.class);

    public static void main(String[] args) {
        logger.info("this is log4j");
    }
}
