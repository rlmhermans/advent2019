import java.util.ArrayList;
import java.util.HashMap;

public class Day04b {
    public static void main(String[] args) {
        ArrayList<Integer> possibleCodes = new ArrayList<>();

        for (int i = 152085; i < 670283; i++) {
            String code = "" + i;

            boolean doubleFound = false;
            boolean onlyAscending = true;
            int previous = -1;
            HashMap<Integer, Integer> numbers = new HashMap<>();

            for (int j = 0; j < 6; j++) {
                int current = Integer.parseInt("" + code.charAt(j));
                if(numbers.containsKey(current)) {
                    numbers.replace(current, numbers.get(current) + 1);
                } else {
                    numbers.put(current, 1);
                }

                if(current < previous) onlyAscending = false;

                previous = current;
            }

            doubleFound = numbers.containsValue(2);

            if(doubleFound && onlyAscending) {
                possibleCodes.add(i);
            }
        }

        System.out.println(possibleCodes.size());
    }
}
