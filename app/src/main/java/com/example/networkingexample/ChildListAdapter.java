package com.example.networkingexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.ChildHolder> {
    private Context mContext;
    private List<UsersClass> mlistnew;

    public ChildListAdapter(Context context,List<UsersClass> listnew){
        mContext=context;
        mlistnew=listnew;
    }

    @NonNull
    @Override
    public ChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.onclickitem, parent, false);
        return new ChildListAdapter.ChildHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildHolder holder, int position) {
        holder.childText.setText(mlistnew.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mlistnew.size();
    }

    class ChildHolder extends RecyclerView.ViewHolder{
        TextView childText;

        public ChildHolder(View itemView){
            super(itemView);
            childText=itemView.findViewById(R.id.childText);

        }

    }
}
