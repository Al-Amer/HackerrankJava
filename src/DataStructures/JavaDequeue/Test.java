package java.DataStructures.JavaDequeue;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if(i == 0){
                deque.add(num);
                maxUnique++;
            }else{
                if(deque.size() == m){
                    deque.removeFirst();
                }
                if(!deque.contains(num) && maxUnique<m){
                    maxUnique++;
                }
                deque.addLast(num);
            }
        }
        System.out.println(""+maxUnique);
        System.out.println(deque);



    }
}
