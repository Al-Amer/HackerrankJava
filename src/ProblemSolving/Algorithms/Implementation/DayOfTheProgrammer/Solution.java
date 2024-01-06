/*
Marie invented a Time Machine and wants to test it by time-traveling to visit Russia on the Day of the Programmer
(the 256th day of the year) during a year in the inclusive range from 1700 to 2700.
From 1700 to 1917, Russia's official calendar was the Julian calendar; since 1919 they used the Gregorian calendar system.
 The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January
 31st was February 14th. This means that in 1918, February 14th was the 32nd day of the year in Russia.
In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a leap year,
and 28 days during all other years. In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar,
leap years are either of the following:
Divisible by 400.
Divisible by 4 and not divisible by 100.
 */

package ProblemSolving.Algorithms.Implementation.DayOfTheProgrammer;

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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */
    public static String dayOfProgrammer(int year) {
        // Write your code here
        String result = "";
            if (year == 1918){
                result = "26.09."+year;
            }else if (year<1918 && (year % 4 == 0) ){
                    result = "12.09."+year;
            }else if ( year>1918 && ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))){
                    result =  "12.09." + year;
            }else {
                result = "13.09." + year;
            }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    // Test Out  Method
        System.out.println(result);


    }
}

