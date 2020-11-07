package bean_test;

public class Strange {
    private String s;
    public void initmethod()
    {
        System.out.print("创建Strange");
    }
    public void destroymethod()
    {
        System.out.print("销毁Strange");
    }
    public void setS(String s) {
        this.s = s;
    }

}
