package com.example.tp3_cbhering_di;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentTp extends Fragment {

    // Declaration des objets
    View view;
    ImageView imageViewPlein;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        String photoPath = activity.getMyPhoto();

        // Preparation du layout
        view = inflater.inflate(R.layout.fragment, container, false);

        // Afichage de l'image
        imageViewPlein = view.findViewById(R.id.imageViewPlein);
        Bitmap myBitmap = BitmapFactory.decodeFile(photoPath);
        imageViewPlein.setImageBitmap(myBitmap);

        // Inflate the layout for this fragment
        return view;
    }

}
