package Day03a;

public class Line {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Line(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Point getIntersectionWith(Line line) {
        Point point = null;

        if (this.startX == this.endX && line.startY == line.endY) {
            if (line.minX() <= this.startX && this.startX <= line.maxX()) {
                if (this.minY() <= line.startY && line.startY <= this.maxY()) {
                    return new Point(this.startX, line.startY);
                }
            }
        } else if (this.startY == this.endY && line.startX == line.endX) {
            if (this.minX() <= line.startX && line.startX <= this.maxX()) {
                if (line.minY() <= this.startY && this.startY <= line.maxY()) {
                    return new Point(line.startX, this.startY);
                }
            }
        }

        return point;
    }

    private int minX() {
        return Math.min(this.startX, this.endX);
    }

    private int maxX() {
        return Math.max(this.startX, this.endX);
    }

    private int minY() {
        return Math.min(this.startY, this.endY);
    }

    private int maxY() {
        return Math.max(this.startY, this.endY);
    }
}
