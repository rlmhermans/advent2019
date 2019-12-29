import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day22a {
    public static void main(String[] args) {
        new Day22a().run();
    }

    public void run() {
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File("src/_inputDay22.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> file = new ArrayList<>();

        while (fileReader.hasNextLine()) {
            file.add(fileReader.nextLine());
        }

        Deck myDeck = new Deck(10007);

        for(String s : file) {
            if(s.contains("increment")) {
                String number = s.substring(s.lastIndexOf(" ") + 1);
                int n = Integer.parseInt(number);
                myDeck = myDeck.dealInc(n);
            } else if(s.contains("cut")) {
                String number = s.substring(s.indexOf(" ") + 1);
                int n = Integer.parseInt(number);
                myDeck = myDeck.cut(n);
            } else {
                myDeck = myDeck.dealNew();
            }
        }

        for (int i = 0; i < myDeck.cards.length; i++) {
            if(myDeck.cards[i] == 2019) System.out.print(i);
        }
    }

    class Deck {
        int[] cards;

        public Deck(int numberOfCards) {
            cards = new int[numberOfCards];
            for (int i = 0; i < numberOfCards; i++) {
                cards[i] = i;
            }
        }

        public Deck dealNew() {
            Deck newDeck = new Deck(cards.length);

            for (int i = 0; i < cards.length; i++) {
                newDeck.cards[i] = cards[cards.length - 1 - i];
            }

            return newDeck;
        }

        public Deck cut(int n) {
            Deck newDeck = new Deck(cards.length);

            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    newDeck.cards[cards.length - n + i] = cards[i];
                }

                for (int i = n; i < cards.length; i++) {
                    newDeck.cards[i - n] = cards[i];
                }
            }

            if (n < 0) {
                n = Math.abs(n);
                for (int i = 0; i < n; i++) {
                    newDeck.cards[i] = cards[cards.length - n + i];
                }

                for (int i = n; i < cards.length; i++) {
                    newDeck.cards[i] = cards[i - n];
                }
            }

            return newDeck;
        }

        public Deck dealInc(int n) {
            Deck newDeck = new Deck(cards.length);

            for (int i = 0; i < cards.length; i++) {
                newDeck.cards[(i * n) % cards.length] = cards[i];
            }

            return newDeck;
        }
    }
}
