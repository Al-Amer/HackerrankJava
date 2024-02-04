/*
Little Bobby loves chocolate. He frequently goes to his favorite 5 & 10 store, Penny Auntie, to buy them.
They are having a promotion at Penny Auntie. If Bobby saves enough wrappers, he can turn them in for a free chocolate.
Example
n = 15
c = 3
m = 2
He has 15 to spend, bars cost 3, and he can turn in 2 wrappers to receive another bar. Initially, he buys 5 bars
and has 5 wrappers after eating them. He turns in 4 of them, leaving him with 1, for 2 more bars. After eating those
two, he has 3 wrappers, turns in 2 leaving him with 1 wrapper and his new bar. Once he eats that one, he has 2 wrappers
and turns them in for another bar. After eating that one, he only has  wrapper, and his feast ends. Overall, he has
eaten 5 + 2 + 1 + 1 = 9 bars.
 */

package ProblemSolving.Algorithms.Implementation.ChocolateFeast;

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
     * Complete the 'chocolateFeast' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c
     *  3. INTEGER m
     */

    public static int chocolateFeast(int n, int c, int m) {
        // Write your code here
        int count = n / c;
        int wrappers = count;

        while (wrappers >= m) {
            int freebies = wrappers / m;
            count += freebies;
            wrappers = freebies + wrappers % m;
        }

       return count;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int c = Integer.parseInt(firstMultipleInput[1]);

                int m = Integer.parseInt(firstMultipleInput[2]);

                int result = Result.chocolateFeast(n, c, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


