package ru.practikum.animaltest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.Lion;

@RunWith(Parameterized.class)
public class TestLionManeParam {

    private String sex;

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
    public void testLionMane()  {

        try {
            Lion lion = new Lion(sex);
            //проверяем есть ли грива
            boolean hasMane = lion.doesHaveMane();
            //результат в зависимости от пола
            if (sex.equals("Самец")) {
                Assert.assertTrue("Проверка наличия гривы возвращает false, хотя лев самец", hasMane);
            } else if (sex.equals("Самка")) {
                Assert.assertFalse("Проверка наличия гривы возвращает true, хотя лев самка", hasMane);
            }
        }  catch (Exception exception) {
            //проверка наличия текста об ошибке при некорректном значении
            String expectedError = "Используйте допустимые значения пола животного - Самец или Самка";
            String actualError = exception.toString();

            Assert.assertTrue("Сообщение об ошибке не соответствует ожидаемому", actualError.contains(expectedError));
        }
    }
}
