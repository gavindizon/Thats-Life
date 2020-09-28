package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;

import phase1.Cards.SalaryCard;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Deck;
/**
 * implements a JobSearchSpace that inherits MagentaSpace and implements
 * ChoiceSpace interface
 */
public class JobSearchSpace extends MagentaSpace implements ChoiceSpace{

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */


    public JobSearchSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "Job Search";
        this.longDescription = "It's job hunting season! There are some jobs available for you.";

    }

    /**
     * Assigns or retains the career/ salary of the player
     * @param p player
     * @param decks ArrayList of Decks used in magenta
     * @param choice index value of the choice of the player
     */

    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice){
        CareerCard c;
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);
        if(p.getSalaryCard()!= null){
            if(choice == 2){
                if(p.isHasDegree()){
                    c = (CareerCard) careerDeck.drawCard(careerDeck.getCards().size() - 1);
                } else{
                    c = (CareerCard) decks.get(0).drawCard(CareerCard.getNoDegreeIndex(careerDeck));
                }

                careerDeck.addCardBack(p.getCareerCard());
                p.setCareer(c);
                p.setPayRaiseCnt(0);
                salaryDeck.getCards().add(0, p.getSalaryCard());
                p.setSalaryCard(null);
            }
        } else{
            SalaryCard salary = (SalaryCard) decks.get(1).drawCard(decks.get(1).getCards().size() - choice);
            p.setSalaryCard(salary);
            salaryDeck.shuffleDeck();
        }

    }
    /**
     * Gets the array of string of choices to be shown to the user
     *
     * @param p current player
     * @param decks used in Magenta Spaces
     * @return String of choices available
     */

    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[4];
        String careerName;
        int ctr = 2;
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);

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
        for(int i = salaryDeck.getCards().size() - 1; i > salaryDeck.getCards().size() - 3; i--){
            double salary = ((SalaryCard) salaryDeck.getCards().get(i)).getSalary();
            s[ctr] =  String.format("%.2f", salary);
            ctr++;
        }

        return s;
    }



}
