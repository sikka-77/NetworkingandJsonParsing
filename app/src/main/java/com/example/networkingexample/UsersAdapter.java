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



//        if (position == mExpandedPosition) {
//            holder.llExpandArea.setVisibility(View.VISIBLE);
//        } else {
//            holder.llExpandArea.setVisibility(View.GONE);
//        }

//        final boolean isExpanded = position==mExpandedPosition;
//        holder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
//        holder.mview.setActivated(isExpanded);
//        holder.mview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mExpandedPosition = isExpanded ? -1:position;
//                TransitionManager.beginDelayedTransition(holder.details);
//                notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

//    @Override
//    public void onClick(View v) {
//        RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) v.getTag();
//        String theString = mData.get(holder.getAdapterPosition()).toString();
//
//        // Check for an expanded view, collapse if you find one
//        if (mExpandedPosition >= 0) {
//            int prev = mExpandedPosition;
//            notifyItemChanged(prev);
//        }
//        // Set the current position to "expanded"
//        mExpandedPosition = holder.getAdapterPosition();
//        notifyItemChanged(mExpandedPosition);
//
//        Toast.makeText(mContext, "Clicked: "+theString, Toast.LENGTH_SHORT).show();
//    }


    class UserHolder extends RecyclerView.ViewHolder {

        TextView loginText;
        TextView urlText;
        TextView htmlText;
        public View mview;
        LinearLayout details;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;
            loginText=itemView.findViewById(R.id.loginTextView);
            urlText=itemView.findViewById(R.id.urlTextView);
            htmlText=itemView.findViewById(R.id.htmlTextView);
            details=itemView.findViewById(R.id.onclicklayout);

        }
    }
}
