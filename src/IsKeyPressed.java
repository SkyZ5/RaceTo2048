import java.io.IOException;

// Used to check if key is pressed
public class IsKeyPressed {
    public char getKeyPress() throws IOException{
        if (System.in.available() > 0) {
            return (char) System.in.read();
        }
        return '\0';
    }

    // DOES NOT WORK
    // Suppose to enable raw mode for unbuffered input
    public void setRawMode() throws IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "stty raw -echo </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }

    // DOES NOT WORK
    // Suppose to reset terminal settings after playing the game
    public void resetTerminal() throws  IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "stty sane </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }
}