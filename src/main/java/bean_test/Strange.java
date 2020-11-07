package bean_test;

public class Strange {
    public String slog;
    public void initmethod()
    {
        System.out.print("创建Strange");
    }
    public void destroymethod()
    {
        System.out.print("销毁Strange");
    }
    public void setSlog(String slog) {
        this.slog = slog;
    }

    @Override
    public String toString() {
        return "Strange{" +
                "s='" + slog + '\'' +
                '}';
    }
}
