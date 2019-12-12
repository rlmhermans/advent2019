package Day12a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day12a {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/Day12a/MoonInput.txt"));
        ArrayList<Moon> moons = new ArrayList<>();
        while(fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            line = line. substring(1, line.length()-1);
            String[] positions = line.split(", ");
            int x = Integer.parseInt(positions[0].substring(2));
            int y = Integer.parseInt(positions[1].substring(2));
            int z = Integer.parseInt(positions[2].substring(2));
            moons.add(new Moon(x, y, z));
        }

        for (int i = 0; i < 1000; i++) {
            for(Moon current : moons) {
                for(Moon other : moons) {
                    if(current != other) {
                        current.processGravityInfluenceBy(other);
                    }
                }
            }

            for(Moon current : moons) {
                current.move();
            }
        }

        int total = 0;

        for(Moon m : moons) {
            total += m.getTotalEnergy();
        }

        System.out.println(total);
    }
}
