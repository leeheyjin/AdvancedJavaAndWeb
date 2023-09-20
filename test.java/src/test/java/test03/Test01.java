package test.java.test03;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        ParamMap paramMap = ParamMap.init();
        List<String> list1 = new ArrayList<>();
        list1.add("1");

        paramMap.put("list", list1);

        List<String> list2 = paramMap.get("list", List.class);
        System.out.println("list2 = " + list2);
    }
}
