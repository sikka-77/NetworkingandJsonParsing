package com.example.networkingexample;

import android.content.Context;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder>{
    @NonNull

    private Context mContext;
    private List<UsersClass> mData;
    int mExpandedPosition=-1;

    public UsersAdapter(Context context,List<UsersClass>data) {
        this.mContext=context;
        this.mData=data;

    }

    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_layout, parent, false);
        return new UserHolder(view);

    }


    @Override
    public void onBindViewHolder(final UserHolder holder, final int position) {
        holder.loginText.setText(mData.get(position).getLogin());
        holder.htmlText.setText(mData.get(position).getHtml());
        holder.urlText.setText(mData.get(position).getUrl());

        /*
                expanding the recycler view on touch.
         */
        final UserHolder vh=(UserHolder)holder;
        final boolean isExpanded = position==mExpandedPosition;
        holder.details.setVisibility((isExpanded) ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? RecyclerView.NO_POSITION : vh.getAdapterPosition();
                notifyDataSetChanged();
            }
        });

//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                holder.details.setVisibility(View.VISIBLE);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class UserHolder extends RecyclerView.ViewHolder {

        TextView loginText;
        TextView urlText;
        TextView htmlText;
        LinearLayout details;
        LinearLayout mainLayout;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            loginText=itemView.findViewById(R.id.loginTextView);
            urlText=itemView.findViewById(R.id.urlTextView);
            htmlText=itemView.findViewById(R.id.htmlTextView);
            details=itemView.findViewById(R.id.llExpandArea);
            mainLayout=itemView.findViewById(R.id.mainLayout);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getLayoutPosition();
//                    UsersClass user=mData.get(position);
//                    Toast.makeText(mContext, "item clicked", Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }
}
