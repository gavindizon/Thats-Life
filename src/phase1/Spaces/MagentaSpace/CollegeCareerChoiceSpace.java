package phase1.Spaces.MagentaSpace;

import java.util.ArrayList;

import phase1.Cards.Card;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Cards.SalaryCard;
import phase1.Deck;

/**
 * implements a CollegeCareerChoiceSpace that inherits MagentaSpace and implements
 * ChoiceSpace interface
 */
public class CollegeCareerChoiceSpace extends MagentaSpace implements ChoiceSpace{

    /**
     * Initializes the path and max num of players based from the inherited constructor
     * assigns the action description and long description
     * @param path
     * @param noOfPlayers
     */

    public CollegeCareerChoiceSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "College Career Choice";
        this.longDescription = "You can now choose careers with degrees :)))))))";

    }
    /**
     * Assigns the career/ salary of the player
     * @param p player
     * @param decks ArrayList of Decks used in magenta
     * @param choice index value of the choice of the player
     */

    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice){
        CareerCard careerCard;
        SalaryCard salaryCard;
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);

        try{
            Card playerSalary = p.getSalaryCard();
            if(p.getCareer().equals("Student") || playerSalary != null){
                System.out.println("COME HERE");
                int chosen;
                chosen = careerDeck.getCards().size() - choice;
                if (!p.isHasDegree()){
                    if(choice == 1){
                        choice = CareerCard.getNoDegreeIndex(careerDeck);
                    } else if(choice == 2) {
                        int index = CareerCard.getNoDegreeIndex(careerDeck);
                        choice = CareerCard.getNoDegreeIndex(careerDeck, index);

                    }
                    chosen = choice;
    //                System.out.println("career "+choice);
                }
                Card playerCareer = p.getCareerCard();
                careerCard = (CareerCard) careerDeck.drawCard(chosen);
                if(!p.getCareer().equals("Student") && chosen != -1){
                    careerDeck.addCardBack(playerCareer);
                    p.setCareer(null);
                    salaryDeck.getCards().add(0, playerSalary);
                }
                p.setCareer(careerCard);
                p.setSalaryCard(null);
            } else if(playerSalary == null){
                salaryCard = (SalaryCard) decks.get(1).drawCard(decks.get(1).getCards().size() - choice);
                p.setSalaryCard(salaryCard);
                salaryDeck.shuffleDeck();

//                salaryDeck.addCardBack(playerSalary);
            }
        } catch (Exception e){
            System.out.println("Hello");
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
        String careerName = null;
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);

        int ctr = 0;

        for(int i = careerDeck.getCards().size() - 1; i >= 0; i--){
            if(p.isHasDegree()){
                careerName = ((CareerCard)careerDeck.getCards().get(i)).getCareerName();
                s[ctr] = careerName;
                ctr++;

            } else if(!(((CareerCard)careerDeck.getCards().get(i)).isDegreeRequired())){
                careerName = ((CareerCard)careerDeck.getCards().get(i)).getCareerName();
                s[ctr] = careerName;
                ctr++;
            }


            if(ctr == 2){
                break;
            }

        }
        if(s[0] == null && s[1] == null){
            ctr+=2;
            s[0] = "No careers available";
        }
        for(int i = salaryDeck.getCards().size() - 1; i >= salaryDeck.getCards().size() - 2; i--){
            double salary = ((SalaryCard) salaryDeck.getCards().get(i)).getSalary() ;
            if(ctr == 1){
                ctr++;
            }
            s[ctr] =  String.format("%.2f", salary);
            ctr++;
        }

        return s;
    }



}
