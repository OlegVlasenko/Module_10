package com.company;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Caesar {

    private static final int CODE_OFFSET = 11;
    private static final int V_SIZE = 73;

    public static void encodeArray(ArrayList<String> paramArray) {
        for (String Item : paramArray) {
            Item = encodeValue(Item);
        }
    }

    private static String encodeValue(String input) {

        StringBuilder res = new StringBuilder();

        PrimitiveIterator.OfInt cpIterator = input.codePoints().iterator();

        while (cpIterator.hasNext()) {
            int cp = cpIterator.next();
            res.appendCodePoint('1' + Math.floorMod(cp - '1' + CODE_OFFSET, V_SIZE));
        }

        return res.toString();
    }

    public static void decodeArray(ArrayList<String> paramArray) {
        for (String Item : paramArray) {
            Item = decodeValue(Item);
        }
    }

    private static String decodeValue(String input) {

        StringBuilder res = new StringBuilder();

        PrimitiveIterator.OfInt cpIterator = input.codePoints().iterator();

        while (cpIterator.hasNext()) {
            int cp = cpIterator.next();
            res.appendCodePoint('1' + Math.floorMod(cp - '1' - CODE_OFFSET, V_SIZE));
        }

        return res.toString();
    }

}
