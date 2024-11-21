import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] argv) throws IOException, InterruptedException {
        boolean gameOver = false;
        boolean chosen = false;
        boolean won = false;
        boolean lost = false;
        int gameStatus = 0;
        int choice = '\0';
        Game game = new Game();
        Scanner s = new Scanner(System.in);
        IsKeyPressed key = new IsKeyPressed();
        System.out.println("Hello welcome to 2048, press w,a,s,d in order to move. Reach 2048 to win!");
        while (!chosen) {
            System.out.println("1. If you are in school(Have to press enter after every move)\n2. If you are on personal computer(Unbuffered input)");
            try {
                choice = Integer.parseInt(s.nextLine());
                if (choice == 1) {
                    chosen = true;
                }
                if (choice == 2){
                    key.setRawMode();
                }
            } catch (Exception e) {
                System.out.println("Not a valid input or you cannot enter raw mode");
            }
        }
        game.squareAppear();
        game.display();
        while(!gameOver){
            char move = key.getKeyPress();
            if (move != '\0'){
                System.out.println(move);
                switch (move) {
                    case 'w':
                        game.moveUp();
                        game.moved();
                        break;
                    case 'a':
                        game.moveLeft();
                        game.moved();
                        break;
                    case 's':
                        game.moveDown();
                        game.moved();
                        break;
                    case 'd':
                        game.moveRight();
                        game.moved();
                        break;
                }
            }
            gameStatus = game.isGameOver();
            if (gameStatus == 2) {
                won = true;
                System.out.println("YOU WON CONGRATS :D");
                gameOver = true;
            }
            else if (gameStatus == 1) {
                lost = true;
                boolean validInput = false;
                System.out.println("You lost :(");
                int restart = 0;
                while (!validInput) {
                    System.out.print("If you want to play again return 1, else return 0: ");
                    try {
                        restart = Integer.parseInt(s.nextLine());
                        validInput = true;
                    } catch (Exception e) {
                    }
                }
                if (restart != 1) {
                    gameOver = true;
                }
                else {
                    game.resetBoard();
                    gameStatus = 0;
                }
            }
        }
        if (choice == 2) {
            key.resetTerminal();
        }
    }
}
