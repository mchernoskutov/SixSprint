package ru.practikum.animaltest;

import java.util.ArrayList;
import java.util.List;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import com.example.Cat;




public class TestCat {

    private Feline feline;
    private Predator predator;
    private Cat cat = new Cat(feline);

    @Test
    public void testCatSoundEqual() {

        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals("Звук кошки не соответствует ожидаемому",expected,actual);
    }

    @Test
    public void testCatEatMeat () throws Exception {
        List<String> foodList = new ArrayList<>();

        foodList.add("Животные");
        foodList.add("Рыба");
        foodList.add("Птицы");

        List<String> catFood = cat.getFood();

        Assert.assertTrue("Список еды для кошки не соответствует ожидаемому списку мяса",catFood.containsAll(foodList));

    }

    @Test
    public void testCatCanNotEatGrass () throws Exception {
        String food = "Трава";

        List<String> catFood = cat.getFood();
        Assert.assertFalse("Кошка не может есть траву",catFood.contains(food));

        food = "Различные растения";
        Assert.assertFalse("Кошка не может есть растения",catFood.contains(food));

    }



}
