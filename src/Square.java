// Square method saves the information of each square of the board in a object
public class Square {

    // The value of each square
    private int value;

    // Boolean to keep track of if the square is empty
    private boolean empty;

    // Constructor sets the value and boolean of empty
    public Square(int value, boolean empty) {
        this.value = value;
        this.empty = empty;
    }

    // Method that returns the value
    public void giveValue(int value) {
        this.value = value;
        empty = false;
    }

    // Method that removes value and sets empty back to true basically resetting it
    public void removeValue() {
        empty = true;
        value = 0;
    }

    // Method that returns the value of empty
    public boolean isEmpty() {
        return empty;
    }

    // Method that returns the value
    public int getValue(){
        return value;
    }
}
