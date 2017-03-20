package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyu on 2017/3/15.
 */
public class People {

    private String name;

    private int high;

    private int age;

    private Map info = new HashMap();

    public void say(String words) throws InterruptedException {
        Thread.sleep(1000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getInfo() {
        return info;
    }
}
