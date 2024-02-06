/*
A driver is driving on the freeway. The check engine light of his vehicle is on, and the driver wants to
get service immediately. Luckily, a service lane runs parallel to the highway.
It varies in width along its length.
You will be given an array of widths at points along the road (indices), then a list of the indices of
entry and exit points. Considering each entry and exit point pair, calculate the maximum size vehicle that
can travel that segment of the service lane safely.

Example

n = 4
width = [2, 3, 2, 1]
cases = [[1, 2], [2, 4]]

If the entry index, i = 1 and the exit, j = 2, there are two segment widths of 2 and 3 respectively.
The widest vehicle that can fit through both is 2. If i = 2 and j = 4,
the widths are [3, 2, 1] which limits vehicle width to 1.
 */

package ProblemSolving.Algorithms.Implementation.ServiceLane;

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
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */

    public static List<Integer> serviceLane(int n, List<List<Integer>> cases, List<Integer>width) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (cases.isEmpty() || !casesConformToMethod(cases)) {
            throw new IllegalArgumentException("Cases parameter does not conform to method");
        }
        for (List<Integer> caseList : cases) {
            int x = caseList.get(0);
            int y = caseList.get(1);
            List<Integer> sub = width.subList(x, y + 1);
            result.add(sub.stream().min(Integer::compareTo).orElse(null));
        }
        return result;
    }

    private static boolean casesConformToMethod(List<List<Integer>> cases) {
        for (List<Integer> caseList : cases) {
            if (caseList.size() != 2) {
                return false;
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> cases = new ArrayList<>();

        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.serviceLane(n, cases,width);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

