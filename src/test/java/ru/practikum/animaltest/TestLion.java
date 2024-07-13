package ru.practikum.animaltest;

import java.util.ArrayList;
import java.util.List;


import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import com.example.Lion;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



public class TestLion {

    private Feline feline;
    private Predator predator;
    private Lion lion = new Lion(feline);

    @Test
    public void testLionGetKittens (){

        int expected = 1;
        int actual = lion.getKittens();

        Assert.assertEquals("Число котят по умолчанию:"+ actual+ " не соответствует ожидаемому:"+expected,expected,actual);
    }

    @Test
    public void testLionEatMeat () throws Exception {
        List<String> foodList = new ArrayList<>();

        foodList.add("Животные");
        foodList.add("Рыба");
        foodList.add("Птицы");

        List<String> catFood = lion.getFood();

        Assert.assertTrue("Список еды для льва не соответствует ожидаемому списку мяса",catFood.containsAll(foodList));

    }

    @Test
    public void testCatCanNotEatGrass () throws Exception {
        String food = "Трава";

        List<String> catFood = lion.getFood();
        Assert.assertFalse("Лев не может есть траву",catFood.contains(food));

        food = "Различные растения";
        Assert.assertFalse("Лев не может есть растения",catFood.contains(food));

    }





}
