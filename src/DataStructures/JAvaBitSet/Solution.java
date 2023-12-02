package java.DataStructures.JAvaBitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        BitSet b1= new BitSet(m);
        BitSet b2= new BitSet(m);
        BitSet[] bitset = new BitSet[3];
        bitset[1] = b1;
        bitset[2] = b2;
        while(n--> 0){
            String[] strArray = scanner.nextLine().split(" ");
            switch (strArray[0]) {
                case "AND":
                    bitset[Integer.parseInt(strArray[1])].and(bitset[Integer.parseInt(strArray[2])]);
                    break;
                case "OR":
                    bitset[Integer.parseInt(strArray[1])].or(bitset[Integer.parseInt(strArray[2])]);
                    break;
                case "XOR":
                    bitset[Integer.parseInt(strArray[1])].xor(bitset[Integer.parseInt(strArray[2])]);
                    break;
                case "FLIP":
                    bitset[Integer.parseInt(strArray[1])].flip(Integer.parseInt(strArray[2]));
                    break;
                case "SET":
                    bitset[Integer.parseInt(strArray[1])].set(Integer.parseInt(strArray[2]));
                    break;
            }
            System.out.printf("%d %d%n", b1.cardinality(), b2.cardinality());

        }

        }

    }


