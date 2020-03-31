package spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.overview.annotation.Super;
import spring.ioc.overview.domain.User;
import spring.ioc.overview.repository.UserRepository;

import java.util.Map;

/**
 * 依赖注入示例
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUserCollection());

        /**
         * 依赖注入和依赖查找的来源不同
         *  依赖注入
        System.out.println(userRepository.getBeanFactory());
        // 依赖查找
        System.out.println(beanFactory.getBean(BeanFactory.class));
        System.out.println(userRepository.getBeanFactory() == beanFactory);*/

        /*ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        ApplicationContext applicationContext = objectFactory.getObject();
        System.out.println(applicationContext == beanFactory);*/
    }
}
