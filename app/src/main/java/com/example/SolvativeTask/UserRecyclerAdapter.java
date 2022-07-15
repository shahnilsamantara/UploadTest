package com.example.SolvativeTask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.SolvativeTask.model.DataItem;


public class UserRecyclerAdapter extends ListAdapter<DataItem, UserRecyclerAdapter.ViewHolder> {


    public UserRecyclerAdapter(){
        super(diffCallback);
    }
    public static final DiffUtil.ItemCallback<DataItem> diffCallback =  new DiffUtil.ItemCallback<DataItem>() {

        @Override
        public boolean areItemsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataItem oldItem, @NonNull DataItem newItem) {
           return   oldItem.getId() == newItem.getId();
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.ViewHolder holder, int position) {

        DataItem dataItem = getItem(position);
        Glide.with(holder.imageView.getContext())
                .load(dataItem.getAvatar())
                .thumbnail(0.1f)
                .into(holder.imageView);

        holder.textViewName.setText(dataItem.getFirstName());
        holder.textViewSurname.setText(dataItem.getLastName());
        holder.textViewEmail.setText(dataItem.getEmail());
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName ;
        TextView textViewSurname ;
        TextView textViewEmail ;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.name_tv);
            this.textViewSurname = itemView.findViewById(R.id.surname_tv);
            this.textViewEmail = itemView.findViewById(R.id.email_tv);
            this.imageView = itemView.findViewById(R.id.avatar_image_view);
        }
    }
}
