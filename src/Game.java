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
        System.out.println(Arrays.toString(createRow(0)));
        System.out.println(Arrays.toString(createRow(1)));
        System.out.println(Arrays.toString(createRow(2)));
        System.out.println(Arrays.toString(createRow(3)));
    }
    public String[] createRow(int integer) {
        String[] strings = new String[4];
        for (int i = 0; i < 15; i += 4) {
            if (squares[i].isEmpty()){
                strings[i / 4] = "empty";
            }
            else {
                strings[i / 4] = squares[i].getValue() + "";
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
}
