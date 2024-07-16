package ru.practikum.animaltest;

import org.junit.Assert;
import org.junit.Test;
import ru.practicum.Cat;
import ru.practicum.Feline;
import java.util.List;

public class TestCat {

    private final Feline feline = new Feline();
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

        List<String> foodList = List.of("Животные","Птицы","Рыба" ); //ожидаемое значение
        List<String> catFood = cat.getFood(); //актуальное значение

        Assert.assertEquals("Список еды для кота не соответствует ожидаемому списку мяса",foodList,catFood);
    }
}
