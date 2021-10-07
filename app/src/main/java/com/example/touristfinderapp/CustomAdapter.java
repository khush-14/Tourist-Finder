package com.example.touristfinderapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/* It is used when we push/pull item from list : image Scroll view*/
/* We also have to install recycler view activity from mainActivty -> */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private static final String TAG ="CustomAdaptor" ;
    private Context context;
    private List<modelClassApp> app;

    public CustomAdapter(Context context, List<modelClassApp> app) {
        this.context = context;
        this.app = app;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.content);
            img =(ImageView) itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    // it will return view holder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this will return out view
        // inflate first parameter is layout
        View v= LayoutInflater.from(context).inflate(R.layout.layout_list,parent, false);
        return new MyViewHolder(v);
    }


    @Override
    //it will return how many times adapter will run
    public int getItemCount() {
        return  app.size();
    }

    @Override
    //In this view will Bind , the all items will bound in view we make
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // we pick each item from app and bind in this
        modelClassApp ap = app.get(position);
        holder.text.setText(ap.getContent());
        holder.img.setImageResource(ap.getImage());

        Log.i(TAG, "onBindViewHolder: "+holder.text);
    }

}
