package impl;

import org.junit.Assert;
import org.junit.Test;
import test.GridTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Grid {

    private Jeton [][] matrice ;
    int [] nombreElemInColumns;


    public Grid (){
        // initialiser la matrice
        initializeMatrice();
        inittializeNombreElemInColumns();

    }
    void inittializeNombreElemInColumns(){
        nombreElemInColumns=new int[GridTest.COLUMN_SIZE];
        for (int i = 0; i < GridTest.COLUMN_SIZE; i++) {
            nombreElemInColumns[i]=0;
        }
    }
    public Jeton [][] getMatrice(){
        return matrice;
    }
    public void initializeMatrice(){
        matrice = new Jeton[GridTest.LINE_SIZE][GridTest.COLUMN_SIZE];
    }
    public void insert(Jeton jeton,int columnNumber){
        if (jeton == null) throw new NullPointerException("le jeton ne doit pas etre null");
        if (nombreElemInColumns[columnNumber]==GridTest.COLUMN_SIZE) throw new ArrayStoreException("La colonne est pleine");
        if (columnNumber>GridTest.COLUMN_SIZE) throw  new ArrayIndexOutOfBoundsException("l'intervall d'insertion et entre 0 et 6");

            matrice[columnNumber][nombreElemInColumns[columnNumber]]=jeton;
            nombreElemInColumns[columnNumber]++;



    }





    public int getLineSize(){
        return matrice.length;
    }
    public int getColumnSize(){
        return matrice[0].length;
    }

}
