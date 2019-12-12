package Day12b;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Day12b {
    public static void main(String[] args) throws FileNotFoundException {
        int xSteps = calculateFor(0);
        int ySteps = calculateFor(1);
        int zSteps = calculateFor(2);

        BigInteger bigX = new BigInteger(String.valueOf(xSteps));
        BigInteger bigY = new BigInteger(String.valueOf(ySteps));
        BigInteger bigZ = new BigInteger(String.valueOf(zSteps));
        System.out.println(LCM(LCM(bigX, bigY), bigZ));
    }

    private static int calculateFor(int axis) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/Day12b/MoonInput.txt"));
        ArrayList<Moon> moons = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            line = line.substring(1, line.length() - 1);
            String[] positions = line.split(", ");
            int startPos = Integer.parseInt(positions[axis].substring(2));
            moons.add(new Moon(startPos));
        }

        String startPosition = "";
        boolean same = false;
        int counter = 0;

        while (!same) {
            counter++;
            for (Moon current : moons) {
                for (Moon other : moons) {
                    if (current != other) {
                        current.processGravityInfluenceBy(other);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Moon current : moons) {
                current.move();
                sb.append(current);
            }

            String position = sb.toString();

            if (position.equals(startPosition)) {
                same = true;
            }

            if(startPosition.isEmpty()) startPosition = position;
        }

        return counter;
    }

    public static BigInteger LCM(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(GCD(a, b));
    }

    public static BigInteger GCD(BigInteger a, BigInteger b) {
        if (b.intValue() == 0) {
            return a;
        } else {
            return (GCD(b, a.mod(b)));
        }
    }
}
