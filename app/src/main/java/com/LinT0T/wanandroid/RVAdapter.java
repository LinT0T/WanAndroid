package com.LinT0T.wanandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

    private MyBean myBean;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myadapter_main_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (myBean != null) {
            holder.textView.setText(myBean.getData().getDatas().get(position).getTitle());
            holder.tv_time.setText(myBean.getData().getDatas().get(position).getNicedate());
            holder.tv_author.setText(myBean.getData().getDatas().get(position).getAuthor());
        } else holder.textView.setText("网络请求错误");
    }

    @Override
    public int getItemCount() {
        if (myBean != null) {
            return myBean.getData().getDatas().size();
        } else return 1;
    }


    public RVAdapter(MyBean myBean) {
        this.myBean = myBean;
        System.out.println(myBean);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView,tv_author,tv_time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_main);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
