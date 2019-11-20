package com.app.app_nu34life;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.app_nu34life.retrofit.Food;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ListaAllFoodAdapter  extends RecyclerView.Adapter<ListaAllFoodAdapter.ViewHolder> {
    private ArrayList<Food> dataset;
    private Context context;
    private OnNoteListener canonNoteListener;

    public ListaAllFoodAdapter(Context context)
    {
        this.context=context;
        dataset= new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist2,parent,false);

        return new ViewHolder(view,canonNoteListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){

        Food c = dataset.get(position);
        holder.txt_Food.setText(c.getName());
        Glide.with(context)
                .load(c.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImagen);
    }

    @Override
    public int getItemCount(){
        return dataset.size();
    }


    public void adicionarListaCancion(ArrayList<Food> listaRecipe,OnNoteListener canonNoteListener){
        dataset.addAll(listaRecipe);
        notifyDataSetChanged();
        this.canonNoteListener=canonNoteListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView fotoImagen;
        private TextView txt_Food;
        OnNoteListener onNoteListener;

        public ViewHolder(View itemView ,OnNoteListener onNoteListener ){
            super(itemView);
            fotoImagen=(ImageView) itemView.findViewById(R.id.fotoAlimento);
            txt_Food=(TextView) itemView.findViewById(R.id.txt_Alimento);
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
