package com.example.demo2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GameManagement extends DataManagement {
    public static Random rand = new Random();
    String words="";
    byte hatakodu=0;

    public GameManagement() throws FileNotFoundException,IOException {
        super();
        AutoGameCreator();
    }
    public GameManagement(String written) throws FileNotFoundException {
        super(written);
        written=written.toUpperCase();
        if(isPangram(written)){
        generatableWords(written);
        if((dictionary.size()<=80 && dictionary.size()>=20)){
            words=written;
        }else hatakodu=6;}else{
            hatakodu=6;
        }
    }


    public void AutoGameCreator() throws FileNotFoundException{
        do {
            int random = rand.nextInt(super.getPangram().size());
            words=super.getPangram().get(random);
            generatableWords(words);
        }while(!(dictionary.size()<=80 && dictionary.size()>=20));
    }








}



