package Day10b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day10b {
    private static final String asteroidField = ".###..#......###..#...##.#..#.##..###..#...#.##.#.#.##.#..##.#.###.##.#..#...####.#.##..##..#.###.#.####.##.#######..#######..##..##.#.###.##.#...##.##.####..###....####.####.##########.########.#...##.####..#.#..#.#.#.#.##.###.###..#.#..##...#..#.####..###.#.#...###....###..###..#.###..###.#.###.#...###.##.#.##.#...#..##......#.#.##..#...#.#.###.##.#..##...#..#.#.####..###..##.##..##.######.###.####....######..###.#####.#.#.#.#####.##.#.###.###.##.##..##.##.#..#..#..#.####.#.#..#.#.#.##.##########..######.##......#.#.####.";

    public static void main(String[] args) {
        int lineSize = 23;
        ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();

        for (int i = 0; i < asteroidField.length() / lineSize; i++) {
            for (int j = 0; j < lineSize; j++) {
                if (asteroidField.charAt(j + i * lineSize) == '#') {
                    asteroids.add(new Asteroid(j, i));
                }
            }
        }

        int most = 0;
        HashMap<Float, Asteroid> mostAngleSet = null;

        for (Asteroid a : asteroids) {
            HashMap<Float, Asteroid> asteroidAngles = new HashMap<>();
            for (Asteroid b : asteroids) {
                if (a != b) asteroidAngles.putIfAbsent(a.getAngle(b), b);
            }

            if (most < asteroidAngles.size()) {
                most = asteroidAngles.size();
                mostAngleSet = asteroidAngles;
            }
        }

        ArrayList<Float> sortedList = new ArrayList(mostAngleSet.keySet());
        Collections.sort(sortedList);
        System.out.println(mostAngleSet.get(sortedList.get(199)));
    }
}
