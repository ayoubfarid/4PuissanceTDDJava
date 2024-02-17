package test;

import impl.Grid;
import impl.Jeton;
import impl.Joueur;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class JoueurTest {
    @Test
    public void GivenANameInitializeAJoueur(){
        // Given
        String name = "ayoub";
        // When
        Joueur monJoueur= new Joueur(name);
        //Then
        Assert.assertEquals(name,monJoueur.getName());

    }
    @Test
    public void GivenAColorPickAJeton(){
        //Given
        String color="blue";
        Jeton picckedJeton= new Jeton(color);
        Joueur monJoueur= new Joueur("ayoub");
        //When
        monJoueur.setJeton(picckedJeton);
        // Then
        Assert.assertEquals(picckedJeton,monJoueur.getJeton());

    }
    @Test
    public void GivenAGridPickAColumn(){
        // Given
        Joueur monJoueur= new Joueur("ayoub");
        int column=1;
        // When
        monJoueur.setColumn(column);
        // Then
        Assert.assertEquals(column,monJoueur.getColumn());


    }

}
