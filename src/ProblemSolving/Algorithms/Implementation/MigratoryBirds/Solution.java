/*
Given an array of bird sightings where every element represents a bird type id,
determine the id of the most frequently sighted type. If more than 1 type has been
 spotted that maximum amount, return the smallest of their ids.
 */

package ProblemSolving.Algorithms.Implementation.MigratoryBirds;

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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer>countOfListNumber = new HashMap<>();
        for (Integer integer:arr){
            int i = integer;
            if (countOfListNumber.containsKey(i)){
                int valeu = countOfListNumber.get(i);
                valeu+=1;
                countOfListNumber.put(i,valeu);
            }else {
                countOfListNumber.put(i,1);
            }
        }
        int max = countOfListNumber.get(arr.get(0));
        int key =0;
        for (Integer in :countOfListNumber.keySet()) {
            if (max < countOfListNumber.get(in)) {
                max = countOfListNumber.get(in);
                key = in;
            }
        }
            return key;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

   //     bufferedWriter.write(String.valueOf(result));
   //     bufferedWriter.newLine();

        bufferedReader.close();
    //    bufferedWriter.close();
    // Out put test Method
        System.out.println(result);

    }
}
