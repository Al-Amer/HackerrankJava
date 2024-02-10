/*
You are the benevolent ruler of Rankhacker Castle, and today you’re distributing bread. Your subjects are in a line,
and some of them already have some loaves. Times are hard and your castle’s food stocks are dwindling,
so you must distribute as few loaves as possible according to the following rules:
Every time you give a loaf of bread to some person i, you must also give a loaf of bread to the person
immediately in front of or behind them in the line (i.e., persons i + 1 or i – 1).
After all the bread is distributed, each person must have an even number of loaves.
Given the number of loaves already held by each citizen, find and print the minimum number of loaves you must
distribute to satisfy the two rules above. If this is not possible, print NO.
Example
B = [4, 5, 6, 7]
We can first give a loaf to i = 3 and i = 4 so B = [4, 5, 7, 8].
Next we give a loaf to i = 2 and i = 3 and have B = [4, 6, 8, 8] which satisfies our conditions.
All of the counts are now even numbers. We had to distribute 4 loaves.
 */

package ProblemSolving.Algorithms.Implementation.FairRations;


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
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> B) {
        // Write your code here
        int n = B.size();
        int lst = 0;
        int ans = 0;
        for(int i = 0; i < n; i ++) {
            int now = B.get(i);
            now += lst;
            if(now % 2 != 0) {
                ans += 2;
                lst = 1;
            } else {
                lst = 0;
            }
        }
        if(lst == 1){
            return "NO";
        }
        else {
            return String.valueOf(ans);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String result = Result.fairRations(B);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println(result);

    }
}


