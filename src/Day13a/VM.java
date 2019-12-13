package Day13a;

import java.math.BigInteger;
import java.util.Arrays;

public class VM {
    private BigInteger[] program;
    private int relativeBase = 0;
    private Arcade arcade;


    public VM(BigInteger[] program, Arcade arcade) {
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
                setValue(code, i, 3, getValue(code, i, 1).add(getValue(code, i, 2)));

                raise = 4;
            }

            if (code.substring(3).equals("02")) {
                setValue(code, i, 3, getValue(code, i, 1).multiply(getValue(code, i, 2)));

                raise = 4;
            }

            if (code.substring(3).equals("03")) {
                int input = 0;
                setValue(code, i, 1, new BigInteger(String.valueOf(input)));

                raise = 2;
            }

            if (code.substring(3).equals("04")) {
                int value = getValue(code, i, 1).intValue();
                arcade.input(value);

                raise = 2;
            }

            if (code.substring(3).equals("05")) {
                BigInteger firstValue = getValue(code, i, 1);
                BigInteger secondValue = getValue(code, i, 2);
                if (firstValue.compareTo(new BigInteger("0")) == 1) {
                    i = secondValue.intValue();
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("06")) {
                BigInteger firstValue = getValue(code, i, 1);
                BigInteger secondValue = getValue(code, i, 2);
                if (firstValue.equals(new BigInteger("0"))) {
                    i = secondValue.intValue();
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("07")) {
                BigInteger firstValue = getValue(code, i, 1);
                BigInteger secondValue = getValue(code, i, 2);
                if (firstValue.compareTo(secondValue) == -1) {
                    setValue(code, i, 3, new BigInteger("1"));
                } else {
                    setValue(code, i, 3, new BigInteger("0"));
                }

                raise = 4;
            }

            if (code.substring(3).equals("08")) {
                BigInteger firstValue = getValue(code, i, 1);
                BigInteger secondValue = getValue(code, i, 2);
                if (firstValue.compareTo(secondValue) == 0) {
                    setValue(code, i, 3, new BigInteger("1"));
                } else {
                    setValue(code, i, 3, new BigInteger("0"));
                }

                raise = 4;
            }

            if (code.substring(3).equals("09")) {
                relativeBase += getValue(code, i, 1).intValue();

                raise = 2;
            }

            if (code.substring(3).equals("99")) {
                break;
            }
        }
    }

    public BigInteger getValue(String code, int codeIndex, int parameterOffset) {
        BigInteger value = new BigInteger("0");

        switch (code.charAt(3 - parameterOffset)) {
            case '0':
                int index = program[codeIndex + parameterOffset].intValue();
                if (index >= program.length) {
                    value = new BigInteger(String.valueOf(0));
                } else {
                    value = program[program[codeIndex + parameterOffset].intValue()];
                }
                break;
            case '1':
                value = program[codeIndex + parameterOffset];
                break;
            case '2':
                index = program[codeIndex + parameterOffset].intValue() + relativeBase;
                if (index >= program.length) {
                    value = new BigInteger(String.valueOf(0));
                } else {
                    value = program[program[codeIndex + parameterOffset].intValue() + relativeBase];
                }
                break;
        }

        return value;
    }

    public void setValue(String code, int codeIndex, int parameterOffset, BigInteger newValue) {
        int index = 0;

        switch (code.charAt(3 - parameterOffset)) {
            case '0':
                index = program[codeIndex + parameterOffset].intValue();
                break;
            case '2':
                index = program[codeIndex + parameterOffset].intValue() + relativeBase;
                break;
        }

        int growth = index - program.length + 1;
        if (growth > 0) program = Arrays.copyOf(program, program.length + growth);
        program[index] = newValue;
    }
}
