package com.arianasp.testing;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterEdiText extends RecyclerView.Adapter<AdapterEdiText.ViewHolder>{

    List<DataDao> listItem;
    Context context;
    OnCardClickListener onCardClickListner;

    public AdapterEdiText(List<DataDao> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_inside_card,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DataDao item = listItem.get(position);

        holder.title.setText(item.title);
        holder.description.setText(item.description);
        holder.cv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context,"onLongClick",Toast.LENGTH_LONG).show();
                onCardClickListner.OnCardClicked(v,position,item);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, DataDao data) {
        listItem.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(int position) {
        listItem.remove(position);
        notifyItemRemoved(position);
    }

    public void updateData(int position,DataDao dataDao){
        remove(position);
        insert(position,dataDao);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView title;
        TextView description;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public interface OnCardClickListener{
        void OnCardClicked(View view,int position,DataDao data);
    }

    public void setOnCardClickListener(OnCardClickListener onCardClickListener){
        this.onCardClickListner = onCardClickListener;
    }
}