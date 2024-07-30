package ru.practicum;

import java.util.List;


public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    Predator feline = new Feline();


    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }

}
