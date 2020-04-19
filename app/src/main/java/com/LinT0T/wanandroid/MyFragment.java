package com.LinT0T.wanandroid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyFragment extends Fragment {

    Context mContext;
    RecyclerView recyclerView;
    private OkHttpClient mOkHttpClient;
    private MyBean myBean;
    private RVAdapter rvAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.rv_fragment);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getQues();

    }

    private void getQues() {
        mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/article/list/0/json")
                .get()
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(str);
                        Gson gson = new Gson();
                        myBean = gson.fromJson(str, MyBean.class);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                rvAdapter = new RVAdapter(myBean);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                                if (recyclerView == null) {
                                    System.out.println("sb");
                                }
                                if (rvAdapter == null){
                                    System.out.println("cnm");
                                }
                                recyclerView.setAdapter(rvAdapter);
                                recyclerView.setLayoutManager(linearLayoutManager);
                                rvAdapter.notifyDataSetChanged();
                            }
                        });

                    }
                }).start();
            }
        });
    }

}
