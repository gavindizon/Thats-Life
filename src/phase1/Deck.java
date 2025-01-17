package phase1;

import java.util.ArrayList;
import java.util.Collections;
import phase1.Cards.*;
import phase1.Cards.ActionCard.*;
import phase1.Cards.BlueCard.*;

/**
 * implements a Deck object that has a color, an arrayList of the action Card,
 * the current number of cards left and its maximum card per deck
 */

public class Deck {
    private String type;
    private ArrayList<Card> cards;
    private int numCards;
    private final int MAX;

    /**
     * generates a Deck given the type and the max number of cards in it
     * 
     * @param type type of the card object which may either be <i>salary</i>,
     *             <i>career</i>, <i>action</i>, and <i>blue</i>
     * @param max  max number of cards in a deck
     */

    public Deck(String type, int max) {
        this.type = type;
        this.MAX = max;
        this.numCards = max;
        cards = new ArrayList<>(this.MAX);
        generator();
        shuffleDeck();
    }

    private void generator() {
        switch (this.type) {
            case "Action":
                generateActionDeck();
                break;
            case "Salary":
                generateSalaryDeck();
                break;
            case "Career":
                generateCareerDeck();
                break;
            case "Blue":
                generateBlueDeck();
                break;
            case "House":
                generateHouseDeck();
                break;
        }
    }

    /**
     * generates a deck of action cards which has a composition of 40% (Collect from
     * Bank) Cards, 40% (Pay Bank) Cards, 10% (Pay Player), and 10% (Collect from
     * Player) of the total number (<b>max</b>) of cards specified.
     * 
     */

    private void generateActionDeck() {
        int fortyPercent = (int) (this.MAX * 0.4);
        int tenPercent = (int) (this.MAX * 0.1);

        Card[] collectFromBank = new Card[] { new CollectFromBank("Tax Refund", false),
                new CollectFromBank("Sell an Item", false), new CollectFromBank("Bonus Payday", false),
                new CollectFromBank("Setup School", false), new CollectFromBank("Write a Book", false),

        };

        Card[] payBank = new Card[] { new PayBank("Buy an Item", false), new PayBank("Visit a place", false),
                new PayBank("Hiking", false), new PayBank("Watch a show", false),
                new PayBank("Win a competition", false), new PayBank("Traffic violation", false)

        };

        Card[] collectFromPlayer = new Card[] { new CollectFromPlayer("File a Lawsuit", false),
                new CollectFromPlayer("It's your Birthday", true)

        };

        Card[] payPlayer = new Card[] { new PayPlayer("Lawsuit", false), new PayPlayer("Christmas Bonus", true),

        };

        // for (int i = 0; i < this.MAX; i++)
        // this.cards.add(payBank[(int) (Math.random() * payBank.length)]);

        for (int i = 0; i < fortyPercent; i++)
            this.cards.add(collectFromBank[(int) (Math.random() * collectFromBank.length)]);
        for (int i = fortyPercent; i < fortyPercent * 2; i++)
            this.cards.add(payBank[(int) (Math.random() * payBank.length)]);
        for (int i = fortyPercent * 2; i < (fortyPercent * 2) + tenPercent; i++)
            this.cards.add(collectFromPlayer[(int) (Math.random() * collectFromPlayer.length)]);
        for (int i = (fortyPercent * 2) + tenPercent; i < this.MAX; i++)
            this.cards.add(payPlayer[(int) (Math.random() * payPlayer.length)]);

    }

    private void generateCareerDeck() {

        this.cards.add(new CareerCard("Lawyer", rangeDomizer(5, 8), true));// pay raise [5, 8]
        this.cards.add(new CareerCard("Accountant", rangeDomizer(4, 7), true));// pay raise [4, 7]
        this.cards.add(new CareerCard("Computer Consultant", rangeDomizer(3, 7), true));// pay raise [3, 7]
        this.cards.add(new CareerCard("Doctor", rangeDomizer(5, 8), true));// pay raise [5, 8]
        this.cards.add(new CareerCard("Server", rangeDomizer(1, 4), false));// pay raise [1, 4]
        this.cards.add(new CareerCard("Racecar Driver", rangeDomizer(2, 8), false));// pay raise [2, 8]
        this.cards.add(new CareerCard("Athlete", rangeDomizer(1, 6), false));// pay raise [1, 6]
    }

    private void generateSalaryDeck() {
        int salaryNum = 10;
        for (int i = 0; i < salaryNum; i++) {
            double salary = (int) (Math.random() * 9 + 1) * 10000;
            double tax = (int) (Math.random() * 9 + 1) * 1000;
            double raiseValue = (int)  (Math.random() * 9 + 1) * 1000;
            this.cards.add(new SalaryCard(salary, tax, raiseValue));
        }
    }

    private int rangeDomizer(int min, int max){
        max++;
        int value = (int)  (Math.random() * (max - min + 1) + min);
        System.out.println(value);
        return value;
    }

    private void generateBlueDeck() {
        this.cards.add(new Lawsuit("Lawsuit", "Lawyer", 10000 * ((int) (Math.random() * (15 - 5 + 1)) + 5)));
        this.cards.add(new SalaryTaxDue("Salary Tax Due", "Accountant"));
        this.cards.add(new ComputerRepair("Computer Repair", "Computer Consultant"));
        this.cards.add(new SkiAccident("Ski Accident", "Doctor"));
        this.cards.add(new TipTheServer("Tip the Server", "Server"));
        this.cards.add(new F1Race("F1 Race", "Racecar Driver"));
        this.cards.add(new WorldCup("World Cup", "Athlete"));
    }

    private void generateHouseDeck() {
        this.cards.add(new HouseCard("The Bungalow", 45000));
        this.cards.add(new HouseCard("Small Cottage", 30000));
        this.cards.add(new HouseCard("Tree House", 10000));
        this.cards.add(new HouseCard("Isolated Cedar Cabin", 60000));
        this.cards.add(new HouseCard("Marvelous Mansion", 100000));
    }

    /**
     * shuffles the deck generated
     * 
     */

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    /**
     * prints the number of cards in order (from bottom of the stack to its top)
     * which is used for debugging the program specifically, when the user draws.
     * 
     * returns the appended/ concatenated list of cards
     * 
     * @return String of appended description of the cards.
     */

    public String showCards() {
        System.out.println("Showing Produced  and Shuffled Cards: ");
        String text = "";
        for (int i = 0; i < this.numCards; i++) {
            if (this.cards.get(i) instanceof ActionCard) {
                text += ((ActionCard) this.cards.get(i)).getDescription() + "\n";
            } else if (this.cards.get(i) instanceof CareerCard) {
                text += ((CareerCard) this.cards.get(i)).getCareerName() + "\n";
            }
        }
        return text;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * draws a card from the deck which also decrements the current number of cards
     * 
     * returns the action card drawn
     * 
     * @return ActionCard
     */

    public Card drawCard() {
        checkDeck();
        Card a = this.cards.get(this.numCards - 1);
        this.numCards--;
        return a;
    }

    public Card drawCard(int index){
        checkDeck();
        Card a = this.cards.remove(index);
        this.numCards--;
        shuffleDeck();
        return a;

    }

    public void addCardBack(Card a) {
        cards.add(a);
        this.numCards++;
    }

    /*
     * public Card pickTopTwo(){ Card a = this.cards.get(this.numCards - 1);
     * this.numCards--; Card b = this.cards.get(this.numCards - 1); this.numCards--;
     * 
     * return a; }
     */

    /**
     * helper function that checks the deck whenever a player draws. It calls the
     * shuffleDeck() method when current number of cards is 0.
     * 
     */
    private void checkDeck() {
        if (this.numCards == 0) {
            System.out.println("Deck is empty! Refilling and shuffling deck...\n\n\n");
            this.numCards = this.MAX;
            shuffleDeck();
        }
    }




}