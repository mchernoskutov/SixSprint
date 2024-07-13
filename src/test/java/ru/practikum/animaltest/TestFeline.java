package ru.practikum.animaltest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import ru.practicum.Feline;



@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    @Spy
    private Feline felineSpy = new Feline();

    //тест на значение котят по умолчанию
    @Test
    public void testGetKittensFelineDefault (){
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }
    //тест на значение котят 1
    @Test
    public void testGetKittensFeline1 (){
        felineSpy.getKittens(1);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }
    //тест на значение котят 5
    @Test
    public void testGetKittensFeline5 (){
        felineSpy.getKittens(5);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(5);
    }
    //проверка на семейство
    @Test
    public void testGetFelineFamily() {
        String expected = "Кошачьи";
        String actual = felineSpy.getFamily();

        Assert.assertEquals("Семейство не соответствует кошачьему",actual,expected);
    }
}
