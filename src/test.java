import java.io.IOException;

public class test {
    public static void main(String[] argv) throws IOException, InterruptedException {
        Game game = new Game();
        game.squareAppear();
        game.squareAppear();
        game.squareAppear();
        game.display();
        game.moveUp();
        game.display();
    }
}
