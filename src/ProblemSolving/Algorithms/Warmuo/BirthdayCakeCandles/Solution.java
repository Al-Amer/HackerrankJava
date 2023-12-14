/*
You are in charge of the cake for a child's birthday. You have decided the cake will
 have one candle for each year of their total age. They will only be able to blow out
 the tallest of the candles. Count how many candles are tallest.
 */

package ProblemSolving.Algorithms.Warmuo.BirthdayCakeCandles;

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
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        HashMap<Integer, Integer> listnummer = new HashMap<Integer, Integer>();
        for (Integer integer : candles) {
            if(listnummer.containsKey(integer)){
                int a = listnummer.get(integer)+1;
                listnummer.put(integer, a);
            }else{
                listnummer.put(integer, 1);
            }   }
        int i =0;
     //   int maxElement = 0;
        int maxValue = 0;
        for (Integer intnumber: listnummer.keySet()) {
            if (i==0){
                maxValue =  listnummer.get(intnumber);
              //  maxElement = intnumber;
                i++;
            }else{
                if ( maxValue < listnummer.get(intnumber)){
                    maxValue =  listnummer.get(intnumber);
                //    maxElement = intnumber;
                }
            }
        }
        return maxValue ;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    //    System.out.println(result);
    }
}

