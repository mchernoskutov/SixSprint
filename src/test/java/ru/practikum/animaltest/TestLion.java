package ru.practikum.animaltest;

import java.util.ArrayList;
import java.util.List;


import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import com.example.Lion;

public class TestLion {

    private Feline feline;
    private Predator predator;
    private Lion lion = new Lion(feline);


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
        List<String> foodList = new ArrayList<>();

        foodList.add("Животные");
        foodList.add("Рыба");
        foodList.add("Птицы");

        List<String> catFood = lion.getFood();

        Assert.assertTrue("Список еды для льва не соответствует ожидаемому списку мяса",foodList.containsAll(catFood));

    }

    //тест на поедание травы
    @Test
    public void testCatCanNotEatGrass () throws Exception {
        String food = "Трава";

        List<String> lionFood = lion.getFood();
        Assert.assertFalse("Лев не может есть траву",lionFood.contains(food));

        food = "Различные растения";
        Assert.assertFalse("Лев не может есть растения",lionFood.contains(food));

    }





}
