package com.yma16.springrecord;//package com.yma16.springrecord;
import bean_test.Outbean;
import bean_test.Strange;
import bean_test.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringrecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrecordApplication.class, args);
        SpringrecordApplication S=new SpringrecordApplication();
        S.testbean();
    }
    public void testbean()
    {
        ApplicationContext context1= new ClassPathXmlApplicationContext("bean01.xml");
        User user=context1.getBean("user02",User.class);
        System.out.println(user);

        ApplicationContext context2= new ClassPathXmlApplicationContext("bean02.xml");
        Strange s1=context2.getBean("s01",Strange.class);
        System.out.println(s1);

        System.out.println("外部bean");
        ApplicationContext context3= new ClassPathXmlApplicationContext("bean02.xml");
        Outbean o1=context3.getBean("s01", Outbean.class);
        System.out.println(o1);
    }

}
