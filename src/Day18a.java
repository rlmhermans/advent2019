import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day18a {
    boolean[][] visited;
    char[][] maze;

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

        int sizeX = 81;
        int sizeY = 81;
        maze = new char[sizeY][sizeX];
        int startX = 0;
        int startY = 0;
        int keys = 0;

        int lineNumber = 0;
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                maze[lineNumber][i] = line.charAt(i);
                if (String.valueOf(line.charAt(i)).matches("[a-z]")) keys++;

                if (line.charAt(i) == '@') {
                    startX = i;
                    startY = lineNumber;
                }
            }
            lineNumber++;
        }

        LinkedList<Node> foundNodeList = new LinkedList<>();
        LinkedList<Node> checkedNodeList = new LinkedList<>();
        ArrayList<Node> nodes = new ArrayList<>();

        Node startNode = new Node(startX, startY, 0);
        nodes.add(startNode);
        foundNodeList.add(startNode);

        int shortest = Integer.MAX_VALUE;
        while (!foundNodeList.isEmpty()) {
            Node node = foundNodeList.pop();
            checkedNodeList.addLast(node);
            boolean done = node.foundKeys.length() == keys;

            if (done) {
                if (shortest > node.point.distanceFromStart) shortest = node.point.distanceFromStart;
            } else {
                visited = new boolean[sizeY][sizeX];
                LinkedList<Point> points = new LinkedList<>();
                int[] xDirections = {-1, 1, 0, 0};
                int[] yDirections = {0, 0, -1, 1};

                points.add(node.point);
                boolean longerPath = false;
                while (!points.isEmpty() && !longerPath) {
                    Point p = points.pop();

                    if (p.distanceFromStart >= shortest) longerPath = true;

                    for (int i = 0; i < 4; i++) {
                        Point next = new Point(p.x + xDirections[i], p.y + yDirections[i], p.distanceFromStart + 1);
                        if (allowedMove(node, next.x, next.y)) {
                            visited[next.y][next.x] = true;
                            String field = String.valueOf(maze[next.y][next.x]);

                            boolean found = false;
                            if (field.matches("[a-z]")) {
                                if (!node.foundKeys.contains(field)) {
                                    Node newNode = new Node(next.x, next.y, next.distanceFromStart);
                                    newNode.foundKeys = node.foundKeys + field;
                                    foundNodeList.addLast(newNode);
                                    nodes.add(newNode);
                                    newNode.previous = node;
                                    found = true;
                                }
                            }

                            if (!found) points.addLast(next);
                        }
                    }
                }
            }
        }

        ArrayList<Node> candidates = new ArrayList<>();
        for (Node n : nodes) {
            if (n.foundKeys.length() == keys) candidates.add(n);
        }

        int least = Integer.MAX_VALUE;
        for (Node n : candidates) {
            int length = n.point.distanceFromStart;
            if (length < least) least = length;
        }

        System.out.println(least);

    }

    private boolean allowedMove(Node node, int x, int y) {
        if (visited[y][x]) return false;

        String nextTile = String.valueOf(maze[y][x]);
        if (nextTile.matches("[a-z.@]")) return true;

        if (nextTile.matches("[A-Z]")) {
            return node.foundKeys.contains(nextTile.toLowerCase());
        }

        return false;
    }

    private class Node {
        Node previous;
        Point point;
        String foundKeys = "";

        public Node(int x, int y, int distance) {
            this.point = new Point(x, y, distance);
        }
    }

    private class Point {
        private int x;
        private int y;
        private int distanceFromStart;

        public Point(int x, int y, int distanceFromStart) {
            this.x = x;
            this.y = y;
            this.distanceFromStart = distanceFromStart;
        }
    }
}
