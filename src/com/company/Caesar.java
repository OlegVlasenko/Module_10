package com.company;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

@SuppressWarnings("unused")
class Caesar {

    private static final int CODE_OFFSET = 11;
    private static final int V_SIZE = 255;

    public static void encodeArray(ArrayList<String> paramArray) {
        for (String Item : paramArray) {
            Item = encodeValue(Item);
        }
    }

    public static String encodeValue(String input) {

        StringBuilder res = new StringBuilder();

        if (input != null) {
            PrimitiveIterator.OfInt cpIterator = input.codePoints().iterator();

            while (cpIterator.hasNext()) {
                int cp = cpIterator.next();
                res.appendCodePoint(' ' + Math.floorMod(cp - ' ' + CODE_OFFSET, V_SIZE));
            }
        }

        return res.toString();
    }

    public static void decodeArray(ArrayList<String> paramArray) {
        for (String Item : paramArray) {
            Item = decodeValue(Item);
        }
    }

    public static String decodeValue(String input) {

        StringBuilder res = new StringBuilder();

        PrimitiveIterator.OfInt cpIterator = input.codePoints().iterator();

        while (cpIterator.hasNext()) {
            int cp = cpIterator.next();
            res.appendCodePoint(' ' + Math.floorMod(cp - ' ' - CODE_OFFSET, V_SIZE));
        }

        return res.toString();
    }

}
