import java.io.IOException;
import java.io.*;

public class test {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] argv) throws IOException, InterruptedException {
        Game game = new Game();
        System.out.println(ANSI_YELLOW + "This text is yellow" + ANSI_RESET);
    }
}
