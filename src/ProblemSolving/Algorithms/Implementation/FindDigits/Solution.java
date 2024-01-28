/*
An integer d is a divisor of an integer n if the remainder of n ÷ d = 0 .
Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of
 divisors occurring within the integer.
 */

package ProblemSolving.Algorithms.Implementation.FindDigits;

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
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int result = 0;
      String nInStr = String.valueOf(n);

      for(int i=0;i< nInStr.length();i++){
          int number = Integer.parseInt(String.valueOf(nInStr.charAt(i)));
          if (number > 0){
              if ((n % number) == 0){
                  result++;
              }
          }
      }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

 //               bufferedWriter.write(String.valueOf(result));
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

