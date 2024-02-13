/*
Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the
trail and notices that any two consecutive stones' numbers differ by one of two values. Legend has it that there
is a treasure trove at the end of the trail. If Manasa can guess the value of the last stone, the treasure will
be hers.

 */

package ProblemSolving.Algorithms.Implementation.ManasaAndStones;


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
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
        // Write your code here
        int j = n-1;
        List<Integer> list = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            if(!list.contains((i*a)+((j-i)*b)))list.add((i*a)+((j-i)*b));
        }
        Collections.sort(list);
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int a = Integer.parseInt(bufferedReader.readLine().trim());

                int b = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.stones(n, a, b);

/*
                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );

 */
                System.out.println(result.toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
 //       bufferedWriter.close();

    }
}



