import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

    public static void main(String[] argv) throws Exception {
        Game game = new Game();
        game.squareAppear();
        game.squareAppear();
        game.squareAppear();
        game.display();
//
//        game.display(0);
//        game.display(1);
//        game.display(2);
//        game.display(3);
//        System.out.println();
//        game.moveDown();
//        game.display(0);
//        game.display(1);
//        game.display(2);
//        game.display(3);
//        System.out.println();
//        game.moveUp();
//        game.display(0);
//        game.display(1);
//        game.display(2);
//        game.display(3);

    }
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 4; i ++) {
            for ( int n = 0; n < 4; n ++){
                System.out.print(String.format("4%d", board[i][n]) + " ");
            }
        }
    }
}
