// CS108 HW1 -- String static methods

import java.util.HashSet;
import java.util.Set;

public class StringCode {
    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.isEmpty()) return 0;
        int maxrun = 1, currentrun = 1;
        for (int i = 1; i < str.length(); i+=1) {
            if (str.charAt(i) == str.charAt(i+1)) {
                currentrun++;
            }
            else {
                Math.max(maxrun, currentrun);
                currentrun = 1;
            }
            return Math.max(maxrun, currentrun);
        }


        return 0; // YOUR CODE HERE
    }
    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder result =  new StringBuilder();
        for (int i = 0; i < str.length(); i+=1) {
            char currentchar = str.charAt(i);
            if (Character.isDigit(currentchar)) {
                int giatri = currentchar - '0';
                if (i+1 < str.length() {
                    char nextchar = str.charAt(i+1);
                    for (int j= 0; j <= giatri; j+=1) {
                        result.append(nextchar)
                    }
                }
                else {
                    result.append(currentchar);
                }

            }

        }
        return result.toString();
    }
    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        Set<String> substring = new HashSet<>();
        for (int i = 0; i < a.length()-len; i+=1) {
            subsstring.add(a.substring(i, i+ len));
        }
        for (int i = 0; i <= b.length()-len; i+=1) {
            if (substring.add(b.substring(i, i + len))) return true;
        }
        return false; // YOUR CODE HERE
    }
}