package test.java.test03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test02_Reflection {
    public static void main(String[] args) throws Exception {
        // String -> 특정 클래스 타입 객체 생성 -> Class<T>
        // 클래스명: test.java.test03.Test02_Reflection
        Class<?> forName = Class.forName("test.java.test03.MemberVO");

        {
            Object newInstance = forName.newInstance();
            System.out.println("newInstance = " + newInstance);
        }

        // String -> Class<T> -> Constructor -> 객체생성
        {
            Constructor<?> constructor1 = forName.getDeclaredConstructor(); // = public MemberVO() {}
            Object newInstance1 = constructor1.newInstance(); // = new MemberVO()
            System.out.println("newInstance1 = " + newInstance1);

            Constructor<?> constructor2 = forName.getDeclaredConstructor(String.class, String.class, int.class);
            Object newInstance2 = constructor2.newInstance("a001", "김은대", 1990);
            System.out.println("newInstance2 = " + newInstance2);
        }

        // String -> Class<T> -> Field -> 속성접근 및 객체의 속성조회
        {
            Constructor<?> constructor1 = forName.getDeclaredConstructor(String.class, String.class, int.class);
            Object newInstance1 = constructor1.newInstance("a001", "김은대", 1990);

            Field memName = forName.getDeclaredField("memName");
            memName.setAccessible(true);
            Object object = memName.get(newInstance1); // = [memVO].getMemName();
            System.out.println("newInstance1 = " + newInstance1);

            memName.set(newInstance1, "홍길동");
            memName.setAccessible(false);
            System.out.println("newInstance1 = " + newInstance1);
        }

        {
            Constructor<?> constructor1 = forName.getDeclaredConstructor(String.class, String.class, int.class);
            Object newInstance1 = constructor1.newInstance("a001", "김은대", 1990);

            Method setMemName = forName.getDeclaredMethod("setMemName", String.class);
            setMemName.invoke(newInstance1, "홍길순");
            System.out.println("newInstance1 = " + newInstance1);
        }
    }
}
