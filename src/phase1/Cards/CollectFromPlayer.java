package phase1.Cards;

import java.util.Scanner;

import phase1.Player;

public class CollectFromPlayer extends ActionCard {

    public CollectFromPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    @Override
    public void activate(Player[] players, int currPlayerIndex) {
        System.out.println("activated collect from player");
        System.out.println(players.length);

        if(this.getToAll()){
            double value = 0;
            for(int i = 0; i < 2; i++){
                if(i != currPlayerIndex){
                    players[i].updateCash(-this.getValue());
                    value += this.getValue();
                }
            }
            players[currPlayerIndex].updateCash(value);
        }
        else{
            System.out.println("hello");
            players[0].updateCash(-this.getValue());
            players[currPlayerIndex].updateCash(this.getValue());
        }

    }

}
