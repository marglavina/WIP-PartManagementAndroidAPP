package com.zavrsnirad.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.R;
import com.zavrsnirad.model.CarBrand;
import com.zavrsnirad.model.CarModel;
import com.zavrsnirad.skladiste.recycleView.ModelRV;
import com.zavrsnirad.skladiste.recycleView.SkladisteRV;
import com.zavrsnirad.view.ModelActivity;
import com.zavrsnirad.view.PartActivity;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<SkladisteRV> {
    Context context;
    List<CarModel> carModels;

    public ModelAdapter( Context context, List<CarModel> carModels){
        this.context =context;
        this.carModels = carModels;
    }

    @NonNull
    @Override
    public SkladisteRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkladisteRV(LayoutInflater.from(context).inflate(R.layout.onecard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkladisteRV holder, int position) {

        if(carModels.size()>0) {
            holder.textView.setText(carModels.get(position).getModelName());

            String uri = "drawable/_" + carModels.get(position).getModelName().toLowerCase().replace(" ", "");
            int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());

            if (imageResource != 0) {
                holder.imageView.setImageResource(imageResource);
            } else {
                uri = "drawable/_noimage";
                holder.imageView.setImageResource(context.getResources().getIdentifier(uri, null, context.getPackageName()));

            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i;
                    i = new Intent(v.getContext().getApplicationContext(), PartActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    String modelName = "" + carModels.get(position).getModelName().replace(" ", "%20");
                    i.putExtra("modelName", modelName);
                    v.getContext().getApplicationContext().startActivity(i);
                }
            });
        }else {
            CharSequence noItem = "There are no parts for model ";
            System.out.println(noItem);
            holder.textViewNoItem.setVisibility(View.VISIBLE);
            holder.textViewNoItem.setTextColor(Color.RED);
            holder.textViewNoItem.setText(noItem);
        }

    }


    @Override
    public int getItemCount() {
        return carModels.size();
    }
}
