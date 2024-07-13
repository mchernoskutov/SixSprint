package ru.practikum.animaltest;


import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    private Feline feline;

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void testGetKittensFelineDefault (){
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensFeline1 (){
        felineSpy.getKittens(1);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensFeline5 (){
        felineSpy.getKittens(5);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(5);
    }

    @Test
    public void testGetFelineFamily() {
        String expected = "Кошачьи";
        String actual = felineSpy.getFamily();

        Assert.assertEquals("Семейство не соответствует кошачьему",actual,expected);
    }

}
