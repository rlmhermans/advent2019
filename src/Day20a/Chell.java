package Day20a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Chell {
    public static void main(String[] args) {
        new Chell().run();
    }

    public void run() {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("src/_inputDay20.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> file = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            file.add(fileReader.nextLine());
        }

        int longestLine = 0;
        for (String s : file) {
            if (s.length() > longestLine) longestLine = s.length();
        }

        int ySize = file.size();
        int xSize = longestLine;
        char[][] maze = new char[ySize][xSize];

        for (int y = 0; y < ySize; y++) {
            String line = file.get(y);
            for (int x = 0; x < line.length(); x++) {
                maze[y][x] = line.charAt(x);
            }
        }

        HashMap<String, ArrayList<Point>> portals = new HashMap<>();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                char c = maze[y][x];
                if (Character.isLetter(c)) {
                    Point portalPoint = null;
                    String portalName = "";
                    boolean added = false;

                    char d;
                    if (y > 1 && Character.isLetter(maze[y - 1][x]) && maze[y - 2][x] == '.') {
                        d = maze[y - 1][x];
                        portalPoint = new Point(x, y - 2, 0);
                        portalName = "" + d + c;
                        added = true;
                    } else if (y < ySize - 2 && Character.isLetter(maze[y + 1][x]) && maze[y + 2][x] == '.') {
                        d = maze[y + 1][x];
                        portalPoint = new Point(x, y + 2, 0);
                        portalName = "" + c + d;
                        added = true;
                    } else if (x > 1 && Character.isLetter(maze[y][x - 1]) && maze[y][x - 2] == '.') {
                        d = maze[y][x - 1];
                        portalPoint = new Point(x - 2, y, 0);
                        portalName = "" + d + c;
                        added = true;
                    } else if (x < xSize - 2 && Character.isLetter(maze[y][x + 1]) && maze[y][x + 2] == '.') {
                        d = maze[y][x + 1];
                        portalPoint = new Point(x + 2, y, 0);
                        portalName = "" + c + d;
                        added = true;
                    }

                    if (added) {
                        if (!portals.containsKey(portalName)) {
                            ArrayList<Point> points = new ArrayList<>();
                            points.add(portalPoint);
                            portals.put(portalName, points);
                        } else {
                            ArrayList<Point> points = portals.get(portalName);
                            points.add(portalPoint);
                            portals.replace(portalName, points);
                        }
                    }
                }
            }
        }

        boolean[][] visited = new boolean[ySize][xSize];
        LinkedList<Point> points = new LinkedList<>();
        int[] xDirections = {-1, 1, 0, 0};
        int[] yDirections = {0, 0, -1, 1};
        Point first = portals.get("AA").get(0);
        visited[first.y][first.x] = true;
        points.add(first);
        Point endPoint = portals.get("ZZ").get(0);

        while (!points.isEmpty()) {
            Point p = points.pop();

            if (p.x == endPoint.x && p.y == endPoint.y) System.out.println("Shortest path:" + p.distanceFromStart);
            Point next = null;

            for (String s : portals.keySet()) {
                if (portals.get(s).contains(p) && !s.equals("AA") && !s.equals("ZZ")) {
                    int indexCurrent = portals.get(s).indexOf(p);
                    int indexOther = 1 - indexCurrent;
                    next = portals.get(s).get(indexOther);
                    next.distanceFromStart = p.distanceFromStart + 1;
                    if (!visited[next.y][next.x]) {
                        visited[next.y][next.x] = true;
                        points.addLast(next);
                    } else {
                        next = null;
                    }
                }
            }

            if (next == null) {
                for (int i = 0; i < 4; i++) {
                    next = new Point(p.x + xDirections[i], p.y + yDirections[i], p.distanceFromStart + 1);
                    if (!visited[next.y][next.x] && (maze[next.y][next.x] == '.')) {
                        visited[next.y][next.x] = true;
                        points.addLast(next);
                    }
                }
            }
        }
    }
}