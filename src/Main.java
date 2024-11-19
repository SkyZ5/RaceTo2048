import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String[] argv) throws IOException, InterruptedException {
        boolean gameOver = false;
        boolean chosen = false;
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
                    case 'a':
                        game.moveLeft();
                    case 's':
                        game.moveDown();
                    case 'd':
                        game.moveRight();
                }
                game.display();
            }
        }
        if (choice == 2) {
            key.resetTerminal();
        }
    }
}
