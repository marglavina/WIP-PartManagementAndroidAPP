package com.zavrsnirad.skladiste.recycleView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.R;

public class ModelRV extends RecyclerView.ViewHolder {
    public CardView cardView;
    public TextView textView;
    public ImageView imageView;

    public ModelRV(@NonNull View itemView){

        super(itemView);
        cardView = itemView.findViewById(R.id.oneCard);
        textView = itemView.findViewById(R.id.idIVCarBrandTxt);
        imageView = itemView.findViewById(R.id.idIVCarBrandImage);
    }
}
