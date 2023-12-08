package Java.BigNumber.JavaPrimalityTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {





    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger bigInteger = new BigInteger(n);
        String result = (bigInteger.isProbablePrime(1)) ? "prime" :  "not prime";
        System.out.println(result);


        bufferedReader.close();




    }

}
