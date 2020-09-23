package phase1.Spaces;

import java.util.ArrayList;

import phase1.Cards.Card;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Cards.SalaryCard;
import phase1.Deck;
import java.util.Scanner;

public class CollegeCareerChoiceSpace extends MagentaSpace implements ChoiceSpace{

    public CollegeCareerChoiceSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.actionDescription = "College Career Choice";
        this.longDescription = "You can now choose careers with degrees :)))))))";



    }

    // public void doMagentaAction(Player p, Player[] others, ArrayList<Deck> decks) {
//        int chosen;
//        CareerCard career1 = (CareerCard) decks.get(0).drawCard();
//        CareerCard career2 = (CareerCard) decks.get(0).drawCard();
//
//        System.out.println("Choose a Career: ");
//        System.out.println("[1] - " + career1.getCareerName());
//        System.out.println("[2] - " + career2.getCareerName());
//
//        chosen = Integer.parseInt(sc.nextLine());
//        if (chosen == 1) {
//            p.updateCareer(career1);
//            decks.get(0).addCardBack(career2);
//        } else {
//            p.updateCareer(career2);
//            decks.get(0).addCardBack(career1);
//        }
//
//        SalaryCard salary1 = (SalaryCard) decks.get(1).drawCard();
//        SalaryCard salary2 = (SalaryCard) decks.get(1).drawCard();
//
//        System.out.println("Choose a Salary: ");
//        System.out.println("[1] - " + salary1.getSalary());
//        System.out.println("[2] - " + salary2.getSalary());
//
//        chosen = Integer.parseInt(sc.nextLine());
//        if (chosen == 1) {
//            p.updateSalary(salary1);
//            decks.get(0).addCardBack(salary2);
//        } else {
//            p.updateSalary(salary2);
//            decks.get(0).addCardBack(salary1);
//        }

    // }

    @Override
    public void doMagentaAction(Player p, ArrayList<Deck> decks, int choice){
        CareerCard careerCard;
        SalaryCard salaryCard;
        if(p.getCareer().equals("Student") || p.getSalaryCard() != null){
            int chosen;
            chosen = decks.get(0).getCards().size() - choice;
            if (!p.isHasDegree()){
                if(choice == 1){
                    choice = CareerCard.getNoDegreeIndex(decks.get(0));
                } else if(choice == 2) {
                    int index = CareerCard.getNoDegreeIndex(decks.get(0));
                    choice = CareerCard.getNoDegreeIndex(decks.get(0), index);

                }
                chosen = choice;
//                System.out.println("career "+choice);
            }
            if(!p.getCareer().equals("Student")){
                decks.get(0).addCardBack(p.getCareerCard());
            }
            careerCard = (CareerCard) decks.get(0).drawCard(chosen);
            p.setCareer(careerCard);
            p.setSalaryCard(null);


        } else if(p.getSalaryCard() == null){
            salaryCard = (SalaryCard) decks.get(1).drawCard(decks.get(1).getCards().size() - choice);
            p.setSalaryCard(salaryCard);
        }
    }

    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[4];
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);
        int ctr = 0;

        for(int i = careerDeck.getCards().size() - 1; i > 0; i--){
            if(p.isHasDegree()){
                s[ctr] = ((CareerCard)careerDeck.getCards().get(i)).getCareerName();
                ctr++;
            } else if(!(((CareerCard)careerDeck.getCards().get(i)).isDegreeRequired())){
                s[ctr] = ((CareerCard)careerDeck.getCards().get(i)).getCareerName();
                System.out.println("choice " + i);
                ctr++;
            }

            if(ctr == 2){
                break;
            }
        }

        for(int i = salaryDeck.getCards().size() - 1; i > salaryDeck.getCards().size() - 3; i--){
            double salary = ((SalaryCard) salaryDeck.getCards().get(i)).getSalary() ;
            s[ctr] =  String.format("%.2f", salary);
            System.out.println(s[ctr]);
            ctr++;
        }

        return s;
    }

    private void putCardToTop(ArrayList<Card> cards, Card card){
        cards.remove(card);
        cards.add(card);
    }

}
