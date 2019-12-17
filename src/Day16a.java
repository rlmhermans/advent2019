import java.time.LocalTime;
import java.util.Arrays;

public class Day16a {


    public static void main(String[] args) {
        String input = "03036732577212944063491565474664";
        //input = input.repeat(10000); //part 2
        char[] chars = input.toCharArray();
        int[] numbers = new int[chars.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        int index = 0;
        for (int i = 0; i < 7; i++) {
            index *= 10;
            index += numbers[i];
        }

        int[] pattern = {0, 1, 0, -1};

        for (int phase = 0; phase < 100; phase++) {
            System.out.println("Phase " + (phase + 1) + " start: " + LocalTime.now());

            int[] newArray = new int[numbers.length];

            for (int numberIndex = 0; numberIndex < numbers.length; numberIndex++) {
                int patternNumberTimes = numberIndex + 1;
                int currentPatternNumber = 0;
                int[] tempArray = new int[numbers.length];

                for (int i = numberIndex; i < numbers.length; i++) {
                    if (patternNumberTimes == numberIndex + 1) {
                        patternNumberTimes = 0;
                        currentPatternNumber++;
                        if (currentPatternNumber > pattern.length - 1) currentPatternNumber = 0;
                    }
                    tempArray[i] = numbers[i] * pattern[currentPatternNumber];
                    patternNumberTimes++;
                }
                newArray[numberIndex] = Math.abs(Arrays.stream(tempArray).sum()) % 10;
            }
            numbers = newArray;
        }

        for (int i = 0; i < 8; i++) { //part 1
        //for (int i = index; i < index + 8; i++) { //part 2
            System.out.print(numbers[i]);
        }
    }
}