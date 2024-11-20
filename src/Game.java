import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


public class Game {
    private final Square[] squares = new Square[16];
    private boolean canMove = true;
    private boolean lost = false;
    private boolean won = false;

    public Game() {
        for(int i = 0; i < 16; i ++) {
            squares[i] = new Square(0, true);
        }
    }
    public void squareAppear(){
        boolean works = false;
        double percentage = Math.random();
        int randomValue;
        if (percentage > 0.89){
            randomValue = 4;
        }
        else {
            randomValue = 2;
        }
        int[] numbers = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        ArrayList<Integer> arr_numbers = new ArrayList<Integer>();
        for (int i : numbers)
        {
            arr_numbers.add(i);
        }
        if (canMove) {
            while (!(works)) {
                int randomIndex = (int) (Math.random() * arr_numbers.size());
                if (squares[(arr_numbers.get(randomIndex))].isEmpty()) {
                    squares[arr_numbers.get(randomIndex)].giveValue(randomValue);
                    works = true;
                } else {
                    arr_numbers.remove(randomIndex);
                }
                if (arr_numbers.isEmpty()) {
                    works = true;
                }
            }
        }
        else {
            boolean hasEmptyBox = false;
            for (int i = 0; i < 16; i++) {
                if (squares[i].isEmpty()){
                    hasEmptyBox = true;
                }
            }
            if (!hasEmptyBox){
                lost = true;
            }
            else{
                canMove = true;
            }
        }
    }
    public void moveUp() {
        String[] originalValues = new String[16];
        for (int i = 0; i < 16; i++){
            if (squares[i].isEmpty()){
                originalValues[i] = "empty";
            }
            else {
                originalValues[i] = squares[i].getValue() +"";
            }
        }
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "up");
            for (int n = 0; n < 4; n ++) {
                values[i + (n * 4)] = tempValues[n];
            }
        }
        if (Arrays.equals(originalValues, values)){
            canMove = false;
        }
        for (int i = 0; i < 16; i ++) {
            try {
                int value = Integer.parseInt(values[i]);
                squares[i].giveValue(value);
            }
            catch(Exception e){
                squares[i].removeValue();
            }
        }
    }
    public void moveLeft() {
        String[] originalValues = new String[16];
        for (int i = 0; i < 16; i++){
            if (squares[i].isEmpty()){
                originalValues[i] = "empty";
            }
            else {
                originalValues[i] = squares[i].getValue() +"";
            }
        }
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "left");
            for (int n = 0; n < 4; n ++) {
                values[n + (i * 4)] = tempValues[n];
            }
        }
        if (Arrays.equals(originalValues, values)){
            canMove = false;
        }
        for (int i = 0; i < 16; i ++) {
            try {
                int value = Integer.parseInt(values[i]);
                squares[i].giveValue(value);
            }
            catch(Exception e){
                squares[i].removeValue();
            }
        }
    }
    public void moveRight() {
        String[] originalValues = new String[16];
        for (int i = 0; i < 16; i++){
            if (squares[i].isEmpty()){
                originalValues[i] = "empty";
            }
            else {
                originalValues[i] = squares[i].getValue() +"";
            }
        }
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "right");
            for (int n = 0; n < 4; n ++) {
                values[((i + 1) * 4) - 1 - n ] = tempValues[n];
            }
        }
        if (Arrays.equals(originalValues, values)){
            canMove = false;
        }
        for (int i = 0; i < 16; i ++) {
            try {
                int value = Integer.parseInt(values[i]);
                squares[i].giveValue(value);
            }
            catch(Exception e){
                squares[i].removeValue();
            }
        }
    }
    public void moveDown() {
        String[] originalValues = new String[16];
        for (int i = 0; i < 16; i++){
            if (squares[i].isEmpty()){
                originalValues[i] = "empty";
            }
            else {
                originalValues[i] = squares[i].getValue() +"";
            }
        }
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "down");
            for (int n = 0; n < 4; n ++) {
                values[15 - i - (n * 4)] = tempValues[n];
            }
        }
        if (Arrays.equals(originalValues, values)){
            canMove = false;
        }
        for (int i = 0; i < 16; i ++) {
            try {
                int value = Integer.parseInt(values[i]);
                squares[i].giveValue(value);
            }
            catch(Exception e){
                squares[i].removeValue();
            }
        }
    }
    public String[] createRow(int integer, String str) {
        String[] strings = new String[4];
        if (str.equals("up")) {
            for (int i = integer; i < 16; i += 4) {
                if (squares[i].isEmpty()) {
                    strings[i / 4] = "empty";
                } else {
                    strings[i / 4] = squares[i].getValue() + "";
                }
            }
        }
        else if (str.equals("left")) {
            int n = 0;
            for (int i = integer * 4; i < (integer * 4) + 4; i ++) {
                if (squares[i].isEmpty()) {
                    strings[n] = "empty";
                } else {
                    strings[n] = squares[i].getValue() + "";
                }
                n++;
            }
        }
        else if (str.equals("right")) {
            int n = 0;
            for (int i = ((integer * 4) + 3); i >= integer * 4; i --) {
                if (squares[i].isEmpty()) {
                    strings[n] = "empty";
                }
                else {
                    strings[n] = squares[i].getValue() + "";
                }
                n ++;
            }
        }
        else if (str.equals("down")) {
            int n = 0;
            for (int i = 15 - integer; i >= 3 - integer; i -= 4) {
                if (squares[i].isEmpty()) {
                    strings[n] = "empty";
                }
                else {
                    strings[n] = squares[i].getValue() + "";
                }
                n++;
            }
        }
        ArrayList<String> arr_strings = new ArrayList<String>();
        for (String i : strings)
        {
            arr_strings.add(i);
        }
        return combine(arr_strings);
    }
    public String[] combine(ArrayList<String> arrayList){
        while(arrayList.contains("empty")) {
            arrayList.remove("empty");
        }
        for(int i = 0; i < arrayList.toArray().length; i ++) {
            try {
                if (Integer.parseInt(arrayList.get(i)) == Integer.parseInt(arrayList.get(i + 1))){
                    arrayList.set(i, (Integer.parseInt(arrayList.get(i)) * 2) + "");
                    arrayList.remove(i + 1);
                }
            }
            catch (Exception _) {
            }
        }
        String[] finalArray = new String[4];
        for (int i = 0; i < 4;i ++) {
            try {
                finalArray[i] = arrayList.get(i);
            }
            catch (Exception e) {
                finalArray[i] = "empty";
            }
        }
        return finalArray;
    }
    public void display(){
        int[][] board = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        for(int i = 0; i < 4; i++){

            for(int n = 0; n < 4; n ++){
                board[i][n] = squares[i * 4 + n].getValue();
            }
        }
        printBoard(board);
    }
    public void printBoard(int[][] board) {
        for (int i = 0; i < 4; i ++) {
            System.out.println("+-----+-----+-----+-----+");
            System.out.print("|");
            for ( int n = 0; n < 4; n ++){
                System.out.print(String.format("%4d", board[i][n]) + " ");
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("+-----+-----+-----+-----+");
    }
    public void clearConsole() {
        for (int i = 0; i < 100; i ++) {
            System.out.println();
        }
    }
    public void moved(){
        clearConsole();
        squareAppear();
        display();
    }
    public int isGameOver() {
        if (lost) {
            return 1;
        }
        for (int i = 0; i < 16; i ++) {
            if (squares[i]. getValue() == 2048) {
                return 2;
            }
        }
            return 0;
    }
    public void resetBoard() {
        for(int i = 0; i < 16; i ++){
            squares[i].removeValue();
        }
        moved();
    }
}
