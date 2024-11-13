public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.squareAppear();

        game.display(0);
        game.display(1);
        game.display(2);
        game.display(3);
        //System.out.println();
        //game.moveUp();
        System.out.println();
        game.moveLeft();
        //System.out.println();
        //game.moveRight();
        //System.out.println();
        //game.moveDown();
        game.display(0);
        game.display(1);
        game.display(2);
        game.display(3);
    }
}