package Day11b;

import java.math.BigInteger;

public class PaintRobot {
    private final BigInteger[] program = {new BigInteger("3"), new BigInteger("8"), new BigInteger("1005"), new BigInteger("8"), new BigInteger("338"), new BigInteger("1106"), new BigInteger("0"), new BigInteger("11"), new BigInteger("0"), new BigInteger("0"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("104"), new BigInteger("0"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("10"), new BigInteger("1"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("102"), new BigInteger("1"), new BigInteger("8"), new BigInteger("28"), new BigInteger("1"), new BigInteger("108"), new BigInteger("6"), new BigInteger("10"), new BigInteger("1"), new BigInteger("3"), new BigInteger("7"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("10"), new BigInteger("1"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("8"), new BigInteger("0"), new BigInteger("58"), new BigInteger("2"), new BigInteger("5"), new BigInteger("19"), new BigInteger("10"), new BigInteger("1"), new BigInteger("1008"), new BigInteger("7"), new BigInteger("10"), new BigInteger("2"), new BigInteger("105"), new BigInteger("6"), new BigInteger("10"), new BigInteger("1"), new BigInteger("1007"), new BigInteger("7"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("10"), new BigInteger("1"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1008"), new BigInteger("8"), new BigInteger("0"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("101"), new BigInteger("0"), new BigInteger("8"), new BigInteger("97"), new BigInteger("1006"), new BigInteger("0"), new BigInteger("76"), new BigInteger("1"), new BigInteger("106"), new BigInteger("14"), new BigInteger("10"), new BigInteger("2"), new BigInteger("9"), new BigInteger("9"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("0"), new BigInteger("74"), new BigInteger("3"), new BigInteger("8"), new BigInteger("102"), new BigInteger("-1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("1"), new BigInteger("132"), new BigInteger("1006"), new BigInteger("0"), new BigInteger("0"), new BigInteger("2"), new BigInteger("1104"), new BigInteger("15"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("10"), new BigInteger("1"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1008"), new BigInteger("8"), new BigInteger("0"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("8"), new BigInteger("0"), new BigInteger("162"), new BigInteger("1"), new BigInteger("1005"), new BigInteger("13"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("101"), new BigInteger("0"), new BigInteger("8"), new BigInteger("187"), new BigInteger("1"), new BigInteger("1"), new BigInteger("15"), new BigInteger("10"), new BigInteger("2"), new BigInteger("3"), new BigInteger("9"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("0"), new BigInteger("54"), new BigInteger("3"), new BigInteger("8"), new BigInteger("102"), new BigInteger("-1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("0"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("102"), new BigInteger("1"), new BigInteger("8"), new BigInteger("220"), new BigInteger("1"), new BigInteger("104"), new BigInteger("5"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("102"), new BigInteger("-1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1008"), new BigInteger("8"), new BigInteger("0"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("102"), new BigInteger("1"), new BigInteger("8"), new BigInteger("247"), new BigInteger("1"), new BigInteger("5"), new BigInteger("1"), new BigInteger("10"), new BigInteger("1"), new BigInteger("1109"), new BigInteger("2"), new BigInteger("10"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1008"), new BigInteger("8"), new BigInteger("0"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("1001"), new BigInteger("8"), new BigInteger("0"), new BigInteger("277"), new BigInteger("1006"), new BigInteger("0"), new BigInteger("18"), new BigInteger("3"), new BigInteger("8"), new BigInteger("1002"), new BigInteger("8"), new BigInteger("-1"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("10"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("108"), new BigInteger("1"), new BigInteger("8"), new BigInteger("10"), new BigInteger("4"), new BigInteger("10"), new BigInteger("101"), new BigInteger("0"), new BigInteger("8"), new BigInteger("301"), new BigInteger("2"), new BigInteger("105"), new BigInteger("14"), new BigInteger("10"), new BigInteger("1"), new BigInteger("5"), new BigInteger("1"), new BigInteger("10"), new BigInteger("2"), new BigInteger("1009"), new BigInteger("6"), new BigInteger("10"), new BigInteger("1"), new BigInteger("3"), new BigInteger("0"), new BigInteger("10"), new BigInteger("101"), new BigInteger("1"), new BigInteger("9"), new BigInteger("9"), new BigInteger("1007"), new BigInteger("9"), new BigInteger("1054"), new BigInteger("10"), new BigInteger("1005"), new BigInteger("10"), new BigInteger("15"), new BigInteger("99"), new BigInteger("109"), new BigInteger("660"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("47677546524"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("355"), new BigInteger("0"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("459"), new BigInteger("21102"), new BigInteger("936995299356"), new BigInteger("1"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("366"), new BigInteger("0"), new BigInteger("1106"), new BigInteger("0"), new BigInteger("459"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("0"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("0"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("206312807515"), new BigInteger("1"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("413"), new BigInteger("0"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("459"), new BigInteger("21101"), new BigInteger("206253871296"), new BigInteger("0"), new BigInteger("1"), new BigInteger("21102"), new BigInteger("424"), new BigInteger("1"), new BigInteger("0"), new BigInteger("1106"), new BigInteger("0"), new BigInteger("459"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("0"), new BigInteger("3"), new BigInteger("10"), new BigInteger("104"), new BigInteger("0"), new BigInteger("104"), new BigInteger("0"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("709580554600"), new BigInteger("1"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("447"), new BigInteger("0"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("459"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("868401967464"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("458"), new BigInteger("0"), new BigInteger("0"), new BigInteger("1106"), new BigInteger("0"), new BigInteger("459"), new BigInteger("99"), new BigInteger("109"), new BigInteger("2"), new BigInteger("22102"), new BigInteger("1"), new BigInteger("-1"), new BigInteger("1"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("40"), new BigInteger("2"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("490"), new BigInteger("3"), new BigInteger("21102"), new BigInteger("480"), new BigInteger("1"), new BigInteger("0"), new BigInteger("1106"), new BigInteger("0"), new BigInteger("523"), new BigInteger("109"), new BigInteger("-2"), new BigInteger("2105"), new BigInteger("1"), new BigInteger("0"), new BigInteger("0"), new BigInteger("1"), new BigInteger("0"), new BigInteger("0"), new BigInteger("1"), new BigInteger("109"), new BigInteger("2"), new BigInteger("3"), new BigInteger("10"), new BigInteger("204"), new BigInteger("-1"), new BigInteger("1001"), new BigInteger("485"), new BigInteger("486"), new BigInteger("501"), new BigInteger("4"), new BigInteger("0"), new BigInteger("1001"), new BigInteger("485"), new BigInteger("1"), new BigInteger("485"), new BigInteger("108"), new BigInteger("4"), new BigInteger("485"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("517"), new BigInteger("1101"), new BigInteger("0"), new BigInteger("0"), new BigInteger("485"), new BigInteger("109"), new BigInteger("-2"), new BigInteger("2105"), new BigInteger("1"), new BigInteger("0"), new BigInteger("0"), new BigInteger("109"), new BigInteger("4"), new BigInteger("2101"), new BigInteger("0"), new BigInteger("-1"), new BigInteger("522"), new BigInteger("1207"), new BigInteger("-3"), new BigInteger("0"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("540"), new BigInteger("21102"), new BigInteger("0"), new BigInteger("1"), new BigInteger("-3"), new BigInteger("21201"), new BigInteger("-3"), new BigInteger("0"), new BigInteger("1"), new BigInteger("21202"), new BigInteger("-2"), new BigInteger("1"), new BigInteger("2"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("1"), new BigInteger("3"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("559"), new BigInteger("0"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("564"), new BigInteger("109"), new BigInteger("-4"), new BigInteger("2106"), new BigInteger("0"), new BigInteger("0"), new BigInteger("109"), new BigInteger("5"), new BigInteger("1207"), new BigInteger("-3"), new BigInteger("1"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("587"), new BigInteger("2207"), new BigInteger("-4"), new BigInteger("-2"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("587"), new BigInteger("21202"), new BigInteger("-4"), new BigInteger("1"), new BigInteger("-4"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("655"), new BigInteger("21201"), new BigInteger("-4"), new BigInteger("0"), new BigInteger("1"), new BigInteger("21201"), new BigInteger("-3"), new BigInteger("-1"), new BigInteger("2"), new BigInteger("21202"), new BigInteger("-2"), new BigInteger("2"), new BigInteger("3"), new BigInteger("21102"), new BigInteger("606"), new BigInteger("1"), new BigInteger("0"), new BigInteger("1105"), new BigInteger("1"), new BigInteger("564"), new BigInteger("22102"), new BigInteger("1"), new BigInteger("1"), new BigInteger("-4"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("1"), new BigInteger("-1"), new BigInteger("2207"), new BigInteger("-4"), new BigInteger("-2"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("625"), new BigInteger("21102"), new BigInteger("1"), new BigInteger("0"), new BigInteger("-1"), new BigInteger("22202"), new BigInteger("-2"), new BigInteger("-1"), new BigInteger("-2"), new BigInteger("2107"), new BigInteger("0"), new BigInteger("-3"), new BigInteger("10"), new BigInteger("1006"), new BigInteger("10"), new BigInteger("647"), new BigInteger("22101"), new BigInteger("0"), new BigInteger("-1"), new BigInteger("1"), new BigInteger("21101"), new BigInteger("0"), new BigInteger("647"), new BigInteger("0"), new BigInteger("106"), new BigInteger("0"), new BigInteger("522"), new BigInteger("21202"), new BigInteger("-2"), new BigInteger("-1"), new BigInteger("-2"), new BigInteger("22201"), new BigInteger("-4"), new BigInteger("-2"), new BigInteger("-4"), new BigInteger("109"), new BigInteger("-5"), new BigInteger("2106"), new BigInteger("0"), new BigInteger("0")};
    private final VM brain = new VM(program, this);
    private final int exteriorSize = 100;
    private int positionX = exteriorSize/2 + 1;
    private int positionY = exteriorSize/2 + 1;
    private Color[][] exterior = new Color[exteriorSize][exteriorSize];
    private Direction direction = Direction.UP;

    public void run() {
        exterior[positionY][positionX] = Color.WHITE;
        brain.runProgram();

        for (int i = 0; i < exteriorSize; i++) {
            for (int j = 0; j < exteriorSize; j++) {
                char c = exterior[i][j] == Color.WHITE?'8':'.';
                System.out.print(c);
            }

            System.out.println();
        }
    }

    public int scanColor() {
        int color = 0;

        if (exterior[positionY][positionX] == Color.WHITE) color = 1;

        return color;
    }

    public void moveLeft() {
        switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }

        moveForward();
    }

    public void moveRight() {
        switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }

        moveForward();
    }

    private void moveForward() {
        switch (direction) {
            case UP:
                positionY--;
                break;
            case DOWN:
                positionY++;
                break;
            case LEFT:
                positionX--;
                break;
            case RIGHT:
                positionX++;
                break;
        }
    }

    public void paintWhite() {
        exterior[positionY][positionX] = Color.WHITE;
    }

    public void paintBlack() {
        exterior[positionY][positionX] = Color.BLACK;
    }
}
