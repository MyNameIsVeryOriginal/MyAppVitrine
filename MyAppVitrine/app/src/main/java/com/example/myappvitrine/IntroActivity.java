package com.example.myappvitrine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity {
    TextView c_txtView_titre = null;
    TextView c_txtView_contenu = null;
    Button c_btn_retour = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // On oublie pas de réaliser l'association XML et JAVA
        this.fct_associerElementsJavaEtXML();

        // On effectue le remplissage de la vue
        this.fct_remplirLaVue();
    }


    private void fct_associerElementsJavaEtXML() {
        // On associe le XML du titre avec le JAVA du titre
        c_txtView_titre = findViewById(R.id.introTitle);

        // On associe le XML du contenu avec le JAVA du contenu
        c_txtView_contenu = findViewById(R.id.introContent);

        // On associe le XML du bouton avec le JAVA du bouton
        c_btn_retour = findViewById(R.id.introButtonBack);
    }

    private void fct_remplirLaVue() {
        try {
            if (getIntent().hasExtra("titre")==false) {/* EXCEPTION */ throw new Exception("Aucun extra détecté pour le titre");}
            if (getIntent().hasExtra("texte")==false) {/* EXCEPTION */ throw new Exception("Aucun extra détecté pour le texte principal ");}
            if (getIntent().hasExtra("txt_btn_retour")==false) {/* EXCEPTION */ throw new Exception("Aucun extra détecté pour le texte du bouton retour");}
        } catch (Exception e) {
            this.fct_afficherToast("Erreur détectée lors du remplissage de la vue ["+e.toString()+"]");

            // On ferme directement la vue et on affiche un Toast !
            finish();
        }
        // On récupère les extras depuis les données de l'intent
        String l_str_titrePage = getIntent().getStringExtra("titre");
        String l_str_texteAAfficher = getIntent().getStringExtra("texte");
        String l_str_titre_bouton_retour = getIntent().getStringExtra("txt_btn_retour");

        // On remplit la vue à partir des valeurs récupérées depuis les extras
        this.c_txtView_titre.setText(l_str_titrePage);
        this.c_txtView_contenu.setText(l_str_texteAAfficher);
        this.c_btn_retour.setText(l_str_titre_bouton_retour);

    }

    private void fct_afficherToast(String s) {
        // Récupération du context actuel de l'application
        Context context = getApplicationContext();

        // Préparation de la durée du Toast (LONG)
        int duration = Toast.LENGTH_SHORT;

        // Création du TOAST
        Toast toast = Toast.makeText(context, s, duration);

        // Affichage du Toast
        toast.show();
    }


    public void actionRetour(View view) {
        finish();
    }
}