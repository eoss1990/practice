package beanutils;

import bean.People;
import org.apache.commons.beanutils.*;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by yangyu on 2017/3/18.
 */
public class BeanUtilsTest {

    /**
     * PropertyUtils可以操作Bean中的属性
     */
    public static void main(String[] args) throws Exception {
        Object o = Class.forName("bean.People").newInstance();
        Object map = PropertyUtils.getSimpleProperty(o,"info");
        System.out.println(o);
    }

    /**
     * LazyDynaBean可以装在simple property，Map，数组；且自动扩展容量
     */
    @Test
    public void testLazy(){
        DynaBean dynaBean = new LazyDynaBean();
        dynaBean.set("name","yangyu");
        dynaBean.set("customer","ling","llll");
        dynaBean.set("address",1,"lalalla");
        System.out.println(dynaBean);
    }

    /**
     * 经测试hashmap的性能要远高于LazyDynaBean
     */
    @Test
    public void testHashMapAndLazyDynaBean(){
        Map map = new HashMap();
        DynaBean dynaBean = new LazyDynaBean();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.put(String.valueOf(i),"yangyu");
        }
        long time = System.currentTimeMillis()-start;
        System.out.println(time);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dynaBean.set("map",String.valueOf(i),"yangyu");
        }
        time = System.currentTimeMillis()-start;
        System.out.println(time);
    }

    /**
     * BeanUtils.populate()可以将Map中的键值对直接注入到对应的Bean中
     * ConvertUtils.register()可以注册自定义Converter
     */
    @Test
    public void testBeanUtils() throws InvocationTargetException, IllegalAccessException {
        ConvertUtils.register(new MyConverter(),String.class);
        Map map = new HashMap();
        map.put("name","yangyu");
        map.put("high",175);
        map.put("age",27);
        People people = new People();
        BeanUtils.populate(people,map);
        System.out.println(people);
    }

    /**
     * BeanComparator用法，通过setProperty添加需要比较的字段，然后自动比较
     */
    @Test
    public void TestBeanCompare(){
        People p1 = new People();
        p1.setName("yangyu");

        People p2 = new People();
        p2.setName("yangyu");

        BeanComparator beanComparator = new BeanComparator();
        beanComparator.setProperty("name");
        System.out.println(beanComparator.compare(p1,p2));
    }

    /**
     * BeanPropertyValueChangeClosure可以设置which property will change
     * 配合CollectionUtils.forAllDo()方法可以将一个集合中的所有对象进行转换
     */
    @Test
    public void testBeanPropertyValueChangeClosure(){
        People p1 = new People();
        p1.setName("yangyu");

        People p2 = new People();
        p2.setName("yangyu");

        BeanPropertyValueChangeClosure closure = new BeanPropertyValueChangeClosure("name","lingling");
        List list = Arrays.asList(p1,p2);
        CollectionUtils.forAllDo(list,closure);
        System.out.println(list);
    }

    @Test
    public void testBeanToPropertyValueTransformer(){
        People p1 = new People();
        p1.setName("wangwu");
        People p2 = new People();
        p2.setName("zhangsan");
        People p3 = new People();
        p3.setName("lisi");
        People p4 = new People();
        p4.setName("sanxia");
        List list = Arrays.asList(p1,p2,p3,p4);

        BeanToPropertyValueTransformer transformer = new BeanToPropertyValueTransformer("name",true);
        Collection collection = CollectionUtils.collect(list,transformer);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }

}
