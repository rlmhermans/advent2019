package Day10b;

public class Asteroid {
    private int x;
    private int y;

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float getAngle(Asteroid target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - y, target.x - x));

        if (angle < 0) {
            angle += 360;
        }

        angle += 90;
        if (angle > 359) {
            angle -= 360;
        }


        return angle;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
