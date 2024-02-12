/*
given a string of lowercase english letters and an integer of the substring length, determine the substring of
that length that contains the most vowels. vowels are in the set {a , e , i , o , u} . ﻿if there is more than
one substring with the maximum number of vowels, return the one that starts
 */

package ProblemSolving.certificatesTest.VowelSubstring;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    static String strVowels = "aeiou";
    public static int countVowels(String str) {
        int count = 0;
        for (int j = 0; j < str.length(); j++) {
            if (strVowels.indexOf(str.charAt(j)) >= 0) {
                count++;
            }
        }
        return count;
    }
    public static String findSubstring(String s, int k) {
        // Write your code here
        String ans = "";
        int maxVowelCount = 0, count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        if (count != 0) {
            ans = s.substring(0, k);
            maxVowelCount = count;
        }
        for (int i = 1, j = k; j < s.length(); i++, j++) {
            if (isVowel(s.charAt(i - 1))) {
                count--;
            }
            if (isVowel(s.charAt(j))) {
                count++;
            }
            if (count > maxVowelCount) {
                ans = s.substring(i, j + 1);
                maxVowelCount = count;
            }
        }

        if (ans.length() == 0) {
            return "Not found!";
        }
        return ans;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findSubstring(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


