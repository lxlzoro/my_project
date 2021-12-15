package com.example.myproject;

import com.example.myproject.entity.TPersonInfo;

import java.util.ArrayList;
import java.util.List;

public class Java8Tester {
    public static void main(String[] args) {
//        String[] atp = {"111", "222", "333", "444", "555", "666", "777", "lxl"};
//        List<String> players = Arrays.asList(atp);
        // 以前的循环方式
//        for (String player : players) {
//            System.out.print(player + "; ");
//        }
        // 使用 lambda 表达式以及函数操作(functional operation)
//        players.forEach((player) -> System.out.print(player + "; "));
        // 在 Java 8 中使用双冒号操作符(double colon operator)
//        players.forEach(System.out::println);

//        List<String> lists = new ArrayList<>();
//        lists.add("111");
//        lists.add("222");
//        lists.add("333");
//        lists.add("444");
//        lists.add("555");
//        lists.add("666");
//        lists.add("777");
//        lists.forEach((list)-> System.out.println(list+";"));
//        lists.forEach(System.out::println);

        List<TPersonInfo> javaProgrammers = new ArrayList<TPersonInfo>() {
            {
                add(new TPersonInfo("Tamse", 12, 2, "females"));
                add(new TPersonInfo("Floyd", 13, 1, "females"));
                add(new TPersonInfo("Sindy", 14, 2, "females"));
                add(new TPersonInfo("Veres", 15, 2, "females"));
                add(new TPersonInfo("Maude", 16, 1, "females"));
                add(new TPersonInfo("Shawn", 17, 2, "females"));
                add(new TPersonInfo("Jayde", 18, 1, "females"));
                add(new TPersonInfo("Palme", 19, 2, "females"));
                add(new TPersonInfo("Addis", 10, 1, "females"));
            }
        };
        javaProgrammers.forEach((tPersonInfo -> System.out.println(tPersonInfo.getName())));
    }
}
