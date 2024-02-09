/*
Flatland is a country with a number of cities, some of which have space stations. Cities are numbered consecutively
 and each has a road of 1 km length connecting it to the next city. It is not a circular route, so the first city
 doesn’t connect with the last city. Determine the maximum distance from any city to it’s nearest space station.
For example, there are n=3 cities and m=1 of them has a space station, city 1. They occur consecutively along a
route. City 2 is 2-1=1 unit away and city 3 is 3-1=2 units away. City 1 is 0 units from its nearest space station
as one is located there. The maximum distance is 2.
 */

package ProblemSolving.Algorithms.Implementation.FlatlandSpaceStations;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDistance = Math.max(c[0], n - 1 - c[c.length - 1]);
        for (int i = 0; i + 1 < c.length; i++) {
            maxDistance = Math.max(maxDistance, (c[i + 1] - c[i]) / 2);
        }
        return maxDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

 //       bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}


