package Day20b;

import java.util.Objects;

public class Point {
    int x;
    int y;
    int z;
    int distanceFromStart;
    boolean[][][] visited;

    public Point(int x, int y, int distanceFromStart) {
        this.x = x;
        this.y = y;
        this.distanceFromStart = distanceFromStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}