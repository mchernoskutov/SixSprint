package ru.practikum.animaltest;


import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLionMane {

    private String sex;

    public TestLionMane(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[] getLionSex() {
        return new Object[][] {
                {"Самец"},
                {"Самка"},
                {"Вертолет"}
        };
    }

    @Test
    public void testLionMane()  {

        try {
            Lion lion = new Lion(sex);



            if (sex.equals("Самец")) {
                Assert.assertTrue("Возвращает false, хотя лев самец", lion.doesHaveMane());
            } else if (sex.equals("Самка")) {
                Assert.assertFalse("Возвращает true, хотя лев самка", lion.doesHaveMane());
            }
        }  catch (Exception exception) {

            String expectedError = "Используйте допустимые значения пола животного - Самец или Самка";
            String actualError = exception.toString();

            Assert.assertTrue("Сообщение об ошибке не соответствует ожидаемому", actualError.contains(expectedError));
        }

    }


}
