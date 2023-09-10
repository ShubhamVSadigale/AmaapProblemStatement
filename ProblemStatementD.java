import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProblemStatementD {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int dice1[] = new int[6];
        int dice2[] = new int[6];
        String player1, player2;

        System.out.print("Enter the name of 1st player : ");
        player1 = sc.nextLine();

        System.out.print("Enter the name of the 2nd player : ");
        player2 = sc.nextLine();

        for(int i=0 ; i<6 ; i++){
            dice1[i] = r.nextInt(6) + 1;
        }

        for(int i=0 ; i<6 ; i++){
            dice2[i] = r.nextInt(6) + 1;
        }

        System.out.println("Below are the dice values for "+ player1 +" : ");
        for(int i=0 ; i<dice1.length ; i++){
            System.out.print("  "+dice1[i]);
        }

        System.out.println();
        String p1Result = evaluate(dice1);
        System.out.println("Combination for "+ player1 +" is "+p1Result);
        
        System.out.println();
        System.out.println("Below are the dice values for "+ player2 +" : ");
        for(int i=0 ; i<dice2.length ; i++){
            System.out.print("  "+dice2[i]);
        }

        System.out.println();
        String p2Result = evaluate(dice2);
        System.out.println("Combination for "+ player2 +" is "+p2Result);

        String winnerPlayer = findWinner(dice1, dice2, p1Result, p2Result, player1, player2);

        System.out.println();
        System.out.println("Winner is "+winnerPlayer+"..!!");

    }

    public static String evaluate(int dice[]){
        int[] counts = new int[6];
        for (int i = 0; i < dice.length; i++) {
            int die = dice[i];
            counts[die - 1]++;
        }

        for(int i=0 ; i<counts.length ; i++){
            if(counts[i] == 5){
                return "Five of kind";
            }
            else if(counts[i] == 4){
                return "Four of kind";
            }
            else if(counts[i] == 3){
                for(int j=0 ; j<counts.length ; j++){
                    if(counts[i] == 2){
                        return "Three of kind and a pair";
                    }
                }
                return "Three of kind";
            }
            else if(counts[i] == 2){
                return "A pair";
            }          
        }

        return "Highest Number";
    }


    public static String findWinner(int[] dice1, int[] dice2, String p1Result, String p2Result, String player1, String player2) {
        if (!p1Result.equals(p2Result)) {
            return p1Result.compareTo(p2Result) > 0 ? player1: player2;
        }
        int player1Value = findMax(dice1);
        int player2Value = findMax(dice2);

        if (player1Value != player2Value) {
            return player1Value > player2Value ? player1 : player2;
        }
        else if(player1Value == player2Value){
            return "It's a tie";
        }
        else{
            return player2;
        }
    }

    public static int findMax(int[] dice) {
        int maxValue = 0;
        for (int die : dice) {
            if (die > maxValue) {
                maxValue = die;
            }
        }
        return maxValue;
    }
}
