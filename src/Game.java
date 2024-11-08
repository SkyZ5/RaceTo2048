import java.util.Arrays;
import java.util.ArrayList;


public class Game {
    private Square[] squares = new Square[16];

    public Game() {
        for(int i = 0; i < 16; i ++) {
            squares[i] = new Square(0, true);
        }
        System.out.println(Arrays.toString(squares));
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
            int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
            // int randomIndex = (int) (Math.random() * numbers.length);
            int randomIndex = 1;
            if (squares[numbers[randomIndex]].isEmpty()) {
                squares[numbers[randomIndex]].giveValue(randomValue);
                works = true;
                System.out.println(randomIndex + ", " + randomValue);
            }
            else {
                ArrayList<Integer> arr_new = new ArrayList<Integer>();
                for (int i : numbers)
                {
                    arr_new.add(i);
                }
                arr_new.remove(randomIndex);
            }
        }

    }
}
