package phase1.Spaces;

import java.util.ArrayList;
import phase1.Player;
import phase1.Cards.CareerCard;
import phase1.Cards.SalaryCard;
import phase1.Deck;
import java.util.Scanner;

public class CollegeCareerChoiceSpace extends MagentaSpace implements ChoiceSpace{
    Scanner sc = new Scanner(System.in);

    public CollegeCareerChoiceSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
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
        System.out.println("choice");
    }

    @Override
    public String[] getChoices(Player p, ArrayList<Deck> decks){
        String[] s = new String[4];
        Deck careerDeck = decks.get(0);
        Deck salaryDeck = decks.get(1);
        int ctr = 0;

        for(int i = careerDeck.getCards().size() - 1; i > careerDeck.getCards().size() - 3; i--){
            s[ctr] = ((CareerCard)careerDeck.getCards().get(i - 1)).getCareerName();
            ctr++;
            System.out.println(ctr);
        }

        for(int i = salaryDeck.getCards().size() - 1; i > salaryDeck.getCards().size() - 3; i--){
            double salary = ((SalaryCard) salaryDeck.getCards().get(i - 1)).getSalary() ;
            s[ctr] =  String.format("%.2f", salary);
            System.out.println(s[ctr]);
//            ctr++;
        }


//        CareerCard career1 = (CareerCard) decks.get(0).drawCard();
//        CareerCard career2 = (CareerCard) decks.get(0).drawCard();
//        s[0] = career1.getCareerName();
//        s[1] = career2.getCareerName();
        return s;
    }

}
