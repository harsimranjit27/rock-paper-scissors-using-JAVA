package com.company;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void playTheGame(String playerName, int totalGames, int playerPoints, int computerPoints, int gamesToPlay)
    {
        Scanner sc = new Scanner(System.in);

            // 0 - Rock
            // 1 - Paper
            // 2 - Scissors
                playerPoints=0;
                computerPoints=0;
            while (totalGames!=0 && (gamesToPlay != (playerPoints + computerPoints))) {
//                playerPoints=0;
//                computerPoints=0;
                System.out.print("It's your turn : ");
                String playerTurn;
                playerTurn=sc.next().toLowerCase();
                System.out.print("Computer chooses : ");
                int computerTurn = ThreadLocalRandom.current().nextInt(0, 4);
                String computerTurnString;

                if(computerTurn==0)
                {
                    computerTurnString="Rock";
                }
                else if(computerTurn==1)
                {
                    computerTurnString="Paper";
                }
                else
                {
                    computerTurnString="Scissors";
                }
//                System.out.println(playerTurn);
                System.out.println(computerTurnString + "\n");
                if((computerTurnString.equals("Rock") && playerTurn.equals("paper")) || (computerTurnString.equals("Paper") && playerTurn.equals("scissors")) || (computerTurnString.equals("Scissors") && playerTurn.equals("rock")))
                {
                    ++playerPoints;
                    System.out.println("You won this round.");
                    System.out.println(playerName + " : " + playerPoints);
                    System.out.println("Computer : "+ computerPoints + "\n");
                    System.out.println("-------------------------------------------------------------");
                }
                else if((computerTurnString.equals("Paper") && playerTurn.equals("rock")) || (computerTurnString.equals("Rock") && playerTurn.equals("scissors")) || (computerTurnString.equals("Scissors") && playerTurn.equals("paper")))
                {
                    ++computerPoints;
                    System.out.println("Computer wins this round.");
                    System.out.println("Computer : "+ computerPoints);
                    System.out.println(playerName + " : "+ playerPoints + "\n");
                    System.out.println("-------------------------------------------------------------");
                }
                else
                {
                    System.out.println(playerName + " : "+ playerPoints );
                    System.out.println("Computer : "+ computerPoints);
                    System.out.println("Draw, no points to anyone\n");
                    System.out.println("-------------------------------------------------------------");
                }


            }
        System.out.print(playerPoints+"-");
        System.out.println(computerPoints);
            if (playerPoints>computerPoints)
            {
                System.out.println("Hurray!!!\t"+playerName+" wins");
            }
            else if (playerPoints==computerPoints){
                System.out.println("Draw...\nBut you played well.");
            }
            else {
                System.out.println("You lost.\nGood try " + playerName + "\nBetter luck next time\n");
            }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nLET'S PLAY ROCK, PAPER, SCISSORS\n");
        int totalGames;
        int playerPoints = 0;
        int computerPoints = 0;
        int gamesToPlay;
        System.out.println("Note :- Type whatever you want to play.\nEg. \"rock\" or \"paper\" or \"scissors\"");
        System.out.println("\nMay I know your name ?");
        String playerName=sc.nextLine();
        System.out.print(playerName+", you want to play best of \"3\" or best of \"5\" ?\n");
        do {
            totalGames = sc.nextInt();
            gamesToPlay=totalGames;
            if(totalGames!=3 && totalGames!=5)
            {
                System.out.print("Please enter either \"3\" or \"5\".\n");
            }
        }
        while((totalGames != 3) && (totalGames != 5));

//      Calling method to run game
        playTheGame(playerName, totalGames, playerPoints, computerPoints, gamesToPlay);

//      Asking to play more
        System.out.println("\n Do you want to play one more game ?(Y/n)");
            String moreGame=sc.next();
        System.out.println("\n");

            if(moreGame.equalsIgnoreCase("Y")) {
                playTheGame(playerName, totalGames, playerPoints, computerPoints, gamesToPlay);
            }
        
    }
}
