package com.example.misc;

import java.util.Calendar;

public class Driver {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 2); // 2 means march
        calendar.set(Calendar.YEAR, 2098);

        CardValidator card = new CardValidator(calendar);

        System.out.println("-----Month Checks-----");
        test(card.check("0"), true);
        test(card.check("00"), false);

        test(card.check("1"), true);
        test(card.check("12"), true);

        test(card.check("13"), false);
        test(card.check("3"), false);

        System.out.println("-----3 digits Month-Year Checks Upper Bound -----");
        test(card.check("021"), false);
        test(card.check("031"), true);
        test(card.check("041"), true);

        test(card.check("043"), true);
        test(card.check("044"), false);

        System.out.println("-----4 digits Month-Year Checks Upper Bound -----");
        test(card.check("1239"), false);
        test(card.check("1234"), false);
        test(card.check("1233"), true);
        test(card.check("0134"), true);
        test(card.check("0234"), true);

        System.out.println("-----4 digits Month-Year Checks Lower Bound-----");
        test(card.check("0219"), false);
        test(card.check("0319"), true);
        test(card.check("0419"), true);

        System.out.println("-----Misc Checks -----");
        test(card.check("0120"), true);
        test(card.check(""), true); // if empty supplied
        test(card.check(null), true); // if null supplied
        test(card.check("a"), false);
        test(card.check("ab"), false);
        test(card.check("abc"), false);
        test(card.check("abcd"), false);

    }

    private static void test(boolean value, boolean expectedValue) {
        System.out.println(value == expectedValue ? "Pass" : "Fail");
    }
}