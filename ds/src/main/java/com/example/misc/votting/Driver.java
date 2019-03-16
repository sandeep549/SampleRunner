package com.example.misc.votting;

public class Driver {

    public static void main(String[] args) {
        OnlineElection onlineElection = new OnlineElection();

        onlineElection.vote(2);
        onlineElection.vote(1);
        onlineElection.vote(3);
        System.out.println(test(onlineElection.seekLeader(), 3));

        onlineElection.vote(2);
        System.out.println(test(onlineElection.seekLeader(), 2));

        onlineElection.vote(3);
        System.out.println(test(onlineElection.seekLeader(), 3));

        onlineElection.vote(1);
        System.out.println(test(onlineElection.seekLeader(), 1));

        onlineElection.vote(3);
        System.out.println(test(onlineElection.seekLeader(), 3));

        onlineElection.vote(1);
        System.out.println(test(onlineElection.seekLeader(), 1));

        onlineElection.vote(4);
        onlineElection.vote(4);
        System.out.println(test(onlineElection.seekLeader(), 1));
        onlineElection.vote(4);
        System.out.println(test(onlineElection.seekLeader(), 4));

        onlineElection.vote(2);
        System.out.println(test(onlineElection.seekLeader(), 2));

        onlineElection.vote(3);
        System.out.println(test(onlineElection.seekLeader(), 3));

    }

    private static String test(int actual, int expected) {
        return actual == expected ? "PASS" : "FAIL";
        //return "Leader = " + actual;
    }
}
