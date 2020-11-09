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
