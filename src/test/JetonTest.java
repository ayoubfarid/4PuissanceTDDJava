package test;

import impl.Jeton;
import org.junit.Assert;
import org.junit.Test;

public class JetonTest {
    @Test
    public void WhenNoConstructThenCreateDefaultJeton(){
        // When
        Jeton monJeton= new Jeton();
        // Then
        Assert.assertEquals("rouge",monJeton.getColor());
    }
    @Test
    public void GivenColorCreateJetonWithColor(){
        // Given
        String color="bleu";
        // When
        Jeton monJeton = new Jeton(color);
        //Then
        Assert.assertEquals(color,monJeton.getColor());
    }


}
