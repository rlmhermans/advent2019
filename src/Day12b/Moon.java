package Day12b;

public class Moon {
    private int position;
    private int velocity;

    public Moon(int position) {
        this.position = position;
    }

    public void move() {
        position += velocity;
    }

    public void processGravityInfluenceBy(Moon other) {
        if(this.position < other.position) velocity++;
        if(this.position > other.position) velocity--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(position);
        sb.append(":");
        sb.append(velocity);

        return sb.toString();
    }
}
