/*
An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly  steps, for every step
it was noted if it was an uphill,U , or a downhill, D step. Hikes always start and end at sea level, and each step up
or down represents a 1 unit change in altitude. We define the following terms:
A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/
 */

package ProblemSolving.Algorithms.Implementation.CountingValleys;


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
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int elevation = 0;
        int valley = 0;
        for (int i=0;i<path.length();i++){
            String str = String.valueOf(path.charAt(i));
            if (str.equals("D")&&(elevation == 0)){
                valley++;
            }
            if (str.equals("D")){
                elevation--;
            }else{
                elevation++;
            }
        }
        return valley;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
   public static int countingValleys(int steps, String path) {
        // Write your code here
        int count  = 0;
        int[] arrcount= new int[path.length()];
        for (int i=0;i<path.length();i++){
           if (i < (path.length()-1)){
               String cha1= String.valueOf(path.charAt(i));
               int countIf = 0;
       //        String cha2= String.valueOf(path.charAt(i+1));
               if(cha1.equals("D")){
                   countIf++;
               }
                   for (int j =i+1;j<path.length();j++){
                       String chOnrTime =String.valueOf(path.charAt(j));
                       if (chOnrTime.equals("D")){
                           countIf++;
                       }else {
                           i = j-1;
                           if (countIf >= 2){
                               count++;
                           }
                           break;
                       }
                   }
           }
        }
        return count;
    }

}
 */
