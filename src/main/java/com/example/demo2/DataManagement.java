package com.example.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataManagement {


    private ArrayList<String> pangram = new ArrayList<>();
    public String mainword;
    protected static ArrayList<String> dictionary = new ArrayList<>();
    private byte mod ;
    public ArrayList<String> getDictionary() {
        return dictionary;
    }

    public DataManagement() throws FileNotFoundException, IOException, NullPointerException { //çift constructer yapılacak boş girdili
        mod=1;
        String a ="";
        File Data = new File("sozluk_v2.txt");
        Scanner scan = new Scanner(Data);
        while((scan.hasNext())) {
            a = scan.nextLine();
            a=a.toUpperCase();
            if (a.length() >= 7 && isPangram(a)) {
                pangram.add(mainword);
            }
        }
        scan.close();
    }
    public DataManagement(String word){
        mod =0;
    }


    public ArrayList<String> getPangram() {
        return pangram;
    }


    public  boolean isPangram(String word){
        String mainWords="";
        boolean ip =false;
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<word.length();j++){
                if(word.charAt(i)==word.charAt(j)){
                    break;
                }else if(j==word.length()-1){
                    mainWords = mainWords+word.charAt(i);
                }
            }
        }
        mainWords=mainWords+word.charAt(word.length()-1);
        mainword=mainWords;
        if(mainWords.length()==7){
            ip=true;
        }
        return ip;

    }
    public ArrayList<String> generatableWords(String words) throws FileNotFoundException {
        dictionary.clear();
        File Data = new File("sozluk_v2.txt");
        Scanner scan = new Scanner(Data);
        String a ="";
        String b="";
        String centerletter = words.substring(0,1);
        while((scan.hasNext())) {
            a = scan.nextLine();
            a=a.toUpperCase();
            b=a;
            if(a.length()>=4){
                if(a.contains(centerletter)){
                    if(mod==1){
                    words=words.replaceAll(centerletter,"");
                    a=a.replaceAll(centerletter,"");
                    a=a.replaceAll(words.substring(0,1),"");
                    a=a.replaceAll(words.substring(1,2),"");
                    a=a.replaceAll(words.substring(2,3),"");
                    a=a.replaceAll(words.substring(3,4),"");
                    a=a.replaceAll(words.substring(4,5),"");
                    a=a.replaceAll(words.substring(5,6),"");
                    }else if(mod==0){
                        mainword=mainword.replaceAll(centerletter,"");
                        a=a.replaceAll(centerletter,"");
                        a=a.replaceAll(mainword.substring(0,1),"");
                        a=a.replaceAll(mainword.substring(1,2),"");
                        a=a.replaceAll(mainword.substring(2,3),"");
                        a=a.replaceAll(mainword.substring(3,4),"");
                        a=a.replaceAll(mainword.substring(4,5),"");
                        a=a.replaceAll(mainword.substring(5,6),"");
                    }
                    if(a.length()==0){dictionary.add(b);}
                }}
        }
        scan.close();
        return dictionary;

    }

}


