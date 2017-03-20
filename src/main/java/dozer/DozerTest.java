package dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by yangyu on 2017/3/14.
 * mapper是一个深clone
 */
public class DozerTest {

    public static void main(String[] args) {

        SourceBean sourceBean = new SourceBean(1,"yangyu","lalala");
        RefBean refBean = new RefBean();
        System.out.println(refBean);
        sourceBean.setRefBean(refBean);

        Mapper mapper = new DozerBeanMapper();
        TargetBean targetBean = mapper.map(sourceBean,TargetBean.class);
        System.out.println(targetBean.toString());

    }
}
