package com.hit.basmath.learn.array_and_string;

import java.math.BigInteger;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class _67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        /**
         * Let String to CharArray can improve efficiency
         */
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLength = aChars.length - 1, bLength = bChars.length - 1, carry = 0;
        while (aLength >= 0 || bLength >= 0) {
            int sum = carry;
            if (bLength >= 0) {
                /**
                 * In order to  convert the char to it's actual int value,
                 * so, let bChars[bLength--] - '0', otherwise the returned int is its ascii value
                 */
                sum += bChars[bLength--] - '0';
            }
            if (aLength >= 0) {
                /**
                 * As the same of above, - '0' is meaningful
                 */
                sum += aChars[aLength--] - '0';
            }
            sb.append(sum % 2);
            /**
             * Actually, this equation is carry = sum / 2, but the largest value of sum is 2,
             * so we can use equation of below instead of carry = sum / 2 and avoid divided
             */
            carry = sum < 2 ? 0 : 1;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
