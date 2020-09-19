package com.example.tp3_cbhering_di;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Presentation extends AppCompatActivity {

    //C'est la variable qui va garder le temps en milisecondes.
    //5000 milisecondes est équivalent à 5 secondes.
    private static int SPLASH_TIME_OUT = 5000;

    //C'est la méthode qui va permettre d'afficher l'activité et récupérer les éléments liés au layout.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        //HANDLER: le Handler considère les messages et les Runnables qui sont liés à un thread
        //Son utilisation dans ce cas-ci sert à créer une boucle qui exécutéra le runnable au moment de l'expiration du délai.

        //Runnable: il s'agit de l'interface qui sera implémentée par les classes dont les instances sont exécutés
        //par un thread.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent interface2Intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(interface2Intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}