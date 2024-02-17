package impl;

import java.util.ArrayList;
import java.util.List;

public class Arbitre {
    private String name;
    private Grid grid;
    private Joueur premierJoueur;
    private Joueur deuxiemeJoueur;
    private Joueur recentlyPlayed;

    public Joueur getRecentlyPlayed() {
        return recentlyPlayed;
    }

    public void setRecentlyPlayed(Joueur recentlyPlayed) {
        this.recentlyPlayed = recentlyPlayed;
    }

    public void delegatePlaying(){
        if (recentlyPlayed.equals(premierJoueur))  setRecentlyPlayed(deuxiemeJoueur);
        else setRecentlyPlayed(deuxiemeJoueur);
    }
    public void setGrid(Grid grid){
        this.grid=grid;
    }

    public Grid getGrid(){
        return grid;
    }
    public Arbitre(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setPremierJoueur(Joueur joueur){
        this.premierJoueur=joueur;
    }
    public void setDeuxiemeJoueur(Joueur joueur){
        if (joueur.getName().equals(premierJoueur.getName())) throw new IllegalArgumentException("Name Exception Already picked");
        this.deuxiemeJoueur=joueur;
    }

    public Joueur getDeuxiemeJoueur() {
        return deuxiemeJoueur;
    }

    public Joueur getPremierJoueur() {
        return premierJoueur;
    }

    public boolean isFull(){
        for (int i = 0; i < grid.getLineSize(); i++) {
            if (grid.nombreElemInColumns[i]< grid.getColumnSize()) return false;
        }
        return true;
    }

    public boolean isArrayOftheSameColor(List<String> colors){
        String firstColor=colors.get(0);
        return colors.stream().filter((color)->firstColor.equals(color) && !firstColor.equals("")).toList().size() == 4;
    }
    public boolean analyzeWinnerHorizontal(){
        for (int i = 0; i < grid.getLineSize(); i++) {
            int deb=0;
            int fin=4;
            while ( fin<grid.getColumnSize() ){
                // given deb fin check for 4 colors matching
                List<String>  extractedColor=new ArrayList<>();
                for (int j = deb  ; j  < fin; j++) {
                    if (grid.getMatrice()[i][j]!=null)
                    extractedColor.add(grid.getMatrice()[i][j].getColor());
                    else  extractedColor.add("");
                }
                // winner founded
                if (isArrayOftheSameColor(extractedColor)) return true;
                deb++;
                fin++;
            }
        }

        return false;
    }
    public boolean analyzeWinnerDiagonal(){
        // traitement depuis top left to  bottom right
        // traitement depuis top right to  bottom left
        return analyzeWinnerDiagonalFromTopLeftToHalf() || analyzeWinnerDiagonalFromTopRightToHalf();
    }
    public boolean analyzeWinnerDiagonalFromTopLeftToHalf(){
        for (int i = 3; i < grid.getLineSize(); i++) {
            int deb=i;
            int firstDeb=i;
            int fin=0;
            List<String>  extractedColor=new ArrayList<>();
            while ( fin <= firstDeb ){
                // given deb fin check for 4 colors matching


                    if (grid.getMatrice()[deb][fin]!=null){
                        extractedColor.add(grid.getMatrice()[deb][fin].getColor());
                        System.out.println(" [ "+ deb + "] " + " [ "+ fin + "] " + grid.getMatrice()[deb][fin].getColor()  );
                    } else  extractedColor.add("");

                // winner founded

                deb--;
                fin++;
            }
            if (isArrayOftheSameColor(extractedColor)) return true;
        }

        return false;

    }
    public  boolean analyzeWinnerDiagonalFromTopRightToHalf(){
        return false;
    }
    public boolean analyzeWinnerVertical(){
        for (int i = 0; i < grid.getColumnSize(); i++) {
            int deb=0;
            int fin=4;
            while ( fin< grid.getLineSize()){
                // given deb fin check for 4 colors matching verticaly
                List<String>  extractedColor=new ArrayList<>();
                for (int j = deb  ; j  < fin; j++) {

                    if (grid.getMatrice()[j][i]!=null)
                        extractedColor.add(grid.getMatrice()[j][i].getColor());
                    else  extractedColor.add("");
                }
                // winner founded
                if (isArrayOftheSameColor(extractedColor)) return true;
                deb++;
                fin++;
            }
        }

        return false;
    }
}
