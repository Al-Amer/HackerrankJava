package Advanced.JavaSHA256;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        String inputWord = scanner.nextLine();
        scanner.close();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(inputWord.getBytes());
            byte[] digest = messageDigest.digest();
            for(byte b:digest){
                System.out.printf("%02x",b);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

}
