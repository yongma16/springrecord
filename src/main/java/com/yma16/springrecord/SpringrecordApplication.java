package com.yma16.springrecord;//package com.yma16.springrecord;
import bean_test.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringrecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrecordApplication.class, args);
        ApplicationContext context1= new ClassPathXmlApplicationContext("bean01.xml");
        User user=context1.getBean("user01",User.class);
        System.out.println(user);

    }

}
