package Day10a;

import java.util.ArrayList;
import java.util.HashSet;

public class Day10a {
    private static final String asteroidField = ".###..#......###..#...##.#..#.##..###..#...#.##.#.#.##.#..##.#.###.##.#..#...####.#.##..##..#.###.#.####.##.#######..#######..##..##.#.###.##.#...##.##.####..###....####.####.##########.########.#...##.####..#.#..#.#.#.#.##.###.###..#.#..##...#..#.####..###.#.#...###....###..###..#.###..###.#.###.#...###.##.#.##.#...#..##......#.#.##..#...#.#.###.##.#..##...#..#.#.####..###..##.##..##.######.###.####....######..###.#####.#.#.#.#####.##.#.###.###.##.##..##.##.#..#..#..#.####.#.#..#.#.#.##.##########..######.##......#.#.####.";

    public static void main(String[] args) {
        int lineSize = 23;
        ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();

        for (int i = 0; i < asteroidField.length() / lineSize; i++) {
            for (int j = 0; j < lineSize; j++) {
                if (asteroidField.charAt(j + i * lineSize) == '#') {
                    asteroids.add(new Asteroid(i, j));
                }
            }
        }

        int most = 0;

        for(Asteroid a : asteroids) {
            HashSet<Float> asteroidAngles = new HashSet<>();
            for(Asteroid b : asteroids) {
                if(a != b) asteroidAngles.add(a.getAngle(b));
            }

            if(most < asteroidAngles.size()) most = asteroidAngles.size();
        }

        System.out.println(most);
    }
}
