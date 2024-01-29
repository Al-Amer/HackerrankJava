/*
The factorial of the integer n, written n!, is defined as:
         n! = n * (n-1) * (n-2) * ........ * 3 * 2 * 1
Calculate and print the factorial of a given integer.

For example, if n = 30, we calculate 30 * 29 * 28 * ...... * 3 * 2 * 1 and get 265252859812191058636308480000000.


Function Description

Complete the extraLongFactorials function in the editor below. It should print the result and return.
extraLongFactorials has the following parameter(s):
n: an integer
 */


package ProblemSolving.Algorithms.Implementation.ExtraLongFactorials;

import java.io.*;
import java.math.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = BigInteger.ONE;
        for(int i = n; i >0; i--){
            BigInteger in = new BigInteger(String.valueOf(i));
            result= result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}


