import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01b {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/inputDay1.txt"));
        int totalFuel = 0;

        while(fileReader.hasNextLine()) {
            totalFuel += calculateFuel(Integer.parseInt(fileReader.nextLine()));
        }

        System.out.println(totalFuel);
    }

    public static int calculateFuel(int mass) {
        int fuelNeeded = mass/3 -2;

        if(fuelNeeded > 0) {
            return fuelNeeded + calculateFuel(fuelNeeded);
        }

        return 0;
    }
}