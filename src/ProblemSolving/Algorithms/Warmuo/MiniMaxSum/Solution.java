/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly
 four of the five integers. Then print the respective minimum and maximum values as a single line of two
  space-separated long integers.



 */


package ProblemSolving.Algorithms.Warmuo.MiniMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long[] listSum =new long[arr.size()];
        for(int i=0;i< arr.size();i++){
            long sum =0;
            for (int j=0;j< arr.size();j++){
                if (i != j){
                    sum+= arr.get(j);
                }
            }
            listSum[i]=sum;

        }
        System.out.println( Arrays.stream(listSum).min().getAsLong() + " " + Arrays.stream(listSum).max().getAsLong());

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}


