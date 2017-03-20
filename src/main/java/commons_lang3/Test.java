package commons_lang3;

import bean.People;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by yangyu on 2017/3/19.
 */
public class Test {

    public String name = "yangyu";

    public static void main(String[] args) {
        System.out.println(ClassUtils.isAssignable(People.class,Object.class));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}
