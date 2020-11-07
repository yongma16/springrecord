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
