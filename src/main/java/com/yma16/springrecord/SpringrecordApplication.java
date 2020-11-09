package com.yma16.springrecord;
import bean_test.Outbean;
import bean_test.Strange;
import bean_test.User;
import entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

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

//        System.out.println("外部bean");
//        ApplicationContext context3= new ClassPathXmlApplicationContext("bean02.xml");
//        Outbean o1=context3.getBean("s01", Outbean.class);
//        System.out.println(o1);

        ApplicationContext context4=new ClassPathXmlApplicationContext("bean06.xml");
        BookService jdbc=context4.getBean("bookService",BookService.class);//自动注解
        System.out.println(jdbc);//已执行
        Book user01=new Book();//添加的数据
        user01.setUsername("yma16");
        user01.setUserpassword("password");
        user01.setId(666);//条件
        //问题所在！
        jdbc.addBook(user01);//实现接口
        //插入数据
        System.out.println("insert成功！");
        //

        Book user02=new Book();//修改的数据
        user02.setUsername("修改的用户名");
        user02.setUserpassword("修改的密码");
        user02.setId(666);//条件
        jdbc.updateBook(user02);//实现修改的接口
        System.out.println("update成功！");


//        Book user03=new Book();//删除的数据id
//        user03.setId(666);//条件
//        jdbc.deleteBook(user03);//删除的数据

        //查询的数据
        jdbc.selectCount();//实现查询的接口
        System.out.println("查询成功！");
    }

}

