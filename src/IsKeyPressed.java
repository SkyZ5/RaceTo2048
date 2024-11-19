import java.io.IOException;

public class IsKeyPressed {
    public char getKeyPress() throws IOException{
        if (System.in.available() > 0) {
            return (char) System.in.read();
        }
        return '\0';
    }
    public void setRawMode() throws IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "stty raw -echo </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }
    public void resetTerminal() throws  IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "stty sane </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();
    }
}