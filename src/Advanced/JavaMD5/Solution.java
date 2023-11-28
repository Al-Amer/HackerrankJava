/*
MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a128-bit hash value. Here are some
common uses for MD5:
* To store a one-way hash of a password.
* To provide some assurance that a transferred file has arrived intact.
MD5 is one in a series of message digest algorithms designed by Professor Ronald Rivest of MIT (Rivest,1994 ); however,
 the security of MD5 has been severely compromised, most infamously by the Flame malware in 2012 . The CMU Software
 Engineering Institute essentially considers MD5 to be "cryptographically broken and unsuitable for further use".
Given an alphanumeric string, s, denoting a password, compute and print its MD5 encryption value.

 */
// Java 8
package Advanced.JavaMD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] messageDiegest = md5.digest(input.getBytes());
            BigInteger bigInteger = new BigInteger(1,messageDiegest);
            String hashtext = bigInteger.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println( hashtext );

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
