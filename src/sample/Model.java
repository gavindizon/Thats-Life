package sample;

public class Model {
    private String name;
    private int cash;
    public Model(String name, int cash){
        this.name = name;
        this.cash = cash;
    }
    public String getName(){
        return this.name;
    }

    public int getCash() {
        return cash;
    }

    public void updateCash(int value){
        this.cash += value;
    }

}
