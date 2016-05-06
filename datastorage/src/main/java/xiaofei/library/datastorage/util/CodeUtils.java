package xiaofei.library.datastorage.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by Eric on 16/3/17.
 *
 * Utils for encoding and decoding.
 */
public class CodeUtils {

    private static final char[] DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
    };

    private CodeUtils() {

    }

    public static String encode(byte[] input) {
        if (input == null || input.length < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        int len = input.length;
        for (int i = 0; i < len; i++) {
            result.append(DIGITS[(0xF0 & input[i]) >>> 4]).append(DIGITS[0x0F & input[i]]);
        }
        return result.toString();
    }

    public static String encode(String input) {
        if (input == null || input.length() < 0) {
            throw new IllegalArgumentException();
        }
        try {
            return encode(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int charToInt(char ch) {
        return 0 <= ch && ch <= '9' ? ch - '0' : ch - 'A' + 10;
    }

    public static byte[] decodeToBytes(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input error.");
        }
        int len = input.length();
        if (len < 0 || len % 2 != 0) {
            throw new IllegalArgumentException("Input error.");
        }
        byte[] result = new byte[len / 2];
        for (int i = 0, j = 0; i < len;) {
            int tmp = charToInt(input.charAt(i++)) << 4;
            tmp = tmp | charToInt(input.charAt(i++));
            result[j++] = (byte) tmp;
        }
        return result;
    }

    public static String decode(String input) {
        if (input == null || input.length() < 0 || input.length() % 2 != 0) {
            throw new IllegalArgumentException("Input error.");
        }
        byte[] bytes = decodeToBytes(input);
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}