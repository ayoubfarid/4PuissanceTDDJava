package test;

import impl.Grid;
import impl.Jeton;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GridTest {
    public static final int COLUMN_SIZE=7;
    public static final int LINE_SIZE=6;

    @Test
    public void WhenNoConstructThenCreateGrid(){
        //When
        Grid monGrid=new Grid();
        // Then
        Assert.assertEquals(LINE_SIZE,monGrid.getLineSize());
        Assert.assertEquals(COLUMN_SIZE,monGrid.getColumnSize());
    }
    @Test
    public void  GivenJetonInsertInColumn9ThenRaizeException(){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton = new Jeton();
        int columnNumber=9;
        // When
        IndexOutOfBoundsException exception = Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
            //Code under test
            monGrid.insert(monJeton,columnNumber);

        });
    }

    @Test
    public void GivenJetonInsertInANullColumnThenRaizeException(){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton =new Jeton();
        String messageError="Index 9 out of bounds for length 7";
        int columnNumber=9;
        // When
        ArrayIndexOutOfBoundsException exception = Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            //Code under test
            monGrid.insert(monJeton,columnNumber);

        });
        Assert.assertEquals( messageError,exception.getMessage());
    }
    @Test
    public void GivenJetonNullInsertInAColumnShouldRaizeException(){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton =null;
        String messageError="le jeton ne doit pas etre null";
        int columnNumber=0;
        // When
        NullPointerException exception = Assert.assertThrows(NullPointerException.class, () -> {
            //Code under test
            monGrid.insert(monJeton,columnNumber);

        });
        Assert.assertEquals( messageError,exception.getMessage());
    }
    @Test
    public void GivenJetonIfEmptyShouldInsertInFirstPositionOfColumn(){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton =new Jeton();
        int columnNumber=0;

        monGrid.insert(monJeton,columnNumber);
        Assert.assertNotNull(monGrid.getMatrice()[columnNumber][0]);

    }

    @ParameterizedTest
    @ValueSource( ints= {0,1,2,3,4,5})
    public void GivenJetonIfEmptyShouldInsertInFirstPositionOfEachColumn(int columnNumber){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton =new Jeton();

        monGrid.insert(monJeton,columnNumber);
        Assert.assertNotNull(monGrid.getMatrice()[columnNumber][0]);

    }
    @Test
    public void ShouldRaizeExceptionWhenGivenColumnIsFilled(){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton = new Jeton();
        String errorMessage="La colonne est pleine";
        int columnNumber=5;

        for (int i=0; i<monGrid.getColumnSize();i++) monGrid.insert(monJeton,columnNumber);



        ArrayStoreException exception = Assert.assertThrows(ArrayStoreException.class, () -> {
            //Code under test
            monGrid.insert(monJeton,columnNumber);

        });
        Assert.assertEquals( errorMessage,exception.getMessage());

    }

    @ParameterizedTest
    @ValueSource( ints= {0,1,2,3,4,5})
    public void ShouldRaizeExceptionWhenEachColumnIsFilled(int columnNumber){
        // Given
        Grid monGrid=new Grid();
        Jeton monJeton = new Jeton();
        String errorMessage="La colonne est pleine";

        for (int i=0; i<monGrid.getColumnSize();i++) monGrid.insert(monJeton,columnNumber);

        //When

        ArrayStoreException exception = Assert.assertThrows(ArrayStoreException.class, () -> {
            //Code under test
            monGrid.insert(monJeton,columnNumber);

        });
        Assert.assertEquals( errorMessage,exception.getMessage());

    }


}
