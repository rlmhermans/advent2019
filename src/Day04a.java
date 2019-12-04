import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day04a {
    public static void main(String[] args) {
        ArrayList<Integer> possibleCodes = new ArrayList<>();

        for (int i = 152085; i < 670283; i++) {
            String code = "" + i;

            boolean doubleFound = false;
            boolean onlyAscending = true;
            int previous = -1;

            for (int j = 0; j < 6; j++) {
                int current = Integer.parseInt("" + code.charAt(j));
                if(previous == current ) doubleFound = true;
                if(current < previous) onlyAscending = false;

                previous = current;
            }

            if(doubleFound && onlyAscending) {
                possibleCodes.add(i);
            }
        }

        System.out.println(possibleCodes.size());
    }
}
