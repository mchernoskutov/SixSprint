package ru.practikum.animaltest;

import org.junit.Assert;
import org.junit.Test;
import ru.practicum.Cat;
import ru.practicum.Feline;
import java.util.ArrayList;
import java.util.List;

public class TestCat {

    Feline feline;
    private final Cat cat = new Cat(feline);

    //тест на мяуканье
    @Test
    public void testCatSoundEqual() {

        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals("Звук кошки не соответствует ожидаемому",expected,actual);
    }

    //тест на поедание мяса
    @Test
    public void testCatEatMeat () throws Exception {
        List<String> foodList = new ArrayList<>();

        foodList.add("Животные");
        foodList.add("Рыба");
        foodList.add("Птицы");

        List<String> catFood = cat.getFood();

        Assert.assertTrue("Список еды для кошки не соответствует ожидаемому списку мяса",foodList.containsAll(catFood));
    }

    //тест на поедание травы
    @Test
    public void testCatCanNotEatGrass () throws Exception {
        String food = "Трава";

        List<String> catFood = cat.getFood();
        Assert.assertFalse("Кошка не может есть траву",catFood.contains(food));

        food = "Различные растения";
        Assert.assertFalse("Кошка не может есть растения",catFood.contains(food));

    }
}
