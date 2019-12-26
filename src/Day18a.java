import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Day18a {
    public static void main(String[] args) {
        new Day18a().run();
    }

    public void run() {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("src/_inputDay18.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> fileContents = new ArrayList<>();
        while (fileReader.hasNextLine()) {
            fileContents.add(fileReader.nextLine());
        }

        int sizeX = fileContents.get(0).length();
        int sizeY = fileContents.size();
        char[][] maze = new char[sizeY][sizeX];

        int lineNumber = 0;

        Point middle = null;

        for (String line : fileContents) {
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                maze[lineNumber][i] = c;
                if (c == '@') middle = new Point(i, lineNumber, 0);
            }

            lineNumber++;
        }

        int[] xEntrance = {-2, 2, -1, 1, -2, 2, -1, 1};
        int[] yEntrance = {-1, -1, -2, -2, 1, 1, 2, 2};
        ArrayList<Path> paths = new ArrayList<>();

        for (int i = 0; i < xEntrance.length; i++) {
            paths.add(new Path(middle.x + xEntrance[i], middle.y + yEntrance[i]));
        }

        for (Path path : paths) {
            boolean[][] visited = new boolean[sizeY][sizeX];
            LinkedList<Point> points = new LinkedList<>();
            int[] xDirections = {-1, 1, 0, 0};
            int[] yDirections = {0, 0, -1, 1};

            points.add(path.start);

            while (!points.isEmpty()) {
                Point p = points.pop();
                visited[p.y][p.x] = true;
                char field = maze[p.y][p.x];

                if (Character.isLetter(field)) {
                    p.name = field;
                    path.keys.add(p);
                }

                for (int i = 0; i < 4; i++) {
                    Point next = new Point(p.x + xDirections[i], p.y + yDirections[i], p.distanceFromStart + 1);
                    if (!visited[next.y][next.x] && maze[next.y][next.x] != '#') {
                        points.addLast(next);
                    }
                }
            }
        }

        paths.removeIf(x -> x.keys.size() < 2);

        for (int i = 0; i < paths.size(); i++) {
            Path p = paths.get(i);
            System.out.println(String.format("Path %d: %s", i, p.keys));

            for (int j = 0; j < paths.size(); j++) {
                if(i != j) System.out.println(String.format("Path %d to path %d: %d", i, j, p.distanceTo(paths.get(j))));
            }

            Path middlePath = new Path(middle.x, middle.y);
            System.out.println(String.format("Path %d to middle: %d", i,  p.distanceTo(middlePath)));
        }
    }

    private class Point {
        int x;
        int y;
        int distanceFromStart;
        char name;

        public Point(int x, int y, int distanceFromStart) {
            this.x = x;
            this.y = y;
            this.distanceFromStart = distanceFromStart;
        }

        @Override
        public String toString() {
            return name + " (" + distanceFromStart + ")";
        }
    }

    private class Path {
        Point start;
        ArrayList<Point> keys = new ArrayList<>();
        int depth = 0;
        boolean end = false;

        public Path(int x, int y) {
            start = new Point(x, y, 0);
        }

        public int distanceTo(Path other) {
            int xDistance = Math.abs(start.x - other.start.x);
            int yDistance = Math.abs(start.y - other.start.y);

            return xDistance + yDistance;
        }
    }
}
