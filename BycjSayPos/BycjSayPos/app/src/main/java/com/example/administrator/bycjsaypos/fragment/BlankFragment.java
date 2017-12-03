//package com.example.administrator.bycjsaypos.fragment;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.administrator.bycjsaypos.Data.Data;
//import com.example.administrator.bycjsaypos.R;
//import com.example.administrator.bycjsaypos.modle.RowsBeans;
//import com.example.administrator.bycjsaypos.modle.shopping;
//import com.google.gson.Gson;
//
//import java.util.HashMap;
//import java.util.List;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//@SuppressLint("ValidFragment")
//public class BlankFragment extends Fragment implements View.OnClickListener{
//    //要显示的个数
//    private int count;
//    //要显示多少列
//    private int clumn=4;
//
//    public  static  String resurtstring;
//    private TextView text_name,text_code,text_picture;
//    private String string,code_string,pic_string;
//    LinearLayout linear;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        //初始化视图
//        ScrollView sv =new ScrollView(getActivity());
//        LinearLayout ll = new LinearLayout(getActivity());
//        ll.setOrientation(LinearLayout.VERTICAL);
//        setCount(50);
//        initView(ll,inflater);
//        sv.addView(ll);
//        return sv;
//    }
//
//    private void initView(LinearLayout ll, LayoutInflater inflater) {
//        LinearLayout llh=null;
//        for(int index=0;index<count;index++ ){
//            if(index%clumn==0){
//                llh = new LinearLayout(getActivity());
//                llh.setOrientation(LinearLayout.HORIZONTAL);
//                ll.addView(llh);
//            }
//            View view =inflater.inflate(R.layout.twollayout,null);
//            ImageView img = (ImageView) view.findViewById(R.id.bit);
//             text_name = (TextView) view.findViewById(R.id.name_v);
//             text_code = (TextView) view.findViewById(R.id.encoded);
//              text_picture = (TextView) view.findViewById(R.id.price_view);
//              linear = (LinearLayout) view.findViewById(R.id.big_p);
//              linear.setOnClickListener(this);
//            //Gson的使用
//            Gson gson = new Gson();
//            shopping goods = gson.fromJson(resurtstring, shopping.class);
////             Log.d("TAG", "initView: ***************"+goods.toString());
//            List<RowsBeans> rows = goods.getData().getRows();
//            for (int i = 0; i < rows.size(); i++) {
//                //Glide的使用
//                Glide.with(getActivity()).load(goods.getData().getRows().get(i).getPicture().trim()).into(img);
//                //Log.i("TAG", "initView: ------------------------->"+goods.getData().getRows().get(i).getPicture());
//                text_name.setText(goods.getData().getRows().get(i).getProductName());
//                Log.i("1111", "=========================================>" + goods.getData().getRows().get(i).getProductName());
//                string = text_name.getText().toString();
//                text_code.setText(goods.getData().getRows().get(i).getBarCode());
//                code_string = text_code.getText().toString();
//                text_picture.setText(goods.getData().getRows().get(i).getSalePrice());
//                pic_string = text_picture.getText().toString();
//                }
//                llh.addView(view);
//            ll.postInvalidate();
//                 }
//            }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.big_p:
//                HashMap<String, Object> allHashMap = new HashMap<String, Object>();
//                allHashMap.put("num", string);
//                allHashMap.put("picture", pic_string);
//                allHashMap.put("commentry", code_string);
//                allHashMap.put("id", Data.arrayList_cart_id += 1);
//                Data.arrayList_cart.add(allHashMap);
//                Log.e("TAG", "######===================================>" + allHashMap.toString());
//                break;
//        }
//    }
//}
