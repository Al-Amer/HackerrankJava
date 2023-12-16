/*
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
Example
 */

package ProblemSolving.Algorithms.Warmuo.TimeConversion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
            String result = "";
            String[] sInArray = s.split(":");
            if (sInArray[2].contains("PM")){
                if (Integer.parseInt(sInArray[0]) == 12){
                    result= sInArray[0]+":"+sInArray[1]+":"+sInArray[2].substring(0,2);
                }else{
                result= (Integer.parseInt(sInArray[0])+12)+":"+sInArray[1]+":"+sInArray[2].substring(0,2);}
            }else if (sInArray[2].contains("AM")){
                if (Integer.parseInt(sInArray[0]) == 12){
                    result = "00:"+sInArray[1]+":"+sInArray[2].substring(0,2);
                }else{
                result= sInArray[0]+":"+sInArray[1]+":"+sInArray[2].substring(0,2);}
            }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

       bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
   //   Test Method
 //       System.out.println(result);
    }
}

