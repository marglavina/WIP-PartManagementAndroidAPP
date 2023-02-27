package com.zavrsnirad.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zavrsnirad.R;
import com.zavrsnirad.model.CarModel;
import com.zavrsnirad.model.Part;
import com.zavrsnirad.skladiste.recycleView.ModelRV;
import com.zavrsnirad.skladiste.recycleView.SkladisteRV;

import java.util.List;

public class PartAdapter extends RecyclerView.Adapter<SkladisteRV> {
    Context context;
    List<Part> partList;
    String modelName;

    public PartAdapter( Context context, List<Part> partList, String modelName){
        this.context =context;
        this.partList = partList;
        this.modelName =modelName;
    }

    @NonNull
    @Override
    public SkladisteRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new SkladisteRV(LayoutInflater.from(context).inflate(R.layout.onecard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SkladisteRV holder, int position) {

                holder.textView.setText(partList.get(position).getPart_name());

                String[] split = partList.get(position).getPartNumber().split("/");

                String uri = "drawable/_" + split[1];
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
                        CharSequence text = "Hello toast!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

    }


    @Override
    public int getItemCount() {
        return partList.size();
    }
}
