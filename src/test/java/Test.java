/**
 * Created by yangyu on 2017/3/14.
 */
public class Test {

    public static void main(String[] args) {
        String str = "Parse [%s] with format [%s] error!";
        System.out.println(String.format(str,"lll","ddd"));

        doit();
    }

    public static void doit(){
        System.out.println(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
