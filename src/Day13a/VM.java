package Day13a;

import java.util.Arrays;

public class VM {
    private long[] program;
    private int relativeBase = 0;
    private Arcade arcade;


    public VM(long[] program, Arcade arcade) {
        this.program = program;
        this.arcade = arcade;
    }

    public void runProgram() {
        int raise;

        for (int i = 0; i < program.length; i += raise) {
            raise = 1;

            String code = String.valueOf(program[i]);
            for (int j = code.length(); j < 5; j++) {
                code = "0" + code;
            }

            if (code.substring(3).equals("01")) {
                setValue(code, i, 3, getValue(code, i, 1) + getValue(code, i, 2));

                raise = 4;
            }

            if (code.substring(3).equals("02")) {
                setValue(code, i, 3, getValue(code, i, 1) * getValue(code, i, 2));

                raise = 4;
            }

            if (code.substring(3).equals("03")) {
//                int input = arcade.readStick();
//                setValue(code, i, 1, input);

                raise = 2;
            }

            if (code.substring(3).equals("04")) {
                int value = (int)getValue(code, i, 1);
                arcade.input(value);

                raise = 2;
            }

            if (code.substring(3).equals("05")) {
                long firstValue = getValue(code, i, 1);
                long secondValue = getValue(code, i, 2);
                if (firstValue != 0) {
                    i = (int)secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("06")) {
                long firstValue = getValue(code, i, 1);
                long secondValue = getValue(code, i, 2);
                if (firstValue == 0) {
                    i = (int)secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("07")) {
                long firstValue = getValue(code, i, 1);
                long secondValue = getValue(code, i, 2);
                if (firstValue < secondValue) {
                    setValue(code, i, 3, 1);
                } else {
                    setValue(code, i, 3, 0);
                }

                raise = 4;
            }

            if (code.substring(3).equals("08")) {
                long firstValue = getValue(code, i, 1);
                long secondValue = getValue(code, i, 2);
                if (firstValue == secondValue) {
                    setValue(code, i, 3, 1);
                } else {
                    setValue(code, i, 3, 0);
                }

                raise = 4;
            }

            if (code.substring(3).equals("09")) {
                relativeBase += getValue(code, i, 1);

                raise = 2;
            }

            if (code.substring(3).equals("99")) {
                break;
            }
        }
    }

    public long getValue(String code, int codeIndex, int parameterOffset) {
        long value = 0;

        switch (code.charAt(3 - parameterOffset)) {
            case '0':
                long index = program[codeIndex + parameterOffset];
                if (index >= program.length) {
                    value = 0;
                } else {
                    value = program[(int) program[codeIndex + parameterOffset]];
                }
                break;
            case '1':
                value = program[codeIndex + parameterOffset];
                break;
            case '2':
                index = program[codeIndex + parameterOffset] + relativeBase;
                if (index >= program.length) {
                    value = 0;
                } else {
                    value = program[(int) program[codeIndex + parameterOffset] + relativeBase];
                }
                break;
        }

        return value;
    }

    public void setValue(String code, int codeIndex, int parameterOffset, long newValue) {
        int index = 0;

        switch (code.charAt(3 - parameterOffset)) {
            case '0':
                index = (int) program[codeIndex + parameterOffset];
                break;
            case '2':
                index = (int) program[codeIndex + parameterOffset] + relativeBase;
                break;
        }

        int growth = index - program.length + 1;
        if (growth > 0) program = Arrays.copyOf(program, program.length + growth);
        program[index] = newValue;
    }
}
