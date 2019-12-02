public class Day02b {
    public static void main(String[] args) {
        final int[] inputProgram = {1, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 1, 9, 19, 1, 13, 19, 23, 2, 23,
                9, 27, 1, 6, 27, 31, 2, 10, 31, 35, 1, 6, 35, 39, 2, 9, 39, 43, 1, 5, 43, 47, 2, 47, 13, 51, 2, 51, 10,
                55, 1, 55, 5, 59, 1, 59, 9, 63, 1, 63, 9, 67, 2, 6, 67, 71, 1, 5, 71, 75, 1, 75, 6, 79, 1, 6, 79, 83, 1,
                83, 9, 87, 2, 87, 10, 91, 2, 91, 10, 95, 1, 95, 5, 99, 1, 99, 13, 103, 2, 103, 9, 107, 1, 6, 107, 111,
                1, 111, 5, 115, 1, 115, 2, 119, 1, 5, 119, 0, 99, 2, 0, 14, 0};

        int verb = 0;
        int noun = 0;

        for (int i = 0; i < 100; i++) {
            int result = 0;

            for (int j = 0; j < 100; j++) {
                int[] program = inputProgram.clone();
                program[1] = i;
                program[2] = j;
                result = runProgram(program);

                if (result == 19690720) {
                    verb = j;
                    break;
                }
            }

            if (result == 19690720) {
                noun = i;
                break;
            }
        }

        System.out.println(100 * noun + verb);
    }

    public static int runProgram(int[] program) {
        for (int i = 0; i < program.length; i += 4) {
            if (program[i] == 1) {
                int firstInputLocation = program[i + 1];
                int secondInputLocation = program[i + 2];
                int outputLocation = program[i + 3];

                program[outputLocation] = program[firstInputLocation] + program[secondInputLocation];
            }

            if (program[i] == 2) {
                int firstInputLocation = program[i + 1];
                int secondInputLocation = program[i + 2];
                int outputLocation = program[i + 3];

                program[outputLocation] = program[firstInputLocation] * program[secondInputLocation];
            }

            if (program[i] == 99) {
                break;
            }
        }

        return program[0];
    }
}