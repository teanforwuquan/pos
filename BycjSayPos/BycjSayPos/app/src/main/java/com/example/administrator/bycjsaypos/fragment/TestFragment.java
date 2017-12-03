package com.example.administrator.bycjsaypos.fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.bycjsaypos.R;
import com.example.administrator.bycjsaypos.adapter.MyRecycleView;
import com.example.administrator.bycjsaypos.modle.shopping;
import com.google.gson.Gson;

public class TestFragment extends Fragment {
private RecyclerView recyclerView;
    private MyRecycleView myRecycleAdapter;
    public static String json;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recly_view, null);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        GridLayoutManager mgr = new GridLayoutManager(getActivity(), 5);
        recyclerView.setLayoutManager(mgr);
//        return super.onCreateView(inflater, container, savedInstanceState);

//        Bundle b = getArguments();
//        shopping json = (shopping) b.getSerializable("json");
            Gson gson = new Gson();
            shopping goods = gson.fromJson(json, shopping.class);
        myRecycleAdapter = new MyRecycleView(getActivity(),goods);
        recyclerView.setAdapter(myRecycleAdapter);
        return v;
    }
}