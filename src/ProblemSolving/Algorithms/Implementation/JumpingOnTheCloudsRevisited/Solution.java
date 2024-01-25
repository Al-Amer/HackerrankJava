/*
A child is playing a cloud hopping game. In this game, there are sequentially numbered clouds
that can be thunderheads or cumulus clouds. The character must jump from cloud to cloud until
it reaches the start again.
 */

package ProblemSolving.Algorithms.Implementation.JumpingOnTheCloudsRevisited;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int kPluss = 0;
        boolean process = true;
        while(process){
            kPluss = (kPluss+k)%c.length;
            energy -= (c[kPluss] == 0) ? 1 : 3 ;
            if (kPluss == 0){
                process = false;
            }
        }
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
 //       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
   //     scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        scanner.close();
        int result = jumpingOnClouds(c, k);

 //       bufferedWriter.write(String.valueOf(result));
 //       bufferedWriter.newLine();

 //       bufferedWriter.close();
        // Test Method
        System.out.println(result);


    }
}

