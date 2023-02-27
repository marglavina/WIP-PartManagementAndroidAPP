package com.zavrsnirad.skladiste.recycleView;

import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zavrsnirad.R;


public class SkladisteRV  extends RecyclerView.ViewHolder {

    CardView cardView;
    public TextView textView;
    public ImageView imageView;
    public TextView textViewNoItem;
    public  Button addButton;

    public SkladisteRV(@NonNull View itemView){

        super(itemView);
        cardView = itemView.findViewById(R.id.oneCard);
        textView = itemView.findViewById(R.id.idIVCarBrandTxt);
        imageView = itemView.findViewById(R.id.idIVCarBrandImage);
        textViewNoItem = itemView.findViewById(R.id.noItem);
        addButton = (Button) itemView.findViewById(R.id.button);
    }
}
