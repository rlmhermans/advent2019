package Day14a;

import java.util.HashMap;
import java.util.Map;

public class Chemical {
    private String name;
    private HashMap<Chemical, Integer> ingredients = new HashMap<>();
    private int amountGenerated;
    private int leftOver;

    public Chemical(String name) {
        this.name = name;
    }

    public void addIngredient(Chemical chem, int amount) {
        ingredients.put(chem, amount);
    }

    public void setAmountGenerated(int amountGenerated) {
        this.amountGenerated = amountGenerated;
    }

    public int calculateAmount(int needed) {
        if (this.name.equals("ORE")) return needed;

        int originalNeeded = needed;
        needed -= leftOver;
        leftOver = leftOver - originalNeeded < 0 ? 0 : leftOver - originalNeeded;

        if(needed <= 0) return 0;

        int times = 1;
        if (needed > amountGenerated) {
            times = needed / amountGenerated;
            if (needed % amountGenerated != 0) times++;
        }

        leftOver += times * amountGenerated - needed;

        int total = 0;

        for (Map.Entry<Chemical, Integer> ingredient : ingredients.entrySet()) {
            total += ingredient.getKey().calculateAmount(times * ingredient.getValue());
        }

        return total;
    }

    public String getName() {
        return name;
    }
}
