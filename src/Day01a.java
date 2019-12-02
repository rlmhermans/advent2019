import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01a {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/inputDay1.txt"));
        int totalFuel = 0;

        while(fileReader.hasNextLine()) {
            totalFuel += calculateFuel(Integer.parseInt(fileReader.nextLine()));
        }

        System.out.println(totalFuel);
    }

    public static int calculateFuel(int mass) {
        return mass/3 -2;
    }
}