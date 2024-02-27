/*
There is a special counter in which, at the first second, it displays the number 3. Each second, the number
displayed by the counter decrements by 1 until it reaches 1 .
The counter counts down in cycles. In next second, the timer resets to and continues counting down. The diagram
below shows the counter values for each time in the first three cycles:
 */

package ProblemSolving.Algorithms.Implementation.StrangeCounter;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

    public static long strangeCounter(long t) {
        // Write your code here
        long U=1;
        long sum =0;
        long Vt=3;
        if(t<=3){
            return (4-t);
        }
        for(int i=0;;i++){
            sum += Math.pow(2,i);
            U = 1 + (3 * sum);
            long sumNext = (long) (sum + Math.pow(2,i+1));
            long Unext = 1 + (3*sumNext);
            if(t>=(U) && t<(Unext)){
                Vt = (long) (Unext - t);
                break;
            }
        }
        return Vt;    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.strangeCounter(t);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();

        System.out.println(result);

    }
}



