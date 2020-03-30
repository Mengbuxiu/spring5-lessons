package spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.annotation.Super;
import spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 依赖查找示例-实时查找
 */
public class DependencyLookupDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupInLazy(beanFactory);
        lookupInRealTime(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> user = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("标注@Super = " + user);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> user = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("user = " + user);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        // 此处应用范型，所以可得出这个方法是从spring3.0出现的，因为spring3.0开始支持java5范型
        User user = beanFactory.getBean(User.class);
        System.out.println("real  time: " + user);
    }

    @SuppressWarnings("unchecked")
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lazy: " + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User)beanFactory.getBean("user");
        System.out.println("real  time: " + user);
    }
}
