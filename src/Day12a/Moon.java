package Day12a;

public class Moon {
    private int positionX;
    private int positionY;
    private int positionZ;

    private int velocityX;
    private int velocityY;
    private int velocityZ;

    public Moon(int positionX, int positionY, int positionZ) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public void move() {
        positionX += velocityX;
        positionY += velocityY;
        positionZ += velocityZ;
    }

    public void processGravityInfluenceBy(Moon other) {
        if(this.positionX < other.positionX) velocityX++;
        if(this.positionX > other.positionX) velocityX--;
        if(this.positionY < other.positionY) velocityY++;
        if(this.positionY > other.positionY) velocityY--;
        if(this.positionZ < other.positionZ) velocityZ++;
        if(this.positionZ > other.positionZ) velocityZ--;
    }

    public int getTotalEnergy() {
        int pot = Math.abs(positionX) + Math.abs(positionY) + Math.abs(positionZ);
        int kin = Math.abs(velocityX) + Math.abs(velocityY) + Math.abs(velocityZ);

        return pot * kin;
    }
}
