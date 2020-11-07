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
