package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LionAlex extends Lion {

    private static final String ALEX_SEX = "Самец";
    private List<String> alexFriends = Arrays.asList("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    private String alexAdress = "Нью-Йоркский зоопарк";

    public LionAlex (Feline feline) {
        super(feline);
    }

    public LionAlex (String sex) throws Exception {
        super(ALEX_SEX);
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return alexFriends;
    }

    public String getPlaceOfLiving() {
        return alexAdress;
    }

}
