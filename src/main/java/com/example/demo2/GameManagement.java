package com.example.demo2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GameManagement extends DataManagement {
    public static Random rand = new Random();
    String words="";
    int puan =0;
    byte hatakodu=0; // sözlükte yok 1, merkez yok 2 ,4ten az harf 3 ,farklı harf 4 , zaten bulundu 5 , hata kodu 6
    ArrayList<String> founded = new ArrayList<>();

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



    public boolean wordController(String word){
        String center = words.substring(0,1);
        boolean bool = false;
        if(word.contains(center)&&dictionary.contains(word)){
            bool=true;
        }//doğru
        else if(word.contains(center)&& !dictionary.contains(word)){
            hatakodu=1;
            bool=false;}
        else if(!word.contains(center)){
            hatakodu=2;}//sözlükte yok uyarısı
        return bool;}


    public void pointCalculator(String Word){
            if(wordController(Word)){
                founded.add(Word);
                puan= puan+(Word.length()-3);
                if(super.isPangram(Word)){
                    puan=puan+7;
                }

        }
    }
    public void gameController(String Word) {//kelimedeki harfin doğrulukları ekle int dönder hata kodunu
        hatakodu=0;
        if(!founded.contains(Word)){
            if (wordController(Word)){
                pointCalculator(Word);
            }else {
                switch (hatakodu){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;

                }

            }
        }else{
            //5 firlat

        }

    }
}



