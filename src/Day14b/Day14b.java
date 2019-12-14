package Day14b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day14b {
    private static HashMap<String, Chemical> chems = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File("src/Day14a/Recipe.txt"));

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();

            String[] splitOffResult = line.split(" => ");
            String[] ingredients = splitOffResult[0].split(", ");
            String chemResult = splitOffResult[1];
            String resultName = chemResult.split(" ")[1];
            String resultAmount = chemResult.split(" ")[0];

            Chemical chem = getOrCreateChem(resultName);
            chem.setAmountGenerated(Integer.parseInt(resultAmount));

            for (String ingredient : ingredients) {
                String[] chemAndAmount = ingredient.split(" ");

                Chemical iChem = getOrCreateChem(chemAndAmount[1]);
                chem.addIngredient(iChem, Integer.parseInt(chemAndAmount[0]));
            }
        }

        System.out.println(chems.get("FUEL").calculateAmount(11788287));
    }

    private static Chemical getOrCreateChem(String name) {
        Chemical chem = null;
        if (chems.containsKey(name)) {
            chem = chems.get(name);
        } else {
            chem = new Chemical(name);
            chems.put(chem.getName(), chem);
        }

        return chem;
    }
}
