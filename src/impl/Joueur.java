package impl;

public class Joueur {
    private String name;
    private Jeton jeton;
    private int column;
    private Grid grid;

    public Joueur (String name){
        this.name=name;
    }
    public void setJeton(Jeton jeton){
        this.jeton= jeton;
    }
    public Jeton getJeton(){
        return jeton;
    }
    public String getName(){
        return  name;
    }

    public void setColumn(int column){
        this.column=column;


    }
    public int getColumn(){
        return column;
    }

    public void setGrid(Grid grid){
        this.grid=grid;
    }

    public Grid getGrid(){
        return grid;
    }
}
