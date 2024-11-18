import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) throws Exception {
        boolean gameOver = false;
        Game game = new Game();
        IsKeyPressed isKeyPressed = new IsKeyPressed();
        while(!gameOver){
            System.out.println(isKeyPressed.isKeyPressed());
        }
    }
}
