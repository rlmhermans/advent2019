package Day07b;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Day07 {
    static final int[] inputProgram = {3, 8, 1001, 8, 10, 8, 105, 1, 0, 0, 21, 42, 51, 60, 77, 94, 175, 256, 337, 418, 99999, 3, 9, 1001, 9, 4, 9, 102, 5, 9, 9, 1001, 9, 3, 9, 102, 5, 9, 9, 4, 9, 99, 3, 9, 102, 2, 9, 9, 4, 9, 99, 3, 9, 1001, 9, 3, 9, 4, 9, 99, 3, 9, 101, 4, 9, 9, 1002, 9, 4, 9, 101, 5, 9, 9, 4, 9, 99, 3, 9, 1002, 9, 5, 9, 101, 3, 9, 9, 102, 2, 9, 9, 4, 9, 99, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 99, 3, 9, 1001, 9, 2, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 3, 9, 1001, 9, 2, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 99, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 1001, 9, 2, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 99, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 3, 9, 1001, 9, 1, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 99, 3, 9, 1001, 9, 2, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 101, 2, 9, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 102, 2, 9, 9, 4, 9, 3, 9, 1002, 9, 2, 9, 4, 9, 3, 9, 101, 1, 9, 9, 4, 9, 99};

    public static void main(String[] args) {
        int highestOutput = 0;
        ArrayList<Integer> combination = new ArrayList<>(5);
        combination.add(9);
        combination.add(8);
        combination.add(7);
        combination.add(6);
        combination.add(5);

        for (int i = 0; i < 100; i++) {
            int input = 0;
            int output;
            Collections.shuffle(combination);

            ArrayList<VM> amplifiers = new ArrayList<>();
            for (int setting : combination) {
                amplifiers.add(new VM(setting, inputProgram.clone()));
            }

            for (int j = 0; j < 5; j++) {
                VM amplifier = amplifiers.get(j);
                amplifier.setInput(input);
                output = amplifier.runProgram();

                if (j == 4) {
                    if (amplifier.isHalted()) {
                        if (output > highestOutput) {
                            highestOutput = output;
                        }
                    } else {
                        j = -1;
                    }
                }

                input = output;
            }

        }

        System.out.println(highestOutput);
    }
}
