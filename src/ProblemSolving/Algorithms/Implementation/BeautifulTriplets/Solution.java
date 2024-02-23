/*
Given a sequence of integers , a triplet  is beautiful if:
Given an increasing sequenc of integers and the value of , count the number of beautiful triplets in the sequence.
Example
There are three beautiful triplets, by index: . To test the first triplet,  and .
Function Description
Complete the beautifulTriplets function in the editor below.
beautifulTriplets has the following parameters:
int d: the value to match
int arr[n]: the sequence, sorted ascending
 Returns
 int: the number of beautiful triplets
 Input Format
 The first line contains  space-separated integers,  and , the length of the sequence and the beautiful difference.
 The second line contains  space-separated integers .
 Constraints
 Sample Input
 STDIN           Function
 -----           --------
 7 3             arr[] size n = 7, d = 3
 1 2 4 5 7 8 10  arr = [1, 2, 4, 5, 7, 8, 10]
 Sample Output
 3
 */

package ProblemSolving.Algorithms.Implementation.BeautifulTriplets;


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
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        int nb =0;
        int sizeArr = arr.size();
        if(sizeArr>=3){
            for(int i=0;i<sizeArr-2;i++){
                for(int j=i+1;j<sizeArr-1;j++){
                    int diffJI = arr.get(j)-arr.get(i);
                    if(diffJI==d){
                        for(int k=j+1;k<sizeArr;k++){
                            int diffKJ = arr.get(k)-arr.get(j);
                            if(diffKJ==d && diffJI==diffKJ){
                                nb++;
                            }
                        }
                    }
                }
            }
        }
        return nb;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



