package com.acme.edu;


public class TypeSafeLogger {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_PREFIX = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";
    public static int sum = 0;
    public static boolean changed = false;
    public static int maxIntegerCounter = 0;

    /**
     * OCP
     */
    public static void log(int message) {
//        String decoratedMessage = PRIMITIVE_PREFIX + message; //explaining var
//        print(decoratedMessage);

        sum += message;
        changed = true;
    }


    public static void log(char message) {
        String decoratedMessage = CHAR_PREFIX + message;
        print(decoratedMessage);
    }

    public static void log(String message) {
        flush();
        String decoratedMessage = STRING_PREFIX + message;
        print(decoratedMessage);
    }

    public static void log(boolean message) {
        String decoratedMessage = PRIMITIVE_PREFIX + message;
        print(decoratedMessage);
    }

    public static void log(Object message) {
        String decoratedMessage = REFERENCE_PREFIX + message;
        print(decoratedMessage);
    }


    public static void flush() {
        if (changed) {
            print(String.valueOf(sum));
            while (maxIntegerCounter>0)
            {
                System.out.println(Integer.MAX_VALUE);
                maxIntegerCounter--;
            }
            changed = false;
            sum=0;
        }
    }

    /**
     * 1. Reuse
     * 2. Abstract -> Flexibility
     */
    private static void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
