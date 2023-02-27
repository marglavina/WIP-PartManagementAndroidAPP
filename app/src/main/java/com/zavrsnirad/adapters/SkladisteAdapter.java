package com.zavrsnirad.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.R;
import com.zavrsnirad.model.CarBrand;
import com.zavrsnirad.skladiste.recycleView.SkladisteRV;
import com.zavrsnirad.view.BrandEditActivity;
import com.zavrsnirad.view.ModelActivity;
import com.zavrsnirad.view.SkladisteActivity;

import java.util.List;

public class SkladisteAdapter extends RecyclerView.Adapter<SkladisteRV> {
    Context context;
    List<CarBrand> carBrands;


    public SkladisteAdapter( Context context, List<CarBrand> carBrands){
        this.context =context;
        this.carBrands = carBrands;
    }

    @NonNull
    @Override
    public SkladisteRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SkladisteRV(LayoutInflater.from(context).inflate(R.layout.onecard,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkladisteRV holder, int position) {
    holder.textView.setText(carBrands.get(position).getBrandName());


    String uri = "drawable/"+carBrands.get(position).getBrandName().toLowerCase().replace(" ", "");
    int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());


    if (imageResource != 0) {
        holder.imageView.setImageResource(imageResource);
    }
    else{
        uri = "drawable/_noimage";
        holder.imageView.setImageResource(context.getResources().getIdentifier(uri, null, context.getPackageName()));

    }
    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i;
                i = new Intent(v.getContext().getApplicationContext(), ModelActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                String brandName = ""+carBrands.get(position).getBrandName().replace(" ", "%20");
                i.putExtra("brandName",brandName);
                v.getContext().getApplicationContext().startActivity(i);
            }
    });



    }

    @Override
    public int getItemCount() {
        return carBrands.size();
    }
}
