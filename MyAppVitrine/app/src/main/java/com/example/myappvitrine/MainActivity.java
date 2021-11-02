package com.example.myappvitrine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // bouton pour aller sur la page produit avec intent extra
    public void actionButtonProduct(View view) {
        Intent intent = new Intent (this, ProductActivity.class);
        intent.putExtra("titre", getString(R.string.productIntro));
        intent.putExtra("texte", getString(R.string.Lorem_Ipsum));
        intent.putExtra("txt_btn_retour", getString(R.string.back));
        startActivity(intent);
    }

    // Bouton aide avec intent simple
    public void actionButtonHelp(View view) {
        Intent intent = new Intent (this, HelpActivity.class);
        startActivity(intent);
    }

    // buton pour aller sur la page intro
    public void actionButtonIntro(View view) {
        Intent intent = new Intent (this, IntroActivity.class);
        intent.putExtra("titre", getString(R.string.intro));
        intent.putExtra("texte", getString(R.string.Lorem_Ipsum));
        intent.putExtra("txt_btn_retour", getString(R.string.back));

        startActivity(intent);
    }


}