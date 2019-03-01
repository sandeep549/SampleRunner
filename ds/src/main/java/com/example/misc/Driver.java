package com.example.misc;

public class Driver {
    public static void main(String[] args) {
        CardValidator card = new CardValidator();

        System.out.println("-----Month Checks-----");
        System.out.println("" + card.check("0"));

        System.out.println("" + card.check("1"));
        System.out.println("" + card.check("12"));

        System.out.println("" + card.check("13"));
        System.out.println("" + card.check("3"));


        System.out.println("-----Month-Year Checks Upper Bound -----");
        System.out.println("" + card.check("1239"));
        System.out.println("" + card.check("1234"));
        System.out.println("" + card.check("1233"));
        System.out.println("" + card.check("0134"));
        System.out.println("" + card.check("0234"));


        System.out.println("-----Month-Year Checks Lower Bound-----");
        System.out.println("" + card.check("0219"));
        System.out.println("" + card.check("0319"));
        System.out.println("" + card.check("0419"));

        System.out.println("-----Misc Checks -----");
        System.out.println("" + card.check("0120"));

    }
}