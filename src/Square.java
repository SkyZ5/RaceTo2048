public class Square {
    private int value;
    private boolean empty;

    public Square(int value, boolean empty) {
        this.value = value;
        this.empty = empty;
    }

    public void giveValue(int value) {
        this.value = value;
        empty = false;
    }
    public void removeValue() {
        value = 0;
    }
    public boolean isEmpty() {
        return empty;
    }
}
