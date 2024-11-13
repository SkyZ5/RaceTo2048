import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.ArrayList;


public class Game {
    private Square[] squares = new Square[16];

    public Game() {
        for(int i = 0; i < 16; i ++) {
            squares[i] = new Square(0, true);
        }
    }
    public void squareAppear(){
        Boolean works = false;
        double percentage = Math.random();
        int randomValue;
        if (percentage > 0.89){
            randomValue = 4;
        }
        else {
            randomValue = 2;
        }
        while (!(works)){
            int[] numbers = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            ArrayList<Integer> arr_numbers = new ArrayList<Integer>();
            for (int i : numbers)
            {
                arr_numbers.add(i);
            }
            int randomIndex = (int) (Math.random() * numbers.length);
            if (squares[(arr_numbers.get(randomIndex))].isEmpty()) {
                squares[arr_numbers.get(randomIndex)].giveValue(randomValue);
                works = true;
                System.out.println(randomIndex + ", " + randomValue);
            }
            else {
                arr_numbers.remove(randomIndex);
            }
        }
    }
    public void moveUp() {
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "up");
            for (int n = 0; n < 4; n ++) {
                values[n + (i * 4)] = tempValues[n];
            }
        }
        System.out.println(Arrays.toString(values));
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
        String[] values = new String[16];
        for (int i = 0; i < 4; i ++) {
            String[] tempValues = createRow(i, "left");
            for (int n = 0; n < 4; n ++) {
                values[n + (i * 4)] = tempValues[n];
            }
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
        System.out.println(Arrays.toString(createRow(0,"right")));
        System.out.println(Arrays.toString(createRow(1,"right")));
        System.out.println(Arrays.toString(createRow(2,"right")));
        System.out.println(Arrays.toString(createRow(3,"right")));
    }
    public void moveDown() {
        System.out.println(Arrays.toString(createRow(0,"down")));
        System.out.println(Arrays.toString(createRow(1,"down")));
        System.out.println(Arrays.toString(createRow(2,"down")));
        System.out.println(Arrays.toString(createRow(3,"down")));
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
            for (int i = 15 - (integer * 4); i >= 15 - (integer * 4 + 3); i --) {
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
            catch (Exception e) {
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
    public void display(int integer){
        String[] strings = new String[4];
        int n = 0;
        for (int i = integer * 4; i < (integer * 4) + 4; i ++) {
            if (squares[i].isEmpty()) {
                strings[n] = "empty";
            } else {
                strings[n] = squares[i].getValue() + "";
            }
            n++;
        }
        ArrayList<String> arr_strings = new ArrayList<String>();
        for (String i : strings)
        {
            arr_strings.add(i);
        }
        System.out.println(arr_strings);
    }
}
