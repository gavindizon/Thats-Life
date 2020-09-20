package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Deck;
import java.util.Scanner;

public class JobSearchSpace extends MagentaSpace implements ChoiceSpace {
    Scanner sc = new Scanner(System.in);

    public JobSearchSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
    }

    public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {

        CareerCard c = (CareerCard) decks.get(0).drawCard();
        int chosen = 0;
        System.out.println("Choose: ");
        System.out.println("[1] - Retain Job");
        System.out.println("[2] - Change to " + c.getCareerName());

        chosen = Integer.parseInt(sc.nextLine());

        if (chosen == 1) {
            decks.get(0).addCardBack(c);
        } else {
            decks.get(0).addCardBack(p.getCareerCard());
            p.setCareer(c);
        }

    }

    @Override
    public void choiceAction(Player p, ArrayList<Deck> decks, int choice){
        System.out.println("choice");
    }
    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[2];
        CareerCard c = (CareerCard) decks.get(0).drawCard();
        s[0] = "Retain Job";
        s[1] = "Change to " + c.getCareerName();

        return s;
    }


}
