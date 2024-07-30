package ru.practikum.animaltest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.Feline;
import ru.practicum.Lion;

@RunWith(Parameterized.class)
public class TestLionManeParam {

    private final String sex;
    private final Feline feline = new Feline();

    public TestLionManeParam(String sex) {
        this.sex = sex;
    }

    //параметры пола
    @Parameterized.Parameters
    public static Object[] getLionSex() {
        return new Object[][] {
                {"Самец"},
                {"Самка"},
                {"Вертолет"}
        };
    }

    //проверка наличия гривы
    @Test
    public void testLionMane() {
        try {
            Lion lion = new Lion(feline, sex);
            //проверяем есть ли грива
            boolean hasMane = lion.doesHaveMane();
            //результат в зависимости от пола
            if (sex.equals("Самец")) {
                Assert.assertTrue("Проверка наличия гривы возвращает false, хотя лев самец", hasMane);
            } else if (sex.equals("Самка")) {
                Assert.assertFalse("Проверка наличия гривы возвращает true, хотя лев самка", hasMane);
            }
        }  catch (Exception exception) {

            String expectedError = "Используйте допустимые значения пола животного - Самец или Самка";//ожидаемое сообщение об ошибке

            Assert.assertEquals(expectedError, exception.getMessage());
        }
    }
}
