package java.DataStructures.JavaComparator;

import java.util.*;

class Players {
    String name;
    int score;

    public Players(String name, Integer score) {
        this.name = name;
        this.score = score;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getScore() {return score;}
    public void setScore(Integer score) {this.score = score;}
    @Override
    public String toString() {return   name + " " + score ;}
}
class PrayerSortingComparator implements Comparator<Players>{
    @Override
    public int compare(Players o1, Players o2) {
        int NameCompare = o1.getName().compareTo(o2.getName());
    //    int ScoreCompare = o1.getScore().compareTo(o2.getScore());
        int ScoreCompare = o2.getScore().compareTo(o1.getScore());
        return (ScoreCompare == 0) ? NameCompare
                : ScoreCompare;
    }

    }


    public class Solution {

    public static void main(String[] args) {
        List<Players> inputListOpPlayer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
                scanner.nextLine();
        while (n > 0){
            String playerName = scanner.next();
            int playerScore = scanner.nextInt();
        //    scanner.nextLine();
            Players players= new Players(playerName, playerScore);
            inputListOpPlayer.add(players);
            n--;
        }

        Collections.sort(inputListOpPlayer, new PrayerSortingComparator());
      //  Iterator<Players> listOfPlayers = inputListOpPlayer.iterator();
        for(Players player:inputListOpPlayer){
            System.out.println(player);
        }

    }


}
