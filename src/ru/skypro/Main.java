package ru.skypro;

import ru.skypro.service.impl.StringListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringListImpl list = new StringListImpl();
        for (int i = 0; i < 6; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(list);
        StringListImpl list2 = new StringListImpl(1);
        for (int i = 0; i < 6; i++) {
            list2.add(String.valueOf(i));
        }
        System.out.println(list2);
        list2.add(0, "-1");
        list2.remove("0");
        list2.remove(5);
        System.out.println("list2.contains(\"5\") = " + list2.contains("5"));
        System.out.println("list2.contains(\"4\") = " + list2.contains("4"));
        System.out.println("list2.lastIndexOf(\"5474\") = " + list2.lastIndexOf("5474"));
        System.out.println(list2);
        System.out.println("list2.equals(list): " + list2.equals(list));
        System.out.println("list2.isEmpty() = " + list2.isEmpty());
        list2.clear();
        System.out.println("list2.isEmpty() = " + list2.isEmpty());
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));

    }
}
