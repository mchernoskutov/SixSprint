package ru.practikum.animaltest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.practicum.Feline;
import ru.practicum.Lion;


import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestLion {


    private Feline feline;
    private Lion lion;

    @Mock
    private Feline felineMock;
    private Lion lionTest;

    @Before
    public void setUp() throws Exception {
            feline = new Feline();
            lion = new Lion(feline, "Самец");
            lionTest = new Lion(felineMock, "Самец");
    }

    //тест на котят
    @Test
    public void testLionGetKittensDefault (){

        int expected = 1;
        int actual = lion.getKittens();

        Assert.assertEquals("Число котят по умолчанию:"+ actual+ " не соответствует ожидаемому:"+expected,expected,actual);
    }

    //тест на поедание мяса
    @Test
    public void testLionEatMeat () throws Exception {

        List<String> foodList = List.of("Животные","Птицы","Рыба" ); //ожидаемое значение
        List<String> lionFood = lion.getFood();  //актуальное значение

        lion = new Lion(feline, "Самец");

        Assert.assertEquals("Список еды для льва не соответствует ожидаемому списку мяса",foodList,lionFood);
    }

    //проверка зависимости при поедании мяса
    @Test
    public void testLionEatMeatFelineMock () throws Exception {

        List<String> foodList = List.of("Животные","Птицы","Рыба" );//ожидаемое значение
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные","Птицы","Рыба" ));

        List<String> lionFood = lionTest.getFood();//актуальное значение

        Assert.assertEquals("Список еды для льва не соответствует ожидаемому списку мяса",foodList,lionFood);
    }

    //проверка наличия исключения при проверке гривы
    @Test (expected = Exception.class)
    public void testLionManeHaveException () throws Exception{
        Lion lion = new Lion(feline, "123");
        lion.doesHaveMane();
    }
}
