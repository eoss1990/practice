package commons_lang3;

import org.apache.commons.lang3.event.EventListenerSupport;

/**
 * Created by yangyu on 2017/3/19.
 */
public class TestListenerSupport {


    private static EventListenerSupport<Listener> eventListenerSupport = new EventListenerSupport(Listener.class);

    public static void main(String[] args) {
        eventListenerSupport.addListener(new Mylistener());
        eventListenerSupport.fire().doIt();
    }

    static class Mylistener implements Listener{

        public void doIt(){
            System.out.println("listener do it");
        }
    }
}
