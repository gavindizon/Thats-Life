package phase1;

import java.util.*;
import phase1.Spaces.*;
import phase1.Spaces.GreenSpace.PayDaySpace;
import phase1.Spaces.GreenSpace.PayRaiseSpace;
import phase1.Spaces.MagentaSpace.*;

/**
 * Creates a game that initalizes all decks and adds players to the game.
 *
 */
public class Game {
    Scanner scanner = new Scanner(System.in);
    private Player[] players;
    private int NUM_PLAYERS;
    private Deck actionDeck;
    private Deck salaryDeck;
    private Deck careerDeck;
    private Deck blueDeck;
    private Deck houseDeck;
    private Space spaces[];

    /**
     * Implements a game object that has the number of players as a parameter. The
     * number of players may be 2 to 3. For invalid values for number of players
     * provided, 2 will be used.
     *
     * @param NUM_PLAYERS number of players; 2 will be used if invalid
     */
    public Game(int NUM_PLAYERS, String[] players) {
        this.NUM_PLAYERS = checkPlayerNumber(NUM_PLAYERS);

        this.players = new Player[this.NUM_PLAYERS];

        this.actionDeck = new Deck("Action", 50);
        this.salaryDeck = new Deck("Salary", 7);
        this.careerDeck = new Deck("Career", 7);
        this.blueDeck = new Deck("Blue", 7);
        this.houseDeck = new Deck("House", 5);
        actionDeck.shuffleDeck();
        careerDeck.shuffleDeck();
        salaryDeck.shuffleDeck();
        houseDeck.shuffleDeck();
        this.spaces = new Space[100];

        for (int i = 0; i < this.NUM_PLAYERS; i++) {
            this.players[i] = new Player(players[i]);
        }

        generateSpaces();
    }
    public int getPlayerByName(String name){
        int p = 0;
        for(int i =0; i < this.NUM_PLAYERS; i++){
            if(this.players[i].getName().equals(name)){
                System.out.println("get "+i);
                p = i;
            }
        }
        return p;
    }


    public void generateSpaces() {
        // Career Path
//        for(int i = 0; i < 100; i++){
//            this.spaces[i] = new BlueSpace("career", this.NUM_PLAYERS);
//        }

        this.spaces[0] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[1] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[2] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[3] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[4] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[5] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[6] = new GetMarriedSpace("career", this.NUM_PLAYERS);
        this.spaces[7] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[8] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[9] = new PayDaySpace("career", this.NUM_PLAYERS);
        this.spaces[10] = new OrangeSpace("career", this.NUM_PLAYERS);

//         College Path
        this.spaces[11] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[12] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[13] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[14] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[15] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[16] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[17] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[18] = new GraduationSpace("college", this.NUM_PLAYERS);
        this.spaces[19] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[20] = new CollegeCareerChoiceSpace("college", this.NUM_PLAYERS);
        this.spaces[21] = new OrangeSpace("college", this.NUM_PLAYERS);

        // Meet at Some Point

        for (int i = 22; i < 38; i++) {
            this.spaces[i] = spaceRandomizer("main"); // implement a randomizer
        }

        // Junction
        this.spaces[38] = new WhichPathSpace("main", this.NUM_PLAYERS);

        // Change Career Path
        this.spaces[39] = new PayDaySpace("change career", this.NUM_PLAYERS);
        this.spaces[39].setJunctionStart(true);
        this.spaces[40] = new CollegeCareerChoiceSpace("change career", this.NUM_PLAYERS);
        this.spaces[41] = new OrangeSpace("change career", this.NUM_PLAYERS);
        this.spaces[42] = new BlueSpace("change career", this.NUM_PLAYERS);
        this.spaces[43] = new PayRaiseSpace("change career", this.NUM_PLAYERS);
        this.spaces[44] = new OrangeSpace("change career", this.NUM_PLAYERS);
        this.spaces[45] = new BlueSpace("change career", this.NUM_PLAYERS);
        this.spaces[46] = new OrangeSpace("change career", this.NUM_PLAYERS);
        this.spaces[47] = new OrangeSpace("change career", this.NUM_PLAYERS);

        // Main Path
        this.spaces[48] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[48].setJunctionStart(true);
        this.spaces[49] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[50] = new JobSearchSpace("main", this.NUM_PLAYERS);
        this.spaces[51] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[52] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[53] = new OrangeSpace("main", this.NUM_PLAYERS);

        // Meet at some point

        for (int i = 54; i < 70; i++) {
            this.spaces[i] = spaceRandomizer("main"); // implement a randomizer
        }

        this.spaces[70] = new WhichPathSpace("main", this.NUM_PLAYERS);

        // Start a Family Path
        this.spaces[71] = new BlueSpace("family", this.NUM_PLAYERS);
        this.spaces[71].setJunctionStart(true);
        this.spaces[72] = new OrangeSpace("family", this.NUM_PLAYERS);
        this.spaces[73] = new PayDaySpace("family", this.NUM_PLAYERS);
        this.spaces[74] = new GetMarriedSpace("family", this.NUM_PLAYERS);
        this.spaces[75] = new BlueSpace("family", this.NUM_PLAYERS);
        this.spaces[76] = new BuyHouseSpace("family", this.NUM_PLAYERS);
        this.spaces[77] = new HaveBabySpace("family", this.NUM_PLAYERS);
        this.spaces[78] = new OrangeSpace("family", this.NUM_PLAYERS);
        this.spaces[79] = new OrangeSpace("family", this.NUM_PLAYERS);
        this.spaces[80] = new PayRaiseSpace("family", this.NUM_PLAYERS);

        // Main Path
        this.spaces[81] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[81].setJunctionStart(true);
        this.spaces[82] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[83] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[84] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[85] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[86] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[87] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[88] = new OrangeSpace("main", this.NUM_PLAYERS);
        this.spaces[89] = new OrangeSpace("main", this.NUM_PLAYERS);

        // Meet at some point
        for (int i = 90; i < 100; i++) {
            this.spaces[i] = spaceRandomizer("main"); // implement a randomizer
        }
    }

    public Space spaceRandomizer(String path){
        int rand = (int) (Math.random() * (8 - 1 + 1) + 1);

        switch(rand){
            case 1:
            case 2:
                return new BlueSpace(path, this. NUM_PLAYERS);
            case 3:
                return new PayDaySpace(path, this.NUM_PLAYERS);
            case 4:
                return new PayRaiseSpace(path, this.NUM_PLAYERS);
            default:
                return new OrangeSpace(path, this.NUM_PLAYERS);
        }


    }

    public void initializeStart(Player p){

        this.spaces[p.getSpaceTracker()].getPlayers().add(p);

    }

    public static int spinWheel() {
        return (int) (Math.random() * (9 - 1 + 1) + 1);
    }

    public int move(Player p) {
        int moveCnt = spinWheel();
        int spinHolder = moveCnt;
        int place = 1;
        // Special Treatment for Junctions

        if((moveCnt + p.getSpaceTracker() )>= 99){
            this.spaces[p.getSpaceTracker()].getPlayers().remove(p);
            p.teleportToSpace(99);
            this.spaces[p.getSpaceTracker()].getPlayers().add(p);
            p.setToRetire(true, place);
            place++;

        }else{

            if (p.getSpaceTracker() != 0 && this.spaces[p.getSpaceTracker()].isJunctionStart() && moveCnt != 1) {
                moveCnt--;
            }

            System.out.println("Moving Player " + p.getName() + " to +" + moveCnt + " steps");

            for (; moveCnt > 0; moveCnt--) {
                this.spaces[p.getSpaceTracker()].getPlayers().remove(p); // removes from a player to the current shit
                p.updateSpaceTracker();
                this.spaces[p.getSpaceTracker()].getPlayers().add(p);

                if ((this.spaces[p.getSpaceTracker()] instanceof MagentaSpace)) {
                    moveCnt = 0; // stop
                    System.out.println("STOP");
                    MagentaSpace m = (MagentaSpace) this.spaces[p.getSpaceTracker()];

                } else {
                    this.spaces[p.getSpaceTracker()].getPlayers().remove(p);
                    switch (p.getSpaceTracker()) {
                        case 11:
                            p.teleportToSpace(22);
                            break;
                        case 47:
                            p.teleportToSpace(54);
                            break;
                        case 80:
                            p.teleportToSpace(90);
                            break;
                    }
                    this.spaces[p.getSpaceTracker()].getPlayers().add(p);

                }

            }

        }

        playerDupRemover();
        if(gameOver()){
            System.out.println("game over xD");
        }
        return spinHolder;
    }

    public ArrayList<Deck> getDecks(Space s) {
        ArrayList<Deck> decks = new ArrayList<>();

        if (s instanceof OrangeSpace) {
            decks.add(this.actionDeck);
        } else if (s instanceof MagentaSpace) {
            decks.add(this.careerDeck);
            decks.add(this.salaryDeck);
            decks.add(this.houseDeck);
        } else if (s instanceof BlueSpace) {
            decks.add(this.blueDeck);
        } else {
            // Green
        }

        return decks;

    }

    /**
     * returns Deck class of the actionDeck.
     *
     * @return Deck class of the actionDeck.
     */
    public Deck getActionDeck() {
        return this.actionDeck;
    }

    public Deck getBlueDeck() {
        return blueDeck;
    }

    public Deck getCareerDeck() {
        return careerDeck;
    }

    public Deck getSalaryDeck() {
        return salaryDeck;
    }

    /**
     * returns the number of players in the game.
     *
     * @return the number of players in the game.
     */
    public int getNumPlayers() {
        return this.NUM_PLAYERS;
    }

    /**
     * returns Player class of the player chosen.
     *
     *
     * @param index of player chosen
     * @return Player class o f the player chosen.
     */
    public Player getPlayer(int index) {

        return this.players[index];
    }

    /**
     * returns an array of Players containing the current players in the game.
     *
     * @return an array of Players containing the current players in the game.
     */
    public Player[] getPlayers() {
        return this.players;
    }

    public Space getSpace(int index) {

        return this.spaces[index];
    }

    /**
     * Checks if the game is over when all the players are retired.
     *
     * @return true if all players are retired; false if not.
     */
    public boolean gameOver() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (!players[i].getIsRetired())
                return false;
        }

        return true;
    }

    /**
     * Force retire all players to end the game. Temporary method to end the game.
     *
     */
    public void retireAll() { // to be removed after phase 1(?)
        for (int i = 0; i < NUM_PLAYERS; i++) {
            this.players[i].setToRetire(true, 0);
        }
    }

    /**
     * Displays the current cash of each player and career.
     *
     */
    public void displayState() {
        System.out.println("\nCurrent State: ");
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println(this.players[i].getName() + " : $" + this.players[i].getCash() + " Career: "
                    + this.players[i].getCareer());
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            if (this.spaces[i].getPlayers().size() != 0) {
                System.out.println(" Space " + (i + 1) + " Players: ");
                for (int j = 0; j < this.spaces[i].getPlayers().size(); j++)
                    System.out.println(this.spaces[i].getPlayers().get(j).getName());

            }
        }
    }

    /**
     * Checks if the number of players are valid or not.
     *
     * @param numPlayers indicated the specified number of player
     *
     * @return the final number of players indicated.
     */
    private int checkPlayerNumber(int numPlayers) {
        if (numPlayers > 3 || numPlayers < 2) {
            System.out.println("Invalid player numbers. The player number was adjusted to two.");
            numPlayers = 2;
        }
        return numPlayers;
    }

    public Space[] getSpaces() {
        return spaces;
    }

    private void playerDupRemover(){
        boolean match = false;
        for(int i = 0; i < this.getNumPlayers(); i++){
            match = false;
            for(int j = 99; j >= 0; j--){
                if(match && this.spaces[j].getPlayers().contains(this.players[i]))
                    this.spaces[j].getPlayers().remove(this.players[i]);

                if(this.spaces[j].getPlayers().contains(this.players[i]))
                    match = true;
            }
        }
    }


    public void rankPlayers(){

        for (int i = 0; i < this.NUM_PLAYERS-1; i++){
            int max = i;
            for (int j = i+1; j < this.NUM_PLAYERS; j++)
                if (this.players[j].getCash() >= this.players[max].getCash())
                    max = j;

            Player temp = this.players[max];
            this.players[max] = this.players[i];
            this.players[i] = temp;
        }
        for(Player p: this.players)
            System.out.println(p.getName() + " : " + p.getCash());
    }
}