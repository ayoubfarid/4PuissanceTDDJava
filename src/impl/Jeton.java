package impl;

public class Jeton {

    private String color;

    public  Jeton(){
        this.color="rouge";
    };
    public Jeton(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
}
