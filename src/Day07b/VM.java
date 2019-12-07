package Day07b;

public class VM {
    private int phaseSetting;
    private int[] program;
    private int input;
    private int output;
    boolean first = true;
    boolean halted = false;
    int start = 0;

    public VM(int phaseSetting, int[] program) {
        this.phaseSetting = phaseSetting;
        this.program = program;
    }

    public int runProgram() {
        int raise;

        for (int i = start; i < program.length; i += raise) {
            raise = 1;

            String code = String.valueOf(program[i]);
            for (int j = code.length(); j < 5; j++) {
                code = "0" + code;
            }

            if (code.substring(3).equals("01")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                program[program[i + 3]] = firstValue + secondValue;

                raise = 4;
            }

            if (code.substring(3).equals("02")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                program[program[i + 3]] = firstValue * secondValue;

                raise = 4;
            }

            if (code.substring(3).equals("03")) {
                if (first) {
                    program[program[i + 1]] = phaseSetting;
                    first = false;
                } else {
                    program[program[i + 1]] = input;
                }


                raise = 2;
            }

            if (code.substring(3).equals("04")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                output = firstValue;
                start = i + 2;


                break;
            }

            if (code.substring(3).equals("05")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue > 0) {
                    i = secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("06")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue == 0) {
                    i = secondValue;
                    raise = 0;
                } else {
                    raise = 3;
                }
            }

            if (code.substring(3).equals("07")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue < secondValue) {
                    program[program[i + 3]] = 1;
                } else {
                    program[program[i + 3]] = 0;
                }

                raise = 4;
            }

            if (code.substring(3).equals("08")) {
                int firstValue = code.charAt(2) == '0' ? program[program[i + 1]] : program[i + 1];
                int secondValue = code.charAt(1) == '0' ? program[program[i + 2]] : program[i + 2];
                if (firstValue == secondValue) {
                    program[program[i + 3]] = 1;
                } else {
                    program[program[i + 3]] = 0;
                }

                raise = 4;
            }

            if (program[i] == 99) {
                halted = true;
                break;
            }
        }

        return output;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public boolean isHalted() {
        return halted;
    }
}
