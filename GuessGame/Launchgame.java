import java.util.*;
import java.lang.*;

class Guesser {
    double guessNum;
    int num;

    public int guessNumber() {
        System.out.println("==============================================================");
        System.out.println("Please choose your level:- Easy(E), Medium(M), Hard(H)");
        System.out.println("==============================================================");
        Scanner scan = new Scanner(System.in);
        guessNum = Math.random();
        String choice = scan.next();
        char ch = choice.charAt(0);
        switch (ch)
        {
            case 'E': guessNum = guessNum * 10;
                break;

            case 'M': guessNum = guessNum * 100;
                break;

            case 'H': guessNum = guessNum * 1000;
                break;

            default: System.out.println("==============================================================");
                System.out.println("Please either enter choice in Uppercase or re-enter your choice! ");
                System.out.println("==============================================================");
                System.exit(0);
                break;
        }
        System.out.println("==============================================================");
        System.out.println("System is choosing a number for you :) ");
        System.out.println("==============================================================");
        num = (int) guessNum;
        return num;
    }
}

class Player {
    int pguessNum;

    public int guessNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("==============================================================");
        System.out.println("Player kindly guess the number");
        System.out.println("==============================================================");
        pguessNum = scan.nextInt();
        return pguessNum;
    }
}

class Umpire {

    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;


    public void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessNumber();

    }


    public void collectNumFromPlayer() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();


        numFromPlayer1 = p1.guessNumber();
        numFromPlayer2 = p2.guessNumber();
        numFromPlayer3 = p3.guessNumber();
    }

    void compare() {

        if (numFromGuesser == numFromPlayer1) {
            if (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3) {
                System.out.println("Game tied all three players guessed correctly and won");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("Player 1 and Player2 won the game, player 3 lost");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 1 and Player3 won and player 2 lost ");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            } else {

                System.out.println("Player 1 won the game and everyone else lost");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            }
        } else if (numFromGuesser == numFromPlayer2) {

            if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 2 and Player3 won the game and player 1 lost");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            } else {
                System.out.println("Player 2 won the game and other lost");
                System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
            }
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("Player 3 won the game and everyone else lost ");
            System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
        } else {
            System.out.println("No one guessed correctly! The number which was to be guessed is:- " + numFromGuesser);
            System.out.println("::::::::::: Thank you for playing, have a great one ahead :)  :::::::::::::");
        }
    }

}


public class Launchgame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        Umpire u = new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayer();
        u.compare();
    }
}