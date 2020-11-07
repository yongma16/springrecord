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
        return "Outbean{" +
                "userclass=" + userclass +
                ", Oname='" + Oname + '\'' +
                '}';
    }
}
