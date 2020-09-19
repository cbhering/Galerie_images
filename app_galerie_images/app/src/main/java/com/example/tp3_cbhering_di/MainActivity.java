package com.example.tp3_cbhering_di;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Chaine de caractère qui sera passée au fragment
    private String maChaine;
    private String cheminImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Permet l'affichage de l'audio
        final MediaPlayer audioWav = MediaPlayer.create(this, R.raw.audio);

        // Reference vers le linearLayout qui se trouve a l'interieur du horizontalscroolview
        LinearLayout galerieImages = findViewById(R.id.galerieimages);

        // Création d'un LayoutInflater pour remplir le contenu de la galerie
        LayoutInflater inflater = LayoutInflater.from(this);
        checkPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        String StringPath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));

        String FullPath;

        // Boucle pour ajouter les éléments dans la galerie
        for (int i = 1; i < 21; i++) {
            FullPath = StringPath + "/tp2_image" + i + ".jpg";
            Bitmap myBitmap = BitmapFactory.decodeFile(FullPath);
            // On récupere le layout et on le place dans le scroolView
            View view = inflater.inflate(R.layout.miniatures, galerieImages, false);
            // Référence vers le textView
            TextView textView = view.findViewById(R.id.definitionImageView);
            // On adapte le texte en fonction de l'index (numero de l'image)
            textView.setText("Image: " + i);

            // Référence vers imageView
            ImageView imageView = view.findViewById(R.id.miniatureImageView);
            // Redéfinir le id du imageView
            imageView.setId(i);
            imageView.setTag(FullPath);
            // Affectation de l'image (déjà dans le ressource (à modifie pour le tp)) /sdcard/Download
            imageView.setImageBitmap(myBitmap);
            // Definition d'un onClickListener dans la boucle pour l'affecter a chaque miniature
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioWav.start();
                    // Assigner l'index de l'image à la variable maChaine
                    maChaine = String.valueOf(view.getId());
                    cheminImage = (String) view.getTag();
                    loadFragment(new FragmentTp());
                }
            });

            galerieImages.addView(view);
        }
    }



    private void checkPermission(String permission) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == getPackageManager().PERMISSION_DENIED)
        { ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, 23);}
    }

    private void loadFragment(Fragment fragment) {
        // Creation d'un fragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // Creation d'un fragmentation pour commencer la transaction et remplacer le fragment
        FragmentTransaction ft = fm.beginTransaction();
        // On remplace le contenu du layout avec le nouveau fragment
        ft.replace(R.id.frameLayout, fragment);
        // On applique les changement
        ft.commit();
    }

    public String getMyData() {
        return maChaine;
    }

    public String getMyPhoto() {
        return cheminImage;
    }
}