/*
Watson likes to challenge Sherlock’s math ability. He will provide a starting and ending value
describing a range of integers. Sherlock must determine the number of square integers within that
range, inclusive of the endpoints.
Note: A square integer is an integer which is the square of an integer, e.g. 1, 4, 9, 16, 25.
For example, the range is a = 24 and b = 49, inclusive. There are three square integers in the range: 25, 36 and 49.
 */


package ProblemSolving.Algorithms.Implementation.SherlockAndSquares;

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
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     */


        public static int squares(int a, int b) {
            // Write your code here
            int result=0;
            double z=0;
            double sqr=b+1;
            for(int i=a;i<=b;i++){
                double x=Math.sqrt(i);
                long y=(long)x;
                if(x==y){
                    z=x;
                    sqr=i;
                    break;
                }
            }
            while(sqr<=b){
                result++; z+=1; sqr=Math.pow(z,2.0);
            }
            return result;
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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

/*
    public static int squares(int a, int b) {
    // Write your code here
        int num=0;
        double z=0;
         double sqr=b+1;
         for(int i=a;i<=b;i++){
             double x=Math.sqrt(i);
             long y=(long)x;
             if(x==y){
                 z=x;
                 sqr=i;
                 break;
                 }
            }
            while(sqr<=b){
                 num++; z+=1; sqr=Math.pow(z,2.0);
                 }
    return num;
    }
 */


