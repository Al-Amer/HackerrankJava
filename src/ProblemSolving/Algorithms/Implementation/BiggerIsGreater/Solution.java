/*
Lexicographical order is often known as alphabetical order when dealing with strings.
A string is greater than another string if it comes later in a lexicographically sorted list.
Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
It must be greater than the original word
It must be the smallest word that meets the first condition
 */
package ProblemSolving.Algorithms.Implementation.BiggerIsGreater;


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
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        // Write your code here
        StringBuilder sb = new StringBuilder(w);

        int minPos = Integer.MIN_VALUE;
        char minVal = Character.MAX_VALUE;
        Character toSubst = Character.MAX_VALUE;
        int positionToSubst = Integer.MAX_VALUE;

        for (int i = w.length() - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                char iVal = w.charAt(i);
                char jVal = w.charAt(j);
                if (w.charAt(i) > w.charAt(j)) {
                    if (minPos < j) {
                        minPos = j;
                        positionToSubst = i;
                        minVal = jVal;
                        toSubst = iVal;
                    }
                    break;
                }
            }
        }

        if (minPos != Integer.MIN_VALUE) {
            sb.replace(minPos, minPos + 1, String.valueOf(toSubst));
            sb.replace(positionToSubst, positionToSubst + 1, String.valueOf(minVal));

            return sb.replace(minPos + 1, sb.length(), sb.chars().skip(minPos + 1).sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString()).toString();
        } else {
            return "no answer";
        }

    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

 //               bufferedWriter.write(result);
 //               bufferedWriter.newLine();
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}



