package com.example.demo2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class HelloController {

    @FXML
    protected  Label txtlbl;
    @FXML
    protected TextArea txtarea;
    @FXML
    protected Label lblipucu;
    @FXML
    protected TextField txtharf;
    @FXML
    protected TextField txtfield;
    @FXML
    protected Button btnharf1;
    @FXML
    protected Button btnharf2;
    @FXML
    protected Button btnharf3;
    @FXML
    protected Button btnharf4;
    @FXML
    protected Button btnharf5;
    @FXML
    protected Button btnharf6;
    @FXML
    protected Button btnharf7;
    @FXML
    protected Button btnenter;
    @FXML
    protected Button btnekle;

    @FXML
    protected Label lblpuan;
    ArrayList<String> BulunanKelimeler= new ArrayList<>();
    ArrayList<String> Sözlük= new ArrayList<>();
    GameManagement gmp=new GameManagement();
    String text ="";
    int puan=0;

    public HelloController() throws IOException {
    }

    @FXML
    protected void onOtomatikClicked() throws IOException {
        BulunanKelimeler.clear();
        lblpuan.setText("");
        txtharf.setVisible(false);
        btnekle.setVisible(false);
        txtarea.setText("");
        GameManagement gm = new GameManagement();
        btnharf1.setText(gm.words.substring(1,2));
        btnharf2.setText(gm.words.substring(2,3));
        btnharf3.setText(gm.words.substring(3,4));
        btnharf4.setText(gm.words.substring(4,5));
        btnharf5.setText(gm.words.substring(5,6));
        btnharf6.setText(gm.words.substring(6,7));
        btnharf7.setText(gm.words.substring(0,1));
        Sözlük=gm.getDictionary();
        puan=0;
        txtlbl.setText("");
    }
    @FXML
    protected void onManuelClicked(){
        btnekle.setText("EKLE");
        lblpuan.setText("");
        btnharf1.setText("");
        btnharf2.setText("");
        btnharf3.setText("");
        btnharf4.setText("");
        btnharf5.setText("");
        btnharf6.setText("");
        btnharf7.setText("");
        txtarea.setText("");
        txtharf.setVisible(true);
        btnekle.setVisible(true);
        lblipucu.setText("baş harf merkez olacak şekilde kelimeyi giriniz!!!!");
    }
    int m=1;
    @FXML
    protected void onEkleClicked() throws FileNotFoundException {
      if(m==1){
        String s="";
        s=txtharf.getText().toUpperCase(Locale.ROOT);
        GameManagement gm= new GameManagement(s);
        if(gm.hatakodu!=6){
        String center=s.substring(0,1);
        btnharf7.setText(s.substring(0,1));
        s= gm.mainword;
        s=s.replaceAll(center,"");
        btnharf1.setText(s.substring(1,2));
        btnharf2.setText(s.substring(2,3));
        btnharf3.setText(s.substring(3,4));
        btnharf4.setText(s.substring(4,5));
        btnharf5.setText(s.substring(5,6));
        btnharf6.setText(s.substring(0,1));
        Sözlük=gm.getDictionary();
        btnekle.setText("TAMAM");
            txtlbl.setText("");
            BulunanKelimeler.clear();
            puan=0;
            txtlbl.setText("");
            m++;
        }else{txtlbl.setText("oluşturulamadı");}
            }else{m=1;
                lblipucu.setVisible(false);
                txtharf.setVisible(false);
                btnekle.setVisible(false);}



    }


    @FXML
    protected void onEnterClicked(){
        txtfield.getText().toUpperCase(Locale.ROOT);
        if(txtfield.getText().length()!=0){
        String kelime;
        String aranan =btnharf7.getText();
        kelime=txtfield.getText().toUpperCase();
            if(harfBul(kelime,aranan)==true){
                if(BulunanKelimeler.contains(kelime)==true){
                    txtlbl.setText("Bu kelime daha önce bulundu!");}
                else {
                    if(kelime.length()>3){
                    if(Sözlük.contains(kelime)){
                        if(kelime.length()==4){
                            puan++;
                            lblpuan.setText(String.valueOf(puan));
                        }else if (kelime.length()>4) {
                            puan=puan+(kelime.length()-3);
                            lblpuan.setText(String.valueOf(puan));
                            if(gmp.isPangram(kelime)){
                                puan=puan+7;
                                lblpuan.setText(String.valueOf(puan));
                        }
                        }
                        BulunanKelimeler.add(kelime);
                        txtarea.setText(txtarea.getText()+"\n"+kelime);
                        txtlbl.setText("Tebrikler!!");}
                    else{txtlbl.setText("Sözlükte Yok!!");}

                }
                else {
                    txtlbl.setText("kelime en az 4 harften oluşmalı!");
                }
                }}
            else
                {
                    txtlbl.setText(btnharf7.getText()+" harfini kullanmalısınız!");
                }}
        txtfield.setText("");
        text="";
        }



    @FXML
    protected void onButtonsClicked1(){
        text=text+btnharf1.getText();
        txtfield.setText(text);

    }
    @FXML
    protected void onButtonsClicked2(){
        text=txtfield.getText();
        text=text+btnharf2.getText();
        txtfield.setText(text);}
    @FXML
    protected void onButtonsClicked3(){
        text=txtfield.getText();
        text=text+btnharf3.getText();
        txtfield.setText(text);}
    @FXML
    protected void onButtonsClicked4(){
        text=txtfield.getText();
        text=text+btnharf4.getText();
        txtfield.setText(text);}
    @FXML
    protected void onButtonsClicked5(){
        text=txtfield.getText();
        text=text+btnharf5.getText();
        txtfield.setText(text);}
    @FXML
    protected void onButtonsClicked6(){
        text=txtfield.getText();
        text=text+btnharf6.getText();
        txtfield.setText(text);}
    @FXML
    protected void onButtonsClicked7(){
        text=txtfield.getText();
        text=text+btnharf7.getText();
        txtfield.setText(text);}


    @FXML
    protected void onChangeClicked(){
        int i =1 ;
        String a,b,c,d,e,f;
        a=btnharf1.getText();
        b=btnharf2.getText();
        c=btnharf3.getText();
        d=btnharf4.getText();
        e=btnharf5.getText();
        f=btnharf6.getText();
        if (i==1){
            btnharf1.setText(f);
            btnharf2.setText(a);
            btnharf3.setText(b);
            btnharf4.setText(c);
            btnharf5.setText(d);
            btnharf6.setText(e);

        } else if (i==2) {
            btnharf1.setText(e);
            btnharf2.setText(f);
            btnharf3.setText(a);
            btnharf4.setText(b);
            btnharf5.setText(c);
            btnharf6.setText(d);

        }
        else if (i==3) {
            btnharf1.setText(d);
            btnharf2.setText(e);
            btnharf3.setText(f);
            btnharf4.setText(a);
            btnharf5.setText(b);
            btnharf6.setText(c);

        }
        else if (i==4) {
            btnharf1.setText(c);
            btnharf2.setText(d);
            btnharf3.setText(e);
            btnharf4.setText(f);
            btnharf5.setText(a);
            btnharf6.setText(b);

        }
        else if (i==5) {
            btnharf1.setText(b);
            btnharf2.setText(c);
            btnharf3.setText(d);
            btnharf4.setText(e);
            btnharf5.setText(f);
            btnharf6.setText(a);

        }
        else
            i++;

    }



    @FXML
    protected void onDeleteClicked(){
        if(txtfield.getText().length()!=0){
        text=txtfield.getText();
        text=text.substring(0,text.length()-1);
        txtfield.setText(text);}
    }


    @FXML
    protected void onExitClicked(){
        System.exit(0);
    }

    static boolean harfBul(String kelime,String aranan) {
        char b=aranan.charAt(0);
        for(int a = 0; a < kelime.length(); a++) {
            if (kelime.charAt(a)==b)
                return true;

        }
        return false;
    }
    @FXML
    public void onEnter(ActionEvent ae){
      onEnterClicked();
    }


}