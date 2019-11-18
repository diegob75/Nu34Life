package com.app.fas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.fas.retrofit.Ingredient;
import com.app.fas.retrofit.Recipe;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ListaFoodAdapter extends RecyclerView.Adapter<ListaFoodAdapter.ViewHolder>  {
    private ArrayList<Ingredient> dataset;
    private Context context;
    private ListaFoodAdapter.OnNoteListener canonNoteListener;

    public ListaFoodAdapter(Context context)
    {
        this.context=context;
        dataset= new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodllist,parent,false);

        return new ViewHolder(view,canonNoteListener);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){

        Ingredient c = dataset.get(position);
        holder.txt_Food.setText(c.getFood().getName());
    }

    @Override
    public int getItemCount(){
        return dataset.size();
    }


    public void adicionarListaCancion(ArrayList<Ingredient> listaRecipe, ListaFoodAdapter.OnNoteListener canonNoteListener){
        dataset.addAll(listaRecipe);
        notifyDataSetChanged();
        this.canonNoteListener=canonNoteListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txt_Food;
        ListaFoodAdapter.OnNoteListener onNoteListener;

        public ViewHolder(View itemView , ListaFoodAdapter.OnNoteListener onNoteListener ){
            super(itemView);
            txt_Food=(TextView) itemView.findViewById(R.id.foodlist_txt);
            this.onNoteListener=onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.oneNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void oneNoteClick(int position);
    }
}
