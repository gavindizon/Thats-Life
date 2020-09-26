package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Deck;

public class JobSearchSpace extends MagentaSpace implements ChoiceSpace{
//    Scanner sc = new Scanner(System.in);

    public JobSearchSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Job Search";
        this.longDescription = "It's job hunting season! There are some jobs available for you.";

    }



    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice){
        CareerCard c;
        if(choice == 2){
            if(p.isHasDegree()){
                c = (CareerCard) decks.get(0).drawCard(decks.get(0).getCards().size() - 1);
            } else{
                c = (CareerCard) decks.get(0).drawCard(CareerCard.getNoDegreeIndex(decks.get(0)));
            }

            decks.get(0).addCardBack(p.getCareerCard());
            p.setCareer(c);
        }

    }
    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[2];
        String careerName;
//        CareerCard c = (CareerCard) decks.get(0).drawCard();
        Deck careerDeck = decks.get(0);
        int deckSize = careerDeck.getCards().size();
        if(p.isHasDegree()){
            careerName = ((CareerCard)careerDeck.getCards().get(deckSize - 1)).getCareerName();
        } else{
            if(CareerCard.getNoDegreeIndex(careerDeck) != -1){
                careerName = ((CareerCard)careerDeck.getCards().get(CareerCard.getNoDegreeIndex(careerDeck))).getCareerName();
            } else {
                careerName = null;
            }
        }
        if(careerName != null){
            s[0] = "Retain Job";
            s[1] = "Change to " + careerName;
        }
        else{
            s[0] = "No job available";
            s[1] = null;
        }

        return s;
    }



}
