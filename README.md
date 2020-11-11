# springrecord
spring学习日记
### IOC容器
控制反转(Inversion of Control)，是面向对象编程中的一种设计原则，可以降低耦合度。包括依赖注入（Dependency Injection）、依赖查找（Dependency Lookup）。创建对象时，系统将其所依赖的对象的引用传递给自身。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201106204124678.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
#### 原生的实现接口
java中实现一个接口功能，创建一个类来实现接口，我创建一个接口Dosomething，在创建一个Working类来实现这个接口。

```java
public interface Dosomething {
    public void down();//实现某个功能
}
```

```java
public class Working implements Dosomething{
    @Override
    public void down() {
        //实现接口功能
    }
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201106205955930.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
#### 工厂模式

创建一个第三者将接口和实现类关联起来

```java
public class Do_cosplay{
    public void down()
    {
        System.out.println("模拟工厂模式\n");
    }
}

public class User_cosplay{//模拟用户类
public void execute(){
    Do_cosplay dosomething=Factory_cosplay.getDo_cosplay();
    dosomething.down();//实现
}
}

public class Factory_cosplay {//模拟工厂类
    public static Do_cosplay getDo_cosplay() {
        return new Do_cosplay();
    }
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201106232033700.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)

### xml注解
spring提供IOC容器两种方式

 - BeanFactory
 - ApplicationContext
 
 
| BeanFactory | ApplicationContext |
|--|--|
|  加载配置文件不创建对象，获取使用创建对象 | 加载配置文件时创建配置文件|

```java
ClassPathXmlApplicationContext("");//对应src下的路径(相对路径)
FileSystemXmlApplicationContext("");//对应绝对路径
```
这个路径可以在ide改，但是可能会报错（`ClassNotFoundException`）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201106224150727.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
推荐放在src目录下
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201107230420401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)

### bean无参注入
需要对象拥有无参的构造函数
#### 基本属性
**bean**
`id、class`
class对应packge.class类、id对应唯一的对象标识（不是创建名）。
**property**
`name、value`
name对应set方法名（去掉set）、value对应set方法注入对象属性的值。

#### bean的创建销毁
需要配置。
`init-method`创建方法。
`destroy-method`销毁方法。
```java
package bean_test;

public class User {
    private  String name,age,sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void initmethod()
    {
        System.out.print("创建user");
    }
    public void destroymethod()
    {
        System.out.print("销毁user");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}


```
配置文件（无参构造set注入）
```xml
<bean id="user01" class="bean_test.User" init-method="initmethod" destroy-method="destroymethod">
    <property name="name" value="yma16" ></property>
    <property name="sex" value="男"></property>
    <property name="age" value="18"></property>
</bean>
```

```java
ApplicationContext context1= new ClassPathXmlApplicationContext("bean01.xml");
User user=context1.getBean("user01",User.class);
System.out.println(user);
```
无参注入成功！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201107230752502.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
### bean的有参注入
需要有参的构造方法
#### constructor-arg标签
配置有参构造函数的参数属性

```xml
<bean id="" class="">
<constructor-arg name="" value=""></constructor-arg>
</bean>
```

#### bean的p命名空间
在bean标签中添加

```java
xmlns:p="http://www.springframework.org/schema/p"
```
属性添加

```xml
p:属性=""
```
在User类添加一个有参构造函数

```java
package bean_test;

public class User {
    private  String name,age,sex;
//    public User()
//    {
//        System.out.println("无参构造");
//    }
    public User(String name,String age,String sex)
    {
        this.name=name;
        this.age=age;
        this.sex=sex;
        System.out.println("有参构造");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void initmethod()
    {
        System.out.print("创建user");
    }
    public void destroymethod()
    {
        System.out.print("销毁user");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

```
bean设置

```xml
<bean id="user02" class="bean_test.User" init-method="initmethod" destroy-method="destroymethod">
<constructor-arg name="name" value="yma16_替身"></constructor-arg>
<constructor-arg name="sex" value="男"></constructor-arg>
<constructor-arg name="age" value="16"></constructor-arg>
</bean>
```
有参注入成功！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201107232632166.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
### bean注入特殊符号
**字面量**

```java
private String name="yam16";//定值
```
#### null值和特殊符号< >

idea不允许直接粗暴的写`<`和`>`
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108001023208.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)

**分别使用`&lt;` 和`&gt;`转义成`<`和`>`**

```xml
<property name="slog" value="&lt;yma16&gt;"></property>
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108000911447.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)

**使用CDATA**

```xml
    <bean id="s01" class="bean_test.Strange">
            <property name="slog">
                <value>
                    <![CDATA[<yma16>]]>
                </value>
            </property>
        </bean>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108000259403.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
### 注入外部bean
创建另一个类调用User对象
#### ref标签
链接bean的id
**测试用例**
使用创建一个Outbean类调用User类

```java
package bean_test;

public class Outbean {
    public User userclass;//外部的user
    public String Oname;

    public void setUserclass(User userclass) {
        this.userclass = userclass;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    @Override
    public String toString() {
        return "Outbean{" +
                "userclass=" + userclass +
                ", Oname='" + Oname + '\'' +
                '}';
    }
}

```

bean的配置

```xml
    <bean id="Out01" class="bean_test.Outbean" init-method="initmethod" destroy-method="destroymethod">
        <property name="oname" value="测试1号"></property>
        <property name="userclass" ref="user_ref"></property>

    </bean>
    <bean id="user_ref" class="bean_test.User" init-method="initmethod" destroy-method="destroymethod">
        <constructor-arg name="name" value="yma16_ref"></constructor-arg>
        <constructor-arg name="sex" value="男_ref"></constructor-arg>
        <constructor-arg name="age" value="16_ref"></constructor-arg>
    </bean>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020110800273411.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
外部bean测试完成！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108003323547.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
#### array、set、map、list
创建一个Array_Listcase类并且创建array、set、map、list属性。

```java
package bean_test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Array_Listcase {
    public String[] array_case;
    public Map<String,String> map_case;
    public List<String> list_case;
    public Set<String> set_case;

    public void setArray_case(String[] array_case) {
        this.array_case = array_case;
    }

    public void setMap_case(Map<String, String> map_case) {
        this.map_case = map_case;
    }

    public void setList_case(List<String> list_case) {
        this.list_case = list_case;
    }

    public void setSet_case(Set<String> set_case) {
        this.set_case = set_case;
    }

    public void initmethod()
    {
        System.out.print("创建Outbean");
    }
    public void destroymethod()
    {
        System.out.print("销毁Outbean");
    }

    @Override
    public String toString() {
        return "Array_Listcase{" +
                "array_case=" + array_case +
                ", map_case=" + map_case +
                ", list_case=" + list_case +
                ", set_case=" + set_case +
                '}';
    }
}


```
bean配置

```xml
 <bean id="case01" class="bean_test.Array_Listcase" init-method="initmethod" destroy-method="destroymethod">
        <property name="array_case">
            <array>
                <value>yma16</value>
                <value>18</value>
            </array>
        </property>
        <property name="map_case">
            <map>
                <entry key="I am a keay" value="I am a value"></entry>
                <entry key="yma16" value="yma16 value"></entry>
            </map>
        </property>
        <property name="list_case">
            <list>
                <value>yma16</value>
                <value>2020</value>
            </list>
        </property>
        <property name="set_case">
            <set>
                <value>I am a set</value>
                <value>yma16</value>
            </set>
        </property>
    </bean>
```
测试结果！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108012101588.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
### 注解方式
#### Component、Service、Controller、Ropository
- @Component
-  @Service
-  @Controller
-  @Ropository
注解方式可以类、方法和属性名上面

```xml
@注解(value="");<!-- 对应 bean标签中 id唯一标识   -->
```

 1. 引入依赖aop
 2. 开启组件扫描
3.  引入命名空间context

创建一个Demo类，component方式创建对象

```java
package context_demo;
import org.springframework.stereotype.Component;
@Component(value="component1")
public class Demo {

}

```

```java
System.out.println("component方式注入");
ApplicationContext context5= new ClassPathXmlApplicationContext("bean05.xml");
Demo compnent1=context5.getBean("component1", Demo.class);
System.out.println(compnent1);
```

```xml
<context:component-scan base-package="context_demo">
</context:component-scan>
```
component方式注入成功！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108122918625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
### 基于注解方式的属性注入
#### Autowired、Qualifier、Resource
注入
 - Autowired(属性类型)
 - Qualifier(属性名称)
 - Resource(属性类型或属性名称)
 - value(普通类型属性)
 
代码：[去我的仓库](https://github.com/yongma16/springrecord.git)
**end**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201108011545267.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4ODcwMTQ1,size_16,color_FFFFFF,t_70#pic_center)
