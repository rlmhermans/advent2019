package Day09a;

import java.math.BigInteger;
import java.util.Scanner;

public class VM {
    private BigInteger[] program;
    int relativeBase = 0;

    public VM(BigInteger[] program) {
        this.program = program;
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
                Scanner inputReader = new Scanner(System.in);
                System.out.print("Run what program?");
                String input = inputReader.nextLine();
                setValue(code, i, 1, new BigInteger(input));

                raise = 2;
            }

            if (code.substring(3).equals("04")) {
                System.out.println(getValue(code, i, 1));

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
                value = program[program[codeIndex + parameterOffset].intValue()];
                break;
            case '1':
                value = program[codeIndex + parameterOffset];
                break;
            case '2':
                value = program[program[codeIndex + parameterOffset].intValue() + relativeBase];
                break;
        }

        return value;
    }

    public void setValue(String code, int codeIndex, int parameterOffset, BigInteger newValue) {
        switch (code.charAt(3 - parameterOffset)) {
            case '0':
                program[program[codeIndex + parameterOffset].intValue()] = newValue;
                break;
            case '2':
                program[program[codeIndex + parameterOffset].intValue() + relativeBase] = newValue;
                break;
        }
    }
}
