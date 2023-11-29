package Advanced.JavaSHA256;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution_1 {


    public static void main(String[] args) throws NoSuchAlgorithmException {


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        MessageDigest md = MessageDigest.getInstance( "SHA-256" ) ;
         byte[] digest = md.digest( input.getBytes( StandardCharsets.UTF_8 ) ) ;
        BigInteger number = new BigInteger( 1, digest ) ;
        StringBuilder hexString = new StringBuilder( number.toString( 16 ) ) ;
        while ( hexString.length( ) < 32 )
        { hexString.insert( 0,  " 0 " ) ;}
        System.out.println( hexString.toString( )) ;
    }

}
