package test;

import impl.Arbitre;
import impl.Grid;
import impl.Jeton;
import impl.Joueur;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArbitreTest {
    @Test
    public  void GivenNameInitializeArbitre(){
        //Given
        String name="arbitre";
        // When
        Arbitre arbitre=new Arbitre(name);
        //Then
        Assert.assertEquals(name,arbitre.getName());
    }

    @Test
    public  void GivenAnArbitreShouldBeAssignedToAGrid(){
        // Given
        Grid monGrid=new Grid();
        String name="arbitre";
        // When
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(monGrid);

        Assert.assertNotNull(arbitre.getGrid());
    }
    @Test
    public void GivenTwoPlayerWithTheSameShouldRaizeException(){
        //Given
        String name="arbitre";
        String messageError="Name Exception Already picked";
        Arbitre arbitre=new Arbitre(name);
        Joueur premierJoueur=new Joueur("Ayoub");
        Joueur dexiemeJoueur=new Joueur("Ayoub");

        //When
        arbitre.setPremierJoueur(premierJoueur);

        //Then
        IllegalArgumentException exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            //Code under test
            arbitre.setDeuxiemeJoueur(dexiemeJoueur);

        });
        Assert.assertEquals(messageError,exception.getMessage());

    }
    @Test
    public void GivenTwoPlayerAssignArbitreTwoPlayer(){
        //Given
        String name="arbitre";
        // When
        Arbitre arbitre=new Arbitre(name);
        Joueur premierJoueur=new Joueur("Ayoub");
        Joueur dexiemeJoueur=new Joueur("Anass");

        //When
        arbitre.setPremierJoueur(premierJoueur);
        arbitre.setDeuxiemeJoueur(dexiemeJoueur);
        //Then
        Assert.assertNotNull(arbitre.getDeuxiemeJoueur());
        Assert.assertNotNull(arbitre.getPremierJoueur());



    }
    @Test
    public void ShouldDelegatePlayingToSecondPlayingWhenFirstPlayed(){
        //Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        Joueur premierJoueur=new Joueur("Ayoub");
        Joueur dexiemeJoueur=new Joueur("Anass");

        arbitre.setPremierJoueur(premierJoueur);
        arbitre.setRecentlyPlayed(premierJoueur);
        arbitre.setDeuxiemeJoueur(dexiemeJoueur);
        //When
        arbitre.delegatePlaying();
        //Then
        Assert.assertEquals(dexiemeJoueur,arbitre.getRecentlyPlayed());


    }
    @Test
    public void WhenGridIsOverShouldWhenMatchNull(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getFullGridNull());
        //When
        //Then
        Assert.assertEquals(true,arbitre.isFull());

    }
    @Test
    public void  When4ColorsFoundedHorizontalThenReturnTrueWinner(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getWinnerHorizontalGrid());
        //Then
        Assert.assertEquals(true,arbitre.analyzeWinnerHorizontal());
    }
    @Test
    public void  When4ColorsFoundedVerticalThenReturnTrueWinner(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getWinnerVerticalGrid());
        //Then
        Assert.assertEquals(true,arbitre.analyzeWinnerVertical());
    }
    @Test
    public void  WhenNoMatchingColorsFoundedVerticalThenReturnFalse(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getFailedVerticalGrid());
        //Then
        Assert.assertEquals(false,arbitre.analyzeWinnerVertical());
    }
    @Test
    public void  WhenNoMatchingColorsFoundedHorizontalThenReturnFalse(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getFailedHorizontalGrid());
        //Then
        Assert.assertEquals(false,arbitre.analyzeWinnerHorizontal());
    }
    @Test
    public  void When4ColorsFoundInDigonalThenReturnTrue(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getWinnerDiagonalGrid());
        //Then
        Assert.assertEquals(true,arbitre.analyzeWinnerDiagonal());
    }
 @Test
    public  void WhenNo4ColorsFoundInDigonalThenReturnFalse(){
        // Given
        String name="arbitre";
        Arbitre arbitre=new Arbitre(name);
        arbitre.setGrid(getFailedDiagonalGrid());
        //Then
        Assert.assertEquals(false,arbitre.analyzeWinnerDiagonal());
    }

    public Grid getWinnerDiagonalGrid(){
        Grid monGrid= new Grid();
        int deb=3;
        int firstDeb=3;
        int fin=0;
        while ( fin <= firstDeb ){
                monGrid.getMatrice()[deb][fin]=new Jeton();

            deb--;
            fin++;
        }

        return monGrid;
    }
    public Grid getFailedDiagonalGrid(){
        Grid monGrid= new Grid();
        int deb=2;
        int firstDeb=2;
        int fin=0;
        while ( fin <= firstDeb ){
                monGrid.getMatrice()[deb][fin]=new Jeton();

            deb--;
            fin++;
        }
    //    monGrid.getMatrice()[deb+1][fin-1]=new Jeton("blue");
        return monGrid;
    }
    public Grid getWinnerHorizontalGrid(){
        Grid monGrid= new Grid();
          for (int j = 0; j < 4; j++) {
                monGrid.insert(new Jeton(),0);
            }

        return monGrid;
    };

    public Grid getWinnerVerticalGrid(){
        Grid monGrid= new Grid();
          for (int j = 0; j < 4; j++) {
                monGrid.insert(new Jeton(),j);
            }

        return monGrid;
    };
    public Grid getFailedVerticalGrid(){
        Grid monGrid= new Grid();
          for (int j = 0; j < 3; j++) {
                monGrid.insert(new Jeton(),j);
            }
        monGrid.insert(new Jeton("blue"),3);
        return monGrid;
    };
    public Grid getFailedHorizontalGrid(){
        Grid monGrid= new Grid();
          for (int j = 0; j < 2; j++) {
                monGrid.insert(new Jeton(),0);
            }

        return monGrid;
    };
    public Grid getFullGridNull(){
        Grid monGrid= new Grid();
        for (int i = 0; i < monGrid.getLineSize(); i++) {
            for (int j = 0; j < monGrid.getColumnSize(); j++) {
                monGrid.insert(new Jeton(),i);
            }
        }
        return monGrid;
    };


}
