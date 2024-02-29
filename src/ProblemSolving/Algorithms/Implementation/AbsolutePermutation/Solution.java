/*
We define P to be a permutation of the first n natural numbers in the range [1, n]. Let  denote the value at position
i in permutation P using 1-based indexing.
P is considered to be an absolute permutation if [pos[i] – i] = k holds true for every i ∈ [1, n].
Given n and k, print the lexicographically smallest absolute permutation P. If no absolute permutation exists, print -1.
 */

package ProblemSolving.Algorithms.Implementation.AbsolutePermutation;


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
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
        } else if (n % (2 * k) == 0) {
            boolean[] visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                int pos1 = i - k;
                int pos2 = i + k;

                if (pos1 > 0 && !visited[pos1]) {
                    result.add(pos1);
                    visited[pos1] = true;
                } else if (pos2 <= n && !visited[pos2]) {
                    result.add(pos2);
                    visited[pos2] = true;
                } else {
                    result.clear();
                    for (int j = 1; j <= n; j++) {
                        result.add(j);
                    }
                    break;
                }
            }
        } else {
            result.add(-1);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);
/*
                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
 */
                for(Integer in:result){
                    System.out.print(in);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

/*
    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        List<Integer>resultList = new ArrayList<>();
        List<Integer>NList = new ArrayList<>();
        if (k >= n){
            resultList.add(-1);
     //       return resultList;
        }else if (k == 0) {
            for (int i = 1; i <= n; i++) {
                resultList.add(i);
            }
        }else {
            for (int i = 1; i <= n; i++) {
                NList.add(i);
            }
            for (int j = 0; j < NList.size(); j++) {
                for (int i = 0; i < NList.size(); i++) {
                    if (NList.get(i) < j + 1) {
                        if (((j + 1) - (NList.get(i))) == k) {
                            resultList.add(i + 1);
                        }
                    } else {
                        if ((NList.get(i) - (j + 1)) == k) {
                            resultList.add(i + 1);
                        }
                    }
                }
            }
        }
                if (resultList.size() == n) {
                    return resultList;
                } else {
                    //  resultList.removeAll(resultList);
                    resultList.clear();
                    resultList.add(-1);
                    return resultList;
                }
    }
 */

