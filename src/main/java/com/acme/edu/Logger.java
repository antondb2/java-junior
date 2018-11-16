package com.acme.edu;

import java.io.IOException;

/**
 * Text
 * <strong>flgjhdfkgjdhfgkjh</strong>
 *
 * @author
 * @see String#toString
 * @since 16.18
 */
public class Logger {
    public static void log(String message) {
        if (message == null) return; //Guard Clause
        if ("".equals(message)) throw new IllegalArgumentException();

        print("string: " + message);

        //===================
        if (message == null) {
            if ("".equals(message)) {

            } else {

            }
        } else { //main flow

        }
    }

    /**
     * 1. Contract:
     * Pre-conditions: param values, state
     * Post-conditions: side effect
     * Invariants: business rules
     * <p>
     * 2. Architecture comments & whys?
     * - JDBC -> ORM, faster
     */
    public static void findMinimalElementInCollection(byte message) throws IOException {
        //region checks
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean isUserLoggedIn = a != b;
        //c == d -> is user registered?
        if (isUserLoggedIn && c == d) {

        }
        //endregion
        print("primitive: " + message);
        print("primitive: " + message);
        print("primitive: " + message);
    }

    //<=5MSLoC -> <=100k global vars
    public static int primitiveClassVar;
    public static Object refClassVar = new Object();

    public static void main(String[] args) {
        int localOrStackOrTempOrAutoVar = 0;
        Logger.print("HW!!!");
    }

    public static void log(int message) {
        print("primitive: " + message);
    }

    public static void log(byte message) {
        print("primitive: " + message);
    }

    public static void log(boolean message) {
        print("primitive: " + message);
    }

    public static void log(char message) {
        print("char: " + message);
    }

    public static void log(Object message) {
        print("reference: " + message);
    }

    private static void print(String s) {
        System.out.println(s);
    }

}
