package com.vicky.mvvmretofitroomdatabsetest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vicky.mvvmretofitroomdatabsetest.Models.ResultModel;
import com.vicky.mvvmretofitroomdatabsetest.R;

import java.util.List;

public class RetroPostListAdapter  extends RecyclerView.Adapter<RetroPostListAdapter.PostViewHolder> {

    private final LayoutInflater inflater;
    private List<ResultModel> mUsers;

    public RetroPostListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (mUsers != null)
        {
            ResultModel resultModel = mUsers.get(position);
            holder.txtId.setText(""+resultModel.getId());
            holder.txtTitle.setText(resultModel.getTitle());
            holder.txtBody.setText(resultModel.getBody());
        }
        else
        {

        }
    }

    public void setWords(List<ResultModel> users){
        mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mUsers != null)
        {
            return mUsers.size();
        }
        else {
            return 0;
        }
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtTitle, txtBody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.mId);
            txtTitle = itemView.findViewById(R.id.mTitle);
            txtBody = itemView.findViewById(R.id.mBody);
        }
    }
}
